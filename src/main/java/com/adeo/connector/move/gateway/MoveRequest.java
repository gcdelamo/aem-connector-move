package com.adeo.connector.move.gateway;

import com.adobe.connector.ConnectorRequest;

import java.util.Map;

public class MoveRequest extends ConnectorRequest {

    protected String[] parameters;
    protected Map<String, String> headers;
    protected Object body;

    public MoveRequest(Map<String, String> headers, Object body, String... parameters) {
        this.parameters = parameters;
        this.headers = headers;
        this.body = body;
    }

    public String[] getParameters() {
        return this.parameters;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Object getBody() {
        return body;
    }
}
