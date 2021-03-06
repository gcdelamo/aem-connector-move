package com.adeo.connector.move.gateway.com.adeo.connector.move.services;

import com.adeo.connector.move.dto.OauthSessionTokenInfo;
import com.adeo.connector.move.gateway.MoveGateway;
import com.adeo.connector.move.gateway.MoveRequest;
import com.adobe.connector.gateway.connection.http.HttpResponse;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import java.text.MessageFormat;
import java.util.*;

/**
 * Created by stievena on 12/10/16.
 */
@Component(immediate = true)
@Service(value = MoVeService.class)
public class LoginService extends MoVeService {

    @Override
    public String getUrl(MoveGateway gateway, String[] parameters) {
        String url = new StringBuilder().append(gateway.getMoveOauthDomain()).append("://").append(gateway.getMoveOauthDomain()).append(gateway.getMoveOauthContext()).append(getPath()).toString();
        if (parameters.length > 0) {
            MessageFormat messageFormat = new MessageFormat(url);
            url = messageFormat.format(parameters);
        }
        return url;
    }

    @Override
    public String getName() {
        return "LoginService";
    }

    @Override
    public String getPath() {
        return "/oauth-server/oauth/token";
    }

    @Override
    public Map<String, String> getFormParameters(MoveGateway gateway, MoveRequest moveRequest) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("grant_type", "password");
        parameters.put("username", moveRequest.getFormAttribute("username"));
        parameters.put("password", moveRequest.getFormAttribute("password"));
        return parameters;
    }

    @Override
    public List makeResponse(HttpResponse httpResponse, MoveRequest moveRequest) {
        OauthSessionTokenInfo sessionTokenInfo = fromJson(httpResponse.getData(), OauthSessionTokenInfo.class);
        return Collections.singletonList(sessionTokenInfo);
    }


    @Override
    public Map<String, String> getHeaders(MoveGateway gateway, MoveRequest moveRequest) {
        Map<String, String> headers = super.getHeaders(gateway, moveRequest);
        headers.put("Authorization", "Basic " + Base64.getEncoder().encodeToString((gateway.getMoveOauthClientId() + ":" + gateway.getMoveOauthClientSecret()).getBytes()));
        return headers;
    }
}
