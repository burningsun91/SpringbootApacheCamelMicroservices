package com.suraj.springboot.camel.realbase.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suraj.springboot.camel.realbase.model.RealBaseInfo;
import com.suraj.springboot.camel.realbase.repository.RealBaseInfoRepository;

@Service
public class RealBaseInfoService {
	
	@Autowired
    RealBaseInfoRepository realBaseInfoRepository;

    public List<RealBaseInfo> getAllRealBaseInfos() {
        List<RealBaseInfo> realBaseInfos = new ArrayList<RealBaseInfo>();
        realBaseInfoRepository.findAll().forEach(e -> realBaseInfos.add(e));
        return realBaseInfos;
    }


    public RealBaseInfo getRealBaseInfo(Long realBaseInfoId) {
        Optional<RealBaseInfo> realBaseInfo = realBaseInfoRepository.findById(realBaseInfoId);
        if(realBaseInfo.isPresent()) {
            return realBaseInfo.get();
        } else {
            return new RealBaseInfo(0L, "Unknown", "Unknown");
        }
    }

    public RealBaseInfo saveRealBaseInfo(RealBaseInfo realBaseInfo) {
        return realBaseInfoRepository.save(realBaseInfo);
    }

}
