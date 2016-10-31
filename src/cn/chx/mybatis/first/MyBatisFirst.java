package cn.chx.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.chx.mybatis.po.User;

public class MyBatisFirst {

	// 根据id查询用户信息，得到一条记录信息
	@Test
	public void findUserByIdTest() throws IOException {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 通过会话工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 通过SqlSession操作数据库
		// 第一个参数，映射文件中statement的id=namespace+"."+statement的id
		// 第二个参数，指定和映射文件中所匹配的parameterType类型的对象
		// User对象表示resultType，返回的对象
		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user);
		sqlSession.close();
	}
	
	@Test
	public void findUserByNameTest() throws IOException {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 通过会话工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 通过SqlSession操作数据库
		// 第一个参数，映射文件中statement的id=namespace+"."+statement的id
		// 第二个参数，指定和映射文件中所匹配的parameterType类型的对象
		// User对象表示resultType，返回的对象
		List<User> user = sqlSession.selectList("test.findUserByName", "%张%");
		System.out.println(user);
		sqlSession.close();
	}
	
	@Test
	public void insertUserTest() throws IOException {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 通过会话工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		
		User user = new User();
		user.setSex("0");
		user.setAddress("广东省");
		user.setBirthday(new Date());
		user.setUsername("陈宏鑫");
		sqlSession.insert("test.insertUser", user);
		
		// 事务提交
		sqlSession.commit();

		sqlSession.close();
	}

}
