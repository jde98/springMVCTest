package com.study.bbs.service;

import java.util.List;
import java.util.Map;

public interface BoardService {
	List<Map<String, Object>> getBoardList();

	void addBoard(Map<String, Object> param);
 
	
}

