package cn.chx.mybatis.first;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.chx.mybatis.dao.UserDaoImpl;
import cn.chx.mybatis.po.User;

public class UserDaoImplTest {

	private UserDaoImpl userDaoImpl;

	@Before
	public void setUp() throws IOException {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		userDaoImpl = new UserDaoImpl(sqlSessionFactory);
	}

	// 根据id查询用户信息，得到一条记录信息
	@Test
	public void findUserByIdTest() throws IOException {
		User user = userDaoImpl.findUserById(1);
		System.out.println(user);
	}

}
