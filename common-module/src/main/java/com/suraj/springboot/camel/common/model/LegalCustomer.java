package com.suraj.springboot.camel.common.model;

import java.io.Serializable;

public class LegalCustomer extends Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private LegalBaseInfo legalBaseInfo;
	
	public LegalBaseInfo getLegalBaseInfo() {
        return legalBaseInfo;
    }

    public void setLegalBaseInfo(LegalBaseInfo legalBaseInfo) {
        this.legalBaseInfo = legalBaseInfo;
    }

    public LegalCustomer(Long id, Long baseInfoId, Long cifNumber, String customerType, LegalBaseInfo legalBaseInfo) {
        super(id, baseInfoId, cifNumber, customerType);
        this.legalBaseInfo = legalBaseInfo;
    }

    public LegalCustomer() {
    }

    @Override
    public String toString() {
        return "FullLegalCustomer{" +
                "legalBaseInfo=" + legalBaseInfo +
                '}';
    }

}
