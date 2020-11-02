package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		
		// 1. Spring컨테이너 구동
		AbstractApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		// 2. BoardServiceImpl 객체 lookup
		BoardService boardService = (BoardService) context.getBean("boardService");
		
		// 3. CRUD TEST
		// 등록테스트 
//		BoardVO vo = new BoardVO();
//		vo.setTitle("제목테스트");
//		vo.setContent("내용테스트");
//		vo.setWriter("관리자");
//		boardService.insertBoard(vo);
		
		// 목록 테스트
		List<BoardVO> boardList = boardService.getBoardList(new BoardVO());
		for (BoardVO board : boardList) {
			System.out.println(board.toString());
		}
		
		// 게시글 확인 테스트
//		vo.setSeq(100);
//		BoardVO board = boardService.getBoard(vo);
//		if(board==null) {
//			System.out.println("널이다 j");
//		}else {
//			System.out.println(board.toString());
//		}
		
		
		// 4. 컨테이너 종료
		context.close();
		
		
	}

}
