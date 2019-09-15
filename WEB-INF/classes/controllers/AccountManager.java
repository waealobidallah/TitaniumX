/**
 * @FileName: AccountManager.java
 * 
 * @authore 
 * Titanium x
 * Ekaterina Guseva <eguse009@uottawa.ca>
 * Mohamad Safie <msafie083@uottawa.ca>
 * Mert Metin <mertmetin@outlook.com>
 * Waeal J.Obidallah <Wobidallah@uoattwa.ca>
 *  
 * Package name: controllers
 */
package controllers;

import java.io.IOException;

import models.Account;
import models.Address;
import ws.OrderProcessorWebService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// TODO: Auto-generated Javadoc
/**
 * The Class AccountManager.
 */
public class AccountManager{
	
	/** The session. */
	HttpSession session;

	
	/**
	 * 
	 * Process action requests.
	 *
	 * @param actionPath the action path
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void processActionRequests(String actionPath,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (actionPath.equals("/register")) {
			processAccountRegistration(request, response);
		}
		else if (actionPath.equals("/login")){
			processValidateAccount(request, response);
		}
		else if (actionPath.equals("/viewAccount"))
		{
			processViewAccount(request, response);
		}
	}
	
	/**
	 * Process view account.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void processViewAccount(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{
		String email = (String) request.getSession().getAttribute("email");
		String password = (String) request.getSession().getAttribute("password") ;
		
		Account account = getAccountInfo(email, password);
		
		request.setAttribute("accountObj", account);
		
		request.getRequestDispatcher("/AccountInfo.jsp").forward(request, response);
		
	}

	/**
	 * Process account registration.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void processAccountRegistration(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	

		String  firstName, lastName, password, email;
		
		firstName = request.getParameter("fname");
		lastName = request.getParameter("lname");
		email = request.getParameter("email");
		password = request.getParameter("pass1");
		
		String street, city, province, zipCode, country;
		
		street = request.getParameter("street");
		city = request.getParameter("city");
		province = request.getParameter("province");
		zipCode = request.getParameter("zipcode");
		country = request.getParameter("country");

		boolean registrationSucceeded = register(firstName,
				lastName, password,  email, street, city, province, zipCode, country);
		request.getSession().setAttribute("nextPage","submitRegistration");
		response.sendRedirect("submitRegistration.jsp");
		
	}
	
	
	/**
	 * Register.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param password the password
	 * @param email the email
	 * @param street the street
	 * @param city the city
	 * @param province the province
	 * @param zipCode the zip code
	 * @param country the country
	 * @return true, if successful
	 */
	private boolean register(String firstName, String lastName, String password,
			 String email, String street, String city, String province, String zipCode, String country)
	{
		OrderProcessorWebService orderProcessService = new OrderProcessorWebService();

		
		boolean registrationSuccess = false;
		
		Account account = new Account();
		account.setFirstName(firstName);
		account.setLastName(lastName);
		account.setPassword(password);
		account.setEmail(email);
		
		Address address = new Address();
		address.setCity(city);
		address.setCountry(country);
		address.setProvince(province);
		address.setStreet(street);
		address.setZipcode(zipCode);
		
		registrationSuccess = orderProcessService.createAccount(account, address);
		
		if(registrationSuccess == true)
			System.out.println("Registered successfully.");
		else
			System.err.println("There is an error. Registration is failed.");
		
		return registrationSuccess;
	}
	
	/**
	 * Process validate account.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	private void processValidateAccount(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException
	{
		String email, password;
		
		email = request.getParameter("email");
		password = request.getParameter("password");
		
		Account account = getAccountInfo(email, password);
		
		if(account != null){
			session = request.getSession(true);
			session.setAttribute("email", email);
			session.setAttribute("password", password);
			
			request.setAttribute("servletMessage", "Login Successful");
		}	
		else
			request.setAttribute("servletMessage", "Login Unsuccessful");
		
		request.getSession().setAttribute("nextPage","index");	
		request.getRequestDispatcher("/index.jsp").forward(request,response);
	}
	
	/**
	 * Gets the account info.
	 *
	 * @param email the email
	 * @param password the password
	 * @return the account info
	 */
	private Account getAccountInfo(String email, String password) {
		OrderProcessorWebService orderProcessService = new OrderProcessorWebService();
		
		Account account = orderProcessService.getAccount(email, password);
		
		return account;
	}
	

}
