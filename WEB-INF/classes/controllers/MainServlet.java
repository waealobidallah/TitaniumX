/**
 * @FileName: MainServlet.java
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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

// TODO: Auto-generated Javadoc
/**
 * The Class MainServlet.
 */
public class MainServlet extends HttpServlet{
	
	/** The session. */
	HttpSession session;

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new main servlet.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet() 
	{
		super();
	}
	
	/* 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException  {
		String actionPath = request.getServletPath() ;
		
		if (actionPath.equals("/categoryList") || actionPath.equals("/productList") || actionPath.equals("/productInfo"))
		{
			ProductManager productMgr = new ProductManager() ; 
			productMgr.process(actionPath, request, response) ;
		}
		
		if (actionPath.equals("/viewAccount") )
		{
			AccountManager accountMgr = new AccountManager(); 
			accountMgr.processActionRequests(actionPath, request, response);
		}
	}
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String actionPath = request.getServletPath();		
		if (actionPath.equals("/login") || actionPath.equals("/register")) 
		{
			AccountManager accountMgr = new AccountManager() ; 
			accountMgr.processActionRequests(actionPath, request, response);
		}
		
		else if(actionPath.equals("/logout"))
		{
			session = request.getSession(false);
			if (session != null) {
				session.invalidate();
				System.out.print("User logged out from the system.");
			}
			
			response.sendRedirect("index.jsp");
		}
		
		else if(actionPath.equals("/addToCart") || actionPath.equals("/removeFromCart") 
				|| actionPath.equals("/orderCheckout") ||  actionPath.equals("/confirmOrder") )
		{
			System.out.print("yes");
			OrderManager orderMgr = new OrderManager() ;
			orderMgr.processActionRequests(actionPath, request, response);
		}
		
		else if(actionPath.equals("/sendEmail"))
				{
			System.out.println("email");
			int status=0;
			SendMail mail = new SendMail(request, response);
			
			response.sendRedirect("index.jsp");
			
			
			
				}
	}

}
