
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminService {
	
	/*USER TYPE
	 * 0 - Admin
	 * 1 - Manager
	 * 2 - Staff
	 * 3 - Prof
	 * 4 - Student
	 */
	
	public AdminService(){}
	
	

	public static void addAdministrator(String adminId,String firstName, String mi, String lastName, String secretQ, String secretA, String birthday){
		
		String sql = String.format("INSERT INTO %s (`%s`,`%s`,`%s`,`%s`,`%s`,`%s`,`%s`,`%s`) VALUES (?,?, ?, ?, ?, ?, ?, ?)",
				Admin.TABLE_NAME, Admin.COLUMN_ADMIN_ID, Admin.COLUMN_ADMIN_FIRST_NAME, Admin.COLUMN_ADMIN_LAST_NAME, Admin.COLUMN_ADMIN_MIDDLE_INITIAL, Admin.COLUMN_ADMIN_BIRTHDAY, Admin.COLUMN_ADMIN_SECRET_QUESTION, Admin.COLUMN_ADMIN_SECRET_ANSWER, Admin.COLUMN_ADMIN_ADMIN_TYPE);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBPool.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, adminId);
			pstmt.setString(2, firstName);
			pstmt.setString(3, lastName);
			pstmt.setString(4, mi);
			pstmt.setString(5, birthday);
			pstmt.setString(6, secretQ);
			pstmt.setString(7, secretA);
			pstmt.setString(8, "0");
			
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
	public static void addLibraryManager(String adminId,String firstName, String mi, String lastName, String secretQ, String secretA, String birthday){
		
		String sql = String.format("INSERT INTO %s (`%s`,`%s`,`%s`,`%s`,`%s`,`%s`,`%s`,`%s`) VALUES (?,?, ?, ?, ?, ?, ?, ?)",
				Admin.TABLE_NAME, Admin.COLUMN_ADMIN_ID,Admin.COLUMN_ADMIN_FIRST_NAME, Admin.COLUMN_ADMIN_LAST_NAME, Admin.COLUMN_ADMIN_MIDDLE_INITIAL, Admin.COLUMN_ADMIN_BIRTHDAY, Admin.COLUMN_ADMIN_SECRET_QUESTION, Admin.COLUMN_ADMIN_SECRET_ANSWER, Admin.COLUMN_ADMIN_ADMIN_TYPE);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBPool.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, adminId);
			pstmt.setString(2, firstName);
			pstmt.setString(3, lastName);
			pstmt.setString(4, mi);
			pstmt.setString(5, birthday);
			pstmt.setString(6, secretQ);
			pstmt.setString(7, secretA);
			pstmt.setString(8, "1");
			
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
	
	public static void addLibraryStaff(String adminId,String firstName, String mi, String lastName, String secretQ, String secretA, String birthday){
		
		String sql = String.format("INSERT INTO %s (`%s`,`%s`,`%s`,`%s`,`%s`,`%s`,`%s`,`%s`) VALUES (?,?, ?, ?, ?, ?, ?, ?)",
				Admin.TABLE_NAME, Admin.COLUMN_ADMIN_ID, Admin.COLUMN_ADMIN_FIRST_NAME, Admin.COLUMN_ADMIN_LAST_NAME, Admin.COLUMN_ADMIN_MIDDLE_INITIAL, Admin.COLUMN_ADMIN_BIRTHDAY, Admin.COLUMN_ADMIN_SECRET_QUESTION, Admin.COLUMN_ADMIN_SECRET_ANSWER, Admin.COLUMN_ADMIN_ADMIN_TYPE);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBPool.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, adminId);
			pstmt.setString(2, firstName);
			pstmt.setString(3, lastName);
			pstmt.setString(4, mi);
			pstmt.setString(5, birthday);
			pstmt.setString(6, secretQ);
			pstmt.setString(7, secretA);
			pstmt.setString(8, "2");
			
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
	public static ArrayList<Admin> getAllUserLibraryManager(){
		ArrayList<Admin> adminList = new ArrayList<Admin>();
		
		//String sql="SELECT * FROM " + Admin.TABLE_NAME + ";";
//		SELECT * FROM shslibrary.user u,admin a
//		where u.userID=a.adminId;
		
		String sql = "SELECT * FROM User u, Admin a WHERE u.userID = a.adminId";
		
		//String sql = "SELECT * FROM " + User.TABLE_NAME + " u, " + Admin.TABLE_NAME + " a WHERE u." + User.COLUMN_ID_NUMBER + " = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBPool.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				
//				//added
//				private int idNumber;
//				private String password;
//				private int userType;
//				private String emailAddress;
//				private String mNumber;
//				private int lockStatus;
//				private int loginAttempts;
//				
//				//original
//				private int adminID;
//				private String firstName;
//				private String lastName;
//				private String middleInitial;
//				private String birthday;
//				private String secretQuestion;
//				private String secretAnswer;
//				private int adminType;
				
				
				Admin a = new Admin();
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
				adminList.add(a);
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
		return adminList;
	}
	
	public static boolean unlockAccount (String userID) {
		String sql = "UPDATE " + User.TABLE_NAME + " SET " + 
					 User.COLUMN_LOCK_STATUS + "= ?, " +
					 User.COLUMN_LOGIN_ATTEMPTS + "= ?, " +
					 " WHERE " + User.COLUMN_USER_ID + "= ?";
					 
		Connection connection = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		int result = -1;
		
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, "0");
			pstmt.setString(2, "0");
			pstmt.setString(3, userID);
			
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result > 0;
	}

	
}
