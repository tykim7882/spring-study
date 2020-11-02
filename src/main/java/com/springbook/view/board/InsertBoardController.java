package com.springbook.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

//@Controller
public class InsertBoardController {
//public class InsertBoardController implements Controller {
	
//	@RequestMapping(value="/insertBoard.do")
	public String InsertBoard(BoardVO vo, BoardDAO boardDAO) {

		System.out.println("InsertBoardController) 글 등록 ");
		boardDAO.insertBoard(vo);
		return "redirect:getBoardList.do";	//기본이 포워딩 방식이므로 리다이렉트 필요
	}
	
	/*
	@RequestMapping(value="/insertBoard.do")
	public void InsertBoard(BoardVO vo) { // BoardVO는 command 객체, 사용자 입력한 값을 매핑할 VO클래스 선언, 스프링 컨테이너가 세팅해서 넘겨줌
											// form tag 의 파라미터 이름과 command객체의 setter 메소드 이름이 반드시 일치해야함 
		
		//public void InsertBoard(HttpServletRequest request) {
	//public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
	
		System.out.println("InsertBoardController) 글 등록 ");

//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
//		String writer = request.getParameter("writer");
//
//		BoardVO vo = new BoardVO();
//		vo.setTitle(title);
//		vo.setContent(content);
//		vo.setWriter(writer);

//		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);

		// 글 등록 성공 후 새로 검색해야 하므로
////		return "getBoardList.do";
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("redirect:getBoardList.do");
//		return mav;

	}*/

}
