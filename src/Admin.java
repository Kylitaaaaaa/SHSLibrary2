import java.sql.Date;

/**
 * @author Thea
 *
 */
public class Admin {
	public static String TABLE_NAME = "admin";
	public static String COLUMN_ADMIN_ID="adminId";
	public static String COLUMN_ADMIN_FIRST_NAME="firstName";
	public static String COLUMN_ADMIN_LAST_NAME="lastName";
	public static String COLUMN_ADMIN_MIDDLE_INITIAL="middleInitial";
	public static String COLUMN_ADMIN_BIRTHDAY="birthday";
	public static String COLUMN_ADMIN_SECRET_QUESTION="secretQuestion";
	public static String COLUMN_ADMIN_SECRET_ANSWER="secretAnswer";
	public static String COLUMN_ADMIN_ADMIN_TYPE="adminType";
	
	//added
	private int idNumber;
	private String password;
	private int userType;
	private String emailAddress;
	private String mNumber;
	private int lockStatus;
	private int loginAttempts;
	
	//original
	private int adminID;
	private String firstName;
	private String lastName;
	private String middleInitial;
	private String birthday;
	private String secretQuestion;
	private String secretAnswer;
	private int adminType;
	public int getAdminID() {
		return adminID;
	}
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}
	public String getSecretQuestion() {
		return secretQuestion;
	}
	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}
	public String getSecretAnswer() {
		return secretAnswer;
	}
	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}
	public int getAdminType() {
		return adminType;
	}
	public void setAdminType(int adminType) {
		this.adminType = adminType;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
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
	public String getmNumber() {
		return mNumber;
	}
	public void setmNumber(String mNumber) {
		this.mNumber = mNumber;
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
