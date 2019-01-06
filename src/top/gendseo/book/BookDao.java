package top.gendseo.book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import top.gendseo.book.pojo.*;

public class BookDao {
	private static final String DB_DEIVER = "org.postgresql.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/Bookdb";
	private static final String DB_NAME = "Books";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "1";
	private static Connection connection = null;
	
	public static String query() throws SQLException, ClassNotFoundException {
		PreparedStatement ps;
		
		List<Book> bookList = new ArrayList<>();
		
		Class.forName(DB_DEIVER);
		connection = DriverManager.getConnection(DB_URL + DB_NAME, DB_USER, DB_PASSWORD);
		ps = connection.prepareStatement("SELECT * FROM books");
		// ps.executeUpdate()
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
;
			Book book = new Book();
			book.setBid(rs.getInt("Bid"));
			book.setBname(rs.getString("Bname"));
			book.setBnumber(rs.getInt("Bnumber"));
			bookList.add(book);

		BookBean bookBean = new BookBean();
		bookBean.setRows(bookList);
		
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		query();
	}

}
