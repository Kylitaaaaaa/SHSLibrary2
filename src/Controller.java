

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TrialServlet
 */


/*
 * Admin
 * 0 - Admin
 * 1 - Manager
 * 2 - Staff
 * 
 * Student
 * 3 - Prof
 * 4 - Student
 */

@WebServlet(urlPatterns={"/Controller",
						"/getAllAdminManager",
						"/loginUser",
						"/meetingRoomsPage"})
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
		
		System.out.println("controller get called " + request.getParameter("process"));
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
		String a_type = request.getParameter("a_type");
		
		/*
		 * Admin
		 * 0 - Admin
		 * 1 - Manager
		 * 2 - Staff
		 * 
		 * Student
		 * 3 - Prof
		 * 4 - Student
		 */
		
		String process = "";
		
		if(request.getServletPath()!= null)
			process = request.getServletPath();
		System.out.println("here");		
		
		
		switch (process) {
		
		case "/getAllAdminManager":
			getAllAdminManager(request, response);
			break;
		case "/loginUser":
			System.out.println("here 2");
			loginUser(request, response);
			break;
		case "/meetingRoomsPage":
			gotoMeetingRooms(request, response);
			break;
			
			
			
		default:
			//getAllAdminManager(request, response);
			System.out.println("here 3");
			break;
		}
		
		/*
		if(a_type != null){
			switch (a_type) {
			case "0":
				addAdministrator(request, response);
				break;
			case "1":
				addManager(request, response);
				break;
			case "2":
				addStaff(request, response);
				break;		
			case "3":
			case "4":
				addStudentProfessor(request, response);
				break;		
			default:
				//error handling
				break;
			}
			
		}
		else{
			String process = request.getParameter("process");
			
			switch (process) {
			
			case "/getAllAdminManager":
				getAllAdminManager(request, response);
				break;
				
			default:
				
				break;
			}
		}
		*/
	}
	
	protected void gotoMeetingRooms(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Meeting_Room> mr = RoomService.getAllMeetings();
		
		request.setAttribute("meetingRooms", mr);
		
		request.getRequestDispatcher("meetings.jsp").forward(request, response);
	}
	
	protected void loginUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		//change string to int
		System.out.println("At login");			
		String username =  request.getParameter("user");
		String password = request.getParameter("pass");
		
		System.out.println("Username : " + username);
		System.out.println("password : " + password);
		
		
		
		if(username != null && password != null){
			boolean isValid = false;
			isValid = UserService.loginUser(username, password);
			if(isValid){
				request.setAttribute("hasUser", true);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			
			
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
		String a_type = request.getParameter("a_type");
		
		
		if(idNum != null && fName != null && lName != null && mi != null && mNum  != null && email != null && sQuestion != null && sAnswer != null && birthday != "" && password != null && a_type != null){
			int adminId = UserService.addAdminUser(idNum, password, email, mNum, a_type);
			adminService.addAdministrator(Integer.toString(adminId),fName, lName, mi, sQuestion, sAnswer, birthday);

		}			
		else 
			System.out.println("Aww");				
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
		String a_type = request.getParameter("a_type");
		
		
		if(idNum != null && fName != null && lName != null && mi != null && mNum  != null && email != null && sQuestion != null && sAnswer != null && birthday != "" && password != null && a_type != null){
			int adminId= UserService.addAdminUser(idNum, password, email, mNum, a_type);
			adminService.addLibraryManager(Integer.toString(adminId),fName, lName, mi, sQuestion, sAnswer, birthday);

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
		String a_type = request.getParameter("a_type");
		
		if(idNum != null && fName != null && lName != null && mi != null && mNum  != null && email != null && sQuestion != null && sAnswer != null && birthday != "" && password != null && a_type != null){
			int adminId= UserService.addAdminUser(idNum, password, email, mNum, a_type);
			adminService.addLibraryStaff(Integer.toString(adminId),fName, lName, mi, sQuestion, sAnswer, birthday);

		}
			
		else 
			System.out.println("Aww");				
	}
	

	protected void addStudentProfessor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
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
		String a_type = request.getParameter("a_type");
		
		
		if(idNum != null && fName != null && lName != null && mi != null && mNum  != null && email != null && sQuestion != null && sAnswer != null && birthday != "" && password != null){
			int customerId= UserService.addCustomerUser(idNum, password, email, mNum, a_type);
			if(customerId != -1)
				if(a_type.equals("3"))
					customerService.addProfessor(Integer.toString(customerId),fName, lName, mi, sQuestion, sAnswer, birthday, a_type);
				else if(a_type.equals("4"))
					customerService.addStudent(Integer.toString(customerId),fName, lName, mi, sQuestion, sAnswer, birthday, a_type);
		}			
		else 
			System.out.println("Aww");				
	}	
	
	protected void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title =  request.getParameter("title");
		String type = request.getParameter("type");
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		String year = request.getParameter("year");
		String location = request.getParameter("location");
		String status = request.getParameter("status");
		
		if(title != null && type != null && author != null && publisher != null && year != null && location != null && status != null)
			BookService.addBook(title, type, author, publisher, year, location, status);
		else 
			System.out.println("Aww");				
	}
	
	protected void reserveBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookId =  request.getParameter("bookId");
		String borrowId = request.getParameter("borrowId");
		String reservationDate = request.getParameter("reservationDate");
		String borrowDate = request.getParameter("borrowDate");
		String expectedReturnDate = request.getParameter("expectedReturnDate");
		String status = request.getParameter("status");
		
		if(bookId != null && borrowId != null && reservationDate != null && borrowDate != null && expectedReturnDate != null && status != null){
			BookService.reserveBook(bookId, borrowId, reservationDate, borrowDate, expectedReturnDate, status);
			Book b = new Book();
			b.setBookId(Integer.parseInt(bookId));
			b.setStatus(Integer.parseInt(status));
			BookService.updateBookStatus(b);
		}
		else 
			System.out.println("Aww");				
	}
	
	protected void reserveRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roomId =  request.getParameter("roomId");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String reservationDate = request.getParameter("reservationDate");
		String dateReserved = request.getParameter("dateReserved");
		String status = request.getParameter("status");
		
		if(roomId != null && startTime != null && startTime != null && endTime != null && reservationDate != null && dateReserved != null && status != null){
			RoomService.reserveRoom(roomId, startTime, endTime, reservationDate, dateReserved, status);
			Meeting_Room r = new Meeting_Room();
			r.setMeetingRoomId(Integer.parseInt(roomId));
			r.setRoomStatus(Integer.parseInt(status));
			RoomService.updateRoomStatus(r);
		}
		else 
			System.out.println("Aww");				
	}
	
	protected void unlockUserAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID =  request.getParameter("userID");
		
		if(userID != null){
			AdminService.unlockAccount(userID);
		}
		else 
			System.out.println("Aww");				
	}
	
	protected void getAllAdminManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("here at getAllAdminManager");
		ArrayList <Admin> adminManList = AdminService.getAllUserLibraryManager();
		
		for(int i=0; i<adminManList.size(); i++)
			System.out.println(i + ": " + adminManList.get(i).getFirstName());
		
		request.setAttribute("adminManList", adminManList);
		request.getRequestDispatcher("Admin.jsp").forward(request, response);
	}
	
	protected void searchBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		ArrayList<Book> bookList = new ArrayList<Book>();
		bookList=BookService.getAllBooksWithSearch(keyword);
		request.setAttribute("bookList", bookList);
		//Edit the Admin.jsp
		//request.getRequestDispatcher("Admin.jsp").forward(request, response);
		
	}

	protected void filterBooksbyAuthor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String startingLetter = request.getParameter("startingLetter");
		ArrayList<Book> bookList = new ArrayList<Book>();
		bookList=BookService.getAllBooksAuthorStartingWithLetter(startingLetter);
		request.setAttribute("bookList", bookList);
		//Edit the Admin.jsp
		//request.getRequestDispatcher("Admin.jsp").forward(request, response);		
	}

	protected void filterBooksbyTitle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String startingLetter = request.getParameter("startingLetter");
		ArrayList<Book> bookList = new ArrayList<Book>();
		bookList=BookService.getAllBooksTitleStartingWithLetter(startingLetter);
		request.setAttribute("bookList", bookList);
		//Edit the Admin.jsp
		//request.getRequestDispatcher("Admin.jsp").forward(request, response);		
	}


	protected void filterBooksbyPublisher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String startingLetter = request.getParameter("startingLetter");
		ArrayList<Book> bookList = new ArrayList<Book>();
		bookList=BookService.getAllBooksPublisherStartingWithLetter(startingLetter);
		request.setAttribute("bookList", bookList);
		//Edit the Admin.jsp
		//request.getRequestDispatcher("Admin.jsp").forward(request, response);		
	}
	
	
	
}
