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
    public int test(@RequestBody Map<String,Object> msg){
        return CQ.sendPrivateMsg((Integer) msg.get("qq"),(String) msg.get("msg"));
    }

    @RequestMapping("/regex")
    public String testRegex(@RequestBody Map<String,Object> msg){
        return Instructions.getMatcher((String) msg.get("regex"), (String) msg.get("test"));
    }
}
