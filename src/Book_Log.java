import java.sql.Date;

public class Book_Log {
	
	public static String TABLE_NAME = "book";
	public static String COLUMN_BOOK_LOG_ID="bookLogId";
	public static String COLUMN_BOOK_ID="bookId";
	public static String COLUMN_BOOK_BORROW_ID="borrowID";
	public static String COLUMN_BOOK_LOG_RESERVATION_DATE="reservationDate";
	public static String COLUMN_BOOK_LOG_BORROW_DATE="borrowDate";
	public static String COLUMN_BOOK_LOG_RETURN_DATE="expectedReturnDate";
	public static String COLUMN_BOOK_LOG_STATUS="status";
	
	private int bookLogId;
	private int bookId;
	private int borrowId;
	private Date reservationDate;
	private Date borrowDate;
	private Date expectedReturnDate;
	private int status;
	public int getBookLogId() {
		return bookLogId;
	}
	public void setBookLogId(int bookLogId) {
		this.bookLogId = bookLogId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getBorrowId() {
		return borrowId;
	}
	public void setBorrowId(int borrowId) {
		this.borrowId = borrowId;
	}
	public Date getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
	public Date getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}
	public Date getExpectedReturnDate() {
		return expectedReturnDate;
	}
	public void setExpectedReturnDate(Date expectedReturnDate) {
		this.expectedReturnDate = expectedReturnDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	

	
}
