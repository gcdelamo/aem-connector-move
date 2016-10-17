package com.adeo.connector.move.dto;

import com.google.gson.annotations.SerializedName;

public class OauthSessionTokenInfo {

    /**
     * Token required to access
     */
    @SerializedName("access_token")
    private String accessToken;
    /**
     * Token needed to regain access
     */
    @SerializedName("refresh_token")
    private String refreshToken;
    /**
     * Email(login) of the customer logged
     */
    private String email;
    /**
     * Id of the customer logged
     */
    private String customerNumber;


    /**
     * Default constructor
     */
    public OauthSessionTokenInfo() {
        super();
    }

    /**
     * @param accessToken  String Token required to access.
     * @param refreshToken String Token needed to regain access.
     */
    public OauthSessionTokenInfo(String accessToken, String refreshToken) {
        super();
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }


    /**
     * @return the accessToken
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * @param accessToken the accessToken to set
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * @return the refreshToken
     */
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * @param refreshToken the refreshToken to set
     */
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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
}
