/**
 * @FileName: VisitEvent.java
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
 * The Class VisitEvent.
 */
public class VisitEvent implements Serializable{
	
	/** The visit_id. */
	private int visit_id ;
	
	/** The v_date. */
	private java.util.Date v_date ;
	
	/** The cd_id. */
	private int cd_id;
	
	/** The event_type. */
	private String event_type;
	
	/**
	 * Instantiates a new visit event.
	 */
	VisitEvent(){}
	
	/**
	 * Gets the visit_id.
	 *
	 * @return the visit_id
	 */
	public int getVisit_id() {
		return visit_id;
	}
	
	/**
	 * Sets the visit_id.
	 *
	 * @param visit_id the new visit_id
	 */
	public void setVisit_id(int visit_id) {
		this.visit_id = visit_id;
	}
	
	/**
	 * Gets the v_date.
	 *
	 * @return the v_date
	 */
	public java.util.Date getV_date() {
		return v_date;
	}
	
	/**
	 * Sets the v_date.
	 *
	 * @param v_date the new v_date
	 */
	public void setV_date(java.util.Date v_date) {
		this.v_date = v_date;
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
	 * Gets the event_type.
	 *
	 * @return the event_type
	 */
	public String getEvent_type() {
		return event_type;
	}
	
	/**
	 * Sets the event_type.
	 *
	 * @param event_type the new event_type
	 */
	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "VisitEvent [visit_id=" + visit_id + ", v_date=" + v_date
				+ ", cd_id=" + cd_id + ", event_type=" + event_type + "]";
	};

}
