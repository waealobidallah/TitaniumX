/**
 * @FileName: ShoppingCartItem.java
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

// TODO: Auto-generated Javadoc
/**
 * The Class ShoppingCartItem.
 */
public class ShoppingCartItem 
{
	
	/** The cd id. */
	private int cdId ; 
	
	/** The title. */
	private String title ; 
	
	/** The price. */
	private float price ;
	
	/**
	 * Instantiates a new shopping cart item.
	 *
	 * @param cdId the cd id
	 * @param title the title
	 * @param price the price
	 */
	public ShoppingCartItem(int cdId, String title, float price) {
		super();
		this.cdId = cdId;
		this.title = title;
		this.price = price;
	}

	/**
	 * Gets the cd id.
	 *
	 * @return the cd id
	 */
	public int getCdId() {
		return cdId;
	}

	/**
	 * Sets the cd id.
	 *
	 * @param cdId the new cd id
	 */
	public void setCdId(int cdId) {
		this.cdId = cdId;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(float price) {
		this.price = price;
	} 
	

}
