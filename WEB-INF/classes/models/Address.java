/**
 * @FileName: Address.java
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
 * The Class Address.
 */
public class Address  implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The address_id. */
	private int address_id;
	
	/** The street. */
	private String street  ;
	
	/** The city. */
	private String city;
	
	/** The province. */
	private String province;
	
	/** The country. */
	private String country;
	
	/** The phone. */
	private String  phone;	
	
	/** The zipcode. */
	private String zipcode;
	
	/**
	 * Instantiates a new address.
	 */
	public Address(){}
	
	/**
	 * Instantiates a new address.
	 *
	 * @param street the street
	 * @param city the city
	 * @param province the province
	 * @param country the country
	 */
	public Address(String street, String city, String province, String country){
		this.street = street;
		this.city = city;
		this.province = province;
		this.country = country;
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
	 * Gets the street.
	 *
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	
	/**
	 * Sets the street.
	 *
	 * @param street the new street
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	
	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * Gets the province.
	 *
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}
	
	/**
	 * Sets the province.
	 *
	 * @param province the new province
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	
	/**
	 * Gets the country.
	 *
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * Sets the country.
	 *
	 * @param country the new country
	 */
	public void setCountry(String country) {
		this.country = country;
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
	 * Gets the zipcode.
	 *
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}
	
	/**
	 * Sets the zipcode.
	 *
	 * @param zipcode the new zipcode
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
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
		return "Address [address_id=" + address_id + ", street=" + street
				+ ", city=" + city + ", province=" + province + ", country="
				+ country + ", phone=" + phone + ", zipcode=" + zipcode + "]";
	}

}
