/**
 * @FileName: ProductManager.java
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
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Account;
import ws.OrderProcessorWebService;
import ws.ProductCatalogWebService;

// TODO: Auto-generated Javadoc
/**
 * Servlet implementation class ProductServlet.
 */
public class ProductManager {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Process.
	 *
	 * @param actionPath the action path
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void process(String actionPath,
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (actionPath.equals("/categoryList"))
		{
			List<String> categoryList = getCategoryList(); 
			List<String> nonFilteredProductList = getProductList(0) ;
			request.getSession().setAttribute("categoryList", categoryList);
			request.setAttribute("productList", nonFilteredProductList);
			request.getSession().setAttribute("nextPage","Categories");
			request.getRequestDispatcher("/Categories.jsp").forward(request,response) ;
		}
		if (actionPath.equals("/productList"))
		{
			String categoryID = request.getParameter("categoryID") ;
			int categoryIDValue = 0 ; 
			if (categoryID != null)
				categoryIDValue = Integer.parseInt(categoryID) ;
				
			List<String> productList = getProductList(categoryIDValue); 
			request.setAttribute("productList", productList);
			request.getSession().setAttribute("nextPage","ProductList");
			request.getRequestDispatcher("/ProductList.jsp").forward(request,response) ;
		}
		if (actionPath.equals("/productInfo"))
		{
			String productID = request.getParameter("productID");
			String productInfo = getProductInfo(Integer.parseInt(productID)) ;
			request.setAttribute("productInfo", productInfo);
			request.getSession().setAttribute("nextPage","ProductInfo");
			request.getRequestDispatcher("/ProductInfo.jsp").forward(request,response) ;
		}
		
	}
	
	/**
	 * Gets the category list.
	 *
	 * @return the category list
	 */
	public ArrayList<String> getCategoryList() {
		ArrayList<String> result = null;
		ProductCatalogWebService productCatalog = new ProductCatalogWebService();
		
		result = productCatalog.getCategoryList();
				
		return result;
	}
	
	/**
	 * Gets the product list.
	 *
	 * @param categoryID the category id
	 * @return the product list
	 */
	public List<String> getProductList(int categoryID) {
		List<String> result = null;
		ProductCatalogWebService productCatalog = new ProductCatalogWebService();
		
		result = productCatalog.getProductList(categoryID);
				
		return result;
	}
	
	/**
	 * Gets the product info.
	 *
	 * @param cdId the cd id
	 * @return the product info
	 */
	public String getProductInfo(int cdId) {
		String result = null;
		ProductCatalogWebService productCatalog = new ProductCatalogWebService();
		
		result = productCatalog.getProductInfo(cdId);
				
		return result;
	}

	
}