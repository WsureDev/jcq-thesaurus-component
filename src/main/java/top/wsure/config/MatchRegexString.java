package top.wsure.config;

public class MatchRegexString {

    public static String exact = Option.exactKey;

    public static String vague = Option.vagueKey;

    public static String regex = Option.regexKey;
    //查问xxx
    public static String query = Option.queryKey+").+$";
    //删问xxx
    public static String delete = Option.deleteKey+")\\d+$";
    //加黑xxx
    public static String addbl = Option.addblKey+")\\d+$";
    //查黑xxx
    public static String querybl = Option.queryblKey+")\\d+$";
    //删黑xxx
    public static String delbl = Option.delblKey+")\\d+$";
    //
    public static String lifted = ".+\\()\\d+{8,11}(?=\\) 被管理员解除禁言$)";

}
