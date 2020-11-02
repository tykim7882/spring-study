package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;


public class BoardSpringDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	// Query
	private final String BOARD_INSERT = "insert into board (seq, title, writer, content) values ((select nvl(max(seq), 0)+1 from board),?,?,?)";
	private final String BOARD_UPDATE = "update board set title = ?, content = ? where seq = ?";
	private final String BOARD_DELETE = "delete from board where seq = ?";
	private final String BOARD_GET = "select seq, title, writer, content, regdate, cnt from board where seq = ?";
	private final String BOARD_LIST = "select seq, title, writer, content, regdate, cnt from board order by seq desc";
	private final String BOARD_COUNT = "select count(seq) from board";
	private final String BOARD_LIST_T = "select seq, title, writer, content, regdate, cnt from board where title like '%' || ? || '%' order by seq desc";
	private final String BOARD_LIST_C = "select seq, title, writer, content, regdate, cnt from board where content like '%' || ? || '%' order by seq desc";
	

	// CRUD 기능
	public void insertBoard(BoardVO vo) {
		System.out.println("SpringDAO ] insertBoard()=================");
	
		Object[] args = {vo.getTitle(), vo.getWriter(), vo.getContent()};
		jdbcTemplate.update(BOARD_INSERT, args);
		
	}

	public void updateBoard(BoardVO vo) {
		System.out.println("SpringDAO ] updateBoard()=================");
		
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());


	}

	public void deleteBoard(BoardVO vo) {
		System.out.println("SpringDAO ] deleteBoard()=================");
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
		
	}

	public BoardVO getBoard(BoardVO vo) {
		System.out.println("SpringDAO ] getBoard()=================");
		
		Object[] agrs = {vo.getSeq()};
		try {
			return jdbcTemplate.queryForObject(BOARD_GET, agrs, new BoardRowMapper());
		}catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public int getBoardCount(BoardVO vo) {
		System.out.println("SpringDAO ] getBoardCount()=================");
		Object[] args = {};
		int count = 0;
		try {
			count = jdbcTemplate.queryForObject(BOARD_COUNT, args, Integer.class);
		}catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
		
		return count;
	}


	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("SpringDAO ] getBoardList()=================");
		Object[] args = {vo.getSearchKeyword()};
		
		if(vo.getSearchCondition().equals("TITLE")) {
			return jdbcTemplate.query(BOARD_LIST_T, args, new BoardRowMapper());
		}else if(vo.getSearchCondition().equals("CONTENT")) {
			return jdbcTemplate.query(BOARD_LIST_C, args, new BoardRowMapper());
		}
		
		return null;
		
	}

}
