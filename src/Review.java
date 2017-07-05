
public class Review {
	public static String TABLE_NAME = "review"; 
	public static String COLUMN_REVIEW_ID="reviewId";
	public static String COLUMN_REVIEW_BOOK_ID="bookId";
	public static String COLUMN_REVIEW_REVIEW_CONTENT="reviewContent";
	public static String COLUMN_REVIEW_USER_ID="userId";
	public static String COLUMN_REVIEW_REVIEW_DATE="reviewDate";
	
	private int reviewId;
	private int bookId;
	private String reviewContent;
	private int userId;
	private String reviewDate;
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	

}
