/**
 * @FileName: Band.java
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
 * The Class Band.
 */
public class Band implements Serializable{
	
	/** The band_id. */
	private int band_id;
	
	/** The band. */
	private String band;
	
	/** The style. */
	private String style;
	
	/**
	 * Instantiates a new band.
	 */
	Band(){}
	
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
	 * Gets the band.
	 *
	 * @return the band
	 */
	public String getBand() {
		return band;
	}
	
	/**
	 * Sets the band.
	 *
	 * @param band the new band
	 */
	public void setBand(String band) {
		this.band = band;
	}
	
	/**
	 * Gets the style.
	 *
	 * @return the style
	 */
	public String getStyle() {
		return style;
	}
	
	/**
	 * Sets the style.
	 *
	 * @param style the new style
	 */
	public void setStyle(String style) {
		this.style = style;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Band [band_id=" + band_id + ", band=" + band + ", style="
				+ style + "]";
	};
	
	
}
