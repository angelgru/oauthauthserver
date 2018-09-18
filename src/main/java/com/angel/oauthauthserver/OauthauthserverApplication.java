package com.angel.oauthauthserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class OauthauthserverApplication {

	private Logger logger = LoggerFactory.getLogger(OauthauthserverApplication.class);

	@RequestMapping(value = { "/user" }, produces = "application/json")
	public Map<String, Object> user(OAuth2Authentication user) {
		Map<String, Object> userInfo = new HashMap<>();
		userInfo.put("user", user.getUserAuthentication().getPrincipal());
		userInfo.put("authorities", AuthorityUtils.authorityListToSet(user.getUserAuthentication().getAuthorities()));
		logger.error("OAuth 2 server logs generated manually");
		return userInfo;
	}


	public static void main(String[] args) {
		SpringApplication.run(OauthauthserverApplication.class, args);
	}
}
