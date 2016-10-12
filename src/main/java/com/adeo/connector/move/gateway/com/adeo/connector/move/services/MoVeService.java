package com.adeo.connector.move.gateway.com.adeo.connector.move.services;

import com.adeo.connector.move.gateway.MoveGateway;
import com.adeo.connector.move.gateway.MoveRequest;
import com.adobe.connector.ConnectorResponse;
import com.adobe.connector.gateways.connection.http.HttpResponse;
import com.adobe.connector.gateways.message.HttpMessage;

import java.util.Map;

/**
 * Created by stievena on 12/10/16.
 */
public interface MoVeService {

    String getName();

    String getUrl();

    ConnectorResponse makeResponse(HttpResponse httpResponse, MoveRequest moveRequest);

    HttpMessage.HTTP_METHOD getHttpMethod();

    Map<String, String> getHeaders(MoveGateway gateway);
}
