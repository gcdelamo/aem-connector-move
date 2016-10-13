package com.adeo.connector.move.gateway;

import com.adeo.connector.move.LoginRequest;
import com.adeo.connector.move.gateway.com.adeo.connector.move.services.MoVeService;
import com.adobe.connector.ConnectorResponse;
import com.adobe.connector.gateways.Gateway;
import com.adobe.connector.gateways.GatewayRequest;
import com.adobe.connector.gateways.connection.EndpointConnector;
import com.adobe.connector.gateways.connection.EndpointResponse;
import com.adobe.connector.gateways.connection.http.HttpResponse;
import com.adobe.connector.gateways.message.HttpMessage;
import com.adobe.connector.gateways.message.Message;
import org.apache.felix.scr.annotations.*;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component(immediate = true, label = "Adeo MoVe Connector Gateway", description = "Gateway for communicating with MoVe back end", metatype = true)
@Service(value = Gateway.class)
@References({
        @Reference(name = "service", referenceInterface = MoVeService.class, cardinality = ReferenceCardinality.OPTIONAL_MULTIPLE, policy = ReferencePolicy.DYNAMIC)})
public class MoveGateway extends Gateway {

    private final static Logger logger = LoggerFactory.getLogger(MoveGateway.class);

    @Reference
    private EndpointConnector endpointConnector;

    private final Map<String, MoVeService> services = new ConcurrentHashMap<>();

    protected void bindService(final MoVeService service, final Map<String, Object> properties) {
        if (service != null) {
            this.services.put(service.getName(), service);
            initServices();
        }
    }

    protected void unbindService(final MoVeService service, final Map<String, Object> properties) {
        if (service != null) {
            this.services.remove(service.getName());
            initServices();
        }
    }

    @Property(label = "Name", description = "The unique name of the gateway")
    protected static final String GATEWAY_NAME = "gateway.name";

    @Property(label = "URL Scheme", description = "URL scheme used for MoVe requests. Values are 'http' or 'https'")
    protected static final String MOVE_SCHEME = "move.url.scheme";

    @Property(label = "URL Domain", description = "URL domain used for MoVe requests. Form is 'example.com[:port]'")
    protected static final String MOVE_DOMAIN = "move.url.domain";

    @Property(label = "URL Context", description = "URL context used for MoVe requests. Form is '/context'")
    protected static final String MOVE_CONTEXT = "move.url.context";

    @Property(label = "OAuth URL Domain", description = "URL domain used for MoVe OAuth requests. Form is 'example.com[:port]'")
    protected static final String MOVE_OAUTH_DOMAIN = "move.oauth.url.domain";

    @Property(label = "OAuth URL Context", description = "URL context used for MoVe OAuth requests. Form is '/context'")
    protected static final String MOVE_OAUTH_CONTEXT = "move.oauth.url.context";

    @Property(label = "OAuth Client ID", description = "Client ID used for OAuth authentication")
    protected static final String MOVE_OAUTH_TOKEN_ID = "move.oauth.token.id";

    @Property(label = "OAuth Client Secret", description = "Client Secret used for OAuth authentication")
    protected static final String MOVE_OAUTH_TOKEN_SECRET = "move.oauth.token.secret";

    private String moveScheme;
    private String moveDomain;
    private String moveOauthDomain;
    private String moveOauthContext;
    private String moveContext;
    private String name;
    private String moveOauthClientId;
    private String moveOauthClientSecret;
    private Map<Class, MoVeService> serviceMappings = new ConcurrentHashMap<>();

    @Activate
    protected void activate(final Map<String, Object> config) {
        this.moveScheme = PropertiesUtil.toString(config.get(MOVE_SCHEME), "");
        this.moveDomain = PropertiesUtil.toString(config.get(MOVE_DOMAIN), "");
        this.moveOauthDomain = PropertiesUtil.toString(config.get(MOVE_OAUTH_DOMAIN), "");
        this.moveOauthContext = PropertiesUtil.toString(config.get(MOVE_OAUTH_CONTEXT), "");
        this.moveContext = PropertiesUtil.toString(config.get(MOVE_CONTEXT), "");
        this.name = PropertiesUtil.toString(config.get(GATEWAY_NAME), "");
        this.moveOauthClientId = PropertiesUtil.toString(config.get(MOVE_OAUTH_TOKEN_ID), "");
        this.moveOauthClientSecret = PropertiesUtil.toString(config.get(MOVE_OAUTH_TOKEN_SECRET), "");
        initServices();
    }

    private void initServices() {
        registerService(LoginRequest.class, "LoginService");
    }

    protected void registerService(Class request, String serviceName) {
        this.serviceMappings.put(request, this.services.get(serviceName));
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    protected EndpointConnector getEndpointConnector() {
        return endpointConnector;
    }

    @Override
    protected Message getMessage(GatewayRequest gatewayRequest) {
        MoveRequest request = (MoveRequest) gatewayRequest.getConnectorRequest();
        MoVeService service = getService(request.getClass());


        Map<String, String> headers = new HashMap<>();
        if (service.getHeaders(this, request) != null) {
            headers.putAll(service.getHeaders(this, request));
        }

        HttpMessage message;
        if (service.getBody(request) != null) {
            message = new HttpMessage(service.getUrl(this, request.getParameters()), service.getBody(request));
        } else if (service.getFormParameters(this, request) != null && service.getFormParameters(this, request).size() > 0) {
            message = new HttpMessage(service.getUrl(this, request.getParameters()), service.getFormParameters(this, request));
        } else {
            message = new HttpMessage(service.getUrl(this, request.getParameters()));
        }

        message.setHeaders(headers);

        return message;
    }

    @Override
    protected ConnectorResponse makeConnectorResponse(EndpointResponse endpointResponse, GatewayRequest gatewayRequest) {
        MoVeService service = getService(gatewayRequest.getClass());
        return service.makeResponse((HttpResponse) endpointResponse.getResponse(), (MoveRequest) gatewayRequest.getConnectorRequest());
    }

    private MoVeService getService(Class requestClass) {
        return serviceMappings.get(requestClass);
    }

    public String getMoveOauthClientId() {
        return moveOauthClientId;
    }

    public String getMoveOauthClientSecret() {
        return moveOauthClientSecret;
    }

    public String getMoveScheme() {
        return moveScheme;
    }

    public String getMoveDomain() {
        return moveDomain;
    }

    public String getMoveOauthDomain() {
        return moveOauthDomain;
    }

    public String getMoveOauthContext() {
        return moveOauthContext;
    }

    public String getMoveContext() {
        return moveContext;
    }
}
