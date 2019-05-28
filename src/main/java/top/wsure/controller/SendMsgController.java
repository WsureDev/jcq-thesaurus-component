package top.wsure.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wsure.function.Instructions;

import java.util.Map;

import static com.sobte.cqp.jcq.event.JcqApp.CQ;

@RestController
public class SendMsgController {

    @RequestMapping("/send")
    public int test(Long qq,String msg){
        return CQ.sendPrivateMsg(qq,msg);
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
