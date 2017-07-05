import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


public class RoomService {
	/*
	 * 0 - Free
	 * 1 - Not Free
	 * 
	 */
	
	public static ArrayList<Meeting_Room> getAllMeetings(){
		
		//String sql = String.format("SELECT *");
		
		return null;
		
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
