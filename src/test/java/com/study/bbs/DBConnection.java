package com.study.bbs;

import static org.junit.Assert.*;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class DBConnection {

	 
    @Inject
    private DataSource ds;
    
    @Inject
    private SqlSessionFactory sqlFactory;


    
    /** db  연결 테스트 **/
    @Test
    public void testConnection(){
    	
        try (Connection con = ds.getConnection()) {
 
            System.out.println("DB연결 성공");
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /** mybatis 연결 테스트 **/
    @Test
    public void testSession() throws Exception{
        
        try(SqlSession session = sqlFactory.openSession()){
            
            System.out.println("session  : "+session);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
