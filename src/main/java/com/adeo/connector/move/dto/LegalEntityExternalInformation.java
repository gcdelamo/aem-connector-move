package com.adeo.connector.move.dto;

/**
 * DTO with the extra information to customer account, when the customer´s type is Legal Entity.
 */
public class LegalEntityExternalInformation {

	/** Customer CIF. */
	private String cif;


	/**
	 * @return the cif
	 */
	public String getCif() {
		return cif;
	}
	/**
	 * @param cif the cif to set
	 */
	public void setCif(String cif) {
		this.cif = cif;
	}
}
