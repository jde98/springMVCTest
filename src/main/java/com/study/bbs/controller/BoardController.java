package com.study.bbs.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.study.bbs.service.BoardService;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardService boardService;
	
	/**
	 * Main Page
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView boardView() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/home");
		mv.addObject("serverTime", 222111);
		mv.addObject("title", "board");
		mv.addObject("menuName", "Board ModelView");
		mv.addObject("list", boardService.getBoardList());
		
		/** JS  > JAVA  Array -> List / Object -> Map **/
		/*
		 * List<Map<String, Object>> boardList = new ArrayList<Map<String,Object>>();
		 * 
		 * String [] titles = {"정다은의글1", "정다은의글2", "정다은의글3"}; String [] createUsers =
		 * {"정다은", "이광석", "홍길동"}; String [] createDates = {"2023-01-01", "2023-01-02",
		 * "2023-01-03"};
		 * 
		 * for (int i = 0 ; i < 3 ; i++) { Map<String,Object> map = new HashMap<String,
		 * Object>();
		 * 
		 * map.put("num", i + 1); map.put("title", titles[i]); map.put("createUser",
		 * createUsers[i]); map.put("createDate", createDates[i]);
		 * 
		 * boardList.add(map); }
		 * 
		 * mv.addObject("list", boardList);
		 */
		
		//mv.addObject("dbList", boardService.getBoardList());
		
		return mv;
	}
	

	/**
	 * get Board List Json Return
	 */
	@RequestMapping(value = "/getBoardList", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> getBoardList() {
		
		List<Map<String, Object>> boardList = new ArrayList<Map<String,Object>>();
			
		String [] titles = {"정다은의글1", "정다은의글2", "정다은의글3"};
		String [] createUsers = {"정다은", "이광석", "홍길동"};
		String [] createDates = {"2023-01-01", "2023-01-02", "2023-01-03"};
		
		for (int i = 0 ; i < 3 ; i++) {
			Map<String,Object> map = new HashMap<String, Object>();
			
			map.put("num", i + 1);
			map.put("title", titles[i]);
			map.put("createUser", createUsers[i]);
			map.put("createDate",  createDates[i]);
			
			boardList.add(map);
		}
		
		return boardList;
	}
	
	


	/**
	 * get Board List Json Return Oracle DB Connection
	 */
	@RequestMapping(value = "/getBoardListDB", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> getBoardListDB() {
		
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		
		try {
			result = boardService.getBoardList();
		} catch(Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	
	
	@RequestMapping(value = "/addBoardView", method = RequestMethod.GET)
	public ModelAndView addBoardView() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/addBoard");
		
		return mv;
	}
	
	@RequestMapping(value = "/addBoard", method = RequestMethod.POST)
	public ModelAndView addBoard(HttpServletRequest request) {
		
		String title = request.getParameter("title") != null ? request.getParameter("title") : "";
        String content = request.getParameter("content") != null ? request.getParameter("content") : "";
        String createUser = request.getParameter("createUser") != null ? request.getParameter("createUser") : "";
		
        Map<String, Object> param = new HashMap<String, Object>();
		param.put("title", title);
		param.put("content", content);
		param.put("createUser", createUser);
		
		boardService.addBoard(param);
        
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		return mv;
	}
}
