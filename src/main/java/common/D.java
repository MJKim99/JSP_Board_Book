package common;

public class D {

	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/boards";
	public static final String USERID = "myuser";
	public static final String USERPW = "1234";
	
	public static final String SQL_BOOK_INSERT = "INSERT INTO book" + "(bk_title, bk_summary, bk_price)"
			+ "VALUES (?, ?, ?)";
	public static final String SQL_BOOK_SELECT =
			"SELECT bk_uid uid, bk_title title, bk_summary summary, bk_price price, "
			+ "bk_viewcnt viewcnt, bk_regdate regdate " + "FROM book ORDER BY bk_uid DESC";
	public static final String SQL_BOOK_SELECT_BY_UID =
			"SELECT bk_uid uid, bk_title title, bk_summary summary, bk_price price,"
			+ "bk_viewcnt viewcnt, bk_regdate regdate " + "FROM book WHERE bk_uid = ?";
	public static final String SQL_BOOK_INC_VIEWCNT =
			"UPDATE book SET bk_viewcnt = bk_viewcnt + 1 WHERE bk_uid = ?";
	public static final String SQL_BOOK_UPDATE = 
			"UPDATE book SET bk_title = ?, bk_summary = ?, bk_price = ? WHERE bk_uid = ?";
}