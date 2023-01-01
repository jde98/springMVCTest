package com.study.bbs.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
	public List<Map<String, Object>> getBoardList();

    void addBoard(Map<String, Object> param);
}
