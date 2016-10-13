package com.adeo.connector.move.dto;

import com.google.gson.annotations.SerializedName;

/**
 * DTO with the classification of the customer account.
 */
public class NaturalPersonClassification {

	public static final String MALE_CODE = "31001";
	private static final String MALE_LABEL = "Hombre";
	public static final String FEMALE_CODE = "31002";
	private static final String FEMALE_LABEL = "Mujer";
	public static final String HAS_LITHIUMACCOUNT_CODE = "47001";
	public static final String HASNT_LITHIUMACCOUNT_CODE = "47002";

	/** Represents the code of the customer´s gender.
	 * 31001 - Male
	 * 31002 - Female
	 */
	@SerializedName("gender")
	private String genderCode;
	/** Represents the code of the fact that customer has a lithium account or not.
	 * 47001 - SI
	 * 47002 - NO
	 */
	@SerializedName("hasLithiumAccount")
	private String hasLithiumAccountCode;


	/**
	 * @return the genderCode
	 * 31001 - Male
	 * 31002 - Female
	 */
	public String getGenderCode() {
		return genderCode;
	}
	/**
	 * @param String genderCode:
	 * 31001 - Male
	 * 31002 - Female
	 */
	public void setGenderCode(String genderCode) {
		this.genderCode = genderCode;
	}
	/**
	 * @return String Gender label.
	 */
	public String getGenderLabel() {
		switch (getGenderCode()) {
			case MALE_CODE:
				return MALE_LABEL;
			case FEMALE_CODE:
				return FEMALE_LABEL;
			default:
				return "";
		}
	}
	/**
	 * @return the hasLithiumAccountCode
	 * 47001 - SI
	 * 47002 - NO
	 */
	public String getHasLithiumAccountCode() {
		return hasLithiumAccountCode;
	}
	/**
	 * @param hasLithiumAccountCode String the hasLithiumAccountCode
	 * 47001 - SI
	 * 47002 - NO
	 */
	public void setHasLithiumAccountCode(String hasLithiumAccountCode) {
		this.hasLithiumAccountCode = hasLithiumAccountCode;
	}
	/**
	 * @return boolean The fact that customer has a lithium account or not.
	 */
	public boolean hasLithiumAccount() {
		switch (getHasLithiumAccountCode()) {
		case HAS_LITHIUMACCOUNT_CODE:
			return true;
		case HASNT_LITHIUMACCOUNT_CODE:
			return false;
		default:
			return false;
		}
	}
}
