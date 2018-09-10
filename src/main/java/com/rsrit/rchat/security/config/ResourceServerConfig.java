package com.rsrit.rchat.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	private JwtTokenStore tokenStore;

	public ResourceServerConfig(JwtTokenStore tokenStore) {
		this.tokenStore = tokenStore;
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
		.headers().frameOptions().sameOrigin()
		.and()
		.authorizeRequests()
		.antMatchers("/rchat/api/user/**")
		.permitAll()
		.antMatchers("/h2/*")
		.permitAll()
		.antMatchers("/stomp/**")
		.authenticated()
		.anyRequest()
		.authenticated()
		.and()
		//.csrf().disable();
		.csrf().ignoringAntMatchers("/h2/*","/rchat/api/user/**");
		super.configure(http);
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore);
		super.configure(resources);
	}

}
