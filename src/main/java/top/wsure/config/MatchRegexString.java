package top.wsure.config;

public class MatchRegexString {

    public static String exact = Option.exactKey;

    public static String vague = Option.vagueKey;

    public static String regex = Option.regexKey;
    //查问xxx
    public static String query = Option.queryKey+").+$";
    //删问xxx
    public static String delete = Option.deleteKey+")\\d+$";

}
