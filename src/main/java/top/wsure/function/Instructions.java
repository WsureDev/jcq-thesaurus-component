package top.wsure.function;

import top.wsure.component.DatebaseUtils;
import top.wsure.config.Option;
import top.wsure.config.RegexString;

import static com.sobte.cqp.jcq.event.JcqApp.CQ;

public class Instructions {

    static DatebaseUtils datebaseUtils = DatebaseUtils.datebaseUtils;

    public static boolean chechPromise(long fromGroup,long fromQQ){
        CQ.getGroupMemberInfo(fromGroup,fromQQ).getAuthority();
//        datebaseUtils;
        return false;
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
}
