package com.suraj.springboot.camel.legalbase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suraj.springboot.camel.legalbase.model.LegalBaseInfo;
import com.suraj.springboot.camel.legalbase.service.LegalBaseInfoService;

@RestController
@RequestMapping("/legalbaseinfos")
public class LegalBaseInfoController {
	
	@Autowired
	private LegalBaseInfoService legalBaseInfoService;
	
	@GetMapping("")
    public ResponseEntity<List<LegalBaseInfo>> getAllLegalBaseInfos() {
        return ResponseEntity.ok(legalBaseInfoService.getAllLegalBaseInfos());
    }

    @GetMapping("/id/{lbiid}")
    public ResponseEntity<LegalBaseInfo> getLegalBaseInfo(@PathVariable("lbiid") Long legalBaseInfoId) {
        return ResponseEntity.ok(legalBaseInfoService.getLegalBaseInfo(legalBaseInfoId));
    }

    @GetMapping("/id")
    public ResponseEntity<LegalBaseInfo> getLegalBaseInfoByRequestParam(@RequestParam("lbiid") Long legalBaseInfoId) {
        return ResponseEntity.ok(legalBaseInfoService.getLegalBaseInfo(legalBaseInfoId));
    }

}
