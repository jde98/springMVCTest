package com.study.bbs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.bbs.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{


    @Autowired
    private SqlSessionFactory sqlSessionFactory;
	
	@Override
	public List<Map<String, Object>> getBoardList() {
		
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		
		try (SqlSession session = sqlSessionFactory.openSession()) {
			BoardMapper mapper = session.getMapper(BoardMapper.class);

			result = mapper.getBoardList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public void addBoard(Map<String, Object> param) {
		// TODO Auto-generated method stub

        SqlSession session = sqlSessionFactory.openSession();
        BoardMapper mapper = session.getMapper(BoardMapper.class);

        mapper.addBoard(param);
	}
}
