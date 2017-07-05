import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	
}
