/**
 * @FileName: PItem.java
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
 * The Class PItem.
 */
public class PItem implements Serializable{

	/** The pitem_id. */
	private int pitem_id;
	
	/** The p_id. */
	private int p_id;
	
	/** The cd_id. */
	private int cd_id;
	
	/** The quantity. */
	private int quantity;
	
	/**
	 * Instantiates a new p item.
	 */
	public PItem(){}
	
	/**
	 * Gets the pitem_id.
	 *
	 * @return the pitem_id
	 */
	public int getPitem_id() {
		return pitem_id;
	}
	
	/**
	 * Sets the pitem_id.
	 *
	 * @param pitem_id the new pitem_id
	 */
	public void setPitem_id(int pitem_id) {
		this.pitem_id = pitem_id;
	}
	
	/**
	 * Gets the p_id.
	 *
	 * @return the p_id
	 */
	public int getP_id() {
		return p_id;
	}
	
	/**
	 * Sets the p_id.
	 *
	 * @param p_id the new p_id
	 */
	public void setP_id(int p_id) {
		this.p_id = p_id;
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
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Sets the quantity.
	 *
	 * @param quantity the new quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PItem [pitem_id=" + pitem_id + ", p_id=" + p_id + ", cd_id="
				+ cd_id + ", quantity=" + quantity + "]";
	};
	
	
}
