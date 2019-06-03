package top.wsure.config;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static com.sobte.cqp.jcq.event.JcqApp.CQ;

public class RegexString {

    public static String[] noSuffixKey = {"query","delete","lifted","addbl","delbl","querybl"};
    public static Map<String,String> regexs = new HashMap<String, String>(){

        TestRegexString model = new TestRegexString();
        {
            for (Field field : model.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    CQ.logInfo(field.getName() , ""+field.get(model) );
                    //插入普通:
                    put("n_"+field.getName(), "^"+field.get(model));
                    //插入全局：
                    put("g_"+field.getName(), "^"+Option.globalKey+field.get(model));
                    //插入私聊：
                    put("p_"+field.getName(), "^"+Option.privateKey+field.get(model));
                } catch (Exception e) {

                }
            }
        }
    };
    
    public static Map<String,String> matchRegexs = new HashMap<String, String>(){
        private String sufix = ").+?(?="+Option.answerKey+".+$)";

        private String prefix = "(?<=^";

        private String answer = prefix + ".+" + Option.answerKey + ").+$";
        MatchRegexString model = new MatchRegexString();
        {
            put("answer",answer);
            for (Field field : model.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    CQ.logInfo(field.getName() , ""+field.get(model) );
                    boolean noSufix = noSufix(field.getName());
                            //field.getName().equals("query") || field.getName().equals("delete") || field.getName().equals("lifted");

                    //插入普通:
                    put("n_"+field.getName(), prefix+field.get(model) + (!noSufix?sufix:""));
                    //插入全局：
                    put("g_"+field.getName(), prefix+Option.globalKey+field.get(model) + (!noSufix?sufix:""));
                    //插入私聊：
                    put("p_"+field.getName(), prefix+Option.privateKey+field.get(model) + (!noSufix?sufix:""));
                } catch (Exception e){

                }
            }
        }
    };


    public static boolean noSufix(String fieldName){
        for (String s:noSuffixKey)
        {
            if(s.equals(fieldName))
                return true;
        }

        return false;
    }

}
