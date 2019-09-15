/**
 * @FileName: Purchase.java
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
 * The Class Purchase.
 */
public class Purchase implements Serializable{
	
	/** The purchase_id. */
	private int purchase_id;
	
	/** The account_id. */
	private int account_id;
	
	/** The address_id. */
	private int address_id;
	
	/** The date_p. */
	private java.util.Date date_p;
	
	/** The stat. */
	private String stat;
	
	/** The due. */
	private float due;
	
	/** The taxes. */
	private float taxes;
	
	/** The creditcardnumber. */
	private int creditcardnumber;
	
	/**
	 * Instantiates a new purchase.
	 */
	public Purchase(){}
	
	/**
	 * Instantiates a new purchase.
	 *
	 * @param account_id the account_id
	 * @param address_id the address_id
	 * @param due the due
	 * @param taxes the taxes
	 */
	public Purchase(int account_id, int address_id, float due, float taxes){
		this.account_id = account_id;
		this.address_id = address_id;
		this.due = due;
		this.taxes = taxes;
	}
	
	/**
	 * Instantiates a new purchase.
	 *
	 * @param creditcardnumber the creditcardnumber
	 */
	public Purchase(int creditcardnumber)
	{
		this.creditcardnumber = creditcardnumber;
	}
	
	/**
	 * Gets the purchase_id.
	 *
	 * @return the purchase_id
	 */
	public int getPurchase_id() {
		return purchase_id;
	}
	
	/**
	 * Sets the purchase_id.
	 *
	 * @param purchase_id the new purchase_id
	 */
	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}
	
	/**
	 * Gets the account_id.
	 *
	 * @return the account_id
	 */
	public int getaccount_id() {
		return account_id;
	}
	
	/**
	 * Sets the account_id.
	 *
	 * @param account_id the new account_id
	 */
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	
	/**
	 * Gets the address_id.
	 *
	 * @return the address_id
	 */
	public int getAddress_id() {
		return address_id;
	}
	
	/**
	 * Sets the address_id.
	 *
	 * @param address_id the new address_id
	 */
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	
	/**
	 * Gets the date_p.
	 *
	 * @return the date_p
	 */
	public java.util.Date getDate_p() {
		return date_p;
	}
	
	/**
	 * Sets the date_p.
	 *
	 * @param date_p the new date_p
	 */
	public void setDate_p(java.util.Date date_p) {
		this.date_p = date_p;
	}
	
	/**
	 * Gets the stat.
	 *
	 * @return the stat
	 */
	public String getStat() {
		return stat;
	}
	
	/**
	 * Sets the stat.
	 *
	 * @param stat the new stat
	 */
	public void setStat(String stat) {
		this.stat = stat;
	}
	
	/**
	 * Gets the due.
	 *
	 * @return the due
	 */
	public float getDue() {
		return due;
	}
	
	/**
	 * Sets the due.
	 *
	 * @param due the new due
	 */
	public void setDue(float due) {
		this.due = due;
	}
	
	/**
	 * Gets the taxes.
	 *
	 * @return the taxes
	 */
	public float getTaxes() {
		return taxes;
	}
	
	/**
	 * Sets the taxes.
	 *
	 * @param taxes the new taxes
	 */
	public void setTaxes(float taxes) {
		this.taxes = taxes;
	}
	
	/**
	 * Sets the taxes.
	 *
	 * @param creditcardnumber the new taxes
	 */
	public void setTaxes(int creditcardnumber) {
		this.creditcardnumber = creditcardnumber;
	}

	/**
	 * Gets the creditcardnumber.
	 *
	 * @return the creditcardnumber
	 */
	public int getCreditcardnumber() {
		return creditcardnumber;
	}

	/**
	 * Sets the creditcardnumber.
	 *
	 * @param creditcardnumber the new creditcardnumber
	 */
	public void setCreditcardnumber(int creditcardnumber) {
		this.creditcardnumber = creditcardnumber;
	}
	
}