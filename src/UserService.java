import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserService {
	public UserService(){}

<<<<<<< Updated upstream
	public static void addCustomerUser(String idNum, String password, String email, String mNumber){
		
		
		String sql = "INSERT INTO " + User.TABLE_NAME + " (" +
				User.COLUMN_ID_NUMBER + ", " +
				User.COLUMN_PASSWORD + ", " +
				 User.COLUMN_USER_TYPE + ", " + 
				 User.COLUMN_EMAIL + ", " +
				 User.COLUMN_PHONE_NUMBER + ") " +
				 " VALUES (?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBPool.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(idNum));
			pstmt.setString(2, password);
			pstmt.setString(3, "1");
			pstmt.setString(4, email);
			pstmt.setString(5, mNumber);
			
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
	public static void addAdminUser(String idNum, String password, String email, String mNumber){
=======
	public static int addLibraryManagerUser(String idNum, String password, String email, String mNumber){
>>>>>>> Stashed changes
		
		
		String sql = "INSERT INTO " + User.TABLE_NAME + " (" +
				User.COLUMN_ID_NUMBER + ", " +
				User.COLUMN_PASSWORD + ", " +
				 User.COLUMN_USER_TYPE + ", " + 
				 User.COLUMN_EMAIL + ", " +
				 User.COLUMN_PHONE_NUMBER + ") " +
				 " VALUES (?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int auto_id = -1;
		
		
		try {
			conn = DBPool.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, Integer.parseInt(idNum));
			pstmt.setString(2, password);
			pstmt.setString(3, "0");
			pstmt.setString(4, email);
			pstmt.setString(5, mNumber);
			
			pstmt.executeUpdate();
			
			
			ResultSet rs = pstmt.getGeneratedKeys();
			rs.next();
			auto_id = rs.getInt(1);
			System.out.println("auto: " + auto_id);
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
		
		return auto_id;
	}
}
