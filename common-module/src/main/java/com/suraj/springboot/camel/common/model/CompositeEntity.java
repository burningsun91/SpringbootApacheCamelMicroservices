package com.suraj.springboot.camel.common.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CompositeEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<Customer> customers;
    List<RealBaseInfo> realBaseInfos;
    List<LegalBaseInfo> legalBaseInfos;

    public CompositeEntity() {
        customers = new ArrayList<>();
        realBaseInfos = new ArrayList<>();
        legalBaseInfos = new ArrayList<>();
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<RealBaseInfo> getRealBaseInfos() {
        return realBaseInfos;
    }

    public void setRealBaseInfos(List<RealBaseInfo> realBaseInfos) {
        this.realBaseInfos = realBaseInfos;
    }

    public List<LegalBaseInfo> getLegalBaseInfos() {
        return legalBaseInfos;
    }

    public void setLegalBaseInfos(List<LegalBaseInfo> legalBaseInfos) {
        this.legalBaseInfos = legalBaseInfos;
    }

}
