

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
						"/meetingRoomsPage",
						"/postAjax",
						"/getAjax",
						"/search",
						"/filterBooks",
						"/libMagPage",
						"/addBook",
						"/deleteBook",
						"/editBook",
						"/override",
						"/addUser"})
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
		
		System.out.println("going to path: "+process);
		
		switch (process) {
		
		case "/getAllAdminManager":
			getAllAdminManager(request, response);
			break;
		case "/loginUser":
			loginUser(request, response);
			break;
		case "/meetingRoomsPage":
			gotoMeetingRooms(request, response);
			break;
		case "/postAjax":
			postAjax(request, response);
			break;
		case "/getAjax":
			getAjax(request, response);
			break;
		case "/search":	
			search(request,response);
			break;
		case "/filterBooks":
			filterBooks(request, response);
			break;
		case "/libMagPage":
			libMagPage(request,response);
			break;
		case "/addBook":
			addBooklm(request, response);
			break;
		case "/deleteBook":
			deleteBooklm(request, response);
			break;
		case "/editBook":
			editBooklm(request, response);
			break;
		case "/override":
			overridelm(request, response);
			break;
		case "/addUser":
			addUser(request, response);
			break;
			
		default:
			//check cookies
			Cookie[] cookies = request.getCookies();
			String username = null;
			if (cookies != null) {
				for (int i = 0; i < cookies.length; i++) {
					if (cookies[i].getName().equals("username")) {
						username = cookies[i].getValue();
						break;
					}
				}
			}
			
			if(username ==null)
				request.getRequestDispatcher("login.jsp").forward(request, response);
			else{
				int user_type = UserService.getUserType(username);
				switch(user_type){
					case 0:
						System.out.println("here at admin login");
						
						getAllAdminManager(request, response);
						break;
					case 1:
						request.getRequestDispatcher("library-manager.jsp").forward(request, response);
						break;
					case 2:
						request.getRequestDispatcher("library-staff.jsp").forward(request, response);
						break;
					case 3:
						request.getRequestDispatcher("index.jsp").forward(request, response);
						break;
					case 4:
						request.getRequestDispatcher("index.jsp").forward(request, response);
						break;
					default:
						request.getRequestDispatcher("login.jsp").forward(request, response);
						break;
				}
			}
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
	
	protected void overridelm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		changeRoomReservationDetails(request, response);
		request.getRequestDispatcher("library-manager.jsp").forward(request, response);
	}
	
	protected void editBooklm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		editBook(request, response);
		request.getRequestDispatcher("library-manager.jsp").forward(request, response);
	}
	
	protected void deleteBooklm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		deleteBook(request, response);
		request.getRequestDispatcher("library-manager.jsp").forward(request, response);
	}
	
protected void addBooklm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		addBook(request, response);
		request.getRequestDispatcher("library-manager.jsp").forward(request, response);
	}
	
	protected void libMagPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("library-manager.jsp").forward(request, response);
	}
	
	protected void filterBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filter = request.getParameter("filter");
		
		ArrayList<Book> books;
		
		/*switch(filter){
			case "Author":
				books = BookService.sort
				break;
			case "Title":
				break;
			case "Publisher":
				break;
		}*/
	}
	
	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String input = request.getParameter("searchInput");
		
		ArrayList<Book> books = BookService.getAllBooksWithSearch(input);
		
		request.setAttribute("books", books);
		request.setAttribute("searchInput", input);
		
		request.getRequestDispatcher("search-results.jsp").forward(request, response);
	}
	
	protected void postAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parameterToInsert = request.getParameter("parameterToPost");
		switch(parameterToInsert){
			case "reserveMeeting":
				String meetingId = request.getParameter("meetingId");
				//reserveRoom with meetingId
				//check if successfully reserved
				boolean isReserved = false;
				isReserved = reserveRoom(request, response);
				
				if(isReserved){
					//do something
				}
				else{
					//do something
				}
					
				String reserved = "true";
				response.getWriter().write(reserved);
				break;
			case "reserveBook":
				String bookId = request.getParameter("bookId");
				//reserveRoom with meetingId
				//check if successfully reserved
				boolean isReserved1 = false;
				reserveBook(request, response);
				
				if(isReserved1){
					//do something
				}
				else{
					//do something
				}
					
				String reserved1 = "true";
				response.getWriter().write(reserved1);
				break;
			case "reviewBook":
				String bookId1 = request.getParameter("bookId");
				String review = request.getParameter("bookReview");
				System.out.println("book review: "+review);
				//reserveRoom with meetingId
				//check if successfully reserved
				boolean isReviewed = false;
				addReview(request, response);
				
				if(isReviewed){
					//do something
				}
				else{
					//do something
				}
					
				String reviewed = "true";
				response.getWriter().write(reviewed);
				break;
		}
	}
	
	protected void getAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parameterToGet = request.getParameter("parameterToGet");
		
		switch(parameterToGet){
		}
	}
	
	protected void gotoMeetingRooms(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Meeting_Room> mr = RoomService.getAllMeetings();
		
		System.out.println("meeting rooms #"+mr.size());
		
		request.setAttribute("meetingRooms", mr);
		
		request.getRequestDispatcher("meetings.jsp").forward(request, response);
	}
	
	protected void loginUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		System.out.println("here at login");
		//change string to int		
		String username =  request.getParameter("user");
		String password = request.getParameter("pass");
		
		System.out.println("Username : " + username);
		System.out.println("password : " + password);
		
		if(username != null && password != null){
			int user_type = -1;
			user_type = UserService.loginUser(username, password);
			Cookie myCookie = null;
			switch(user_type){
				case 0:
					myCookie = new Cookie("username", username);
					response.addCookie(myCookie);
					System.out.println("Saved cookie 0! " + username);
					getAllAdminManager(request, response);
					//request.getRequestDispatcher("Admin.jsp").forward(request, response);
					break;
				case 1:
					myCookie = new Cookie("username", username);
					response.addCookie(myCookie);
					
					System.out.println("Saved cookie 1! " + username);
					request.getRequestDispatcher("library-manager.jsp").forward(request, response);
					break;
				case 2:
					myCookie = new Cookie("username", username);
					response.addCookie(myCookie);
					System.out.println("Saved cookie 2! " + username);
					request.getRequestDispatcher("library-staff.jsp").forward(request, response);
					break;
				case 3:
					myCookie = new Cookie("username", username);
					response.addCookie(myCookie);
					System.out.println("Saved cookie 3! " + username);
					
					request.getRequestDispatcher("index.jsp").forward(request, response);
					break;
				case 4:
					myCookie = new Cookie("username", username);
					response.addCookie(myCookie);
					System.out.println("Saved cookie 4! " + username);
					
					request.getRequestDispatcher("index.jsp").forward(request, response);
					break;
				default:
					request.getRequestDispatcher("login.jsp").forward(request, response);
					break;
			}
			
			
		}			
		else 
			System.out.println("Username and password do not match");				
	}
	
	
	
	protected void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
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
		
		
		if(idNum != null && fName != null && lName != null && mi != null && mNum  != null && email != null && sQuestion != null && sAnswer != null && birthday != "" && password != null && a_type != null && a_type != ""){
			
			int temp = Integer.parseInt(a_type);
			
			switch(temp){
				case 1:
				case 2:
					int adminId = UserService.addAdminUser(idNum, password, email, mNum, a_type);
					adminService.addAdministrator(Integer.toString(adminId),fName, lName, mi, sQuestion, sAnswer, birthday);
					break;
				case 3:
				case 4:
					addStudentProfessor(request, response);
					break;
				default:
					break;
					
			}
			

		}			
		else 
			System.out.println("Aww");		
		getAllAdminManager(request, response);
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
	
	protected boolean reserveRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			
			return true;
		}
		else 
			System.out.println("Aww");		
		return false;
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
	protected void deleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Book book = new Book();
		book.setBookId(Integer.parseInt(request.getParameter("bookId")));
		if(BookService.deleteBook(book))
		{
			System.out.println("BOOK DELETED");
			//Edit the Admin.jsp
			//request.getRequestDispatcher("Admin.jsp").forward(request, response);	
		}
		else
		{
			//Edit the Admin.jsp
			//request.getRequestDispatcher("Admin.jsp").forward(request, response);	
		}
	}
	protected void editBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Book book = new Book();
		book.setBookId(Integer.parseInt(request.getParameter("bookId")));
		book.setAuthor(request.getParameter("author"));
		book.setPublisher(request.getParameter("publisher"));
		book.setLocation(request.getParameter("location"));
		book.setStatus(Integer.parseInt(request.getParameter("status")));
		book.setTitle(request.getParameter("title"));
		book.setType(Integer.parseInt(request.getParameter("type")));
		book.setYear(Integer.parseInt(request.getParameter("year")));
		if(BookService.editBook(book))
		{
			System.out.println("BOOK DELETED");
			//Edit the Admin.jsp
			//request.getRequestDispatcher("Admin.jsp").forward(request, response);	
		}
		else
		{
			//Edit the Admin.jsp
			//request.getRequestDispatcher("Admin.jsp").forward(request, response);	
		}
	}
	

	protected void changeRoomReservationDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Room_Log room_Log = new Room_Log();
		String logId = request.getParameter("room_logId");
		String roomId = request.getParameter("roomId");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String reservationDate = request.getParameter("reservationDate");
		String dateReserved = request.getParameter("dateReserved");
		String status = request.getParameter("status");
		if(Room_LogService.changeReservationDetails(logId, roomId, startTime, endTime, reservationDate, dateReserved, status))
		{
			System.out.println("BOOK DELETED");
			//Edit the Admin.jsp
			//request.getRequestDispatcher("Admin.jsp").forward(request, response);	
		}
		else
		{
			//Edit the Admin.jsp
			//request.getRequestDispatcher("Admin.jsp").forward(request, response);	
		}
	}
	

	protected void deleteRoomReservation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roomLogId = request.getParameter("roomLogId");
		Room_Log reservation = new Room_Log();
		reservation.setRoomLogId(Integer.parseInt(roomLogId));
		if(Room_LogService.deleteReservation(reservation))
		{
			System.out.println("BOOK DELETED");
			//Edit the Admin.jsp
			//request.getRequestDispatcher("Admin.jsp").forward(request, response);	
		}
		else
		{
			//Edit the Admin.jsp
			//request.getRequestDispatcher("Admin.jsp").forward(request, response);	
		}
	}
	
	
	protected void getAllReservations(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("here at getAllAdminManager");
		ArrayList <Room_Log> room_LogList = Room_LogService.getAllReservations();
		
		request.setAttribute("room_LogList", room_LogList);
		//Edit the Admin.jsp
		//request.getRequestDispatcher("Admin.jsp").forward(request, response);	
	}
	

	protected void addReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//change string to int
		String bookId =  request.getParameter("bookId");
		String reviewContent = request.getParameter("reviewContent");
		String userId = request.getParameter("userId");
		String reviewDate = request.getParameter("reviewDate");
		
		if(bookId != null && reviewContent != null && userId != null && reviewDate != null){
			ReviewService.addReview(bookId, reviewContent, userId, reviewDate);
		}
			
		else 
			System.out.println("Aww");		
		
	}
	

	
	protected void getAllReviewsOfABook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String bookId =  request.getParameter("bookId");
		ArrayList <Review> reviewList = ReviewService.getAllReviewsOfABook(Integer.parseInt(bookId));
		
		request.setAttribute("reviewList", reviewList);
		//Edit the Admin.jsp
		//request.getRequestDispatcher("Admin.jsp").forward(request, response);	
	}
	
	
	protected void getAllCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList <Customer> customerList = CustomerService.getAllCustomer();
		
		request.setAttribute("customerLists", customerList);
		//Edit the Admin.jsp
		//request.getRequestDispatcher("Admin.jsp").forward(request, response);	
	}
}
