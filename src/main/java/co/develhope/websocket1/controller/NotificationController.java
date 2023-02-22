package co.develhope.websocket1.controller;

import co.develhope.websocket1.entities.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;


    @PostMapping("/broadcast-message")
    public ResponseEntity<HttpStatus> sendNotification(@RequestBody MessageDTO messageDTO) {
        simpMessagingTemplate.convertAndSend("/topic/broadcast", messageDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}