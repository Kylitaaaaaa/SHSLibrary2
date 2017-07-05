import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookService {
	public static void addBook(String title, String type, String author, String publisher, String year, String location, String status){
		String sql = String.format("INSERT INTO %s (`%s`,`%s`,`%s`,`%s`,`%s`,`%s`,`%s`) VALUES (?,?, ?, ?, ?, ?, ?)",
				Book.TABLE_NAME, Book.COLUMN_BOOK_TITLE, Book.COLUMN_BOOK_TYPE, Book.COLUMN_BOOK_AUTHOR, Book.COLUMN_BOOK_PUBLISHER, Book.COLUMN_BOOK_YEAR, Book.COLUMN_BOOK_LOCATION, Book.COLUMN_BOOK_STATUS);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBPool.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, type);
			pstmt.setString(3, author);
			pstmt.setString(4, publisher);
			pstmt.setString(5, year);
			pstmt.setString(6, location);
			pstmt.setString(7, status);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}	
	
	public static boolean editBook (Book book) {
		String sql = "UPDATE " + Book.TABLE_NAME + " SET " + 
					 Book.COLUMN_BOOK_TITLE + "= ?, " +
					 Book.COLUMN_BOOK_TYPE + "= ?, " +
					 Book.COLUMN_BOOK_AUTHOR + "= ?, " +
					 Book.COLUMN_BOOK_PUBLISHER + "= ?, " +
					 Book.COLUMN_BOOK_YEAR + "= ?, " +
					 Book.COLUMN_BOOK_LOCATION + "= ?, " +
					 Book.COLUMN_BOOK_STATUS + "= ?, " +
					 " WHERE " + Book.COLUMN_BOOK_ID + "= ?";
					 
		Connection connection = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		int result = -1;
		
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, Integer.toString(book.getType()));
			pstmt.setString(3, book.getAuthor());
			pstmt.setString(4, book.getPublisher());
			pstmt.setString(5, Integer.toString(book.getYear()));
			pstmt.setString(6, book.getLocation());
			pstmt.setString(7, Integer.toString(book.getStatus()));
			pstmt.setString(7, Integer.toString(book.getBookId()));
			
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result > 0;
	}
	
	public static boolean deleteBook (Book book) {
		String sql = "DELETE FROM " + Book.TABLE_NAME + 
					" WHERE " + Book.COLUMN_BOOK_ID + " = ?";
					 
		Connection connection = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		int result = -1;
		
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, Integer.toString(book.getBookId()));
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result > 0;
	}

}
