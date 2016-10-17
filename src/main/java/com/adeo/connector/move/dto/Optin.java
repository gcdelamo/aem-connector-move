package com.adeo.connector.move.dto;

import com.google.gson.annotations.SerializedName;

public class Optin {

	public static final int OPTIN_CODE_ADDRESS = 1;
	public static final int OPTIN_CODE_SMS = 2;
	public static final int OPTIN_CODE_TELEMARKETING = 3;
	public static final int OPTIN_CODE_EMAIL = 4;
	public static final String COMMUNICATION_TYPE_EMAIL = "EMAIL";
	public static final String COMMUNICATION_TYPE_PHONE = "PHONENUMBER";
	public static final String COMMUNICATION_TYPE_FAX = "FAXNUMBER";
	public static final String COMMUNICATION_TYPE_ADDRESS = "ADDRESS";

	/** Identifier for the optin: 
	 *<br> 1 - Address optin
	 *<br> 2 - SMS optin
	 *<br> 3 - Telemarketing optin
	 *<br> 4- E-mail optin */
	@SerializedName("optinCode")
	private int code;
	/** Flag to know if customer is enrolled to the optin */
	@SerializedName("optinValue")
	private boolean value;
	/** Communication type:
	 *<br> - EMAIL
	 *<br> - PHONENUMBER
	 *<br> - FAXNUMBER
	 *<br> - ADDRESS */
	@SerializedName("communicationType")
	private String type;


	public Optin(Integer code, boolean value, String type) {
		super();
		this.code = code;
		this.value = value;
		this.type = type;
	}

	public Optin() {
		super();
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}
	/**
	 * @param code Integer Optin code:
	 *<br> 1 - Address optin
	 *<br> 2 - SMS optin
	 *<br> 3 - Telemarketing optin
	 *<br> 4- E-mail optin
	 */
	public void setCode(int code) {
		this.code = code;
	}
	/**
	 * @return the value
	 */
	public boolean isValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(boolean value) {
		this.value = value;
	}
	/**
	 * @return String Communication type.
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type String Communication type:
	 *<br> - EMAIL
	 *<br> - PHONENUMBER
	 *<br> - FAXNUMBER
	 *<br> - ADDRESS */
	public void setType(String type) {
		this.type = type;
	}
}
