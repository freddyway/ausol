package com.redsys.llaa.model.db2;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the T86_PAIS database table.
 * 
 */
@Entity
@Table(name="GRUDES.T86S3")
public class T86Pais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private short c86lpais;
	
	private short c86aprfi;

	private String c86calf2;

	private String c86calf3;

	private String c86mdccm;

	private String c86mdccv;

	private String c86meba;

	private String c86nofic;

	private String c86nredu;

	private String c86tcome;

	public T86Pais() {
	}

	public short getC86aprfi() {
		return this.c86aprfi;
	}

	public void setC86aprfi(short c86aprfi) {
		this.c86aprfi = c86aprfi;
	}

	public String getC86calf2() {
		return this.c86calf2;
	}

	public void setC86calf2(String c86calf2) {
		this.c86calf2 = c86calf2;
	}

	public String getC86calf3() {
		return this.c86calf3;
	}

	public void setC86calf3(String c86calf3) {
		this.c86calf3 = c86calf3;
	}

	public short getC86lpais() {
		return this.c86lpais;
	}

	public void setC86lpais(short c86lpais) {
		this.c86lpais = c86lpais;
	}

	public String getC86mdccm() {
		return this.c86mdccm;
	}

	public void setC86mdccm(String c86mdccm) {
		this.c86mdccm = c86mdccm;
	}

	public String getC86mdccv() {
		return this.c86mdccv;
	}

	public void setC86mdccv(String c86mdccv) {
		this.c86mdccv = c86mdccv;
	}

	public String getC86meba() {
		return this.c86meba;
	}

	public void setC86meba(String c86meba) {
		this.c86meba = c86meba;
	}

	public String getC86nofic() {
		return this.c86nofic;
	}

	public void setC86nofic(String c86nofic) {
		this.c86nofic = c86nofic;
	}

	public String getC86nredu() {
		return this.c86nredu;
	}

	public void setC86nredu(String c86nredu) {
		this.c86nredu = c86nredu;
	}

	public String getC86tcome() {
		return this.c86tcome;
	}

	public void setC86tcome(String c86tcome) {
		this.c86tcome = c86tcome;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("T86Pais {c86lpais=");
		builder.append(c86lpais);
		builder.append(", c86aprfi=");
		builder.append(c86aprfi);
		builder.append(", c86calf2=");
		builder.append(c86calf2);
		builder.append(", c86calf3=");
		builder.append(c86calf3);
		builder.append(", c86mdccm=");
		builder.append(c86mdccm);
		builder.append(", c86mdccv=");
		builder.append(c86mdccv);
		builder.append(", c86meba=");
		builder.append(c86meba);
		builder.append(", c86nofic=");
		builder.append(c86nofic);
		builder.append(", c86nredu=");
		builder.append(c86nredu);
		builder.append(", c86tcome=");
		builder.append(c86tcome);
		builder.append("}");
		return builder.toString();
	}

	
	
}