package edu.eci.arsw.eciwar;

/**
 *
 * @author hcadavid
 */
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    
    @Value("${local.server.port}")
    private int port;
    
    @Value("${local.server.host}")
    private String host;

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        //CloudAmqp
        config.enableStompBrokerRelay("/topic").setRelayHost(host).setRelayPort(port).
                setClientLogin("tkownfax").
                setClientPasscode("UJ4YP9jVSniRrhGMVLdMev0EOY6EphFa").
                setSystemLogin("tkownfax").
                setSystemPasscode("UJ4YP9jVSniRrhGMVLdMev0EOY6EphFa").
                setVirtualHost("tkownfax");
        config.setApplicationDestinationPrefixes("/app");        
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/stompendpoint").setAllowedOrigins("*").withSockJS();
        
    }
    

}
