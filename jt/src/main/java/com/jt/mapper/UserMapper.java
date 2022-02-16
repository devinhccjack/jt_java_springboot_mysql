package com.jt.mapper;
import com.jt.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
public interface UserMapper {

    List<User> findAll();
    @Select("select * from user where username=#{username} and password=#{password}")
    User findUserByUP(User user);
    //1.pojo对象 2.Map集合  3.@Param
    List<User> findUserList(@Param("query") String query,
                            @Param("size") int size,
                            @Param("startNum") int startNum);
    long findCount(String query);

    @Update("update user set status=#{status},updated=#{updated} where id=#{id}")
    void updateStatus(User user);

    void addUser(User user);
    @Select("select * from user where id=#{id}")
    User findUserById(Integer id);

    void updateUser(User user);
    @Delete("delete from user where id=#{id}")
    void deleteUserById(Integer id);
}
