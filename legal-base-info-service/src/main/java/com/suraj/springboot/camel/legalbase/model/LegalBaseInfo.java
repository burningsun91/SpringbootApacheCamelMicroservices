package com.suraj.springboot.camel.legalbase.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "LEGAL_BASE_INFO")
public class LegalBaseInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "organization_name")
    private String organizationName;

	@Column(name = "address")
    private String address;

	@Column(name = "organization_code")
    private String organizationCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    @Override
    public String toString() {
        return "LegalBaseInfo{" +
                "id=" + id +
                ", organizationName='" + organizationName + '\'' +
                ", address='" + address + '\'' +
                ", organizationCode='" + organizationCode + '\'' +
                '}';
    }

    public LegalBaseInfo(Long id, String organizationName, String address, String organizationCode) {
        this.id = id;
        this.organizationName = organizationName;
        this.address = address;
        this.organizationCode = organizationCode;
    }

    public LegalBaseInfo() {
    }

}
