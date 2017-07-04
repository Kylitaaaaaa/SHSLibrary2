import java.sql.Date;

public class Customer {
	public static String TABLE_NAME = "customer";
	public static String COLUMN_CUSTOMER_ID="customerId";
	public static String COLUMN_CUSTOMER_FIRST_NAME="firstName";
	public static String COLUMN_CUSTOMER_LAST_NAME="lastName";
	public static String COLUMN_CUSTOMER_MIDDLE_INITIAL="middleInitial";
	public static String COLUMN_CUSTOMER_BIRTHDAY="birthday";
	public static String COLUMN_CUSTOMER_SECRET_QUESTION="secretQuestion";
	public static String COLUMN_CUSTOMER_SECRET_ANSWER="secretAnswer";
	public static String COLUMN_CUSTOMER_CUSTOMER_TYPE="customerType";
	
	private int customerID;
	private String firstName;
	private String lastName;
	private String middleInitial;
	private Date birthday;
	private String secretQuestion;
	private String secretAnswer;
	private int customerType;
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
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
	public int getCustomerType() {
		return customerType;
	}
	public void setCustomerType(int customerType) {
		this.customerType = customerType;
	}
	
	
}
