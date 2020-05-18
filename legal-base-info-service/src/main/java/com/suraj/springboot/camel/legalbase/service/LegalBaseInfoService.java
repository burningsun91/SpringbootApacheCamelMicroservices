package com.suraj.springboot.camel.legalbase.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suraj.springboot.camel.legalbase.model.LegalBaseInfo;
import com.suraj.springboot.camel.legalbase.repository.LegalBaseInfoRepository;

@Service
public class LegalBaseInfoService {
	
	@Autowired
	private LegalBaseInfoRepository legalBaseInfoRepository;
	
	public List<LegalBaseInfo> getAllLegalBaseInfos() {
        List<LegalBaseInfo> legalBaseInfos = new ArrayList<LegalBaseInfo>();
        legalBaseInfoRepository.findAll().forEach(e -> legalBaseInfos.add(e));
        return legalBaseInfos;
    }


    public LegalBaseInfo getLegalBaseInfo(Long legalBaseInfoId) {
        Optional<LegalBaseInfo> legalBaseInfo = legalBaseInfoRepository.findById(legalBaseInfoId);
        if(legalBaseInfo.isPresent()) {
            return legalBaseInfo.get();
        } else {
            return new LegalBaseInfo(0L, "Unknown", "Unknown", "Unknown");
        }
    }

    public LegalBaseInfo saveLegalBaseInfo(LegalBaseInfo legalBaseInfo) {
        return legalBaseInfoRepository.save(legalBaseInfo);
    }

}
