package com.suraj.springboot.camel.rest.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.suraj.springboot.camel.rest.model.ResourceType;
import com.suraj.springboot.camel.rest.processor.HeaderProcessor;
import com.suraj.springboot.camel.rest.strategy.AllAggregationStrategy;
import com.suraj.springboot.camel.rest.strategy.LegalCustomerAggregationStrategy;
import com.suraj.springboot.camel.rest.strategy.RealCustomerAggregationStrategy;

@Component
public class RestRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("jetty:http://localhost:8089/customerBaseInfos").removeHeaders("CamelHttp*")
				.setHeader(Exchange.HTTP_METHOD, constant("GET"))
				.toD("jetty:http://localhost:8085/customer/id/${header[cid]}").process(new HeaderProcessor()).choice()
				.when(header("type").isEqualTo("REAL")).to("direct:realcustomer")
				.when(header("type").isEqualTo("LEGAL")).to("direct:legalcustomer").otherwise().end();

		from("direct:realcustomer").removeHeaders("CamelHttp*").setHeader(Exchange.HTTP_METHOD, constant("GET"))
				.enrich().simple("jetty:http://localhost:8086/realbaseinfos/id/${header[rbiid]}")
				.aggregationStrategy(new RealCustomerAggregationStrategy())
				.setHeader(Exchange.CONTENT_TYPE, simple("application/json"))
				.setHeader(Exchange.CHARSET_NAME, simple("utf-8"));

		from("direct:legalcustomer").removeHeaders("CamelHttp*").setHeader(Exchange.HTTP_METHOD, constant("GET"))
				.enrich().simple("jetty:http://localhost:8087/legalbaseinfos/id/${header[lbiid]}")
				.aggregationStrategy(new LegalCustomerAggregationStrategy())
				.setHeader(Exchange.CONTENT_TYPE, simple("application/json"))
				.setHeader(Exchange.CHARSET_NAME, simple("utf-8"));

		from("jetty:http://localhost:8089/all").setHeader(Exchange.CONTENT_TYPE, simple("application/json"))
				.setHeader(Exchange.CHARSET_NAME, simple("utf-8")).multicast(new AllAggregationStrategy())
				.parallelProcessing().timeout(500).to("direct:a", "direct:b", "direct:c");
		from("direct:a").setHeader(Exchange.HTTP_URI, simple("http://localhost:8085/customers"))
				.setHeader("RESOURCE_TYPE", constant(ResourceType.CUSTOMERS))
				.to("jetty:http://localhost:8085/customers");
		from("direct:b").setHeader(Exchange.HTTP_URI, simple("http://localhost:8086/realbaseinfos"))
				.setHeader("RESOURCE_TYPE", constant(ResourceType.REAL_BASE_INFOS))
				.to("jetty:http://localhost:8086/realbaseinfos");
		from("direct:c").setHeader(Exchange.HTTP_URI, simple("http://localhost:8087/legalbaseinfos"))
				.setHeader("RESOURCE_TYPE", constant(ResourceType.LEGAL_BASE_INFOS))
				.to("jetty:http://localhost:8087/legalbaseinfos");

	}

}
