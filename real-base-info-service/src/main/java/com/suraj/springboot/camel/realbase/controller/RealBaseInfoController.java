package com.suraj.springboot.camel.realbase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suraj.springboot.camel.realbase.model.RealBaseInfo;
import com.suraj.springboot.camel.realbase.service.RealBaseInfoService;

@RestController
@RequestMapping("/realbaseinfos")
public class RealBaseInfoController {
	
	@Autowired
    RealBaseInfoService realBaseInfoService;
	
	@GetMapping("")
    public ResponseEntity<List<RealBaseInfo>> getAllRealBaseInfos() {
        return ResponseEntity.ok(realBaseInfoService.getAllRealBaseInfos());
    }

    @GetMapping("/id/{rbiid}")
    public ResponseEntity<RealBaseInfo> getRealBaseInfo(@PathVariable("rbiid") Long realBaseInfoId) {
        return ResponseEntity.ok(realBaseInfoService.getRealBaseInfo(realBaseInfoId));
    }

    @GetMapping("/id")
    public ResponseEntity<RealBaseInfo> getRealBaseInfoByRequestParam(@RequestParam("rbiid") Long realBbaseInfoId) {
        return ResponseEntity.ok(realBaseInfoService.getRealBaseInfo(realBbaseInfoId));
    }

}
