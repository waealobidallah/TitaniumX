/**
 * @FileName: DBAgent.java
 * 
 * @authore 
 * Titanium x
 * Ekaterina Guseva <eguse009@uottawa.ca>
 * Mohamad Safie <msafie083@uottawa.ca>
 * Mert Metin <mertmetin@outlook.com>
 * Waeal J.Obidallah <Wobidallah@uoattwa.ca>
 *  
 * Package name: dbagent
 */
package dbagent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import models.Account;
import models.Address;
import models.Band;
import models.CD;
import models.Category;
import models.PItem;
import models.Purchase;

import org.dom4j.io.DOMReader;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import shoppingcart.ShoppingCart;
import shoppingcart.ShoppingCartItem;

// TODO: Auto-generated Javadoc
/**
 * The Class DBAgent.
 */
public class DBAgent {
	
	/** The table. */
	private Hashtable<Integer,String> table;
	
	/** The cfg. */
	private Configuration cfg;
	
	/** The service registry. */
	private ServiceRegistry  serviceRegistry;
	
	/** The sf. */
	private SessionFactory sf;
	
	/** The s. */
	private Session s;
	
	/** The tx. */
	private Transaction tx;

	/**
	 * Instantiates a new DB agent.
	 */
	public DBAgent(){
		cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build(); 
		sf = cfg.buildSessionFactory(serviceRegistry);
		s =  sf.openSession();

	}

	/**
	 * Confirm order.
	 *
	 * @param purchase the purchase
	 * @return true, if successful
	 */
	public boolean confirmOrder(Purchase purchase)
	{
		tx = s.beginTransaction();

		purchase.getPurchase_id();


		return false;
	}

	/**
	 * Creates the order.
	 *
	 * @param acc the acc
	 * @param sc the sc
	 * @return true, if successful
	 */
	public boolean createOrder(Account acc, ShoppingCart sc)
	{	
		System.out.print("DbAgent - createOrder invoked ");
		boolean result = true;

		tx = s.beginTransaction();

		Purchase purchase = new Purchase();
		purchase.setAccount_id(10);
		purchase.setAddress_id(1);
		purchase.setDue(10);
		purchase.setTaxes(15);

		s.save(purchase);
		tx.commit();

		System.out.print("Process completed. ");

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
		System.out.print("DbAgent - createOrder invoked ");
		long now = System.currentTimeMillis();
		Date date = new Date(now);
		
		tx = s.beginTransaction();
		
		Query q = s.createQuery("from Account where email = :email") ;
		q.setParameter("email", sc.getUserEmail()) ;
		Account acc = (Account) q.uniqueResult() ;
		
		Purchase purchase = new Purchase();
		purchase.setAccount_id(acc.getAccount_id());
		purchase.setAddress_id(acc.getAddress_id());
		purchase.setDate_p(date);
		s.save(purchase);
		s.flush();
		q = s.createQuery("select max(purchase_id) from Purchase");
		int purchaseID = (Integer) q.uniqueResult() ;
		
		List<ShoppingCartItem> shoppingCartList = sc.getShoppingCartItems() ;
		
		for (ShoppingCartItem item : shoppingCartList)
		{
			PItem newItem = new PItem() ; 
			newItem.setCd_id(item.getCdId());
			newItem.setP_id(purchaseID);
			newItem.setQuantity(1);
			s.save(newItem);
			s.flush();
		}
		
		tx.commit();

		System.out.print("Process completed. ");

		return purchaseID;
	}

	/**
	 * Creates the account.
	 *
	 * @param account the account
	 * @param address the address
	 * @return true, if successful
	 */
	public boolean createAccount(Account account, Address address)
	{
		System.out.print("DbAgent - createAccount invoked ");
		boolean result = true;

		tx = s.beginTransaction();
		s.save(address);
		Query q = s.createQuery("select max(address_id) from Address");
		int maxAddressValue  = (Integer) q.uniqueResult() ;
		account.setAddress_id(maxAddressValue);
		s.save(account);
		tx.commit();

		System.out.print("Process completed. ");

		return result;
	}

	/**
	 * Gets the account.
	 *
	 * @param account the account
	 * @return the account
	 */
	public String getAccount(Account account)
	{
		System.out.print("DbAgent - getAccount invoked ");

		String result = null;
		String email = account.getEmail();
		String password = account.getPassword();

		String hql = "select email from Account a where a.email = :email and a.password =:password";
		Query query=  s.createQuery(hql);
		query.setParameter("email", email);
		query.setParameter("password", password);
		result =  (String) query.uniqueResult();

		System.out.print("Process completed. ");

		return result;
	}
	
	/**
	 * Gets the account.
	 *
	 * @param email the email
	 * @param password the password
	 * @return the account
	 */
	public Account getAccount(String email, String password) 
	{
		Account account = null;
	
		String hql = "from Account where email = :email and password =:password";
		Query query=  s.createQuery(hql);
		query.setParameter("email", email);
		query.setParameter("password", password);
		account =  (Account) query.uniqueResult();
		hql = "from Address where address_id = :addressID" ;
		query = s.createQuery(hql) ;
		query.setParameter("addressID", account.getAddress_id()) ;
		account.setAddressObj((Address) query.uniqueResult());
		return account;
	}


	/**
	 * Gets the category list.
	 *
	 * @return the category list
	 */
	public ArrayList<String> getCategoryList() {

		Transaction tran = null;

		ArrayList<String> listCat = new ArrayList<String>();

		tran = s.beginTransaction();
		List list = s.createQuery("from Category ").list();
		Iterator itr = list.iterator();


		while (itr.hasNext()) {
			Category emp = (Category) itr.next();
			listCat.add(Integer.toString(emp.getCategoryID()) + "|" + emp.getCategoryName());
			//System.out.println(temp);
		}

		tran.commit();
		s.close();

		System.out.print("Process completed. ");

		return listCat;
	}

	/**
	 * Gets the product list.
	 *
	 * @param categoryID the category id
	 * @return the product list
	 */
	public List<String> getProductList(int categoryID) {

		Transaction tran = null;

		List<String> productList = new ArrayList<String>();

		tran = s.beginTransaction();
		List productResultSet = s.createQuery("from CD").list();
		Iterator itr = productResultSet.iterator();

		while (itr.hasNext()) {
			CD cd = (CD) itr.next();
			if ( categoryID == 0 || cd.getCategoryID() == categoryID )
				productList.add(Integer.toString(cd.getCd_id()) + "|" + 
								cd.getTitle() + "|" + cd.getPrice() + "|" + 
								cd.getLink());
		}

		tran.commit();
		s.flush();
		s.close();

		return productList;
	}
	
	/**
	 * Gets the product info.
	 *
	 * @param cd_id the cd_id
	 * @return the product info
	 */
	public String getProductInfo(int cd_id) {
		List<String> returnList = new ArrayList<String>() ;
		Query query = s.createQuery(" select c.cd_id, c.title, c.price, c.description, c.link, b.band From   CD c, Band b "
				+ "			WHERE  c.cd_id=:cd_id AND b.band_id=c.band_id ");
		query.setParameter("cd_id", cd_id);
		List<Object[]> groupList = query.list();
		String productInfo ="" ; 
		for(Object[] arr : groupList){
			for (Object o : arr)
			{
				productInfo += o.toString()  ;
				productInfo += "|" ;
			}
		}
		s.flush();
		s.close();
		return productInfo;
	}

	/**
	 * Confirm order.
	 *
	 * @param shoppingCart the shopping cart
	 * @param creditCardNum the credit card num
	 */
	public void confirmOrder(ShoppingCart shoppingCart, int creditCardNum) 
	{
		tx = s.beginTransaction();
	    
    	int result = 0;
    	String stat = "SHIPPED";
    	
    	/*String email = shoppingCart.getUserEmail();
    	Query q = s.createQuery("from Account where email = :email") ;
		q.setParameter("email", email) ;
		Account acc = (Account) q.uniqueResult() ;*/
 
    	String hql = "update Purchase set stat = :stat" +
    				" where purchase_id = :purchase_id";   	
  
		Query query = s.createQuery(hql);
		query.setParameter("stat", stat);
		query.setParameter("purchase_id", shoppingCart.getShoppingCartID());
		result =  query.executeUpdate();
		tx.commit();
		
		System.out.print(result);
		System.out.print("Process completed. ");
		
		
	}

}
