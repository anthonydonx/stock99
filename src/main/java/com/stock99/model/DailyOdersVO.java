/**
 * 
 */
package com.stock99.model;

import java.io.Serializable;
import java.util.Date;

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
@Table(name="dailyoders")
public class DailyOdersVO implements Serializable {
	private Integer dailyId;
	private OdersVO orders; 
	private String date;
	private Integer dayQty;
	private Integer dayIss;
	private String status;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dailyid")
	public Integer getDailyId() {
		return dailyId;
	}


	public void setDailyId(Integer dailyId) {
		this.dailyId = dailyId;
	}
	


	@ManyToOne
	@JoinColumn(name = "oderid", referencedColumnName = "oderid",insertable=true,updatable=true,nullable=true)
	public OdersVO getOrders() {
		return orders;
	}


	public void setOrders(OdersVO orders) {
		this.orders = orders;
	}

	

	@Column(name = "status")
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name = "tdate")
	public String getdate() {
		return date;
	}


	public void setdate(String date) {
		this.date = date;
	}
	@Column(name = "dayiss")
	public Integer getDayIss() {
		return dayIss;
	}


	public void setDayIss(Integer dayIss) {
		this.dayIss = dayIss;
	}


	@Column(name = "dayqty")
	public Integer getDayQty() {
		return dayQty;
	}


	public void setDayQty(Integer dayQty) {
		this.dayQty = dayQty;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dailyId == null) ? 0 : dailyId.hashCode());
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
		DailyOdersVO other = (DailyOdersVO) obj;
		if (dailyId == null) {
			if (other.dailyId != null)
				return false;
		} else if (!dailyId.equals(other.dailyId))
			return false;
		return true;
	}


	

	
	

}
