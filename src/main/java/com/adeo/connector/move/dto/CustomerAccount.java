package com.adeo.connector.move.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * DTO with customer account information.
 */
public class CustomerAccount {

    public static final String CUSTOMER_TYPE_NATURAL_PERSON = "naturalPerson";
    public static final String CUSTOMER_TYPE_LEGAL_ENTITY = "legalEntity";
    public static final String LEGAL_ENTITY_SA_CODE = "1";
    private static final String LEGAL_ENTITY_SA_LABEL = "SA";
    public static final String LEGAL_ENTITY_SL_CODE = "2";
    private static final String LEGAL_ENTITY_SL_LABEL = "SL";

    /**
     * Customer id (customerNumber)
     */
    private String customerNumber;
    /**
     * Type of customer
     */
    private String customerType;
    /**
     * Customer name
     */
    private String name;
    /**
     * Customer first name
     */
    private String firstName;
    /**
     * Business Name (razón social). Only when the customer´s type is Legal Entity.
     */
    @SerializedName("corporateName")
    private String businessName;
    /**
     * Extra information when customer´s type is Legal Entity.
     */
    private LegalEntityExternalInformation legalEntityExternalInformations;
    /**
     * Legal entity type code. Only when the customer´s type is Legal Entity.
     */
    @SerializedName("legalEntityType")
    private String legalEntityTypeCode;
    /**
     * Customer web account status.
     */
    @SerializedName("accountStatus")
    private String status;
    /**
     * Customer email (login)
     */
    @SerializedName("login")
    private String email;
    /**
     * Customer password
     */
    private String password;
    /**
     * Customer birthday date. Format 'YYYY-MM-DDTHH:mm:ssZ'
     */
    private String birthDate;
    /**
     * Options for customer communication
     */
    private List<CommunicationOption> communicationOptions;
    /**
     * Optins for the options customer communication
     */
    private List<Optin> optins;
    /**
     * Extra information when customer´s type is Natural Person.
     */
    private NaturalPersonExternalInformation naturalPersonExternalInformations;
    /**
     * Classification when customer´s type is Natural Person.
     */
    private NaturalPersonExternalInformation naturalPersonClassifications;
    /**
     * Customer addresses
     */
    private List<Address> addresses;
    /**
     * Customer newsletter subscriptions.
     */
    private List<Newsletter> newsletters;


    public CustomerAccount() {
        super();
    }

    /**
     * @return the customerNumber
     */
    public String getCustomerNumber() {
        return customerNumber;
    }

    /**
     * @param customerNumber the customerNumber to set
     */
    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    /**
     * @return The type of customer:
     * <br>- Natural Person
     * <br>- Legal Entity
     */
    public String getCustomerType() {
        return customerType;
    }

    /**
     * @param customerType the type of customer:
     *                     <br>- Natural Person
     *                     <br>- Legal Entity
     */
    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    /**
     * @return Customer name.
     * <br>When the customer´s type is Legal Entity, this field corresponds to commercial name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name Customer name.
     *             <br>When the customer´s type is Legal Entity, this field corresponds to commercial name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return Business Name (razón social).
     * <br>Only when the customer´s type is Legal Entity.
     */
    public String getBusinessName() {
        return businessName;
    }

    /**
     * @param businessName Business Name (razón social).
     *                     <br>Only when the customer´s type is Legal Entity.
     */
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    /**
     * @return LegalEntityExternalInformation Extra information when customer´s type is Legal Entity.
     */
    public LegalEntityExternalInformation getLegalEntityExternalInformations() {
        return legalEntityExternalInformations;
    }

    /**
     * @param legalEntityExternalInformations LegalEntityExternalInformation Extra information
     *                                        <br>when customer´s type is Legal Entity.
     */
    public void setLegalEntityExternalInformations(LegalEntityExternalInformation legalEntityExternalInformations) {
        this.legalEntityExternalInformations = legalEntityExternalInformations;
    }

    /**
     * @return String Legal entity type code.
     * <br>Only when the customer´s type is Legal Entity.
     */
    public String getLegalEntityTypeCode() {
        return legalEntityTypeCode;
    }

    /**
     * @param legalEntityTypeCode String Legal entity type code.
     *                            <br>Only when the customer´s type is Legal Entity.
     */
    public void setLegalEntityTypeCode(String legalEntityTypeCode) {
        this.legalEntityTypeCode = legalEntityTypeCode;
    }

    /**
     * @return String Legal entity type label.
     * <br>Only when the customer´s type is Legal Entity.
     */
    public String getLegalEntityTypeLabel() {
        switch (getLegalEntityTypeCode()) {
            case LEGAL_ENTITY_SA_CODE:
                return LEGAL_ENTITY_SA_LABEL;
            case LEGAL_ENTITY_SL_CODE:
                return LEGAL_ENTITY_SL_LABEL;
            default:
                return "";
        }
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the email (login)
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email (login) to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return String Customer birthday date.
     * <br>Format 'YYYY-MM-DDTHH:mm:ssZ'
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate String Customer birthday date.
     *                  <br>Format 'YYYY-MM-DDTHH:mm:ssZ'
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return the communicationOptions
     */
    public List<CommunicationOption> getCommunicationOptions() {
        return communicationOptions;
    }

    /**
     * @param communicationOptions the communicationOptions to set
     */
    public void setCommunicationOptions(List<CommunicationOption> communicationOptions) {
        this.communicationOptions = communicationOptions;
    }

    /**
     * @return the optins
     */
    public List<Optin> getOptins() {
        return optins;
    }

    /**
     * @param optins the optins to set
     */
    public void setOptins(List<Optin> optins) {
        this.optins = optins;
    }

    /**
     * @return NaturalPersonExternalInformation Extra information
     * <br>when customer´s type is Natural Person.
     */
    public NaturalPersonExternalInformation getNaturalPersonExternalInformations() {
        return naturalPersonExternalInformations;
    }

    /**
     * @param naturalPersonExternalInformations Extra information
     *                                          <br>when customer´s type is Natural Person.
     */
    public void setNaturalPersonExternalInformations(NaturalPersonExternalInformation naturalPersonExternalInformations) {
        this.naturalPersonExternalInformations = naturalPersonExternalInformations;
    }

    /**
     * @return NaturalPersonExternalInformation Classification when customer´s
     * <br>type is Natural Person.
     */
    public NaturalPersonExternalInformation getNaturalPersonClassifications() {
        return naturalPersonClassifications;
    }

    /**
     * @param naturalPersonClassifications NaturalPersonExternalInformation Classification
     *                                     <br>when customer´s type is Natural Person.
     */
    public void setNaturalPersonClassifications(NaturalPersonExternalInformation naturalPersonClassifications) {
        this.naturalPersonClassifications = naturalPersonClassifications;
    }

    /**
     * @return the addresses
     */
    public List<Address> getAddresses() {
        return addresses;
    }

    /**
     * @param addresses the addresses to set
     */
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    /**
     * @return the newsletters
     */
    public List<Newsletter> getNewsletters() {
        return newsletters;
    }

    /**
     * @param newsletters the newsletters to set
     */
    public void setNewsletters(List<Newsletter> newsletters) {
        this.newsletters = newsletters;
    }
}
