package com.lin.EnjoyLife.pojo;

public class Message {
    private String MessageId;
    private String UserId;
    private String MessageTime;
    private String MessageContent;

    public Message() {
    }

    public Message(String messageId, String userId, String messageTime, String messageContent) {
        MessageId = messageId;
        UserId = userId;
        MessageTime = messageTime;
        MessageContent = messageContent;
    }

    public String getMessageId() {
        return MessageId;
    }

    public void setMessageId(String messageId) {
        MessageId = messageId;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getMessageTime() {
        return MessageTime;
    }

    public void setMessageTime(String messageTime) {
        MessageTime = messageTime;
    }

    public String getMessageContent() {
        return MessageContent;
    }

    public void setMessageContent(String messageContent) {
        MessageContent = messageContent;
    }

    @Override
    public String toString() {
        return "Message{" +
                "MessageId='" + MessageId + '\'' +
                ", UserId='" + UserId + '\'' +
                ", MessageTime='" + MessageTime + '\'' +
                ", MessageContent='" + MessageContent + '\'' +
                '}';
    }
}
