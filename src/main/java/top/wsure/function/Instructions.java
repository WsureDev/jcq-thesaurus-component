package top.wsure.function;

import top.wsure.component.DatebaseUtils;
import top.wsure.config.RegexString;
import top.wsure.entity.Groups;
import top.wsure.entity.Lexicon;
import top.wsure.entity.Manage;
import top.wsure.service.GroupsService;
import top.wsure.service.ManageService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.sobte.cqp.jcq.event.JcqApp.CQ;

public class Instructions {

    static DatebaseUtils datebaseUtils = DatebaseUtils.datebaseUtils;

    public static boolean chechPromise(long fromGroup,long fromQQ){
        int authLevel = CQ.getGroupMemberInfo(fromGroup,fromQQ).getAuthority();
        GroupsService groupsService = datebaseUtils.getGroupsService();
        Groups groups = groupsService.selectByPrimaryKey(fromGroup);
        if(groups!=null&&groups.getEditerLevel().intValue()<=authLevel)
            return true;
        if(chechPromise(fromQQ))
            return true;
        return false;
    }

    public static boolean chechPromise(long fromQQ){
        ManageService manageService =datebaseUtils.getManageService();
        Manage manage = manageService.selectByPrimaryKey(fromQQ);
        return manage==null?false:true;
    }

    public static String checkInstruct(String msg){
        for(String s:RegexString.regexs.keySet()){
            if(msg.matches(RegexString.regexs.get(s)))
            {
                return s;
            }
        }
        return null;
    }

    public static Lexicon msgToLexicon(String instructType, String msg,long fromQQ){
        Lexicon lexicon = new Lexicon();
        lexicon.setQuestion(getMatcher(RegexString.matchRegexs.get(instructType),msg));
        lexicon.setAnswer(getMatcher(RegexString.matchRegexs.get("answer"),msg));
        lexicon.setType(lexiconType(instructType));
        lexicon.setCommitUser(fromQQ);
        return lexicon;
    }

    public static String getMatcher(String regex, String source) {
        CQ.logInfo("getMatcher",regex+":"+source);
        String result = "";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);
        while (matcher.find()) {
            CQ.logInfo("find regex",matcher.group());
            result = matcher.group(0);
        }
        return result;
    }

    public static int lexiconType(String instructType){
        String [] types = new String[] { "exact","vague","regex"};
        for (int i=0;i<types.length;i++){
            if(instructType.matches("\\w_"+types[i]))
            {
                return i+1;
            }
        }
        return 0;
    }

    public static Integer msgToDeleteId(String instructType, String msg){
        return Integer.parseInt(getMatcher(RegexString.matchRegexs.get(instructType),msg));
    }

    public static String msgToQueryWord(String instructType, String msg){
        return getMatcher(RegexString.matchRegexs.get(instructType),msg);
    }

    public static String getType(String instructType){
        return instructType.substring(2);
    }
    public static String getTable(String instructType,Long groupId){
        switch (instructType.substring(0,1)){
            case "p":return "private";
            case "g":return "global";
            case "n":return groupId==null?"private":"group_"+groupId;
        }
        return "private";
    }
}
