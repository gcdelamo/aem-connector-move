package com.adeo.connector.move.gateway.com.adeo.connector.move.services;

import com.adeo.connector.move.dto.CustomerAccount;
import com.adeo.connector.move.gateway.MoveGateway;
import com.adeo.connector.move.gateway.MoveRequest;
import com.adeo.connector.move.gateway.MoveResponse;
import com.adobe.connector.ConnectorResponse;
import com.adobe.connector.gateways.connection.http.HttpResponse;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import java.util.Collections;
import java.util.Map;

/**
 * Created by stievena on 13/10/16.
 */
@Component(immediate = true)
@Service(value = MoVeService.class)
public class SearchUserService extends MoVeService {
    @Override
    public String getName() {
        return "SearchUserService";
    }

    @Override
    public String getPath() {
        return "/CustomerAccount/rest/v1/customerAccounts/Search?email={O}";
    }

    @Override
    public ConnectorResponse makeResponse(HttpResponse httpResponse, MoveRequest moveRequest) {
        CustomerAccount account = mapJsonToObject(httpResponse.getData(), CustomerAccount.class);
        return new MoveResponse(Collections.singletonList(account));
    }

    @Override
    public Map<String, String> getHeaders(MoveGateway gateway, MoveRequest moveRequest) {
        Map<String, String> headers = super.getHeaders(gateway, moveRequest);
        headers.put("Move-Application-Source", "WEB");
        headers.put("Move-Correlation-Id", "correlation-id-web");
        headers.put("Move-Store-Code", "058");
        return headers;
    }
}
