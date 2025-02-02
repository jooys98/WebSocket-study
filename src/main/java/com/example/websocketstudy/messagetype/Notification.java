package com.example.websocketstudy.messagetype;

import lombok.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {
    private String message;     // 알림 메시지 내용
    private Long postId;        // 관련 게시글 ID
    private String memberEmail;
    private LocalDateTime timestamp = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
    // 알림 발생 시간 , 실시간 서울 시 기준
    private boolean read;       // 읽음 여부
    private NotificationType notificationType;

    // 알림 타입
    public enum NotificationType {
        COMMENT,    // 댓글 알림
        LIKE,       // 좋아요 알림
        FOLLOW,     // 팔로우 알림
        MENTION     // 멘션 알림
    }
}
