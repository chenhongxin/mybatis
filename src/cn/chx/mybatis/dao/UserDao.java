package cn.chx.mybatis.dao;

import cn.chx.mybatis.po.User;

public interface UserDao {

	User findUserById(Integer id);

	void insertUser(User user);

}
