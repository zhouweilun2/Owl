package com.web.web_spingboot.service.serviceImpl;

import com.web.web_spingboot.common.MyPage;
import com.web.web_spingboot.entity.User;
import com.web.web_spingboot.mapper.UserMapper;
import com.web.web_spingboot.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(String username, String password) {
        return userMapper.getUserByName(username,password);
    }

    @Override
    public Boolean register(User user) {
          return userMapper.insertUser(user);
    }

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    public void addEnergyByUsername(String username, int energy) {
        userMapper.updateUserEnergyByUsername(energy, username);
    }

    @Override
    public MyPage<List<User>> getOtherUsers(Integer userId, Integer current, Integer size) {
        MyPage<List<User>> page = new MyPage<>();

        Integer limit = size;
        Integer offset = (current - 1) * size;
        Integer total = userMapper.getOtherUsersTotal(userId);
        List<User> users = userMapper.getOtherUsers(userId, limit, offset);
        page.setTotal(total);
        page.setList(users);

        return page;
    }

    @Override
    public List<User> getUsersOrderedByEnergy() {
        return userMapper.getUsersOrderByEnergyDesc();
    }

    @Override
    public Integer getUserEnergy(Integer userId) {
        User user = userMapper.getUserById(userId);
        return user != null ? user.getEnergy() : null;
    }


}
