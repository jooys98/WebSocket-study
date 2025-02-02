package com.example.websocketstudy.controller;

import com.example.websocketstudy.messagetype.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

import static com.example.websocketstudy.messagetype.Notification.NotificationType.*;

@Controller
@RequiredArgsConstructor
public class NotificationController {
    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/notifi")
    //서버가 메세지를 받는 주소
    // /notifi 로 온 메세지에 답장을 보낸다!!
    //실제 경로는 config 에서 설정한 /app prefix 가 앞에 붙어서
    // /app/notifi 가 서버의 메세지를 받는 주소가 된다

    public void sendNotification() {
        Notification notification1 = Notification.builder()
                .message("안녕 바보야?")
                .notificationType(COMMENT)
                .postId(1111L)
                .memberEmail("jooys98")
                .timestamp(LocalDateTime.now())
                .read(false)
                .build();
//jooys98 유저의 1111L 아이디를 가진 글에 댓글이 달림
        Notification notification2 = Notification.builder()
                .message("누가 좋아요를 눌렀습니다")
                .notificationType(LIKE)
                .postId(1234L)
                .memberEmail("gaygay11")
                .timestamp(LocalDateTime.now())
                .read(false)
                .build();
        //gaygay11 유저의 1234L 아이디를 가진 글에 좋아요를 누름

        // 각 사용자의 개인 채널로 메시지 전송
        messagingTemplate.convertAndSendToUser(
                "jooys98",  // 사용자 아이디
                "/queue/notifications",  // 사용자가 구독하는 채널
                notification1 // 페이로드 ( 정달될  메세지 )
        );

        messagingTemplate.convertAndSendToUser(
                "gaygay11",
                "/queue/notifications",
                notification2
        );
    }
}
