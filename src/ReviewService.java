import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReviewService {

	public static void addReview(String bookId, String reviewContent, String userId){
		
		String sql = String.format("INSERT INTO %s (`%s`,`%s`,`%s`) VALUES (?, ?,?)",
				Review.TABLE_NAME, Review.COLUMN_REVIEW_BOOK_ID,Review.COLUMN_REVIEW_REVIEW_CONTENT, Review.COLUMN_REVIEW_USER_ID );
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBPool.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bookId);
			pstmt.setString(2, reviewContent);
			pstmt.setString(3, userId);
			
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
}
