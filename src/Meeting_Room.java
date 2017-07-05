
public class Meeting_Room {
	
	/*
	 * 0 - Free
	 * 1 - Not Free
	 * 
	 */
	
	public static String TABLE_NAME = "meeting_room";
	public static String COLUMN_ROOM_ID = "meetingRoomId";
	public static String COLUMN_ROOM_NAME = "roomName";
	public static String COLUMN_ROOM_STATUS = "roomStatus";
	
	private int meetingRoomId;
	private String roomName;
	private int roomStatus;
	
	public int getMeetingRoomId() {
		return meetingRoomId;
	}
	public void setMeetingRoomId(int meetingRoomId) {
		this.meetingRoomId = meetingRoomId;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int getRoomStatus() {
		return roomStatus;
	}
	public void setRoomStatus(int roomStatus) {
		this.roomStatus = roomStatus;
	}
	
	

}
