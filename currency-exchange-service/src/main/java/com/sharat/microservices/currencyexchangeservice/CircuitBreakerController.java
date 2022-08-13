package com.sharat.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.bulkhead.annotation.Bulkhead.Type;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {

	private static final Logger LOG = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	private int count = 0;

	@GetMapping("/retry-api")
	@Retry(name = "retry-api", fallbackMethod = "hardcodedRetryAPIResponse")
	public String retryAPI() {
		LOG.info("inside retryAPI");
		ResponseEntity<String> entity = new RestTemplate().getForEntity("http://localhost:8081", String.class);
		return entity.getBody();
	}

	public String hardcodedRetryAPIResponse(Throwable e) {
		LOG.info("inside hardcodedRetryAPIResponse");
		return "SampleRetry fallback response.";
	}

	@GetMapping("/circuit-breaker-api")
	@CircuitBreaker(name = "default", fallbackMethod = "hardcodedCircuitBreakerAPIResponse")
	public String circuitBreakerAPI() {
		LOG.info("inside circuitBreakerAPI");
		ResponseEntity<String> entity = new RestTemplate().getForEntity("http://localhost:8081", String.class);
		return entity.getBody();
	}

	public String hardcodedCircuitBreakerAPIResponse(Throwable e) {
		LOG.info("inside hardcodedCircuitBreakerAPIResponse");
		return "SampleCircuitBreaker fallback response.";
	}

	@GetMapping("/rate-limiter-api")
	@RateLimiter(name = "default")
	public String rateLimiterAPI() {
		LOG.info("inside rateLimiterAPI");
		return "Rate Limiter API response.";
	}

	@GetMapping("/bulk-head-api")
	@Bulkhead(name = "default")
	public String bulkHeadAPI() {
		LOG.info("inside bulkHeadAPI");
		return "Bulk Head API response.";
	}

	@GetMapping("/resilience-api")
	@Retry(name = "resilience-api", fallbackMethod = "hardcodedRetryResilienceAPIResponse")
//	@CircuitBreaker(name = "resilience-api", fallbackMethod = "hardcodedCircuitBreakerResilienceAPIResponse")
	@RateLimiter(name = "resilience-api", fallbackMethod = "hardcodedRateLimiterResilienceAPIResponse")
	@Bulkhead(name = "resilience-api", fallbackMethod = "hardcodedBukheadResilienceAPIResponse", type = Type.SEMAPHORE)
	public String resilienceAPI() {
		LOG.info("inside resilienceAPI");
		int i = (int) Math.round(Math.random() * 100) % 3;
		if (count > 20 && i != 0) {
			ResponseEntity<String> entity = new RestTemplate().getForEntity("http://localhost:8081", String.class);
			return entity.getBody();
		} else {
			count++;
			return "normal resilience response";
		}
	}
	
	public String hardcodedRetryResilienceAPIResponse(Exception e) {
		LOG.info("inside hardcodedRetryResilienceAPIResponse");
		return "Resilience retry fallback response.";
	}

	public String hardcodedCircuitBreakerResilienceAPIResponse(Exception e) {
		LOG.info("inside hardcodedCircuitBreakerResilienceAPIResponse");
		return "Resilience circuit breaker fallback response.";
	}
	
	public String hardcodedRateLimiterResilienceAPIResponse(RequestNotPermitted exception) {
		LOG.info("inside hardcodedRateLimiterResilienceAPIResponse");
		return "Resilience rate limiter fallback response.";
	}
	
	public String hardcodedBukheadResilienceAPIResponse(RequestNotPermitted exception) {
		LOG.info("inside hardcodedBukheadResilienceAPIResponse");
		return "Resilience rate limiter fallback response.";
	}

}
