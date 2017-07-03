
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminService {
	
	//public static void addAdmin(String firstName, String lastName){
	public static void addAdmin(){
		String sql = "INSERT INTO " + Admin.TABLE_NAME + "( `" + Admin.COLUMN_ADMIN_FIRST_NAME + "`)"
		+ " VALUES (?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBPool.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "hello");
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
