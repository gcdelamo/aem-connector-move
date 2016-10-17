package com.adeo.connector.move.dto;

import com.google.gson.annotations.SerializedName;

/**
 * DTO with the customer newsletter subscriptions.
 */
public class Newsletter {

    public static final String COMMUNICATION_TYPE_PHONE = "1";
    public static final String COMMUNICATION_TYPE_FAX = "2";
    public static final String COMMUNICATION_TYPE_EMAIL = "3";
    public static final String COMMUNICATION_TYPE_ADDRESS = "4";

    /**
     * Identifier for the newsletter.
     */
    @SerializedName("newsletterId")
    private String id;
    /**
     * Identifier for the subscription
     */
    private String subscriptionId;
    /**
     * CanalCommunicationId field for the subscription service.
     * <p>
     * The corresponding values given to the subscription service are:
     * <p>
     * PHONENUMBER => 1
     * <p>
     * FAXNUMBER => 2
     * <p>
     * EMAIL  => 3
     * <p>
     * ADDRESS => 4
     */
    private String communicationType;
    /**
     * Flag to know if customer is enrolled to the newsletter.
     * <p>
     * Boolean as String
     */
    @SuppressWarnings("unused")
    private String newsletterValue;
    /**
     * Flag to know if customer is enrolled to the newsletter.
     */
    private boolean enrolled = false;


    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the subscriptionId
     */
    public String getSubscriptionId() {
        return subscriptionId;
    }

    /**
     * @param subscriptionId the subscriptionId to set
     */
    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    /**
     * @return String Communication type.
     * <p>
     * The corresponding values given to the subscription service are:
     * <p>
     * PHONENUMBER => 1
     * <p>
     * FAXNUMBER => 2
     * <p>
     * EMAIL  => 3
     * <p>
     * ADDRESS => 4
     */
    public String getCommunicationType() {
        return communicationType;
    }

    /**
     * @param communicationType String Communication type:
     *                          <p>
     *                          The corresponding values given to the subscription service are:
     *                          <p>
     *                          PHONENUMBER => 1
     *                          <p>
     *                          FAXNUMBER => 2
     *                          <p>
     *                          EMAIL  => 3
     *                          <p>
     *                          ADDRESS => 4
     */
    public void setCommunicationType(String communicationType) {
        this.communicationType = communicationType;
    }

    /**
     * @return boolean Flag to know if customer is enrolled to the newsletter.
     */
    public boolean isEnrolled() {
        return enrolled;
    }

    /**
     * @param enrolled boolean Flag to know if customer is enrolled to the newsletter.
     */
    public void setEnrolled(boolean enrolled) {
        this.enrolled = enrolled;
        if (enrolled) {
            this.newsletterValue = "true";
        } else {
            this.newsletterValue = "false";
        }
    }
}
