package com.rsrit.rchat.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	private JwtAccessTokenConverter jwtAccessTokenConverter;

	private UserDetailsService userDetailsService;

	private BCryptPasswordEncoder passwordEncoder;
	
	private final AuthenticationManager authenticationManager;

	public AuthorizationServerConfig(JwtAccessTokenConverter jwtAccessTokenConverter,
			UserDetailsService userDetailsService, BCryptPasswordEncoder passwordEncoder,AuthenticationManager authenticationManager) {
		super();
		this.jwtAccessTokenConverter = jwtAccessTokenConverter;
		this.userDetailsService = userDetailsService;
		this.passwordEncoder = passwordEncoder;
		this.authenticationManager = authenticationManager;
	}

	@Bean
	public JwtTokenStore jwtTokenStore() {
		JwtTokenStore tokenStore = new JwtTokenStore(jwtAccessTokenConverter);
		return tokenStore;
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.accessTokenConverter(jwtAccessTokenConverter).tokenStore(jwtTokenStore())
				.userDetailsService(userDetailsService)
				.authenticationManager(authenticationManager);
		super.configure(endpoints);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
		.withClient("client")
		.secret(passwordEncoder.encode("secret"))
		.authorizedGrantTypes("password","refresh_token")
		.scopes("read","write");
		super.configure(clients);
	}

}
