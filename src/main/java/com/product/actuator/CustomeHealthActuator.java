package com.product.actuator;

import java.util.Random;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.stereotype.Component;

@Component
public class CustomeHealthActuator extends AbstractHealthIndicator{

	@Override
	protected void doHealthCheck(Builder builder) throws Exception {
		Random random =new Random();
		int randomValue = random.nextInt(100);
		if(randomValue%2 == 0) {
			builder.down();
		}else {
			builder.up();
		}
		
	}

}
