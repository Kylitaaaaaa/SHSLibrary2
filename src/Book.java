
public class Book {
	public static String TABLE_NAME = "book";
	public static String COLUMN_BOOK_ID="bookId";
	public static String COLUMN_BOOK_TITLE="title";
	public static String COLUMN_BOOK_TYPE="type";
	public static String COLUMN_BOOK_AUTHOR="author";
	public static String COLUMN_BOOK_PUBLISHER="publisher";
	public static String COLUMN_BOOK_YEAR="year";
	public static String COLUMN_BOOK_LOCATION="location";
	public static String COLUMN_BOOK_STATUS="status";
	
	
	private int bookId;
	private String title;
	private int type;
	private String author;
	private String publisher;
	private int year;
	private String location;
	private int status;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
