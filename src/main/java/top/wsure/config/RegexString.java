package top.wsure.config;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static com.sobte.cqp.jcq.event.JcqApp.CQ;

public class RegexString {

    public static Map<String,String> regexs = new HashMap<String, String>(){

        OrgRegexString model = new OrgRegexString();
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
}
