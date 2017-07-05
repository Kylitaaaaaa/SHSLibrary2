
public class Room_Log {
	/*
	 * 0 - Free
	 * 1 - Not Free
	 * 
	 */
	
	public static String TABLE_NAME = "room_log";
	public static String COLUMN_ROOM_LOG_ID = "roomLogId";
	public static String COLUMN_ROOM_LOG_ROOM_ID = "roomId";
	public static String COLUMN_ROOM_LOG_START_TIME = "startTime";
	public static String COLUMN_ROOM_LOG_END_TIME = "endTime";
	public static String COLUMN_ROOM_LOG_RESERVATION_DATE = "reservationDate";
	public static String COLUMN_ROOM_LOG_DATE_RESERVED = "dateReserved";
	public static String COLUMN_ROOM_LOG_STATUS = "status";
	
	private int roomLogId;
	private int roomId;
	private String startTime;
	private String endTime;
	private String reservationDate;
	private String dateReserved;
	private String status;
	public int getRoomLogId() {
		return roomLogId;
	}
	public void setRoomLogId(int roomLogId) {
		this.roomLogId = roomLogId;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}
	public String getDateReserved() {
		return dateReserved;
	}
	public void setDateReserved(String dateReserved) {
		this.dateReserved = dateReserved;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
