package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CARTDB_TEMP database table.
 * 
 */
@Entity
@Table(name="CARTDB_TEMP", schema="TESTDB")
@NamedQuery(name="CartdbTemp.findAll", query="SELECT c FROM CartdbTemp c")
public class CartdbTemp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="P_ID")
	private long pId;

	@Column(name="P_CODE")
	private int pCode;

	@Column(name="P_NAME")
	private String pName;

	@Column(name="P_PRICE")
	private double pPrice;

	@Column(name="P_QTY")
	private int pQty;

	@Column(name="P_SUB")
	private double pSub;

	public CartdbTemp() {
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

	public double getPPrice() {
		return this.pPrice;
	}

	public void setPPrice(double pPrice) {
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

}