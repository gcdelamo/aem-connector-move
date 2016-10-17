package com.adeo.connector.move.gateway.com.adeo.connector.move.services;

import com.adeo.connector.move.dto.CustomerAccount;
import com.adeo.connector.move.gateway.MoveGateway;
import com.adeo.connector.move.gateway.MoveRequest;
import com.adobe.connector.gateway.connection.http.HttpResponse;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import java.util.Collections;
import java.util.List;
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
    public List makeResponse(HttpResponse httpResponse, MoveRequest moveRequest) {
        CustomerAccount account = fromJson(httpResponse.getData(), CustomerAccount.class);
        return Collections.singletonList(account);
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
