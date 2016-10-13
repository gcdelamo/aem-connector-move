package com.adeo.connector.move.gateway.com.adeo.connector.move.services;

import com.adeo.connector.move.gateway.MoveGateway;
import com.adeo.connector.move.gateway.MoveRequest;
import com.adobe.connector.ConnectorResponse;
import com.adobe.connector.gateways.connection.http.HttpResponse;
import com.adobe.connector.gateways.message.HttpMessage;
import com.google.gson.Gson;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by stievena on 12/10/16.
 */
public abstract class MoVeService {

    protected final Gson gson = new Gson();

    protected <T> T convertJson(byte[] data, Class<T> modelClass) {
        Reader jsonReader = new InputStreamReader(new ByteArrayInputStream(data));
        return gson.fromJson(jsonReader, modelClass);
    }

    public String getUrl(MoveGateway gateway, String[] parameters) {
        String url = new StringBuilder().append(gateway.getMoveOauthDomain()).append("://").append(gateway.getMoveDomain()).append(gateway.getMoveContext()).append(getPath()).toString();
        if (parameters.length > 0) {
            MessageFormat messageFormat = new MessageFormat(url);
            url = messageFormat.format(parameters);
        }
        return url;
    }

    public abstract String getName();

    public abstract String getPath();

    public abstract ConnectorResponse makeResponse(HttpResponse httpResponse, MoveRequest moveRequest);

    public HttpMessage.POST_METHOD getHttpMethod() {
        return HttpMessage.POST_METHOD.BODY;
    }

    public Map<String, String> getFormParameters(MoveGateway gateway, MoveRequest moveRequest) {
        return null;
    }

    public Map<String, String> getHeaders(MoveGateway gateway, MoveRequest moveRequest) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        return headers;
    }

    public String getBody(MoveRequest moveRequest) {
        return null;
    }

    public String getMediaType() {
        return "application/json";
    }
}
