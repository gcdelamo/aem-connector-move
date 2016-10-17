package com.adeo.connector.move.gateway;


import com.adeo.connector.move.LoginRequest;
import com.adeo.connector.move.gateway.com.adeo.connector.move.services.LoginService;
import com.adeo.connector.move.gateway.com.adeo.connector.move.services.SearchUserService;
import com.adobe.connector.gateways.connection.http.HttpEndpointConnector;
import com.adobe.connector.gateways.connection.http.OkHttpEndpointClient;
import com.adobe.connector.services.OrchestratorService;
import com.adobe.connector.services.impl.DefaultExecutionPlanBuilder;
import com.adobe.connector.services.impl.DefaultOrchestratorService;
import com.adobe.connector.services.impl.ExecutionPlanFactoryImpl;
import com.google.common.collect.ImmutableMap;
import org.apache.sling.testing.mock.osgi.junit.OsgiContext;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {

    @Rule
    public final OsgiContext context = new OsgiContext();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private OrchestratorService orchestratorService = new DefaultOrchestratorService();

    @Before
    public void setUp() throws Exception {

        context.registerInjectActivateService(new OkHttpEndpointClient());
        context.registerInjectActivateService(new HttpEndpointConnector());
        context.registerInjectActivateService(new DefaultExecutionPlanBuilder());
        context.registerInjectActivateService(new LoginService());
        context.registerInjectActivateService(new SearchUserService());

        context.registerInjectActivateService(new MoveGateway(), ImmutableMap.<String, Object>builder()
                .put(MoveGateway.GATEWAY_NAME, "moveGateway").build());

        context.registerInjectActivateService(new ExecutionPlanFactoryImpl(), ImmutableMap.<String, Object>builder()
                .put("gateway.name", "moveGateway")
                .put("request", "com.adeo.connector.move.gateway.MoveRequest")
                .build());

        context.registerInjectActivateService(orchestratorService);


    }

    @Test
    public void testResolver() {
        LoginRequest login = new LoginRequest();
        OrchestratorService orchestratorService = context.getService(OrchestratorService.class);
        orchestratorService.execute(login);
    }


}
