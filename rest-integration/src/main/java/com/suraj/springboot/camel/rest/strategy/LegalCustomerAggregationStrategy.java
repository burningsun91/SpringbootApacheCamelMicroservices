package com.suraj.springboot.camel.rest.strategy;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import com.google.gson.Gson;
import com.suraj.springboot.camel.common.model.Customer;
import com.suraj.springboot.camel.common.model.LegalBaseInfo;
import com.suraj.springboot.camel.common.model.LegalCustomer;


public class LegalCustomerAggregationStrategy implements AggregationStrategy{

	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		Gson gson = new Gson();
		Customer customer = gson.fromJson(oldExchange.getIn().getBody(String.class), Customer.class);
		LegalBaseInfo legalBaseInfo = gson.fromJson(oldExchange.getIn().getBody(String.class), LegalBaseInfo.class);
		LegalCustomer legalCustomer = new LegalCustomer();
		legalCustomer.setId(customer.getId());
		legalCustomer.setBaseInfoId(customer.getBaseInfoId());
		legalCustomer.setCustomerType(customer.getCustomerType());
		legalCustomer.setCifNumber(customer.getCifNumber());
		legalCustomer.setLegalBaseInfo(legalBaseInfo);
		newExchange.getOut().setBody(gson.toJson(legalCustomer));
		return newExchange;
	}

}
