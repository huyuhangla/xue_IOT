package org.xue.xue_iot.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.xue.xue_iot.pojo.User;

@Mapper
public interface UserMapper {
    @Select("select * from user where username = #{username}")
    public User findByUsername(String username);
    @Insert("insert into user(username, password, email) values(#{username}, #{password}, #{email})")
    public void register(String username, String password, String email);
    @Select("select * from user where username = #{username} and password = #{password}")
    public User login(String username, String password);
}
