package com.adeo.connector.move.gateway;

import com.adobe.connector.ConnectorRequest;

import java.util.HashMap;
import java.util.Map;

public class MoveRequest extends ConnectorRequest {

    protected String[] parameters;
    protected Map<String, String> attributes = new HashMap<>();
    protected Object body;

    public MoveRequest(String... parameters) {
        this.parameters = parameters;
    }

    public String[] getParameters() {
        return this.parameters;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void addAttribute(String key, String value) {
        attributes.put(key, value);
    }

    public String getAttribute(String key) {
        return attributes.get(key);
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
