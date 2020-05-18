package com.suraj.springboot.camel.common.model;

import java.io.Serializable;

public class RealCustomer extends Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private RealBaseInfo realBaseInfo;
	
	public RealBaseInfo getRealBaseInfo() {
        return realBaseInfo;
    }

    public void setRealBaseInfo(RealBaseInfo realBaseInfo) {
        this.realBaseInfo = realBaseInfo;
    }

    public RealCustomer(Long id, Long baseInfoId, Long cifNumber, String customerType, RealBaseInfo realBaseInfo) {
        super(id, baseInfoId, cifNumber, customerType);
        this.realBaseInfo = realBaseInfo;
    }

    public RealCustomer() {
    }

    @Override
    public String toString() {
        return "FullRealCustomer{" +
                "realBaseInfo=" + realBaseInfo +
                '}';
    }

}
