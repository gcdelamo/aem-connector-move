package com.adeo.connector.move.gateway.com.adeo.connector.move.services;

import com.adeo.connector.move.gateway.MoveGateway;
import com.adeo.connector.move.gateway.MoveRequest;
import com.adobe.connector.ConnectorResponse;
import com.adobe.connector.gateways.connection.http.HttpResponse;
import com.adobe.connector.gateways.message.HttpMessage;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by stievena on 12/10/16.
 */
@Component(immediate = true)
@Service(value = MoVeService.class)
public class LoginService implements MoVeService {
    @Override
    public String getName() {
        return "LoginService";
    }

    @Override
    public String getUrl() {
        return "/oauth-server/oauth/token?grant_type=password&username={0}&password={1}";
    }

    @Override
    public ConnectorResponse makeResponse(HttpResponse httpResponse, MoveRequest moveRequest) {
        return null;
    }

    @Override
    public HttpMessage.HTTP_METHOD getHttpMethod() {
        return HttpMessage.HTTP_METHOD.POST;
    }

    @Override
    public Map<String, String> getHeaders(MoveGateway gateway) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Basic " + Base64.getEncoder().encodeToString((gateway.getMoveOauthClientId() + ":" + gateway.getMoveOauthClientSecret()).getBytes()));
        return headers;
    }
}
