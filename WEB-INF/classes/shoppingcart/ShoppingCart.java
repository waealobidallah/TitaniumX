/**
 * @FileName: ShoppingCart.java
 * 
 * @authore 
 * Titanium x
 * Ekaterina Guseva <eguse009@uottawa.ca>
 * Mohamad Safie <msafie083@uottawa.ca>
 * Mert Metin <mertmetin@outlook.com>
 * Waeal J.Obidallah <Wobidallah@uoattwa.ca>
 *  
 * Package name: shoppingcart
 */
package shoppingcart;

import shoppingcart.ShoppingCart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class ShoppingCart.
 */
public class ShoppingCart {
	
	/** The shopping cart item list. */
	private List<ShoppingCartItem> shoppingCartItemList ;
	
	/** The user email. */
	private String userEmail ; 
	
	/** The total price. */
	private float totalPrice ; 
	
	/** The shopping cart id. */
	int shoppingCartID ; 

	/**
	 * Gets the shopping cart id.
	 *
	 * @return the shopping cart id
	 */
	public int getShoppingCartID() {
		return shoppingCartID;
	}

	/**
	 * Sets the shopping cart id.
	 *
	 * @param shoppingCartID the new shopping cart id
	 */
	public void setShoppingCartID(int shoppingCartID) {
		this.shoppingCartID = shoppingCartID;
	}

	/**
	 * Instantiates a new shopping cart.
	 *
	 * @param email the email
	 */
	public ShoppingCart(String email) 
	{
		shoppingCartItemList = new ArrayList<ShoppingCartItem>() ;
		userEmail = email ;
		totalPrice = 0 ; 
	}
	
	/**
	 * Gets the user email.
	 *
	 * @return the user email
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * Sets the user email.
	 *
	 * @param userEmail the new user email
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * Adds the cd to cart.
	 *
	 * @param item the item
	 */
	public void addCdToCart(ShoppingCartItem item)
	{
		shoppingCartItemList.add(item) ;
		totalPrice += item.getPrice();
	}
	
	/**
	 * Gets the shopping cart items.
	 *
	 * @return the shopping cart items
	 */
	public List<ShoppingCartItem> getShoppingCartItems() 
	{
		return this.shoppingCartItemList ;
	}
	
	/**
	 * Removes the cd from cart.
	 *
	 * @param cdId the cd id
	 */
	public void removeCdFromCart(int cdId)
	{
		Iterator<ShoppingCartItem> iterator = 
				shoppingCartItemList.listIterator() ;
		
		ShoppingCartItem temp = null ;
		while (iterator.hasNext())
		{
			temp = iterator.next() ;
			if(temp.getCdId() == cdId)
			{
				totalPrice -= temp.getPrice() ;
				iterator.remove(); 
				break ;
			}
		}
	}
	
	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
	public boolean isEmpty()
	{
		return shoppingCartItemList.isEmpty() ;
	}

	
	/**
	 * Gets the total price.
	 *
	 * @return the total price
	 */
	public float getTotalPrice() 
	{
		return totalPrice;
	}
	
}
