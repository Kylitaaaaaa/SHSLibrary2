import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class RoomService {
	/*
	 * 0 - Free
	 * 1 - Not Free
	 * 
	 */
	
	public static ArrayList<Meeting_Room> getAllMeetings(){ 
		ArrayList<Meeting_Room> mList = new ArrayList<Meeting_Room>();
		String sql = "SELECT * FROM meeting_room";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBPool.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				
				Meeting_Room m = new Meeting_Room();
				m.setMeetingRoomId(rs.getInt(Meeting_Room.COLUMN_ROOM_ID));
				m.setRoomName(rs.getString(Meeting_Room.COLUMN_ROOM_NAME));
				m.setRoomStatus(rs.getInt(Meeting_Room.COLUMN_ROOM_STATUS));
				
				mList.add(m);
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
		return mList;
		
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
	
	public static void reserveRoom(String roomId, String startTime, String endTime, String reservationDate, String dateReserved, String status){
		
		String sql = String.format("INSERT INTO %s (`%s`,`%s`,`%s`,`%s`,`%s`,`%s`) VALUES (?, ?, ?, ?, ?, ?)",
				Room_Log.TABLE_NAME, Room_Log.COLUMN_ROOM_LOG_START_TIME, Room_Log.COLUMN_ROOM_LOG_END_TIME, Room_Log.COLUMN_ROOM_LOG_RESERVATION_DATE, Room_Log.COLUMN_ROOM_LOG_DATE_RESERVED, Room_Log.COLUMN_ROOM_LOG_STATUS);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBPool.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, roomId);
			pstmt.setString(2, startTime);
			pstmt.setString(3, endTime);
			pstmt.setString(4, reservationDate);
			pstmt.setString(5, dateReserved);
			pstmt.setString(6, status);
			
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
	
	
	public static boolean updateRoomStatus(Meeting_Room mr){
		
		String sql = "UPDATE " + Meeting_Room.TABLE_NAME + " SET " +
				Meeting_Room.COLUMN_ROOM_STATUS + "= ?, " +
				 " WHERE " + Meeting_Room.COLUMN_ROOM_ID + "= ?";
				 
		Connection connection = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		int result = -1;
		
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,Integer.toString(mr.getRoomStatus()));
			pstmt.setString(2, Integer.toString(mr.getMeetingRoomId()));
			
			
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
