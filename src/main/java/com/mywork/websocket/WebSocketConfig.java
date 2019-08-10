package com.mywork.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
	
	@Bean
	public ServletServerContainerFactoryBean createWebSocketContainer() {
	    ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
	    container.setMaxBinaryMessageBufferSize(1024000);
	    container.setAsyncSendTimeout(60000L);
	    container.setMaxSessionIdleTimeout((long) (5*60*1000));
	    return container;
	}

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
	    registry.addHandler(new SocketHandler(), "/socket").setAllowedOrigins("*");
	}

}