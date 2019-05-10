package top.wsure.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.sobte.cqp.jcq.event.JcqApp.CQ;

@RestController
public class SendMsgController {

    @RequestMapping("/send")
    public int test(@RequestBody Map<String,Object> msg){
        return CQ.sendPrivateMsg((Integer) msg.get("qq"),(String) msg.get("msg"));
    }
}
