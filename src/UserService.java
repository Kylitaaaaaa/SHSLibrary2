import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserService {
	public UserService(){}
	
	public static Boolean loginUser(String username, String password){
		String sql = String.format("Select * from %s where %s = ? and %s = ?", User.TABLE_NAME, User.COLUMN_ID_NUMBER, User.COLUMN_PASSWORD);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean valid = false;
		
		try {
			conn = DBPool.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			
			valid = rs.next();
			
			
			if(valid){
				System.out.println("yay");
				valid = true;
			}
			else
				System.out.println("noo");
            
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
		return valid;
		
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
	
	public static void increaseLoginCount(String idNumber){
		String sql = "SELECT * FROM "+User.TABLE_NAME+" WHERE "+User.COLUMN_ID_NUMBER+"="+idNumber+";";
		
		User u = new User();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBPool.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){				
				u.setLockStatus(rs.getInt(User.COLUMN_LOCK_STATUS));
				u.setLoginAttempts(rs.getInt(User.COLUMN_LOGIN_ATTEMPTS));
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
		
		if(u.getLockStatus()==0&&u.getLoginAttempts()<3){
			u.setLoginAttempts(u.getLoginAttempts()+1);
			if(u.getLoginAttempts()==3)
			{
				String sql2 = "UPDATE " + User.TABLE_NAME + " SET " + 
						 User.COLUMN_LOCK_STATUS + "= ?, " +
						 User.COLUMN_LOGIN_ATTEMPTS + "= ?, " +
						 " WHERE " + User.COLUMN_ID_NUMBER + "= ?";
						 
				Connection connection = DBPool.getInstance().getConnection();
				PreparedStatement pstmt2 = null;
				
				try {
					pstmt2 = connection.prepareStatement(sql2);
					pstmt2.setString(1, "1");
					pstmt2.setString(2, "0");
					pstmt2.setString(3, idNumber);
					
					
					pstmt.executeUpdate();
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
				String sql2 = "UPDATE " + User.TABLE_NAME + " SET " + 
						 User.COLUMN_LOGIN_ATTEMPTS + "= ?, " +
						 " WHERE " + User.COLUMN_ID_NUMBER + "= ?";
						 
				Connection connection = DBPool.getInstance().getConnection();
				PreparedStatement pstmt2 = null;
				
				try {
					pstmt2 = connection.prepareStatement(sql2);
					pstmt2.setString(1, u.getLoginAttempts()+"");
					pstmt2.setString(2, idNumber);
					
					
					pstmt.executeUpdate();
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
		}
			
	}
}
