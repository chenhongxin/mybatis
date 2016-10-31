package cn.chx.mybatis.mapper;

import java.util.List;

import cn.chx.mybatis.po.User;
import cn.chx.mybatis.po.UserCustomer;
import cn.chx.mybatis.po.UserQueryVo;

/**
 * UserMapper
 * mapper接口，相当于dao的接口
 * @author chenhongxin
 *
 */
public interface UserMapper {

	User findUserById(Integer id);

	void insertUser(User user);
	
	List<UserCustomer> findUserList(UserQueryVo userQueryVo);

	int findUserCount(UserQueryVo userQueryVo);
	
	List<User> findUserResultMap();

}
