package top.wsure.config;

public class TestRegexString {
    //精确问xxx答xxx
    public static String exact = Option.exactKey+".+"+Option.answerKey+".+$";
    //模糊问xxx答xxx
    public static String vague = Option.vagueKey+".+"+Option.answerKey+".+$";
    //正则问xxx答xxx
    public static String regex = Option.regexKey+".+"+Option.answerKey+".+$";
    //开启词库：
    public static String enable = Option.enableKey+"$";
    //关闭词库
    public static String disable = Option.disableKey+"$";
    //查问xxx
    public static String query = Option.queryKey+".+$";
    //删问xxx
    public static String delete = Option.deleteKey+"\\d+$";
    //加黑xxx
    public static String addbl = Option.addblKey+"\\d+$";
    //查黑xxx
    public static String querybl = Option.queryblKey+"\\d+$";
    //删黑xxx
    public static String delbl = Option.delblKey+"\\d+$";
    //被解禁
    public static String lifted = "^.+\\(\\d{8,11}\\) 被管理员解除禁言$";

}
