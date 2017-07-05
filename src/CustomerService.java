import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerService {
	/*
	 * 0 - Prof
	 * 1 - Student
	 */
	public static void addProfessor(String customerId,String firstName, String mi, String lastName, String secretQ, String secretA, String birthday, String a_type){
		
		String sql = String.format("INSERT INTO %s (`%s`,`%s`,`%s`,`%s`,`%s`,`%s`,`%s`,`%s`) VALUES (?,?, ?, ?, ?, ?, ?, ?)",
				Customer.TABLE_NAME, Customer.COLUMN_CUSTOMER_ID, Customer.COLUMN_CUSTOMER_FIRST_NAME, Customer.COLUMN_CUSTOMER_LAST_NAME, Customer.COLUMN_CUSTOMER_MIDDLE_INITIAL, Customer.COLUMN_CUSTOMER_BIRTHDAY, Customer.COLUMN_CUSTOMER_SECRET_QUESTION, Customer.COLUMN_CUSTOMER_SECRET_ANSWER, Customer.COLUMN_CUSTOMER_CUSTOMER_TYPE);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBPool.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, customerId);
			pstmt.setString(2, firstName);
			pstmt.setString(3, lastName);
			pstmt.setString(4, mi);
			pstmt.setString(5, birthday);
			pstmt.setString(6, secretQ);
			pstmt.setString(7, secretA);
			pstmt.setString(8, a_type);
			
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
	public static void addStudent(String customerId,String firstName, String mi, String lastName, String secretQ, String secretA, String birthday, String a_type){
		
		String sql = String.format("INSERT INTO %s (`%s`,`%s`,`%s`,`%s`,`%s`,`%s`,`%s`,`%s`) VALUES (?,?, ?, ?, ?, ?, ?, ?)",
				Customer.TABLE_NAME, Customer.COLUMN_CUSTOMER_ID, Customer.COLUMN_CUSTOMER_FIRST_NAME, Customer.COLUMN_CUSTOMER_LAST_NAME, Customer.COLUMN_CUSTOMER_MIDDLE_INITIAL, Customer.COLUMN_CUSTOMER_BIRTHDAY, Customer.COLUMN_CUSTOMER_SECRET_QUESTION, Customer.COLUMN_CUSTOMER_SECRET_ANSWER, Customer.COLUMN_CUSTOMER_CUSTOMER_TYPE);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBPool.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, customerId);
			pstmt.setString(2, firstName);
			pstmt.setString(3, lastName);
			pstmt.setString(4, mi);
			pstmt.setString(5, birthday);
			pstmt.setString(6, secretQ);
			pstmt.setString(7, secretA);
			pstmt.setString(8, a_type);
			
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
