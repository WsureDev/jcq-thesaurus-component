package top.wsure.function;

import top.wsure.component.DatebaseUtils;
import top.wsure.entity.LexiconDto;
import top.wsure.service.LexiconService;

import static com.sobte.cqp.jcq.event.JcqApp.CQ;
import static top.wsure.function.Instructions.*;

public class MsgHandle {

    public static void privateMsgInstruct(int subType, int msgId, long fromQQ, String msg, int font){
        //判断是否是命令
        CQ.logInfo("privateMsgInstruct",msg);
        String instructType = checkInstruct(msg);
        if(instructType==null){
            return;
        }

        String table = getTable(instructType,null);
        //校验权限
        if(chechPromise(fromQQ)){
            //执行操作
            switch (getType(instructType)){
                case "exact":
                case "vague":
                case "regex":
                    addLexicon(new LexiconDto(msgToLexicon(instructType,msg,fromQQ),table));

                    break;
                case "delete":
                    break;
                case "query":
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

    public static void privateMsgChat(int subType, int msgId, long fromQQ, String msg, int font){
        //

    }

    public static void enableLexicon(){

    }

    public static void addLexicon(LexiconDto lexiconDto){
        LexiconService lexiconService = DatebaseUtils.datebaseUtils.getLexiconService();
        int res = lexiconService.insertSelective(lexiconDto);
        if(res>0) CQ.sendPrivateMsg(lexiconDto.getCommitUser(),"添加成功");
        else CQ.sendPrivateMsg(lexiconDto.getCommitUser(),"添加失败");
    }
}
