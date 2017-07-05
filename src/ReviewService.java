import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReviewService { 

	public static void addReview(String bookId, String reviewContent, String userId, String reviewDate){
		
		String sql = String.format("INSERT INTO %s (`%s`,`%s`,`%s`,`%s`) VALUES (?, ?,?,?)",
				Review.TABLE_NAME, Review.COLUMN_REVIEW_BOOK_ID,Review.COLUMN_REVIEW_REVIEW_CONTENT, Review.COLUMN_REVIEW_USER_ID,Review.COLUMN_REVIEW_REVIEW_DATE );
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBPool.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bookId);
			pstmt.setString(2, reviewContent);
			pstmt.setString(3, userId);
			pstmt.setString(4, reviewDate);
			
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

	public static ArrayList<Review> getAllReviewsOfABook(int bookId){
		ArrayList<Review> reviewList = new ArrayList<Review>();
		
		String sql="SELECT * FROM "+Review.TABLE_NAME+" where bookId='"+bookId+"'";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBPool.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Review a = new Review();
				a.setReviewId(Integer.parseInt(rs.getString(Review.COLUMN_REVIEW_ID)));
				a.setBookId(Integer.parseInt(rs.getString(Review.COLUMN_REVIEW_BOOK_ID)));
				a.setReviewContent(rs.getString(Review.COLUMN_REVIEW_REVIEW_CONTENT));
				a.setUserId(Integer.parseInt(rs.getString(Review.COLUMN_REVIEW_USER_ID)));
				a.setReviewDate(rs.getString(Review.COLUMN_REVIEW_REVIEW_DATE));
				
				reviewList.add(a);
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
		return reviewList;
	}
	
}
