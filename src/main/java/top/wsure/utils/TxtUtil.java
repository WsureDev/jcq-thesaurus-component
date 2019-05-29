package top.wsure.utils;

import top.wsure.entity.Lexicon;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TxtUtil {

    public static List<Lexicon> getLexString(String source){
        String regex = "编号：\\[\\d+\\][\\n\\r]问=.+?=问[\\n\\r]答=.+?=答[\\n\\r]模式：\\[[\\u4e00-\\u9fa5]{2}\\]#####";


        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(source);
        List<Lexicon> list = new ArrayList<>();
        int i = 0;
        while (matcher.find()) {
            Lexicon entity = stringToEntity(matcher.group());
            list.add(entity);
        }
        return list;
    }

    public static String getMatcher(String regex, String source) {
        System.out.println(regex+":"+source);
        String result = "";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);
        while (matcher.find()) {
            result = matcher.group(0);
        }
        return result;
    }

    public static Lexicon stringToEntity(String lexicon){
        Lexicon lex = new Lexicon();
        lex.setAnswer(getMatcher("(?<=[\\n\\r]问=).+?(?==问[\\n\\r])",lexicon));
        lex.setQuestion(getMatcher("(?<=[\\n\\r]答=).+?(?==答[\\n\\r])",lexicon));
        lex.setWordId(Integer.parseInt(getMatcher("(?<=编号：\\[)\\d+(?=\\][\\n\\r])",lexicon)));
        lex.setType(getType(getMatcher("(?<=[\\n\\r]模式：\\[)[\\u4e00-\\u9fa5]{2}(?=\\]#####)",lexicon)));
        return lex;
    }

    public static int getType(String type){
        switch (type){
            case "精确":return 1;
            case "模糊":return 2;
        }
        return 0;
    }
}
