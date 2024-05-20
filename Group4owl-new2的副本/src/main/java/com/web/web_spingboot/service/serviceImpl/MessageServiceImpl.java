package com.web.web_spingboot.service.serviceImpl;

import com.web.web_spingboot.common.MyPage;
import com.web.web_spingboot.entity.Message;
import com.web.web_spingboot.entity.User;
import com.web.web_spingboot.mapper.MessageMapper;
import com.web.web_spingboot.mapper.UserMapper;
import com.web.web_spingboot.service.MessageService;
import com.web.web_spingboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public MyPage<List<Message>> getMessages(Integer userId, Integer current, Integer size) {
        MyPage<List<Message>> page = new MyPage<>();

        Integer limit = size;
        Integer offset = (current - 1) * size;
        Integer total = messageMapper.getMessagesTotal(userId);
        List<Message> messages = messageMapper.getMessages(userId, limit, offset);
        page.setTotal(total);
        page.setList(messages);

        return page;
    }

    @Override
    public void createMessage(Message message) {
        message.setSendTime(LocalDateTime.now());
        messageMapper.createMessage(message);
    }

    @Override
    public Message getMessageById(Integer id) {
        return messageMapper.getMessageById(id);
    }
}
