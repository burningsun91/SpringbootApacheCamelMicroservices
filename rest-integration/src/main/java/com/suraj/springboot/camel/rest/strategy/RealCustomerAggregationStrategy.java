package com.suraj.springboot.camel.rest.strategy;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import com.google.gson.Gson;
import com.suraj.springboot.camel.common.model.Customer;
import com.suraj.springboot.camel.common.model.RealBaseInfo;
import com.suraj.springboot.camel.common.model.RealCustomer;

public class RealCustomerAggregationStrategy implements AggregationStrategy{

	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		Gson gson = new Gson();
		Customer customer = gson.fromJson(oldExchange.getIn().getBody(String.class), Customer.class);
		RealBaseInfo realBaseInfo = gson.fromJson(oldExchange.getIn().getBody(String.class),RealBaseInfo.class);
		RealCustomer realCustomer = new RealCustomer();
		realCustomer.setId(customer.getId());
		realCustomer.setBaseInfoId(customer.getBaseInfoId());
		realCustomer.setCifNumber(customer.getCifNumber());
		realCustomer.setCustomerType(customer.getCustomerType());
		realCustomer.setRealBaseInfo(realBaseInfo);
		newExchange.getOut().setBody(realCustomer);
		return newExchange;
	}

}
