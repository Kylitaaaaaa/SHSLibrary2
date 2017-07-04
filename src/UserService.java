import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserService {
	public UserService(){}

	public static int addCustomerUser(String idNum, String password, String email, String mNumber, String customerType){
		
		
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
			pstmt.setString(3, customerType);
			pstmt.setString(4, email);
			pstmt.setString(5, mNumber);
			
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();

            if (rs.next()) {
            	auto_id = rs.getInt(1);
            }
            
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
	public static int addAdminUser(String idNum, String password, String email, String mNumber, String userType){
		
		
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
			pstmt.setString(3, userType);
			pstmt.setString(4, email);
			pstmt.setString(5, mNumber);
			
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();

            if (rs.next()) {
            	auto_id = rs.getInt(1);
            }
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
