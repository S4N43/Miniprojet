package com.util;

public class cate {

	int clecat;
	String nom_cat;
	public int getClecat() {
		return clecat;
	}
	public void setClecat(int clecat) {
		this.clecat = clecat;
	}
	public String getNom_cat() {
		return nom_cat;
	}
	public void setNom_cat(String nom_cat) {
		this.nom_cat = nom_cat;
	}
	@Override
	public String toString() {
		return "cate [clecat=" + clecat + ", nom_cat=" + nom_cat + "]";
	}
}
