package com.suraj.springboot.camel.realbase.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.suraj.springboot.camel.realbase.model.RealBaseInfo;

@Repository
public interface RealBaseInfoRepository extends CrudRepository<RealBaseInfo, Long>{

}
