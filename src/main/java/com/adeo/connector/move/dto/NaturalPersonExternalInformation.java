package com.adeo.connector.move.dto;

import com.google.gson.annotations.SerializedName;

/**
 * DTO with the extra information to customer account, when the customer´s type is Natural Person.
 */
public class NaturalPersonExternalInformation {

	/** Represents the DNI */
	private String dni;
	/** Represents the NIE */
	private String nie;
	/**Represents the Passport. */
	@SerializedName("pasaporte")
	private String passport;


	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}
	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	/**
	 * @return the nie
	 */
	public String getNie() {
		return nie;
	}
	/**
	 * @param nie the nie to set
	 */
	public void setNie(String nie) {
		this.nie = nie;
	}
	/**
	 * @return the passport
	 */
	public String getPassport() {
		return passport;
	}
	/**
	 * @param passport the passport to set
	 */
	public void setPassport(String passport) {
		this.passport = passport;
	}
}
