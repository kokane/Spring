package springbook.user.dao;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springbook.user.domain.User;

public class UserDaoTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		ConnectionMaker connectionMaker = new DConnectionMaker();
//		UserDao dao = new UserDao(connectionMaker);
		
//		UserDao dao = new DaoFactory().userDao();
		
		ApplicationContext context = new GenericXmlApplicationContext("/config/applicationContext.xml");
		UserDao dao = context.getBean("userDao",UserDao.class);

		User user = new User();
		user.setId("kokane5");
		user.setName("고명관");
		user.setPassword("married");

		dao.add(user);
			
		System.out.println(user.getId() + " 등록 성공!!!");
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
			
		System.out.println(user2.getId() + " 조회 성공");
	}
}
