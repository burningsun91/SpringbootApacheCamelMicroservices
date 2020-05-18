package com.suraj.springboot.camel.rest.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class HeaderProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		
	}

}
