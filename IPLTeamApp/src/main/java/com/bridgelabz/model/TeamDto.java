package com.bridgelabz.model;
public class TeamDto {
	//add setters and getters
	private String name;
	private String owner;
	private String couch;
	private String captain;
	public String getCaptain() {
		return captain;
	}
	public void setCaptain(String captain) {
		this.captain = captain;
	}
	private String veneue;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getCouch() {
		return couch;
	}
	public void setCouch(String couch) {
		this.couch = couch;
	}
	
	public String getVeneue() {
		return veneue;
	}
	public void setVeneue(String veneue) {
		this.veneue = veneue;
	}
	
}
