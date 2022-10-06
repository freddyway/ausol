package com.redsys.llaa.model.db2;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TE3_RTE0T86 database table.
 * 
 */
@Entity
@Table(name="GRUDES.TE3S4")
public class Te3MonedaPais implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Te3MonedaPaisPK id;

	private String ce3mdcc4;

	private String ce3mdccc;

	private String ce3mdccm;

	private String ce3mdccv;

	private String ce3menvi;

	private String ce3mmdic;

	private String ce3mmdiv;

	public Te3MonedaPais() {
	}


	public Te3MonedaPaisPK getId() {
		return id;
	}


	public void setId(Te3MonedaPaisPK id) {
		this.id = id;
	}


	public String getCe3mdcc4() {
		return this.ce3mdcc4;
	}

	public void setCe3mdcc4(String ce3mdcc4) {
		this.ce3mdcc4 = ce3mdcc4;
	}

	public String getCe3mdccc() {
		return this.ce3mdccc;
	}

	public void setCe3mdccc(String ce3mdccc) {
		this.ce3mdccc = ce3mdccc;
	}


	public String getCe3mdccm() {
		return this.ce3mdccm;
	}

	public void setCe3mdccm(String ce3mdccm) {
		this.ce3mdccm = ce3mdccm;
	}

	public String getCe3mdccv() {
		return this.ce3mdccv;
	}

	public void setCe3mdccv(String ce3mdccv) {
		this.ce3mdccv = ce3mdccv;
	}

	public String getCe3menvi() {
		return this.ce3menvi;
	}

	public void setCe3menvi(String ce3menvi) {
		this.ce3menvi = ce3menvi;
	}

	public String getCe3mmdic() {
		return this.ce3mmdic;
	}

	public void setCe3mmdic(String ce3mmdic) {
		this.ce3mmdic = ce3mmdic;
	}

	public String getCe3mmdiv() {
		return this.ce3mmdiv;
	}

	public void setCe3mmdiv(String ce3mmdiv) {
		this.ce3mmdiv = ce3mmdiv;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Te3MonedaPais {id=");
		builder.append(id);
		builder.append(", ce3mdcc4=");
		builder.append(ce3mdcc4);
		builder.append(", ce3mdccc=");
		builder.append(ce3mdccc);
		builder.append(", ce3mdccm=");
		builder.append(ce3mdccm);
		builder.append(", ce3mdccv=");
		builder.append(ce3mdccv);
		builder.append(", ce3menvi=");
		builder.append(ce3menvi);
		builder.append(", ce3mmdic=");
		builder.append(ce3mmdic);
		builder.append(", ce3mmdiv=");
		builder.append(ce3mmdiv);
		builder.append("}");
		return builder.toString();
	}

	
}