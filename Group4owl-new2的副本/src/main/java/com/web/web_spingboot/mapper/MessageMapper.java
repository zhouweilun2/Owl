package com.web.web_spingboot.mapper;

import com.web.web_spingboot.entity.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper {

    @Select("SELECT message.id AS id, message.title AS title, message.sender_id AS senderId, message.send_time AS sendTime, user.user_name AS senderUserName FROM message JOIN user ON message.sender_id = user.id WHERE (message.receiver_id = #{userId} OR message.sender_id = #{userId}) ORDER BY message.send_time DESC LIMIT #{limit} OFFSET #{offset}")
    List<Message> getMessages(@Param("userId") Integer userId, @Param("limit") Integer limit, @Param("offset") Integer offset);


    @Insert("insert into message(sender_id, receiver_id, send_time, title, content) " +
            "values(#{senderId},#{receiverId},#{sendTime},#{title},#{content})")
    void createMessage(Message message);

    @Select("select message.id as id, message.title as title, message.content as content, message.sender_id as senderId, message.send_time as sendTime, user.user_name as senderUserName from message join user on message.sender_id=user.id where message.id = #{id}")
    Message getMessageById(@Param("id") Integer id);

    @Select("select count(*) from message where receiver_id = #{userId}")
    Integer getMessagesTotal(@Param("userId") Integer userId);
}

