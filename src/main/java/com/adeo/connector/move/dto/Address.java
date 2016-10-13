package com.adeo.connector.move.dto;

import com.google.gson.annotations.SerializedName;

/**
 * DTO with customer addresses.
 */
public class Address {

	public static final int HOUSE_TYPE_CODE_HOUSE = 1;
	private static final String HOUSE_TYPE_LABEL_HOUSE = "Chalet";
	public static final int HOUSE_TYPE_CODE_FLAT = 2;
	private static final String HOUSE_TYPE_LABEL_FLAT = "Bloque";
	public static final int HOUSE_TYPE_CODE_WITH_GARDEN = 3;
	private static final String HOUSE_TYPE_LABEL_WITH_GARDEN = "Bajo con jardín";

	/** Unique identifier of the address in SIRIUS. */
	@SerializedName("addressId")
	private Integer id;
	/** Flag to set the customer main address.
	 *  One and only one address must be the main address. */
	@SerializedName("mainAddress")
	private boolean main = false;
	/**  */
	private String line1;
	/**  */
	private String line2;
	/**  */
	private String line3;
	/**  */
	private String line4;
	/** Address postal code. */
	private String postalCode;
	/** Address city. */
	private String city;
	/** Address postal province. */
	private String province;
	/** House type code of the address. */
	@SerializedName("houseType")
	private int houseTypeCode = 0;


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the main
	 */
	public boolean isMain() {
		return main;
	}
	/**
	 * @param main the main to set
	 */
	public void setMain(boolean main) {
		this.main = main;
	}
	/**
	 * @return the line1
	 */
	public String getLine1() {
		return line1;
	}
	/**
	 * @param line1 the line1 to set
	 */
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	/**
	 * @return the line2
	 */
	public String getLine2() {
		return line2;
	}
	/**
	 * @param line2 the line2 to set
	 */
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	/**
	 * @return the line3
	 */
	public String getLine3() {
		return line3;
	}
	/**
	 * @param line3 the line3 to set
	 */
	public void setLine3(String line3) {
		this.line3 = line3;
	}
	/**
	 * @return the line4
	 */
	public String getLine4() {
		return line4;
	}
	/**
	 * @param line4 the line4 to set
	 */
	public void setLine4(String line4) {
		this.line4 = line4;
	}
	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}
	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * @return the houseTypeCode
	 */
	public int getHouseTypeCode() {
		return houseTypeCode;
	}
	/**
	 * @param houseTypeCode the houseTypeCode to set
	 */
	public void setHouseTypeCode(int houseTypeCode) {
		this.houseTypeCode = houseTypeCode;
	}
	/**
	 * @return String House type label of the address.
	 */
	public String getHouseTypeLabel() {
		switch (getHouseTypeCode()) {
			case HOUSE_TYPE_CODE_HOUSE:
				return HOUSE_TYPE_LABEL_HOUSE;
			case HOUSE_TYPE_CODE_FLAT:
				return HOUSE_TYPE_LABEL_FLAT;
			case HOUSE_TYPE_CODE_WITH_GARDEN:
				return HOUSE_TYPE_LABEL_WITH_GARDEN;
			default:
				return "";
		}
	}
}
