package com.adeo.connector.move.gateway;

import com.adobe.connector.RestResponse;

import java.util.List;

/**
 * Created by stievena on 19/10/16.
 */
public class MoveResponse<T> extends RestResponse<T> {
    public MoveResponse(List<T> results, int status, String message) {
        super(results, status, message);
    }
}
