package io.a2a.client.transport.jsonrpc;

import java.util.List;

import io.a2a.client.config.ClientCallInterceptor;
import io.a2a.client.config.ClientConfig;
<<<<<<< HEAD:client/transport/jsonrpc/src/main/java/io/a2a/client/transport/jsonrpc/JSONRPCTransportProvider.java
import io.a2a.client.config.ClientTransportConfig;
import io.a2a.client.http.A2AHttpClient;
import io.a2a.client.transport.spi.ClientTransport;
import io.a2a.client.transport.spi.ClientTransportProvider;
import io.a2a.spec.A2AClientException;
=======
import io.a2a.client.transport.spi.ClientTransport;
import io.a2a.client.transport.spi.ClientTransportProvider;
>>>>>>> 5955029 (feat: Update the ClientTransport interface, introducing ClientCallContext, ClientConfig, and ClientCallInterceptor similar to the Python SDK. Introduce a ClientTransportProvider and update the JSONRPC and gRPC transport implementations. Introduce a new Client and ClientFactory implementations.):client-transport/jsonrpc/src/main/java/io/a2a/client/transport/jsonrpc/JSONRPCTransportProvider.java
import io.a2a.spec.AgentCard;
import io.a2a.spec.TransportProtocol;

public class JSONRPCTransportProvider implements ClientTransportProvider {

    @Override
    public ClientTransport create(ClientConfig clientConfig, AgentCard agentCard,
<<<<<<< HEAD:client/transport/jsonrpc/src/main/java/io/a2a/client/transport/jsonrpc/JSONRPCTransportProvider.java
                                  String agentUrl, List<ClientCallInterceptor> interceptors) throws A2AClientException {
        A2AHttpClient httpClient = null;
        List<ClientTransportConfig> clientTransportConfigs = clientConfig.getClientTransportConfigs();
        if (clientTransportConfigs != null) {
            for (ClientTransportConfig clientTransportConfig : clientTransportConfigs) {
                if (clientTransportConfig instanceof JSONRPCTransportConfig jsonrpcTransportConfig) {
                    httpClient = jsonrpcTransportConfig.getHttpClient();
                    break;
                }
            }
        }
        return new JSONRPCTransport(httpClient, agentCard, agentUrl, interceptors);
=======
                                  String agentUrl, List<ClientCallInterceptor> interceptors) {
        return new JSONRPCTransport(clientConfig.getHttpClient(), agentCard, agentUrl, interceptors);
>>>>>>> 5955029 (feat: Update the ClientTransport interface, introducing ClientCallContext, ClientConfig, and ClientCallInterceptor similar to the Python SDK. Introduce a ClientTransportProvider and update the JSONRPC and gRPC transport implementations. Introduce a new Client and ClientFactory implementations.):client-transport/jsonrpc/src/main/java/io/a2a/client/transport/jsonrpc/JSONRPCTransportProvider.java
    }

    @Override
    public String getTransportProtocol() {
        return TransportProtocol.JSONRPC.asString();
    }
}
