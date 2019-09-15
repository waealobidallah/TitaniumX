/**
 * @FileName: Account.java
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
 * The Class Account.
 */
public class Account implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The account_id. */
	private int account_id;
    
    /** The password. */
    private String password;
	
	/** The confirmation. */
	private String confirmation;
    
    /** The first name. */
    private String firstName;
    
    /** The last name. */
    private String lastName;
	
	/** The email. */
	private String email;
    
    /** The phone. */
    private String phone;
    
    /** The address_id. */
    private int address_id ; 
    
    /** The address obj. */
    private Address addressObj ;
    
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
	 * Instantiates a new account.
	 */
	public Account(){}
    
    /**
     * Instantiates a new account.
     *
     * @param email the email
     */
    public Account(String email)
    {
    	this.email = email;
    }
    

    /**
     * Instantiates a new account.
     *
     * @param email the email
     * @param password the password
     */
    public Account(String email, String password)
    {
    	this.email = email;
    	this.password = password;
    }
    
	/**
	 * Gets the account_id.
	 *
	 * @return the account_id
	 */
	public int getAccount_id() {
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
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the confirmation.
	 *
	 * @return the confirmation
	 */
	public String getConfirmation() {
		return confirmation;
	}

	/**
	 * Sets the confirmation.
	 *
	 * @param confirmation the new confirmation
	 */
	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the phone.
	 *
	 * @param phone the new phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [account_id=" + account_id 
				+ ", pass=" + password + ", confirmation=" + confirmation
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phone=" + phone + "]";
	}

	/**
	 * Gets the address obj.
	 *
	 * @return the address obj
	 */
	public Address getAddressObj() {
		return addressObj;
	}

	/**
	 * Sets the address obj.
	 *
	 * @param addressObj the new address obj
	 */
	public void setAddressObj(Address addressObj) {
		this.addressObj = addressObj;
	}

}
