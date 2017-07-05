import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
	
	public static void reserveBook(String bookId, String borrowId, String reservationDate, String borrowDate, String expectedReturnDate, String status){
		
		String sql = String.format("INSERT INTO %s (`%s`,`%s`,`%s`,`%s`,`%s`,`%s`) VALUES (?, ?, ?, ?, ?, ?)",
				Book_Log.TABLE_NAME, Book_Log.COLUMN_BOOK_ID, Book_Log.COLUMN_BOOK_BORROW_ID, Book_Log.COLUMN_BOOK_LOG_RESERVATION_DATE, Book_Log.COLUMN_BOOK_LOG_BORROW_DATE, Book_Log.COLUMN_BOOK_LOG_RETURN_DATE, Book_Log.COLUMN_BOOK_LOG_STATUS);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBPool.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bookId);
			pstmt.setString(2, borrowId);
			pstmt.setString(3, reservationDate);
			pstmt.setString(4, borrowDate);
			pstmt.setString(5, expectedReturnDate);
			pstmt.setString(6, status);
			
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
	
	
	public static boolean updateBookStatus(Book b){ 
		String sql = "UPDATE " + Book_Log.TABLE_NAME + " SET " +
				Book_Log.COLUMN_BOOK_LOG_STATUS + "= ?, " +
				 " WHERE " + Book_Log.COLUMN_BOOK_ID + "= ?";
				 
		Connection connection = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		int result = -1;
		
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,Integer.toString(b.getStatus()));
			pstmt.setString(2, Integer.toString(b.getBookId()));
			
			
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
	

	
	public static ArrayList<Book> getAllBooks(){
		ArrayList<Book> bookList = new ArrayList<Book>();
		String sql="SELECT * FROM " + Book.TABLE_NAME + ";";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBPool.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Book a = new Book();
				a.setBookId(Integer.parseInt(rs.getString(Book.COLUMN_BOOK_ID)));
				a.setTitle(rs.getString(Book.COLUMN_BOOK_TITLE));
				a.setType(Integer.parseInt(rs.getString(Book.COLUMN_BOOK_TYPE)));
				a.setAuthor(rs.getString(Book.COLUMN_BOOK_AUTHOR));
				a.setPublisher(rs.getString(Book.COLUMN_BOOK_PUBLISHER));
				a.setYear(Integer.parseInt(rs.getString(Book.COLUMN_BOOK_YEAR)));
				a.setLocation(rs.getString(Book.COLUMN_BOOK_LOCATION));
				a.setStatus(Integer.parseInt(rs.getString(Book.COLUMN_BOOK_STATUS)));
				bookList.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bookList;		
	}
	
	
	public static ArrayList<Book> getAllBooksWithSerach(String key){
		ArrayList<Book> bookList = new ArrayList<Book>();
		String sql="SELECT * FROM " + Book.TABLE_NAME + 
				"where title like '%"+key+"%'"+
				"or author like '%"+key+"%'"+
				"or publisher like '%"+key+"%';";
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBPool.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Book a = new Book();
				a.setBookId(Integer.parseInt(rs.getString(Book.COLUMN_BOOK_ID)));
				a.setTitle(rs.getString(Book.COLUMN_BOOK_TITLE));
				a.setType(Integer.parseInt(rs.getString(Book.COLUMN_BOOK_TYPE)));
				a.setAuthor(rs.getString(Book.COLUMN_BOOK_AUTHOR));
				a.setPublisher(rs.getString(Book.COLUMN_BOOK_PUBLISHER));
				a.setYear(Integer.parseInt(rs.getString(Book.COLUMN_BOOK_YEAR)));
				a.setLocation(rs.getString(Book.COLUMN_BOOK_LOCATION));
				a.setStatus(Integer.parseInt(rs.getString(Book.COLUMN_BOOK_STATUS)));
				bookList.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bookList;		
	}

	
	public static ArrayList<Book> getAllBooksTitleStartingWithLetter(String key){
		ArrayList<Book> bookList = new ArrayList<Book>();
		String sql="SELECT * FROM " + Book.TABLE_NAME + 
				"where title like '"+key+"%';";		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBPool.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Book a = new Book();
				a.setBookId(Integer.parseInt(rs.getString(Book.COLUMN_BOOK_ID)));
				a.setTitle(rs.getString(Book.COLUMN_BOOK_TITLE));
				a.setType(Integer.parseInt(rs.getString(Book.COLUMN_BOOK_TYPE)));
				a.setAuthor(rs.getString(Book.COLUMN_BOOK_AUTHOR));
				a.setPublisher(rs.getString(Book.COLUMN_BOOK_PUBLISHER));
				a.setYear(Integer.parseInt(rs.getString(Book.COLUMN_BOOK_YEAR)));
				a.setLocation(rs.getString(Book.COLUMN_BOOK_LOCATION));
				a.setStatus(Integer.parseInt(rs.getString(Book.COLUMN_BOOK_STATUS)));
				bookList.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bookList;		
	}

	public static ArrayList<Book> getAllBooksAuthorStartingWithLetter(String key){
		ArrayList<Book> bookList = new ArrayList<Book>();
		String sql="SELECT * FROM " + Book.TABLE_NAME + 
				"where author like '"+key+"%';";		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBPool.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Book a = new Book();
				a.setBookId(Integer.parseInt(rs.getString(Book.COLUMN_BOOK_ID)));
				a.setTitle(rs.getString(Book.COLUMN_BOOK_TITLE));
				a.setType(Integer.parseInt(rs.getString(Book.COLUMN_BOOK_TYPE)));
				a.setAuthor(rs.getString(Book.COLUMN_BOOK_AUTHOR));
				a.setPublisher(rs.getString(Book.COLUMN_BOOK_PUBLISHER));
				a.setYear(Integer.parseInt(rs.getString(Book.COLUMN_BOOK_YEAR)));
				a.setLocation(rs.getString(Book.COLUMN_BOOK_LOCATION));
				a.setStatus(Integer.parseInt(rs.getString(Book.COLUMN_BOOK_STATUS)));
				bookList.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bookList;		
	}	

	public static ArrayList<Book> getAllBooksPublishertartingWithLetter(String key){
		ArrayList<Book> bookList = new ArrayList<Book>();
		String sql="SELECT * FROM " + Book.TABLE_NAME + 
				"where publisher like '"+key+"%';";		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBPool.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Book a = new Book();
				a.setBookId(Integer.parseInt(rs.getString(Book.COLUMN_BOOK_ID)));
				a.setTitle(rs.getString(Book.COLUMN_BOOK_TITLE));
				a.setType(Integer.parseInt(rs.getString(Book.COLUMN_BOOK_TYPE)));
				a.setAuthor(rs.getString(Book.COLUMN_BOOK_AUTHOR));
				a.setPublisher(rs.getString(Book.COLUMN_BOOK_PUBLISHER));
				a.setYear(Integer.parseInt(rs.getString(Book.COLUMN_BOOK_YEAR)));
				a.setLocation(rs.getString(Book.COLUMN_BOOK_LOCATION));
				a.setStatus(Integer.parseInt(rs.getString(Book.COLUMN_BOOK_STATUS)));
				bookList.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bookList;		
	}	

	public static ArrayList<Book> sortBooksByTitle(ArrayList<Book> books){
		
		Collections.sort(books,new Comparator<Book>(){
			@Override
			public int compare(Book book2, Book book1){
				return book1.getTitle().compareTo(book2.getTitle());
			}
			
		});
		return books;
	}
	public static ArrayList<Book> sortBooksByAuthor(ArrayList<Book> books){
		
		Collections.sort(books,new Comparator<Book>(){
			@Override
			public int compare(Book book2, Book book1){
				return book1.getAuthor().compareTo(book2.getAuthor());
			}
			
		});
		return books;
	}
	public static ArrayList<Book> sortBooksByPublisher(ArrayList<Book> books){
		
		Collections.sort(books,new Comparator<Book>(){
			@Override
			public int compare(Book book2, Book book1){
				return book1.getPublisher().compareTo(book2.getPublisher());
			}
			
		});
		return books;
	}

}
