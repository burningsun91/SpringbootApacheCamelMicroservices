package com.suraj.springboot.camel.legalbase.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.suraj.springboot.camel.legalbase.model.LegalBaseInfo;

@Repository
public interface LegalBaseInfoRepository extends CrudRepository<LegalBaseInfo,Long>{

}
