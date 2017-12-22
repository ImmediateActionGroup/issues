package com.immediateactiongroup.issues.controller.api;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by xueshan.wei on 6/27/2017.
 */
@Controller
public class ChatController {

    @Resource
    private SimpMessagingTemplate simpMessagingTemplate;

    @RequestMapping("/chatpage")
    public String toChatPage(){
        return "chat";
    }

    @MessageMapping("/userChat")
    public void chat(String message){
        System.out.println("message:" + message);
        this.simpMessagingTemplate.convertAndSend("/userChat/chat", message);
    }
}
