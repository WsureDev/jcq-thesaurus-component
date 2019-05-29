package top.wsure.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wsure.function.Instructions;

import java.util.HashMap;
import java.util.Map;

import static com.sobte.cqp.jcq.event.JcqApp.CQ;

@RestController
public class SendMsgController {

    @RequestMapping("/delMsg")
    public HashMap<String,Object> delMsg(long msgId){
        return new HashMap<String,Object>(){
            {
                put("result",CQ.deleteMsg(msgId));
            }
        };
    }

    @RequestMapping("/sendToQQ")
    public HashMap<String,Object> sendToQQ(Long qq,String msg){
        return new HashMap<String,Object>(){
            {
                put("qq",qq);
                put("msg",msg);
                put("msgId",CQ.sendPrivateMsg(qq,msg));
            }
        };
    }

    @RequestMapping("/sendToGroup")
    public HashMap<String,Object> sendToGroup(Long group,String msg){
        return new HashMap<String,Object>(){
            {
                put("group",group);
                put("msg",msg);
                put("msgId",CQ.sendGroupMsg(group,msg));
            }
        };
    }

    @RequestMapping("/regex")
    public String subRegex(String regex,String test){
        return Instructions.getMatcher(regex,test);
    }
    @RequestMapping("/test")
    public boolean testRegex(String regex,String string){
        return string.matches(regex);
    }
}
