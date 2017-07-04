

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TrialServlet
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public AdminService adminService = new AdminService();
	public CustomerService customerService = new CustomerService();
	public UserService userService = new UserService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("controller get called" + request.getParameter("process"));
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("controller do called" + request.getParameter("process"));
		process(request, response);
		
		//doGet(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String process = request.getParameter("process");
		
		System.out.println("Ongoing " + process);
		
		switch (process) {
		
		case "addManager":
			addManager(request, response);
			break;
			
		default:
			
			break;
		}
	}

	protected void addManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//change string to int
		String idNum =  request.getParameter("id_num");
		String fName = request.getParameter("first_name");
		String lName = request.getParameter("m_initial");
		String mi = request.getParameter("last_name");
		String mNum = request.getParameter("mobile_number");
		String email = request.getParameter("email_address");
		String sQuestion = request.getParameter("secret_question");
		String sAnswer = request.getParameter("secret_answer");
		String birthday = request.getParameter("birthday");
		String password = request.getParameter("password");
		
		
		if(idNum != null & fName != null & lName != null & mi != null & mNum  != null & email != null & sQuestion != null & sAnswer != null & birthday != "" & password != null){
			UserService.addAdminUser(idNum, password, email, mNum);
			String adminId= ""/*Get UserID where COLUMN_ID_NUMBER = idNum */;
			adminService.addLibraryManager(adminId,fName, lName, mi, sQuestion, sAnswer, birthday);

		}
			
		else 
			System.out.println("Aww");		
		
	}
	protected void addStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		//change string to int
		String idNum =  request.getParameter("id_num");
		String fName = request.getParameter("first_name");
		String lName = request.getParameter("m_initial");
		String mi = request.getParameter("last_name");
		String mNum = request.getParameter("mobile_number");
		String email = request.getParameter("email_address");
		String sQuestion = request.getParameter("secret_question");
		String sAnswer = request.getParameter("secret_answer");
		String birthday = request.getParameter("birthday");
		String password = request.getParameter("password");
		
		
		if(idNum != null & fName != null & lName != null & mi != null & mNum  != null & email != null & sQuestion != null & sAnswer != null & birthday != "" & password != null){
			UserService.addAdminUser(idNum, password, email, mNum);
			String adminId= ""/*Get UserID where COLUMN_ID_NUMBER = idNum */;
			adminService.addLibraryStaff(adminId,fName, lName, mi, sQuestion, sAnswer, birthday);

		}
			
		else 
			System.out.println("Aww");				
	}
	

	protected void addAdministrator(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		//change string to int
		String idNum =  request.getParameter("id_num");
		String fName = request.getParameter("first_name");
		String lName = request.getParameter("m_initial");
		String mi = request.getParameter("last_name");
		String mNum = request.getParameter("mobile_number");
		String email = request.getParameter("email_address");
		String sQuestion = request.getParameter("secret_question");
		String sAnswer = request.getParameter("secret_answer");
		String birthday = request.getParameter("birthday");
		String password = request.getParameter("password");
		
		
		if(idNum != null & fName != null & lName != null & mi != null & mNum  != null & email != null & sQuestion != null & sAnswer != null & birthday != "" & password != null){
			UserService.addAdminUser(idNum, password, email, mNum);
			String adminId= ""/*Get UserID where COLUMN_ID_NUMBER = idNum */;
			adminService.addAdministrator(adminId,fName, lName, mi, sQuestion, sAnswer, birthday);

		}			
		else 
			System.out.println("Aww");				
	}
	

	protected void addProfessor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		//change string to int
		String idNum =  request.getParameter("id_num");
		String fName = request.getParameter("first_name");
		String lName = request.getParameter("m_initial");
		String mi = request.getParameter("last_name");
		String mNum = request.getParameter("mobile_number");
		String email = request.getParameter("email_address");
		String sQuestion = request.getParameter("secret_question");
		String sAnswer = request.getParameter("secret_answer");
		String birthday = request.getParameter("birthday");
		String password = request.getParameter("password");
		
		
		if(idNum != null & fName != null & lName != null & mi != null & mNum  != null & email != null & sQuestion != null & sAnswer != null & birthday != "" & password != null){
			UserService.addCustomerUser(idNum, password, email, mNum);
			String customerId= ""/*Get UserID where COLUMN_ID_NUMBER = idNum */;
			customerService.addProfessor(customerId,fName, lName, mi, sQuestion, sAnswer, birthday);
		}			
		else 
			System.out.println("Aww");				
	}	
	protected void addStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		//change string to int
		String idNum =  request.getParameter("id_num");
		String fName = request.getParameter("first_name");
		String lName = request.getParameter("m_initial");
		String mi = request.getParameter("last_name");
		String mNum = request.getParameter("mobile_number");
		String email = request.getParameter("email_address");
		String sQuestion = request.getParameter("secret_question");
		String sAnswer = request.getParameter("secret_answer");
		String birthday = request.getParameter("birthday");
		String password = request.getParameter("password");
		
		
		if(idNum != null & fName != null & lName != null & mi != null & mNum  != null & email != null & sQuestion != null & sAnswer != null & birthday != "" & password != null){
			UserService.addCustomerUser(idNum, password, email, mNum);
			String customerId= ""/*Get UserID where COLUMN_ID_NUMBER = idNum */;
			customerService.addStudent(customerId,fName, lName, mi, sQuestion, sAnswer, birthday);
		}			
		else 
			System.out.println("Aww");				
	}	
}
