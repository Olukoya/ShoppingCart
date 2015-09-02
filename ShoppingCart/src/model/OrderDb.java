package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ORDER_DB database table.
 * 
 */
@Entity
@Table(name="ORDER_DB")
@NamedQuery(name="OrderDb.findAll", query="SELECT o FROM OrderDb o")
public class OrderDb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="P_ID")
	private long pId;

	@Column(name="P_CODE")
	private int pCode;

	@Column(name="P_NAME")
	private String pName;

	@Column(name="P_PRICE")
	private Double pPrice;

	@Column(name="P_QTY")
	private int pQty;

	@Column(name="P_SUB")
	private double pSub;

	@Column(name="USER_ID")
	private String userId;

	public OrderDb() {
	}

	public long getPId() {
		return this.pId;
	}

	public void setPId(long pId) {
		this.pId = pId;
	}

	public int getPCode() {
		return this.pCode;
	}

	public void setPCode(int pCode) {
		this.pCode = pCode;
	}

	public String getPName() {
		return this.pName;
	}

	public void setPName(String pName) {
		this.pName = pName;
	}

	public Double getPPrice() {
		return this.pPrice;
	}

	public void setPPrice(Double pPrice) {
		this.pPrice = pPrice;
	}

	public int getPQty() {
		return this.pQty;
	}

	public void setPQty(int pQty) {
		this.pQty = pQty;
	}

	public double getPSub() {
		return this.pSub;
	}

	public void setPSub(double pSub) {
		this.pSub = pSub;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}