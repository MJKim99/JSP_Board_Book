package com.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import common.D;

public class BookDAO {

	Connection conn;
	
	PreparedStatement pstmt;
	ResultSet rs;

	public BookDAO() {
		try {
			Class.forName(D.DRIVER);
			conn = DriverManager.getConnection(D.URL, D.USERID, D.USERPW);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() throws SQLException {
		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		
		if (conn != null)
			conn.close();
	}

	private List<BookDTO> buildList(ResultSet rs) throws SQLException {
		List<BookDTO> list = new ArrayList<>();

		while (rs.next()) {
			int uid = rs.getInt("uid");
			String title = rs.getString("title");
			String summary = rs.getString("summary");
			if (summary == null)
				summary = "";
			int price = rs.getInt("price");
			int viewCnt = rs.getInt("viewcnt");
			LocalDateTime regDate = rs.getObject("regdate", LocalDateTime.class);

			BookDTO dto = new BookDTO(uid, title, summary, price, viewCnt, regDate);
			list.add(dto);
		}
		return list;
	}

	public List<BookDTO> select() throws SQLException {
		List<BookDTO> list = null;

		try {
			pstmt = conn.prepareStatement(D.SQL_BOOK_SELECT);
			rs = pstmt.executeQuery();
			list = buildList(rs);
		} finally {
			close();
		}
		return list;
	}

	public int insert(BookDTO dto) throws SQLException {
		int cnt = 0;
		
		String title = dto.getTitle();
		String summary = dto.getSummary();
		int price = dto.getPrice();
		
		int uid;
		String[] generatedCols = {"bk_uid"};
		
		try {
			pstmt = conn.prepareStatement(D.SQL_BOOK_INSERT, generatedCols);
			pstmt.setString(1, title);
			pstmt.setString(2, summary);
			pstmt.setInt(3, price);
			cnt = pstmt.executeUpdate();
			
			if (cnt > 0) {
				rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					uid = rs.getInt(1);
					dto.setUid(uid);
				}
			}
		} finally {
			close();
		}
		
		return cnt;
	}

	public List<BookDTO> readByUid(int uid) throws SQLException {
		List<BookDTO> list = null;
		
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(D.SQL_BOOK_INC_VIEWCNT);
			pstmt.setInt(1, uid);
			pstmt.executeUpdate();
			pstmt.close();
			
			pstmt = conn.prepareStatement(D.SQL_BOOK_SELECT_BY_UID);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			list = buildList(rs);
			
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			throw e;
		} finally {
			close();
		}
		
		return list;
	}
	
	public List<BookDTO> selectByUid(int uid) throws SQLException {
		List<BookDTO> list = null;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_BOOK_SELECT_BY_UID);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			list = buildList(rs);
		} finally {
			close();
		}
		
		return list;
	}
	
	public int update(int uid, String title, String summary, int price) throws SQLException {
		int cnt = 0;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_BOOK_UPDATE);
			pstmt.setString(1, title);
			pstmt.setString(2, summary);
			pstmt.setInt(3, price);
			pstmt.setInt(4, uid);
			cnt = pstmt.executeUpdate();
		} finally {
			close();
		}
		
		return cnt;
	}

	public int deleteByUid(int uid) throws SQLException {
		int cnt = 0;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_BOOK_DELETE);
			pstmt.setInt(1, uid);
			cnt = pstmt.executeUpdate();
		} finally {
			close();
		}
		
		return cnt;
	}

}