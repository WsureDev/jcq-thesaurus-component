package top.wsure.function;

import top.wsure.component.DatebaseUtils;
import top.wsure.entity.Groups;
import top.wsure.entity.Lexicon;
import top.wsure.entity.LexiconDto;
import top.wsure.service.GroupsService;
import top.wsure.service.LexiconService;

import java.util.List;

import static com.sobte.cqp.jcq.event.JcqApp.CQ;
import static top.wsure.function.Instructions.*;
import static top.wsure.service.TableService.tableName;

public class MsgHandle {
    static DatebaseUtils datebaseUtils = DatebaseUtils.datebaseUtils;
    public static void privateMsgInstruct(int subType, int msgId, long fromQQ, String msg, int font){
        //判断是否是命令
        CQ.logInfo("privateMsgInstruct",msg);
        String instructType = checkInstruct(msg);
        if(instructType==null){
            return;
        }

        String table = getTable(instructType);
        //校验权限
        if(chechPromise(fromQQ)){
            //执行操作

            switch (getType(instructType)){
                case "exact":
                case "vague":
                case "regex":
                    LexiconDto addlex = msgToLexicon(instructType,msg,fromQQ,table);
                    sendPrivateInfoMsg(addLex(addlex),"新增成功","新增失败",fromQQ);
                    break;
                case "delete":
                    LexiconDto delLex = msgToDeleteLexicon(instructType,msg,table);
                    sendPrivateInfoMsg(deleteLex(delLex),"删除成功","删除失败",fromQQ);
                    break;
                case "query":
                    LexiconDto query = msgToQueryLexicon(instructType,msg,table);
                    List<Lexicon> lexicons = queryLex(query);
                    sendPrivateInfoMsg(lexicons.size(),lexiconListToString(lexicons),"未找到",fromQQ);
                    break;
                case "enable":
                    break;
                case "disable":
                    break;
            }

        } else {
            CQ.sendPrivateMsg(fromQQ,"权限不足");
        }
    }

    public static void groupMsgInstruct(int subType, int msgId, long fromGroup, long fromQQ, String fromAnonymous, String msg,
                                        int font){
        //判断是否是命令
        CQ.logInfo("groupMsgInstruct",msg);
        String instructType = checkInstruct(msg);
        if(instructType==null){
            return;
        }

        String table = getTable(instructType,fromGroup);
        //校验权限
        if(chechPromise(fromGroup,fromQQ)){
            //执行操作
            CQ.logInfo("instructType",getType(instructType));
            switch (getType(instructType)){
                case "exact":
                case "vague":
                case "regex":
                    LexiconDto addlex = msgToLexicon(instructType,msg,fromQQ,table);
                    sendGroupInfoMsg(addLex(addlex),"新增成功","新增失败",fromGroup);
                    break;
                case "delete":
                    LexiconDto delLex = msgToDeleteLexicon(instructType,msg,table);
                    sendGroupInfoMsg(deleteLex(delLex),"删除成功","删除失败",fromGroup);
                    break;
                case "query":
                    LexiconDto query = msgToQueryLexicon(instructType,msg,table);
                    List<Lexicon> lexicons = queryLex(query);
                    sendGroupInfoMsg(lexicons.size(),lexiconListToString(lexicons),"未找到",fromGroup);
                    break;
                case "enable":
                    enable(new Groups(fromGroup,1,2));
                    break;
                case "disable":
                    enable(new Groups(fromGroup,0,2));
                    break;
            }

        } else {
            CQ.sendGroupMsg(fromGroup,"权限不足");
        }
    }

    public static void privateMsgChat(int subType, int msgId, long fromQQ, String msg, int font){
        Lexicon lexicon = new Lexicon();
        lexicon.setQuestion(msg);
        LexiconDto lexiconDto = new LexiconDto(lexicon,"private");
        List<Lexicon> lexicons = question(lexiconDto);
        for (Lexicon l:lexicons)
        {
            CQ.sendPrivateMsg(fromQQ,l.getAnswer());
        }

    }

    public static void groupMsgChat(int subType, int msgId, long fromGroup, long fromQQ, String fromAnonymous, String msg,
                                        int font){
        if(isEnable(fromGroup))
        {
            Lexicon lexicon = new Lexicon();
            lexicon.setQuestion(msg);
            LexiconDto lexiconDto = new LexiconDto(lexicon,tableName(fromGroup));
            List<Lexicon> lexicons = question(lexiconDto);
            for (Lexicon l:lexicons)
            {
                CQ.sendGroupMsg(fromGroup,l.getAnswer());
            }
        }
    }

    public static int addLex(LexiconDto lexiconDto){
        LexiconService lexiconService =  datebaseUtils.getLexiconService();
        return lexiconService.insertSelective(lexiconDto);
    }

    public static int deleteLex(LexiconDto lexiconDto){
        LexiconService lexiconService = datebaseUtils.getLexiconService();
        return lexiconService.deleteByPrimaryKey(lexiconDto);
    }

    public static List<Lexicon> queryLex(LexiconDto lexiconDto){
        LexiconService lexiconService = datebaseUtils.getLexiconService();
        return lexiconService.queryLexicon(lexiconDto);
    }

    public static List<Lexicon> question(LexiconDto lexiconDto){
        LexiconService lexiconService = datebaseUtils.getLexiconService();
        return lexiconService.selectByQuestion(lexiconDto);
    }

    public static int enable(Groups groups){
        GroupsService groupsService = datebaseUtils.getGroupsService();
        return groupsService.setGroup(groups);
    }
    /**
     * 发送消息
     * @param res
     * @param success
     * @param fail
     * @param fromGroup
     */

    public static void sendGroupInfoMsg(int res,String success,String fail,Long fromGroup){
        if(res>0)
            CQ.sendGroupMsg(fromGroup,success);
        else
            CQ.sendGroupMsg(fromGroup,fail);
    }

    public static void sendPrivateInfoMsg(int res,String success,String fail,Long fromQQ){
        if(res>0)
            CQ.sendPrivateMsg(fromQQ,success);
        else
            CQ.sendPrivateMsg(fromQQ,fail);
    }

    public static String lexiconListToString(List<Lexicon> lexicons){
        StringBuffer sb = new StringBuffer();
        for (Lexicon lexicon:lexicons){
            sb.append("id:"+lexicon.getWordId()+"\n");
            sb.append("问:"+lexicon.getQuestion()+"\n");
            sb.append("答:"+lexicon.getAnswer()+"\n");
            sb.append("类型:"+lexiconType(lexicon.getType())+"\n");
        }
        return sb.toString();
    }

    public static boolean isEnable(Long fromGroup){
        GroupsService groupsService = datebaseUtils.getGroupsService();
        Groups groups = groupsService.selectByPrimaryKey(fromGroup);
        if(groups!=null&&groups.getEnable()>0)
            return true;
        return false;
    }
}
