package org.aws.simplejava.springweblambda;

import org.aws.simplejava.springweblambda.model.Country;
import org.aws.simplejava.springweblambda.model.WorldTime;
import org.springframework.web.client.RestTemplate;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 * International Time Handler AWS Lambda Function
 *
 */
public class InternationalTimeHandler implements RequestHandler<Country, WorldTime> {

	private final RestTemplate restTemplate;

	public InternationalTimeHandler() {
		this.restTemplate = new RestTemplate();
	}

	public WorldTime handleRequest(Country country, Context context) {
		return restTemplate.getForObject("http://worldtimeapi.org/api/timezone/Europe/{country}",
				WorldTime.class, country.getCountry());
	}
}