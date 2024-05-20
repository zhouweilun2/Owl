package com.web.web_spingboot.mapper;

import com.web.web_spingboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user where user_number = #{name} and passwords = #{pwd}")
    User getUserByName(@Param("name") String name, @Param("pwd") String pwd);

    @Select("SELECT * FROM user ORDER BY energy DESC")
    List<User> getUsersOrderByEnergyDesc();

    Boolean insertUser(User user);

    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);

    @Update("UPDATE user SET energy = energy + #{energy} WHERE user_name = #{username}")
    void updateUserEnergyByUsername(@Param("energy") int energy, @Param("username") String username);

    @Select("select * from user where id != #{userId} order by user_name limit #{limit} offset #{offset}")
    List<User> getOtherUsers(@Param("userId") Integer userId, @Param("limit") Integer limit, @Param("offset") Integer offset);

    @Select("select count(*) from user where id != #{userId}")
    Integer getOtherUsersTotal(@Param("userId") Integer userId);
}

