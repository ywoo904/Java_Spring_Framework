package com.zerock.database;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//DB테스트용
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DatabaseConnectionTest {
	
	@Autowired
	private DataSource dataSource; 
	
	@Test
	public void testConnect () { 
		try { 
			Connection conn = dataSource.getConnection(); 
			System.out.println("연결성공");
			
		}catch (Exception e ) { 
			System.out.println("연결실패");
			e.printStackTrace();
		}
		
	} 
	
	
	
}
