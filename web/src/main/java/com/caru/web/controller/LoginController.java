package com.caru.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

/**
 * LoginController
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 06. 20.
 */

@Controller
public class LoginController {

	private static String authorizationRequestBaseUri = "oauth2/authorization";
	Map<String, String> oauth2AuthenticationUrls = new HashMap<>();

	@Autowired
	private ClientRegistrationRepository clientRegistrationRepository;

	@Autowired
	private OAuth2AuthorizedClientService authorizedClientService;

	@GetMapping("login")
	public String getLoginPage(Model model) {
		Iterable<ClientRegistration> clientRegistrations = null;
		ResolvableType type = ResolvableType.forInstance(clientRegistrationRepository).as(Iterable.class);

		if (type != ResolvableType.NONE && ClientRegistration.class.isAssignableFrom(type.resolveGenerics()[0])) {
			clientRegistrations = (Iterable<ClientRegistration>)clientRegistrationRepository;
		}

		clientRegistrations.forEach(registration ->
			oauth2AuthenticationUrls.put(registration.getClientName(),
				authorizationRequestBaseUri + "/" + registration.getRegistrationId()));
		model.addAttribute("urls", oauth2AuthenticationUrls);

		return "login";
	}

	@GetMapping("/signup")
	public String socialSignup(Model model, OAuth2AuthenticationToken authentication) {
		OAuth2AuthorizedClient client = authorizedClientService.loadAuthorizedClient(
			authentication.getAuthorizedClientRegistrationId(),
			authentication.getName());

		String userInfoEndpointUri = client.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUri();

		if (!StringUtils.isEmpty(userInfoEndpointUri)) {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + client.getAccessToken().getTokenValue());
			HttpEntity entity = new HttpEntity("", headers);

			ResponseEntity<Map> response = restTemplate.exchange(userInfoEndpointUri, HttpMethod.GET, entity, Map.class);
			Map userAttributes = response.getBody();
			model.addAttribute("name", userAttributes.get("name"));
		}

		return "signup";
	}
}