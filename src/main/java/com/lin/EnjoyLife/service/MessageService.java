package com.lin.EnjoyLife.service;

import com.lin.EnjoyLife.mapper.MessageMapper;
import com.lin.EnjoyLife.mapper.UserMapper;
import com.lin.EnjoyLife.pojo.Message;
import com.lin.EnjoyLife.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageMapper messageMapper;
    @Autowired
    UserMapper userMapper;

    public User initMessage(String userId) {
        User user = null;
        try {
            user = userMapper.queryUserById(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public Boolean addMessage(Message message) {
        Integer integer = 0;
        try {
            integer = messageMapper.addMessage(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return integer == 1;
    }

    public List<Message> messageShow() {
        List<Message> messages = null;
        try {
            messages = messageMapper.messageShow();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return messages;
    }

    public Integer messageCount(String messageTime) {
        Integer integer = 0;
        try {
            integer = messageMapper.messageCount(messageTime);
            integer++;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return integer;
    }
}
