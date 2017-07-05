import java.sql.Date;

public class User {
	public static String TABLE_NAME = "user";
	
	public static String COLUMN_USER_ID = "userID";
	public static String COLUMN_ID_NUMBER = "idNumber";
	public static String COLUMN_PASSWORD = "password";
	public static String COLUMN_USER_TYPE = "userType";
	public static String COLUMN_EMAIL = "emailAddress";
	public static String COLUMN_PHONE_NUMBER = "phoneNumber";
	public static String COLUMN_LOCK_STATUS = "lockStatus";
	public static String COLUMN_LOGIN_ATTEMPTS = "loginAttempts";
	
	private int userID;
	private int idNumber;
	private String password;
	private int userType;
	private String emailAddress;
	private String phoneNumber;
	private int lockStatus;
	private int loginAttempts;
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getLockStatus() {
		return lockStatus;
	}
	public void setLockStatus(int lockStatus) {
		this.lockStatus = lockStatus;
	}
	public int getLoginAttempts() {
		return loginAttempts;
	}
	public void setLoginAttempts(int loginAttempts) {
		this.loginAttempts = loginAttempts;
	}
	
	
	
	
	
}
