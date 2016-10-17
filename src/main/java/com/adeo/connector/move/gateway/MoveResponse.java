package com.adeo.connector.move.gateway;


import com.adobe.connector.ConnectorResponse;

import java.util.List;

/**
 * Opus's Reponse Object.
 *
 * @author kassa
 */
public class MoveResponse<T> extends ConnectorResponse<T> {

    private final static MoveResponse NO_RESPONSE = new MoveResponse(null);

    private int status;
    private String message;
    private List<T> results;

    public MoveResponse(List<T> results) {
        this.results = results;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public List<T> getResults() {
        return results;
    }

    public static MoveResponse makeNoResponse() {
        return NO_RESPONSE;
    }
}
