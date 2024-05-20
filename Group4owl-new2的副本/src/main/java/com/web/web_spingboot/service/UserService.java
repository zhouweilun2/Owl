package com.web.web_spingboot.service;

import com.web.web_spingboot.common.MyPage;
import com.web.web_spingboot.entity.User;

import java.util.List;

public interface UserService {
    //登录功能
    User login(String username, String password);
    //注册功能
    Boolean register(User user);

    User getUserById(int id);
    List<User> getUsersOrderedByEnergy();

    void addEnergyByUsername(String username, int energy);

    Integer getUserEnergy(Integer userId); // New method signature

    MyPage<List<User>> getOtherUsers(Integer userId, Integer current, Integer size);
}
