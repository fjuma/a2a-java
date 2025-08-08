package io.a2a.client.transport.grpc;

import java.util.List;

import io.a2a.client.config.ClientCallInterceptor;
import io.a2a.client.config.ClientConfig;
<<<<<<< HEAD:client/transport/grpc/src/main/java/io/a2a/client/transport/grpc/GrpcTransportProvider.java
import io.a2a.client.config.ClientTransportConfig;
import io.a2a.client.transport.spi.ClientTransport;
import io.a2a.client.transport.spi.ClientTransportProvider;
import io.a2a.spec.A2AClientException;
import io.a2a.spec.AgentCard;
import io.a2a.spec.TransportProtocol;
import io.grpc.Channel;
=======
import io.a2a.client.transport.spi.ClientTransport;
import io.a2a.client.transport.spi.ClientTransportProvider;
import io.a2a.spec.AgentCard;
import io.a2a.spec.TransportProtocol;
>>>>>>> 5955029 (feat: Update the ClientTransport interface, introducing ClientCallContext, ClientConfig, and ClientCallInterceptor similar to the Python SDK. Introduce a ClientTransportProvider and update the JSONRPC and gRPC transport implementations. Introduce a new Client and ClientFactory implementations.):client-transport/grpc/src/main/java/io/a2a/client/transport/grpc/GrpcTransportProvider.java

/**
 * Provider for gRPC transport implementation.
 */
public class GrpcTransportProvider implements ClientTransportProvider {

    @Override
    public ClientTransport create(ClientConfig clientConfig, AgentCard agentCard,
<<<<<<< HEAD:client/transport/grpc/src/main/java/io/a2a/client/transport/grpc/GrpcTransportProvider.java
                                  String agentUrl, List<ClientCallInterceptor> interceptors) throws A2AClientException {
        // not making use of the interceptors for gRPC for now
        List<ClientTransportConfig> clientTransportConfigs = clientConfig.getClientTransportConfigs();
        if (clientTransportConfigs != null) {
            for (ClientTransportConfig clientTransportConfig : clientTransportConfigs) {
                if (clientTransportConfig instanceof GrpcTransportConfig grpcTransportConfig) {
                    Channel channel = grpcTransportConfig.getChannelFactory().apply(agentUrl);
                    return new GrpcTransport(channel, agentCard);
                }
            }
        }
        throw new A2AClientException("Missing required GrpcTransportConfig");
=======
                                  String agentUrl, List<ClientCallInterceptor> interceptors) {
        // not making use of the interceptors for gRPC for now
        return new GrpcTransport(clientConfig.getChannel(), agentCard);
>>>>>>> 5955029 (feat: Update the ClientTransport interface, introducing ClientCallContext, ClientConfig, and ClientCallInterceptor similar to the Python SDK. Introduce a ClientTransportProvider and update the JSONRPC and gRPC transport implementations. Introduce a new Client and ClientFactory implementations.):client-transport/grpc/src/main/java/io/a2a/client/transport/grpc/GrpcTransportProvider.java
    }

    @Override
    public String getTransportProtocol() {
        return TransportProtocol.GRPC.asString();
    }

}
