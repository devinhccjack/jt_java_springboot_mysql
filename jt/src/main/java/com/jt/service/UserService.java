package com.jt.service;

import com.jt.pojo.User;
import com.jt.vo.PageResult;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    List<User> findAll();

    String login(User user);

    PageResult findUserList(PageResult pageResult);

    void updateStatus(User user);

    void addUser(User user);

    User findUserById(Integer id);

    void updateUser(User user);

    void deleteUserById(Integer id);
}
