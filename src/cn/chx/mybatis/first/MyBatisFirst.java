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

	// ����id��ѯ�û���Ϣ���õ�һ����¼��Ϣ
	@Test
	public void findUserByIdTest() throws IOException {
		// mybatis�����ļ�
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// �����Ự����
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// ͨ���Ự�����õ�SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ͨ��SqlSession�������ݿ�
		// ��һ��������ӳ���ļ���statement��id=namespace+"."+statement��id
		// �ڶ���������ָ����ӳ���ļ�����ƥ���parameterType���͵Ķ���
		// User�����ʾresultType�����صĶ���
		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user);
		sqlSession.close();
	}
	
	@Test
	public void findUserByNameTest() throws IOException {
		// mybatis�����ļ�
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// �����Ự����
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// ͨ���Ự�����õ�SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ͨ��SqlSession�������ݿ�
		// ��һ��������ӳ���ļ���statement��id=namespace+"."+statement��id
		// �ڶ���������ָ����ӳ���ļ�����ƥ���parameterType���͵Ķ���
		// User�����ʾresultType�����صĶ���
		List<User> user = sqlSession.selectList("test.findUserByName", "%��%");
		System.out.println(user);
		sqlSession.close();
	}
	
	@Test
	public void insertUserTest() throws IOException {
		// mybatis�����ļ�
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// �����Ự����
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// ͨ���Ự�����õ�SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		
		User user = new User();
		user.setSex("0");
		user.setAddress("�㶫ʡ");
		user.setBirthday(new Date());
		user.setUsername("�º���");
		sqlSession.insert("test.insertUser", user);
		
		// �����ύ
		sqlSession.commit();

		sqlSession.close();
	}

}
