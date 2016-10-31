package cn.chx.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.chx.mybatis.mapper.UserMapper;
import cn.chx.mybatis.po.User;
import cn.chx.mybatis.po.UserCustomer;
import cn.chx.mybatis.po.UserQueryVo;

public class UserMapperTest {

	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws IOException {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindUserById() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById(1);
		System.out.println(user);
		sqlSession.close();
	}

	@Test
	public void testFindUserList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustomer user = new UserCustomer();
		user.setSex("1");
//		user.setUsername("张三丰");
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(10);
		ids.add(16);
		userQueryVo.setIds(ids);
		userQueryVo.setUserCustomer(user);
		List<UserCustomer> userCustomers = userMapper.findUserList(userQueryVo);
		System.out.println(userCustomers);
		sqlSession.close();
	}

	@Test
	public void testFindUserCount() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustomer user = new UserCustomer();
		user.setSex("1");
		user.setUsername("张三丰");
		userQueryVo.setUserCustomer(user);
		int count = userMapper.findUserCount(userQueryVo);
		System.out.println(count);
		sqlSession.close();
	}

	@Test
	public void testFindUserResultMap() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> users = userMapper.findUserResultMap();
		System.out.println(users);
		sqlSession.close();
	}

}
