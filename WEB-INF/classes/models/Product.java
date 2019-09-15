/**
 * @FileName: Product.java
 * 
 * @authore 
 * Titanium x
 * Ekaterina Guseva <eguse009@uottawa.ca>
 * Mohamad Safie <msafie083@uottawa.ca>
 * Mert Metin <mertmetin@outlook.com>
 * Waeal J.Obidallah <Wobidallah@uoattwa.ca>
 *  
 * Package name: models
 */

package models;

import java.io.Serializable;


// TODO: Auto-generated Javadoc
/**
 * The Class Product.
 */
public class Product implements Serializable  {
     
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The cd id. */
	private String cdId;
    
    /** The category. */
    private String category;
    
    /** The title. */
    private String title;
    
    /** The price. */
    private double price;
	
	/**
	 * Gets the cd id.
	 *
	 * @return the cdId
	 */
	public String getCdId() {
		return cdId;
	}
	
	/**
	 * Sets the cd id.
	 *
	 * @param cdId the cdId to set
	 */
	public void setCdId(String cdId) {
		this.cdId = cdId;
	}
	
	/**
	 * Gets the category.
	 *
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	
	/**
	 * Sets the category.
	 *
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
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
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Sets the price.
	 *
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [cdId=" + cdId + ", category=" + category + ", title="
				+ title + ", price=" + price + "]";
	}
    
    
}