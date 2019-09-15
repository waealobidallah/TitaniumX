/**
 * @FileName: OrderManager.java
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

import models.Account;
import models.CD;
import models.Purchase;
import shoppingcart.ShoppingCart;
import shoppingcart.ShoppingCartItem;
import ws.OrderProcessorWebService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



// TODO: Auto-generated Javadoc
/**
 * The Class OrderManager.
 */
public class OrderManager {

	/** The transaction counter. */
	static int transactionCounter = 0 ; 
	
	/**
	 * Process action requests.
	 *
	 * @param actionPath the action path
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void processActionRequests(
			String actionPath, 
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException 
	{
		if ( actionPath.equals("/addToCart") ) 
		{
			processAddToCartRequest( request, response );
		}
		else if (actionPath.equals("/removeFromCart") )
		{
			processRemoveFromCartRequest(request, response);
		}
		else if (actionPath.equals("/orderCheckout"))
		{
			processOrderCheckoutRequest(request, response);
		}
		else if (actionPath.equals("/confirmOrder"))
		{
			processOrderConfirmRequest(request, response);
		}
		
	}

	/**
	 * Process add to cart request.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void processAddToCartRequest(
			HttpServletRequest request,
			HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String loggedUser = (String) request.getSession().getAttribute("email");
		
		if (loggedUser == null || loggedUser.equals("") )  
		{
			request.getRequestDispatcher("/index.jsp").forward(
					request, response);
			//request.getRequestDispatcher("/dynamic.jsp").forward(request,response) ;
		}
		
		else
		{
			String email = (String) request.getSession().getAttribute("email") ;
			//String check =  (String) request.getSession().getAttribute("email");
			ShoppingCart shoppingCart = (ShoppingCart) request.getSession().getAttribute("shoppingCart");
			if (shoppingCart == null)
				shoppingCart = new ShoppingCart(email);
			
			String cdId = request.getParameter("cd_id");
			ProductManager prodMgr = new ProductManager() ;
			
			String cd = prodMgr.getProductInfo(Integer.parseInt(cdId)) ;
			String[] cdParts = cd.split("\\|") ;
			
			ShoppingCartItem item = new ShoppingCartItem(Integer.parseInt(cdParts[0]), cdParts[1], 
					Float.parseFloat(cdParts[2])) ;
			
			shoppingCart.addCdToCart(item);
			
			request.getSession().setAttribute("shoppingCart", shoppingCart);
			request.setAttribute("servletMessage", "Thank you: requested CD added to Cart");	
			request.getSession().setAttribute("nextPage","Categories");
			request.getRequestDispatcher("/Categories.jsp").forward(request,response) ;
			//request.getRequestDispatcher("/dynamic.jsp").forward(request,response) ;
		}
		
	}
	
	/**
	 * Process remove from cart request.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void processRemoveFromCartRequest(
			HttpServletRequest request,
			HttpServletResponse response) 
			throws ServletException, IOException 
	{

		ShoppingCart shoppingCart = (ShoppingCart) 
				request.getSession().getAttribute("shoppingCart") ;

		int cdId =  Integer.parseInt(request.getParameter("cdId"));
		
		shoppingCart.removeCdFromCart(cdId);

		if (shoppingCart.isEmpty())
		{
			request.setAttribute("servletMessage", "No Items in Cart");
		}

		request.getSession().setAttribute("shoppingCart", shoppingCart);
		request.getSession().setAttribute("nextPage","myCart");
		request.getRequestDispatcher("/myCart.jsp").forward(request, response);
		//request.getRequestDispatcher("/dynamic.jsp").forward(request,response) ;
	}
	
	/**
	 * Process order checkout request.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void processOrderCheckoutRequest(
			HttpServletRequest request,
			HttpServletResponse response) 
			throws ServletException, IOException
	{
		ShoppingCart shoppingCart = (ShoppingCart) 
				request.getSession().getAttribute("shoppingCart");
		
		OrderProcessorWebService orderProcessService = new OrderProcessorWebService();
		int shoppingCartID = orderProcessService.createOrder(shoppingCart);
		
		shoppingCart.setShoppingCartID(shoppingCartID);
		
		request.getSession().setAttribute("shoppingCart", shoppingCart);
		request.getSession().setAttribute("nextPage","orderCheckout");
		request.getRequestDispatcher("/orderCheckout.jsp").forward(request, response);
		//request.getRequestDispatcher("/dynamic.jsp").forward(request,response) ;
	}
	
	/**
	 * Process order confirm request.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void processOrderConfirmRequest(
			HttpServletRequest request,
			HttpServletResponse response) 
			throws ServletException, IOException
	{
		
		transactionCounter++ ; 
		ShoppingCart shoppingCart = (ShoppingCart) 
				request.getSession().getAttribute("shoppingCart") ;
		
		if (transactionCounter%5 == 0)
		{
			request.setAttribute("servletMessage", "Transaction Declined!!!");	
		}
		else 
		{
			int creditCardNum = Integer.parseInt(request.getParameter("credit_card_number")); 
		
			OrderProcessorWebService orderProcessService = new OrderProcessorWebService();
			orderProcessService.confirmOrder(shoppingCart, creditCardNum);
			
			request.setAttribute("servletMessage", "Transaction Successful!!!");
		}
		request.getSession().removeAttribute("shoppingCart");
		request.getSession().setAttribute("nextPage","orderConfirm");
		request.getRequestDispatcher("/orderConfirm.jsp").forward(request, response);
		//request.getRequestDispatcher("/dynamic.jsp").forward(request,response) ;
		
	}
	
}
