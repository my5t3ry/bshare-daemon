package de.my5t3ry.bshare_daemon.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.server.standard.TomcatRequestUpgradeStrategy;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

/**
 * created by: saschabast
 * since: 19/05/16
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
        
    @Override
    public void configureMessageBroker(final MessageBrokerRegistry config) {
        final ThreadPoolTaskScheduler te = new ThreadPoolTaskScheduler();
        te.setPoolSize(1);
        te.setThreadNamePrefix("wss-heartbeat-thread-");
        te.initialize();
        config.enableSimpleBroker("/socket")
                .setHeartbeatValue(new long[]{25000, 25000})
                .setTaskScheduler(te);
        config.setApplicationDestinationPrefixes("/send");
    }

    @Override
    public void registerStompEndpoints(final StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint("/connector")
                .setAllowedOrigins("*")
                .setHandshakeHandler(new DefaultHandshakeHandler(new TomcatRequestUpgradeStrategy()))
                .withSockJS();
    }


}
