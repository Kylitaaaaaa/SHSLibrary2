import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Room_LogService {
	public static boolean changeReservationDetails (String logId,String roomId, String startTime, String endTime, String reservationDate, String dateReserved, String status) {
		String sql = "UPDATE " + Room_Log.TABLE_NAME + " SET " + 
					Room_Log.COLUMN_ROOM_LOG_ROOM_ID + "= ?, " +
					Room_Log.COLUMN_ROOM_LOG_START_TIME + "= ?, " +
					Room_Log.COLUMN_ROOM_LOG_END_TIME + "= ?, " +
					Room_Log.COLUMN_ROOM_LOG_RESERVATION_DATE + "= ?, " +
					Room_Log.COLUMN_ROOM_LOG_STATUS + "= ?, " +
					Room_Log.COLUMN_ROOM_LOG_DATE_RESERVED + "= ?, " +
					 " WHERE " + Room_Log.COLUMN_ROOM_LOG_ID + "= ?";
					 
		Connection connection = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		int result = -1;
		
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, roomId);
			pstmt.setString(2, startTime);
			pstmt.setString(3, endTime);
			pstmt.setString(4, reservationDate);
			pstmt.setString(5, dateReserved);
			pstmt.setString(6, status);
			pstmt.setString(7, logId);
			
			
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


	public static boolean deleteReservation (Room_Log reservation) {
		String sql = "DELETE FROM " + Room_Log.TABLE_NAME + 
					" WHERE " + Room_Log.COLUMN_ROOM_LOG_ID + " = ?";
					 
		Connection connection = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		int result = -1;
		
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, Integer.toString(reservation.getRoomLogId()));
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

	public static ArrayList<Room_Log> getAllReservations(){
		ArrayList<Room_Log> reservationList = new ArrayList<Room_Log>();
		
		String sql="SELECT * FROM " + Room_Log.TABLE_NAME + ";";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBPool.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Room_Log a = new Room_Log();
				a.setRoomLogId(Integer.parseInt(rs.getString(Room_Log.COLUMN_ROOM_LOG_ID)));
				a.setRoomId(Integer.parseInt(rs.getString(Room_Log.COLUMN_ROOM_LOG_ROOM_ID)));
				a.setStartTime(rs.getString(Room_Log.COLUMN_ROOM_LOG_START_TIME));
				a.setEndTime(rs.getString(Room_Log.COLUMN_ROOM_LOG_END_TIME));
				a.setReservationDate(rs.getString(Room_Log.COLUMN_ROOM_LOG_RESERVATION_DATE));
				a.setStatus(rs.getString(Room_Log.COLUMN_ROOM_LOG_STATUS));
				a.setDateReserved(rs.getString(Room_Log.COLUMN_ROOM_LOG_DATE_RESERVED));
				
				reservationList.add(a);
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
		return reservationList;
	}
	
}
