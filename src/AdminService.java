
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminService {
	
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
		System.out.println("me here 2");
		ArrayList<Admin> adminList = new ArrayList<Admin>();
		String sql="SELECT * FROM " + Admin.TABLE_NAME + ";";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBPool.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Admin a = new Admin();
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

}
