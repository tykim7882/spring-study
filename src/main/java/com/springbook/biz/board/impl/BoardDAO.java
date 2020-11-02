package com.springbook.biz.board.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;

@Repository("boardDAO")
public class BoardDAO{

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	// Query
	private final String BOARD_INSERT = "insert into board (seq, title, writer, content, regdate) values ((select nvl(max(seq), 0)+1 from board),?,?,?, sysdate)";
	private final String BOARD_UPDATE = "update board set title = ?, content = ? where seq = ?";
	private final String BOARD_DELETE = "delete from board where seq = ?";
	private final String BOARD_GET = "select seq, title, writer, content, regdate, cnt from board where seq = ?";
	private final String BOARD_LIST = "select seq, title, writer, content, regdate, cnt from board order by seq desc";
	private final String BOARD_COUNT = "select count(seq) from board";
	
	private final String BOARD_LIST_T = "select seq, title, writer, content, regdate, cnt from board where title like '%' || ? || '%' order by seq desc";
	private final String BOARD_LIST_C = "select seq, title, writer, content, regdate, cnt from board where content like '%' || ? || '%' order by seq desc";
	
	// CRUD 기능
	public void insertBoard(BoardVO vo) {
		System.out.println("insertBoard()=================");
		
		conn = JDBCUtil.getConnection();
		try {
			psmt = conn.prepareStatement(BOARD_INSERT);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getWriter());
			psmt.setString(3, vo.getContent());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(psmt, conn);
		}
		
		
	}

	public void updateBoard(BoardVO vo) {
		System.out.println("updateBoard()=================");
		
		conn = JDBCUtil.getConnection();
		try {
			psmt = conn.prepareStatement(BOARD_UPDATE);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setInt(3, vo.getSeq());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(psmt, conn);
		}
		


	}

	public void deleteBoard(BoardVO vo) {
		System.out.println("deleteBoard()=================");
		
		conn = JDBCUtil.getConnection();
		try {
			psmt = conn.prepareStatement(BOARD_DELETE);
			psmt.setInt(1, vo.getSeq());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(psmt, conn);
		}
		
		
	}

	public BoardVO getBoard(BoardVO vo) {
		System.out.println("getBoard()=================");
		
		
		BoardVO board = null;
		try {
			conn = JDBCUtil.getConnection();
			psmt = conn.prepareStatement(BOARD_GET);
			psmt.setInt(1, vo.getSeq());
			rs = psmt.executeQuery();
			if(rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setContent(rs.getString("CONTENT"));
				board.setWriter(rs.getString("WRITER")); 
//				board.setRegDate(rs.getObject(5, LocalDateTime.class));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, psmt, conn);
		}
		
		return board;
		
	}
	
	public int getBoardCount(BoardVO vo) {
		System.out.println("getBoardCount()=================");
		int count = 0;
		try {
			conn = JDBCUtil.getConnection();
			psmt = conn.prepareStatement(BOARD_COUNT);
			rs = psmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(0);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, psmt, conn);
		}
		
		return count;
	}


	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("getBoardList()=================");
		
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		
		try {
			conn = JDBCUtil.getConnection();
			
			if(vo.getSearchCondition().equals("TITLE")) {
				psmt = conn.prepareStatement(BOARD_LIST_T);
				psmt.setString(1, vo.getSearchKeyword());
			}else if(vo.getSearchCondition().equals("CONTENT")) {
				psmt = conn.prepareStatement(BOARD_LIST_C);
				psmt.setString(1, vo.getSearchKeyword());
			}else {
				psmt = conn.prepareStatement(BOARD_LIST);	
			}
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setContent(rs.getString("CONTENT"));
				board.setWriter(rs.getString("WRITER")); 
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				boardList.add(board);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, psmt, conn);
		}
		
		return boardList;
		
	}

}
