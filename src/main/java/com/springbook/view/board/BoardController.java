package com.springbook.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardListVO;
import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Controller
@SessionAttributes("board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	// @ModelAttribute
	// RequestMapping 메소드보다 먼저 호출되고 리턴된 객체는 자동으로 Model에 저장되어 
	// view 페이지에서 사용할 수 있음. 
	@ModelAttribute("conditionMap")
	public Map<String,String> searchConditionMap(){
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용","CONTENT");
		System.out.println(conditionMap.toString());
		return conditionMap;
	}

	// 글 목록 검색
	@RequestMapping(value = "/getBoardList.do")
	public String getBoardList(
//			@RequestParam(value = "searchCondition", defaultValue = "TITLE", required = false) String condition,
//			@RequestParam(value = "searchKeyword", defaultValue = "", required = false) String searchKeyword,
//			BoardVO vo, BoardDAO boardDAO, Model model) {
			BoardVO vo, Model model) {
//		System.out.println(condition + " / " + searchKeyword);
//		System.out.println("BoardController)글 목록 검색 처리");

//		model.addAttribute("boardList", boardDAO.getBoardList(vo));
		
		if(vo.getSearchCondition() == null) {
			vo.setSearchCondition("TITLE");
		}
		if(vo.getSearchKeyword() == null) {
			vo.setSearchKeyword("");
		}
		
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "getBoardList.jsp";
	}

	// 글 상세조회
//			@RequestMapping(value="/getBoard.do")
//			public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
//				System.out.println("BoardController) 글 상세 조회");
//				mav.addObject("board", boardDAO.getBoard(vo));
//				mav.setViewName("getBoard.jsp");
//				return mav;
//			}
	@RequestMapping(value = "/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, ModelAndView mav) {
	//public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
//		System.out.println("BoardController) 글 상세 조회");
//		mav.addObject("board", boardDAO.getBoard(vo));	// @SessionAttributes로 인해 model에 board라는 이름으로 저장되면 세션에도 자동 저장됨
		mav.addObject("board", boardService.getBoard(vo));
		mav.setViewName("getBoard.jsp");
		return mav;
	}

	// 글 수정
	@RequestMapping(value = "/updateBoard.do", method = RequestMethod.POST)
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
	//public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAO boardDAO) {
		
		// @ModelAttribute("board") 를 해석하여 세션에 board가 있으면 
		// 해당 객체를 꺼내서 vo에 할당 후 
		// 사용자가 입력한 파라미터를 vo에 할당한다. 
		// 이에 사용자가 입력한 값만 변경되고 나머지 정보는 유지됨 
		
//		System.out.println("BoardController) 글수정");
//		System.out.println("작성자 이름 : " + vo.getWriter());
//		System.out.println("제목 : " + vo.getTitle());
//		System.out.println("번호 : " + vo.getSeq());
//		System.out.println("등록일 : " + vo.getRegDate());
//		System.out.println("조회수 : " + vo.getCnt());
//		boardDAO.updateBoard(vo);
		boardService.updateBoard(vo);
		return "getBoardList.do";

	}

	// 글 등록
	@RequestMapping(value = "/insertBoard.do", method = RequestMethod.POST)
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException {
	//public String insertBoard(BoardVO vo, BoardDAO boardDAO) {

//		System.out.println("BoardController) 글 등록 ");
//		boardDAO.insertBoard(vo);
		
		// 파일 업로드 처리 
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("C:/FileServerTest/" + fileName));
		}
		
		boardService.insertBoard(vo);
		return "redirect:getBoardList.do"; // 기본이 포워딩 방식이므로 리다이렉트 필요
	}

	@RequestMapping(value = "/insertBoard.do", method = RequestMethod.GET)
	public String insertBoardView(BoardVO vo, HttpSession session) {
		return "insertBoard.jsp";
	}

	// 글 삭제
	@RequestMapping(value = "/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
//	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {

//		System.out.println("BoardController) 글삭제");
//		boardDAO.deleteBoard(vo);
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	
	
	@RequestMapping(value="jsonDataTransform.do")
	@ResponseBody
	public List<BoardVO> jsonDataTransform(BoardVO vo){

		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		return boardList;
	}
	
	@RequestMapping(value="xmlDataTransform.do")
	@ResponseBody
	public BoardListVO xmlDataTransform(BoardVO vo){

		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		BoardListVO boardListVO = new BoardListVO();
		boardListVO.setBoardList(boardList);
		return boardListVO;
	}

}
