import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
				System.out.println("yay " + rs.getInt(User.COLUMN_USER_TYPE));
				int temp = rs.getInt(User.COLUMN_USER_TYPE);
				switch(temp){
					case 0:
						//for admin
						Admin a = getAdmin(Integer.toString(rs.getInt(User.COLUMN_USER_ID)));
						if(a!=null){
							int adminType =a.getAdminType();
							
							if(adminType ==0){
								
							}
							else if(adminType ==1){
								
							}
							else if(adminType ==2){
								
							}
							
						}
						break;
					case 1:
						//check customer
						break;
				}
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
