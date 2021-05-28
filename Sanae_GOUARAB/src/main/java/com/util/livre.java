package com.util;

public class livre {
	int id_liv, clecat;
	String nom_liv,nom_aut;
	public int getId_liv() {
		return id_liv;
	}
	public void setId_liv(int id_liv) {
		this.id_liv = id_liv;
	}
	public String getNom_liv() {
		return nom_liv;
	}
	public void setNom_liv(String nom_liv) {
		this.nom_liv = nom_liv;
	}
	public String getNom_aut() {
		return nom_aut;
	}
	public void setNom_aut(String nom_aut) {
		this.nom_aut = nom_aut;
	}
	public int getClecat() {
		return clecat;
	}
	public void setClecat(int clecat) {
		this.clecat = clecat;
	}
	@Override
	public String toString() {
		return "livre [id_liv=" + id_liv + ", nom_liv=" + nom_liv + ", nom_aut=" + nom_aut + ", clecat=" + clecat + " ]";
	}

}
