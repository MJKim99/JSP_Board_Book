package com.source.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.sql.*;

class BookBatch {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	int cnt = 0;
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/boards";
	public static final String USERID = "myuser";
	public static final String USERPW = "1234";
	public static final String SQL_BOOK_INSERT = "INSERT INTO book" + "(bk_title, bk_summary, bk_price)"
			+ "VALUES(?, ?, ?)";

	@Test
	void genDate() {
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERID, USERPW);
			
			// Data 삽입
			pstmt = conn.prepareStatement(SQL_BOOK_INSERT);
			
			int num = 10;
			for (int i = 0; i < num; i++) {
				pstmt.setString(1, String.format("제목%03d", i));
				pstmt.setString(2, String.format("요약%03d", i));
				pstmt.setInt(3, i * 20000);
				cnt += pstmt.executeUpdate();
			}
			System.out.println(cnt + "개의 데이터 INSERT");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}