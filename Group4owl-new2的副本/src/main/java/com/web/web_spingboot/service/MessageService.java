package com.web.web_spingboot.service;

import com.web.web_spingboot.common.MyPage;
import com.web.web_spingboot.entity.Message;
import com.web.web_spingboot.entity.User;

import java.util.List;

public interface MessageService {
    MyPage<List<Message>> getMessages(Integer userId, Integer current, Integer size);

    void createMessage(Message message);

    Message getMessageById(Integer id);
}
