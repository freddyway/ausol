package com.redsys.llaa.model.db2;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Te3MonedaPaisPK implements Serializable {
	private static final long serialVersionUID = 1L;
	private short ce0lmone;
	private short c86lpais;
	
	public Te3MonedaPaisPK() {
	
	}

	public short getCe0lmone() {
		return ce0lmone;
	}

	public void setCe0lmone(short ce0lmone) {
		this.ce0lmone = ce0lmone;
	}

	public short getC86lpais() {
		return c86lpais;
	}

	public void setC86lpais(short c86lpais) {
		this.c86lpais = c86lpais;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + c86lpais;
		result = prime * result + ce0lmone;
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
		Te3MonedaPaisPK other = (Te3MonedaPaisPK) obj;
		if (c86lpais != other.c86lpais)
			return false;
		if (ce0lmone != other.ce0lmone)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Te3MonedaPaisPK {ce0lmone=");
		builder.append(ce0lmone);
		builder.append(", c86lpais=");
		builder.append(c86lpais);
		builder.append("}");
		return builder.toString();
	}


	

}
