package com.springbook.biz.user.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserVO;

@Repository("userDAO")
public class UserDAO {

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String USER_GET = "select id, password, name, role from users where id = ? and password = ?";

	public UserVO getUser(UserVO vo) {
		
		System.out.println("getUser ==========> "+ vo.toString());
		
//		Object[] args = {vo.getId(), vo.getPassword()};
//		return jdbcTemplate.queryForObject(USER_GET, args, new UserRowMapper());
		
		UserVO user = null;
		try {
			conn = JDBCUtil.getConnection();
			psmt = conn.prepareStatement(USER_GET);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPassword());
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setName(rs.getString("NAME"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setRole(rs.getString("ROLE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, psmt, conn);
		}
		
		return user;


	}

}
