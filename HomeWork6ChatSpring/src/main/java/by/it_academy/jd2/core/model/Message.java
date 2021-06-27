package by.it_academy.jd2.core.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity(name = "Message")
@Table(name = "messages", schema = "mychat")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long messageId;

    @Column(name = "user_to")
    private String userTo;

    @Column(name = "user_from")
    private String userFrom;

    @Column(name = "time")
    private LocalDateTime messageTime;

    @Column(name = "message")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getUserTo() {
        return userTo;
    }

    public void setUserTo(String userTo) {
        this.userTo = userTo;
    }

    public String getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(String userFrom) {
        this.userFrom = userFrom;
    }

    public LocalDateTime getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(LocalDateTime messageTime) {
        this.messageTime = messageTime;
    }

    public Message() {
    }

    public Message(String userTo, String userFrom, String message) {
        this.userTo = userTo;
        this.userFrom = userFrom;
        this.message = message;
        this.messageTime = LocalDateTime.now();
    }
}
