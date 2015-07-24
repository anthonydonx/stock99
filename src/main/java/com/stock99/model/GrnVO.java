/**
 * 
 */
package com.stock99.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



/**
 * @author anthonydonx
 *
 */
@Entity
@Table(name="grnin")
public class GrnVO implements Serializable {
	private Integer grninId;
	private Integer quantity;
	private String binLocation;
	private String colour;
	private String epf;
	private String date;
	private String userId;
	private String bookingUserId;
	private String status;
	private OdersVO orders; 
	private String bookingDate;
	private String issuedDate;
	private String issuedUserId;
	

	


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "grninid")
	public Integer getGrninId() {
		return grninId;
	}


	public void setGrninId(Integer grninId) {
		this.grninId = grninId;
	}
	@Column(name = "bookingdate")
	public String getBookingDate() {
		return bookingDate;
	}


	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}


	@Column(name = "quantity")
	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Column(name = "bookinguserid")
	public String getBookingUserId() {
		return bookingUserId;
	}


	public void setBookingUserId(String bookingUserId) {
		this.bookingUserId = bookingUserId;
	}

	

@Column(name="status")
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Column(name = "binlocation")
	public String getBinLocation() {
		return binLocation;
	}


	public void setBinLocation(String binLocation) {
		this.binLocation = binLocation;
	}

	@Column(name = "colour")
	public String getColour() {
		return colour;
	}


	public void setColour(String colour) {
		this.colour = colour;
	}

	@Column(name = "epf")
	public String getEpf() {
		return epf;
	}


	public void setEpf(String epf) {
		this.epf = epf;
	}
	
	

	@Column(name = "date")
	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}

	
	@Column(name="userid")
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@ManyToOne
	@JoinColumn(name="oderid",insertable=true,updatable=true,nullable=false)
	public OdersVO getOrders() {
		return orders;
	}


	public void setOrders(OdersVO orders) {
		this.orders = orders;
	}

	@Column(name="issueddate")
	public String getIssuedDate() {
		return issuedDate;
	}


	public void setIssuedDate(String issuedDate) {
		this.issuedDate = issuedDate;
	}

	@Column(name="issueduserid")
	public String getIssuedUserId() {
		return issuedUserId;
	}


	public void setIssuedUserId(String issuedUserId) {
		this.issuedUserId = issuedUserId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + grninId;
		return result;
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrnVO other = (GrnVO) obj;
		if (grninId != other.grninId)
			return false;
		return true;
	}


	

}
