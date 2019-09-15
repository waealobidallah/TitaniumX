/**
 * @FileName: ProductCatalogWebService.java
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

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;





import org.hibernate.internal.jaxb.cfg.ObjectFactory;

import dbagent.DBAgent;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductCatalogWebService.
 */
@WebService(targetNamespace = "http://localhost", name = "OrderProcessorWebService")
@XmlSeeAlso({ ObjectFactory.class })
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class ProductCatalogWebService {

	/**
	 * Gets the category list.
	 *
	 * @return the category list
	 */
	@WebResult(name = "return", targetNamespace = "", partName = "return")
	@Action(input = "http://localhost/index.jsp")
	@WebMethod(operationName = "getCategoryList")
	public ArrayList<String> getCategoryList() {

		DBAgent dbagent = new DBAgent();

		ArrayList<String> result = dbagent.getCategoryList();

		return result;

	}
	
	/**
	 * Gets the product info.
	 *
	 * @param cdID the cd id
	 * @return the product info
	 */
	@WebResult(name = "return", targetNamespace = "", partName = "return")
	@Action(input = "http://localhost/index.jsp")
	@WebMethod(operationName = "getProductInfo")
	public String getProductInfo(int cdID) 
	{

		DBAgent dbagent = new DBAgent();

		String result = dbagent.getProductInfo(cdID);

		return result;

	}

	/**
	 * Gets the product list.
	 *
	 * @param categoryID the category id
	 * @return the product list
	 */
	public List<String> getProductList(int categoryID) 
	{
		DBAgent dbagent = new DBAgent();
		
		List<String> result = dbagent.getProductList(categoryID);

		return result;
	}
}