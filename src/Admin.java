import java.sql.Date;

public class Admin {
	public static String TABLE_NAME = "admin";
	public static String COLUMN_ADMIN_ID="adminID";
	public static String COLUMN_ADMIN_FIRST_NAME="firstName";
	public static String COLUMN_ADMIN_LAST_NAME="lastName";
	public static String COLUMN_ADMIN_MIDDLE_INITIAL="middleInitial";
	public static String COLUMN_ADMIN_BIRTHDAY="birthday";
	public static String COLUMN_ADMIN_SECRET_QUESTION="secretQuestion";
	public static String COLUMN_ADMIN_SECRET_ANSWER="secretAnswer";
	public static String COLUMN_ADMIN_ADMIN_TYPE="adminType";
	
	private int adminID;
	private String firstName;
	private String lastName;
	private String middleInitial;
	private Date birthday;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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
	
	
	
	

}
