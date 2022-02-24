package com.zerock.database;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class Databasetest {
	
	@Autowired
	private SqlSessionFactory session;

	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testFactory() { 
		try { 
			System.out.println("SQL세션객체주입성공>>>>>>"+ session);
			System.out.println("======================"); 
			System.out.println("DB연결객체주입성공>>>>>>"+ dataSource);
			
		} catch (Exception e) { 
			e.printStackTrace();
		} 
		
		
	}

}
