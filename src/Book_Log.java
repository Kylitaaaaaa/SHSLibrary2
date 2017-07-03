import java.sql.Date;

public class Book_Log {
	private int bookLogID;
	private int bookID;
	private int borrowID;
	private Date reservationDate;
	private Date borrowDate;
	private Date expectedReturnDate;
	private int status;
	public int getBookLogID() {
		return bookLogID;
	}
	public void setBookLogID(int bookLogID) {
		this.bookLogID = bookLogID;
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public int getBorrowID() {
		return borrowID;
	}
	public void setBorrowID(int borrowID) {
		this.borrowID = borrowID;
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
