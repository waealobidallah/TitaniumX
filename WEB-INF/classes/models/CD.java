/**
 * @FileName: CD.java
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
 * The Class CD.
 */
public class CD implements Serializable {
	
	
	/** The cd_id. */
	private int  cd_id;
	
	/** The title. */
	private String title;
	
	/** The price. */
	private float price;
	
	/** The description. */
	private String description;
	
	/** The link. */
	private String link ; 
	
	/** The band_id. */
	private int band_id;
	
	/** The category id. */
	private int categoryID;
	
	/**
	 * Instantiates a new cd.
	 */
	public CD(){}
	
	
	/**
	 * Instantiates a new cd.
	 *
	 * @param cd_id the cd_id
	 * @param title the title
	 * @param price the price
	 * @param description the description
	 * @param link the link
	 * @param band_id the band_id
	 * @param categoryID the category id
	 */
	public CD(int cd_id, String title, float price, String description, String link, int band_id, int categoryID) {
		super();
		this.cd_id = cd_id;
		this.title = title;
		this.price = price;
		this.description = description ; 
		this.link = link ; 
		this.band_id = band_id;
		this.categoryID = categoryID ;
	}


	/**
	 * Gets the cd_id.
	 *
	 * @return the cd_id
	 */
	public int getCd_id() {
		return cd_id;
	}
	
	/**
	 * Sets the cd_id.
	 *
	 * @param cd_id the new cd_id
	 */
	public void setCd_id(int cd_id) {
		this.cd_id = cd_id;
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
	
	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * Gets the link.
	 *
	 * @return the link
	 */
	public String getLink() {
		return link;
	}


	/**
	 * Sets the link.
	 *
	 * @param link the new link
	 */
	public void setLink(String link) {
		this.link = link;
	}


	/**
	 * Gets the band_id.
	 *
	 * @return the band_id
	 */
	public int getBand_id() {
		return band_id;
	}
	
	/**
	 * Sets the band_id.
	 *
	 * @param band_id the new band_id
	 */
	public void setBand_id(int band_id) {
		this.band_id = band_id;
	}
	
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CD [cd_id=" + cd_id + ", title=" + title + ", price=" + price
				+ ", band_id=" + band_id + ", categoryID=" + categoryID +"]";
	}
	
	
	
	
	
	
}
