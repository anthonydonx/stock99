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
import javax.persistence.Table;



/**
 * @author anthonydonx
 *
 */
@Entity
@Table(name="oders")
public class OdersVO implements Serializable {
	private Integer oderId;
	private String module;
	private String style;
	private String salesOder;
	private String lineItem;
	private String size;
	private String oderQty;
	private Integer dayQty;
	private Integer grnQty;
	private Integer allowedQuantity;
	private Integer ginQty;
	private String status;
	private Integer bookingQty;
	
	/*@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="country_id")
	private Set<State> states;*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "oderid")
	public Integer getOderId() {
		return oderId;
	}
	

	public void setOderId(Integer oderId) {
		this.oderId = oderId;
	}



	@Column(name = "module")
	public String getModule() {
		return module;
	}


	public void setModule(String module) {
		this.module = module;
	}

	@Column(name = "style")
	public String getStyle() {
		return style;
	}


	public void setStyle(String style) {
		this.style = style;
	}

	@Column(name = "salesoder")
	public String getSalesOder() {
		return salesOder;
	}


	public void setSalesOder(String salesOder) {
		this.salesOder = salesOder;
	}

	@Column(name = "lineitem")
	public String getLineItem() {
		return lineItem;
	}


	public void setLineItem(String lineItem) {
		this.lineItem = lineItem;
	}

	@Column(name = "size")
	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}

	@Column(name = "oderqty")
	public String getOderQty() {
		return oderQty;
	}


	public void setOderQty(String oderQty) {
		this.oderQty = oderQty;
	}

	@Column(name = "dayqty")
	public Integer getDayQty() {
		return dayQty;
	}


	public void setDayQty(Integer dayQty) {
		this.dayQty = dayQty;
	}

	@Column(name = "grnqty")
	public Integer getGrnQty() {
		return grnQty;
	}


	public void setGrnQty(Integer grnQty) {
		this.grnQty = grnQty;
	}

	@Column(name = "ginqty")
	public Integer getGinQty() {
		return ginQty;
	}


	public void setGinQty(Integer ginQty) {
		this.ginQty = ginQty;
	}

	@Column(name = "status")
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name = "allowedquantity")
	public Integer getAllowedQuantity() {
		return allowedQuantity;
	}


	public void setAllowedQuantity(Integer allowedQuantity) {
		this.allowedQuantity = allowedQuantity;
	}
	@Column(name = "bookingqty")
	public Integer getBookingQty() {
		return bookingQty;
	}


	public void setBookingQty(Integer bookingQty) {
		this.bookingQty = bookingQty;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + oderId;
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
		OdersVO other = (OdersVO) obj;
		if (oderId != other.oderId)
			return false;
		return true;
	}

}
