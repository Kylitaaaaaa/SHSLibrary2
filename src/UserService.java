import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*USER TYPE
 * 0 - Admin
 * 1 - Manager
 * 2 - Staff
 * 3 - Prof
 * 4 - Student
 */

public class UserService {
	public UserService(){}
	
	public static int getUserType(String username){
		String sql = String.format("Select * from %s where %s = ?", User.TABLE_NAME, User.COLUMN_ID_NUMBER);
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int user_type = -1;
		
		try {
			conn = DBPool.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, username);
			
			System.out.println("sql user: " + username);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
				user_type = rs.getInt(User.COLUMN_USER_TYPE);
			else
				System.out.println("fail");
            
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
		return user_type;
		
	}
	
	public static int loginUser(String username, String password){ 
		String sql = String.format("Select * from %s where %s = ? and %s = ?", User.TABLE_NAME, User.COLUMN_ID_NUMBER, User.COLUMN_PASSWORD);
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int user_type = -1;
		
		try {
			conn = DBPool.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			System.out.println("sql user: " + username);
			System.out.println("sql password: " + password);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				user_type = rs.getInt(User.COLUMN_USER_TYPE);
				
			}
			else{
				updateLoginAttemptsLockout(username);
				System.out.println("fail");
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
		return user_type;
		
	}
	
	public static void updateLoginAttemptsLockout(String username){ 
		String sql = String.format("Select %s from %s where %s = ?", User.COLUMN_LOGIN_ATTEMPTS, User.TABLE_NAME, User.COLUMN_ID_NUMBER);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int login_attempts = -1;
		
		try {
			conn = DBPool.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, username);
			
			System.out.println("sql user: " + username);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				login_attempts = rs.getInt(User.COLUMN_LOGIN_ATTEMPTS);
			}
			else
				System.out.println("fail");
            
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
		
		if(login_attempts >=0){
			login_attempts++;
			
			if(login_attempts >=3){
				//lockout
				
				sql = "UPDATE " + User.TABLE_NAME + " SET " + 
						 User.COLUMN_LOGIN_ATTEMPTS + "= ?, " +
						 User.COLUMN_LOCK_STATUS + "= ? " +
						 " WHERE " + User.COLUMN_ID_NUMBER + "= ?";
						 
				Connection connection = DBPool.getInstance().getConnection();
				PreparedStatement pstmt2 = null;
				int result = -1;
				
				try {
					pstmt2 = connection.prepareStatement(sql);
					pstmt2.setInt(1, login_attempts);
					pstmt2.setInt(2, 1);
					pstmt2.setString(3, username);
					
					
					result = pstmt2.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						pstmt2.close();
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
			}
			else{
				//add login attempt
				sql = "UPDATE " + User.TABLE_NAME + " SET " + 
						 User.COLUMN_LOGIN_ATTEMPTS + "= ? " +
						 " WHERE " + User.COLUMN_ID_NUMBER + "= ?";
						 
				Connection connection = DBPool.getInstance().getConnection();
				PreparedStatement pstmt3 = null;
				int result = -1;
				
				try {
					System.out.println("login_attempts: " + login_attempts);
					pstmt3 = connection.prepareStatement(sql);
					pstmt3.setInt(1, login_attempts);
					pstmt3.setInt(2, Integer.parseInt(username));
					
					result = pstmt3.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						pstmt3.close();
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
		
	}
	

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
	
	public static Admin getAdmin(String id){
		Admin a = null;
		
		String sql = "SELECT * FROM User u, Admin a WHERE u.userID = ? and a.adminId = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBPool.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(id));
			pstmt.setInt(2, Integer.parseInt(id));
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				System.out.println("putangina " + rs.getInt(User.COLUMN_ID_NUMBER));
				a = new Admin();
				a.setIdNumber(rs.getInt(User.COLUMN_ID_NUMBER));
				a.setPassword(rs.getString(User.COLUMN_PASSWORD));
				a.setUserType(rs.getInt(User.COLUMN_USER_TYPE));
				a.setEmailAddress(rs.getString(User.COLUMN_EMAIL));
				a.setmNumber(rs.getString(User.COLUMN_PHONE_NUMBER));
				a.setLockStatus(rs.getInt(User.COLUMN_LOCK_STATUS));
				a.setLoginAttempts(rs.getInt(User.COLUMN_LOGIN_ATTEMPTS));
				
				a.setFirstName(rs.getString(Admin.COLUMN_ADMIN_FIRST_NAME));
				a.setLastName(rs.getString(Admin.COLUMN_ADMIN_LAST_NAME));
				a.setMiddleInitial(rs.getString(Admin.COLUMN_ADMIN_MIDDLE_INITIAL));
				a.setBirthday(rs.getString(Admin.COLUMN_ADMIN_BIRTHDAY));
			}
			else
				System.out.println("fuck ");
			System.out.println("fuck " + a.getFirstName());
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
		return a;
	}
}
