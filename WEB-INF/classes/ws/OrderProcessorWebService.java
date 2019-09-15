/**
 * @FileName: OrderProcessorWebService.java
 * 
 * @authore 
 * Titanium x
 * Ekaterina Guseva <eguse009@uottawa.ca>
 * Mohamad Safie <msafie083@uottawa.ca>
 * Mert Metin <mertmetin@outlook.com>
 * Waeal J.Obidallah <Wobidallah@uoattwa.ca>
 *  
 * Package name: ws
 */
package ws;

import models.Account;
import models.Address;
import models.Purchase;
import shoppingcart.ShoppingCart;
import dbagent.DBAgent;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;

import org.hibernate.internal.jaxb.cfg.ObjectFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class OrderProcessorWebService.
 */
@WebService(targetNamespace = "http://localhost", name = "OrderProcessorWebService")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class OrderProcessorWebService {
	
	/** The dbagent. */
	private DBAgent dbagent;
	
	
	/**
	 * Creates the order.
	 *
	 * @param account the account
	 * @param sc the sc
	 * @return true, if successful
	 */
	@WebResult(name = "return", targetNamespace = "", partName = "return")
    @Action(input = "http://localhost/registration.jsp")
    @WebMethod
    public boolean createOrder(Account account, ShoppingCart sc)
	{
		dbagent = new DBAgent();
		
		boolean result = false;
		
		result = dbagent.createOrder(account, sc);
		
		return result;
	}
	
	/**
	 * Creates the order.
	 *
	 * @param sc the sc
	 * @return the int
	 */
	public int createOrder(ShoppingCart sc)
	{
		dbagent = new DBAgent();

		int shoppingCartID;

		shoppingCartID = dbagent.createOrder(sc);

		return shoppingCartID;
	}

	/**
	 * Confirm order.
	 *
	 * @param purchase the purchase
	 * @return true, if successful
	 */
	public boolean confirmOrder(Purchase purchase)
	{
		dbagent = new DBAgent();
		
		boolean result = false;
		
		// I need you here to finish it.
		
		System.out.print(purchase.getCreditcardnumber());
		
		return result;
	}
	
	/**
	 * Confirm order.
	 *
	 * @param shoppingCart the shopping cart
	 * @param creditCardNum the credit card num
	 * @return true, if successful
	 */
	public boolean confirmOrder(ShoppingCart shoppingCart, int creditCardNum)
	{
		dbagent = new DBAgent();
		
		boolean result = false;
		
		
		dbagent.confirmOrder(shoppingCart, creditCardNum) ;
		
		return result;
	}
	
	/**
	 * Creates the account.
	 *
	 * @param account the account
	 * @param address the address
	 * @return true, if successful
	 */
	@WebResult(name = "return", targetNamespace = "", partName = "return")
    @Action(input = "http://localhost/registration.jsp")
    @WebMethod
    public boolean createAccount(Account account, Address address)
	{
		dbagent = new DBAgent();
		
		boolean result = false;
		
		result = dbagent.createAccount(account, address);
		
		return result;
	}
	
	/**
	 * Gets the account.
	 *
	 * @param account the account
	 * @return the account
	 */
	public boolean getAccount(Account account)
	{	
		dbagent = new DBAgent();
		String result = null;
		
		result = dbagent.getAccount(account);
	    
	    if (result.length() > 0) 
	    	return true;
	    else
	    	return false;
	}
	
	/**
	 * Gets the account.
	 *
	 * @param email the email
	 * @param pwd the pwd
	 * @return the account
	 */
	public Account getAccount(String email, String pwd)
	{	
		dbagent = new DBAgent();
		
		return dbagent.getAccount(email, pwd);
	    
	    /*if (result.length() > 0) 
	    	return true;
	    else
	    	return false;*/
	}
}
