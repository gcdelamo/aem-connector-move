/**
 * 
 */
package com.adeo.connector.move.dto;

import com.google.gson.annotations.SerializedName;

/**
 * DTO with the information to customer communication.
 */
public class CommunicationOption {

	public static final String COMMUNICATION_TYPE_EMAIL = "EMAIL";
	public static final String COMMUNICATION_TYPE_PHONE = "PHONENUMBER";
	public static final String COMMUNICATION_TYPE_FAX = "FAXNUMBER";
	public static final String COMMUNICATION_TYPE_ADDRESS = "ADDRESS";

	@SerializedName("communicationId")
	private Integer id;
	/** Values: EMAIL, PHONENUMBER, FAXNUMBER, ADDRESS */
	@SerializedName("communicationType")
	private String type;
	/** Value of the communication */
	@SerializedName("communicationValue")
	private String value;
	/** Flag to set the main communication */
	@SerializedName("mainCommunication")
	private String isMain;
	/** Order index for the communication */
	@SerializedName("communicationOrder")
	private String index;
	/** This data is used only for PHONENUMBER communication type. */
	private String phoneType;


	public CommunicationOption() {
		super();
	}

	public CommunicationOption(String type, String value, String isMain, String index) {
		super();
		this.type = type;
		this.value = value;
		this.isMain = isMain;
		this.index = index;
	}
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
	 * @return String Communication´s type.
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type String Communication´s type.
	 * <br>Values: EMAIL, PHONENUMBER, FAXNUMBER, ADDRESS.
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * @return the isMain
	 */
	public String isMain() {
		return isMain;
	}
	/**
	 * @param isMain the isMain to set
	 */
	public void setMain(String isMain) {
		this.isMain = isMain;
	}
	/**
	 * @return the index
	 */
	public String getIndex() {
		return index;
	}
	/**
	 * @param index the index to set
	 */
	public void setIndex(String index) {
		this.index = index;
	}
	/**
	 * @return the phoneType
	 */
	public String getPhoneType() {
		return phoneType;
	}
	/**
	 * @param phoneType the phoneType to set
	 */
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}
}
