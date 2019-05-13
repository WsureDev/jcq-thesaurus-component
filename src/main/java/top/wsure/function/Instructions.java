package top.wsure.function;

import top.wsure.component.DatebaseUtils;
import top.wsure.config.Option;

import static com.sobte.cqp.jcq.event.JcqApp.CQ;

public class Instructions {
    static DatebaseUtils datebaseUtils = DatebaseUtils.datebaseUtils;

    public static boolean chechPromise(long fromGroup,long fromQQ){
        CQ.getGroupMemberInfo(fromGroup,fromQQ).getAuthority();
//        datebaseUtils;
        return false;
    }

    public static boolean checkInstruct(String msg){
        //1.精确问:
        String exact = "^"+Option.enableKey+".+"+Option.answerKey+".+$";
        //2.模糊问:
        String vague = "^"+Option.vagueKey+".+"+Option.answerKey+".+$";
        //3.正则问:
        String regex = "^"+Option.regexKey+".+"+Option.answerKey+".+$";
        //1.开启词库：
        return msg.matches(Option.enableKey) ||
                //关闭词库
                msg.matches(Option.disableKey) ||
                //精确问xxx答xxx
                msg.matches(exact) ||
                //模糊问xxx答xxx
                msg.matches(vague) ||
                //正则问xxx答xxx
                msg.matches(regex) ||
                //查问xxx
                msg.matches("^"+Option.queryKey+".+$") ||
                //删问xxx
                msg.matches("^"+Option.deleteKey+"\\d+$")
                //||

                ;
    }
}
