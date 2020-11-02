package com.springbook.biz.board;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClientTest {
	
	AbstractApplicationContext context;
	
	@org.junit.Before
	public void setApplicationContext() {
		context = new GenericXmlApplicationContext("applicationContext.xml");
	}
	
	@After
	public void closeApplicationContext() {
		context.close();
	}
	
	@Test
	public void getBoardTest() {
		BoardService boardService = (BoardService)context.getBean("boardService");
		
		// 등록테스트 
		BoardVO vo = new BoardVO();
		vo.setTitle("가입인사입니다");
		vo.setContent("안녕하세요");
		vo.setWriter("관리자");
		boardService.insertBoard(vo);
		
		// 입력목록의 1번째 데이터를 확인 
		List<BoardVO> list = boardService.getBoardList(vo);
		BoardVO board = list.get(0);
		assertThat(board, notNullValue());
		assertThat(vo.getTitle(), is(board.getTitle()));
		
	
	}
	
	@Test
	public void getBoardListTest() {
		
		BoardService boardService = (BoardService)context.getBean("boardService");
		
		// 마지막 조회 데이터의  seq 확인 
		List<BoardVO> list = boardService.getBoardList(new BoardVO());
		BoardVO board = list.get(0);
		assertThat(board.getSeq(), is(list.size()));
		
		
	}

}
