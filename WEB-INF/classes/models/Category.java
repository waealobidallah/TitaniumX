/**
 * @FileName: Category.java
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
 * The Class Category.
 */
public class Category implements Serializable{
	
	/** The category id. */
	private int categoryID;
	
	/** The category name. */
	private String categoryName;
	
	/**
	 * Instantiates a new category.
	 */
	Category(){}
	
	/**
	 * Gets the category id.
	 *
	 * @return the category id
	 */
	public int getCategoryID() {
		return categoryID;
	}
	
	/**
	 * Sets the category id.
	 *
	 * @param categoryID the new category id
	 */
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	
	/**
	 * Gets the category name.
	 *
	 * @return the category name
	 */
	public String getCategoryName() {
		return categoryName;
	}
	
	/**
	 * Sets the category name.
	 *
	 * @param categoryName the new category name
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Category [categoryID=" + categoryID + ", categoryName=" + categoryName + "]";
	};
	
	
}
