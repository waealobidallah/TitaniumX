import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import models.Account;
import models.Address;
import shoppingcart.ShoppingCart;
import shoppingcart.ShoppingCartItem;
import ws.OrderProcessorWebService;
import ws.ProductCatalogWebService;


public class CD_Store_Tester {

	public static void main(String[] args) throws IOException {
		
		BufferedWriter testOutput = new BufferedWriter(new PrintWriter(new File("Testing Output.txt")));
		
		testOutput.write("Testing Product Catalog Web Service\n");
		testOutput.write("\n");
		testOutput.write("\n");
		ProductCatalogWebService pcWS = new ProductCatalogWebService(); 
		
		
		testOutput.write("TESTCASE : Testing ProductCatalog.getCategoryList (Should display all the categories) ");
		testOutput.write("\n");
		testOutput.write("\n");
		List<String> categoryList = pcWS.getCategoryList() ; 
		
		testOutput.write("The output lists the categories along with its id in the database.");
		testOutput.write("\n");
		for (String category : categoryList)
		{
			testOutput.write(category);
			testOutput.write("\n");
		}
		testOutput.write("\n");
		testOutput.write("TESTCASE : Testing ProductCatalog.getProductList (Getting product List for valid category)");
		testOutput.write("\n");
		testOutput.write("\n");
		List<String> productList = pcWS.getProductList(1) ;
		
		testOutput.write("The output lists the products along with its information in the database.\n");
		for (String product : productList)
		{
			testOutput.write(product);
			testOutput.write("\n");
		}
		testOutput.write("\n");
		testOutput.write("TESTCASE : Testing ProductCatalog.getProductList (Getting product List for all categories)");
		testOutput.write("\n");
		testOutput.write("\n");
		productList = pcWS.getProductList(0) ;
		testOutput.write("The output lists all products along with its information in the database for all categories.\n");
		testOutput.write("\n");
		for (String product : productList)
		{
			testOutput.write(product);
			testOutput.write("\n");
		}
		testOutput.write("\n");
		testOutput.write("TESTCASE : Testing ProductCatalog.getProductList (Getting product List for invalid category)");
		testOutput.write("\n");
		testOutput.write("\n");
		productList = pcWS.getProductList(-1) ;
		testOutput.write("The output doesn't list the product for invalid category.");
		testOutput.write("\n");
		for (String product : productList)
		{
			testOutput.write(product);
			testOutput.write("\n");
		}
		
		testOutput.write("\n");
		testOutput.write("TESTCASE : Testing ProductCatalog.getProductInfo (Getting product Info for valid product)");
		testOutput.write("\n");
		testOutput.write("\n");
		String productInfo = pcWS.getProductInfo(1) ;
		testOutput.write("The output displays the product information for a valid product ID");
		testOutput.write("\n");
		testOutput.write("\n");
		testOutput.write(productInfo);
		testOutput.write("\n");
		
		testOutput.write("\n");
		testOutput.write("TESTCASE : Testing ProductCatalog.getProductInfo (Getting product Info for invalid product)");
		testOutput.write("\n");
		testOutput.write("\n");
		
		productInfo = pcWS.getProductInfo(-1) ;
		testOutput.write("The output doesn't displays the product information for a invalid product ID");
		testOutput.write("\n");
		testOutput.write("\n");
		testOutput.write(productInfo.equals("") ? "No Product Info" : productInfo);
		testOutput.write("\n");
		
		testOutput.write("\n");
		testOutput.write("Testing Order Processor Web Service");
		testOutput.write("\n");
		
		OrderProcessorWebService opWs = new OrderProcessorWebService() ; 
		testOutput.write("\n"); 
		testOutput.write("TESTCASE : Testing OrderProcess.createAccount (Account should be created)");
		testOutput.write("\n"); 
		testOutput.write("\n"); 
		
		Account account = new Account();
		account.setFirstName("firstName");
		account.setLastName("lastName");
		account.setPassword("123456");
		account.setEmail("email");
		
		Address address = new Address();
		address.setCity("city");
		address.setCountry("country");
		address.setProvince("province");
		address.setStreet("street");
		address.setZipcode("123456");
		
		boolean registrationSuccess = opWs.createAccount(account, address);
		if (registrationSuccess)
		{
			testOutput.write("Account created");
			testOutput.write("\n");
		}
		else 
		{
			testOutput.write("Account creation failed");
			testOutput.write("\n");
		}
		
		testOutput.write("\n"); 
		//testOutput.write("TESTCASE : Testing OrderProcess.getAccount: Checking for Valid account");
		testOutput.write("\n"); 
		testOutput.write("\n"); 
		
		testOutput.write("Displaying account\n"); 
		testOutput.write("\n") ;
		
		//Account accountGet = opWs.getAccount("email", "123456") ;
		//testOutput.write(accountGet.toString()) ;
		//testOutput.write("\n"); 
		
		testOutput.write("\n"); 
		//testOutput.write("TESTCASE : Testing OrderProcess.getAccount: Try Fetching of non existing account/invalid id or password");
		testOutput.write("\n"); 
		testOutput.write("\n"); 
		
		testOutput.write("Displaying account\n"); 
		testOutput.write("\n") ;
		
		//accountGet = opWs.getAccount("email","invalid"); ;
		//testOutput.write((accountGet == null) ? "Invalid Account" : accountGet.toString()) ;
		
		testOutput.write("\n"); 
		testOutput.write("TESTCASE : Testing OrderProcess.createOrder (New shopping cart ID should be generated)");
		testOutput.write("\n");
		testOutput.write("\n"); 
		
		ShoppingCart sc = new ShoppingCart("email") ;
		ShoppingCartItem item = new ShoppingCartItem(1, "Here and now", Float.parseFloat("15.99"));
		sc.addCdToCart(item);
		item = new ShoppingCartItem(2, "All the right reasons", Float.parseFloat("8.99"));
		sc.addCdToCart(item);
				
		int shoppingCartID = opWs.createOrder(sc) ;
		sc.setShoppingCartID(shoppingCartID);
		testOutput.write("New shopping cart ID created from create Order: " + shoppingCartID); 
		testOutput.write("\n");
		testOutput.write("TESTCASE : Testing OrderProcess.confirmOrder");
		testOutput.write("\n");
		testOutput.write("\n"); 
		
		testOutput.write("Confirming order (Order should be confirmed as per the return value of the status)");
		testOutput.write("\n");
		boolean status = opWs.confirmOrder(sc, 1234567789) ;
		if (status)
		{
			testOutput.write("order confirmed\n") ;
		}
		else
			testOutput.write("order rejected\n");
		
		
		testOutput.close();
		
	}

}
