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
                setClientLogin("yqbofqdf").
                setClientPasscode("6CMzc5eiNjOdlv9cP9HpqFmHLK3KxUNS").
                setSystemLogin("yqbofqdf").
                setSystemPasscode("6CMzc5eiNjOdlv9cP9HpqFmHLK3KxUNS").
                setVirtualHost("yqbofqdf");
        config.setApplicationDestinationPrefixes("/app");        
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/stompendpoint").setAllowedOrigins("*").withSockJS();
        
    }
    

}
