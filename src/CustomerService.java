import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerService {
	/*USER TYPE
	 * 0 - Admin
	 * 1 - Manager
	 * 2 - Staff
	 * 3 - Prof
	 * 4 - Student
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
	public static ArrayList<Customer> getAllCustomer(){
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		String sql = "SELECT * FROM "+ User.TABLE_NAME+" u, "+Customer.TABLE_NAME+" c WHERE u."+User.COLUMN_USER_ID+" = c."+Customer.COLUMN_CUSTOMER_ID+";";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBPool.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){	
				
				Customer a = new Customer();
				a.setIdNumber(rs.getInt(User.COLUMN_ID_NUMBER));
				a.setPassword(rs.getString(User.COLUMN_PASSWORD));
				a.setUserType(rs.getInt(User.COLUMN_USER_TYPE));
				a.setEmailAddress(rs.getString(User.COLUMN_EMAIL));
				a.setmNumber(rs.getString(User.COLUMN_PHONE_NUMBER));
				a.setLockStatus(rs.getInt(User.COLUMN_LOCK_STATUS));
				a.setLoginAttempts(rs.getInt(User.COLUMN_LOGIN_ATTEMPTS));
				
				a.setFirstName(rs.getString(Customer.COLUMN_CUSTOMER_FIRST_NAME));
				a.setLastName(rs.getString(Customer.COLUMN_CUSTOMER_LAST_NAME));
				a.setMiddleInitial(rs.getString(Customer.COLUMN_CUSTOMER_MIDDLE_INITIAL));
				a.setBirthday(rs.getString(Customer.COLUMN_CUSTOMER_BIRTHDAY));
				customerList.add(a);
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
		return customerList;
	}
}
