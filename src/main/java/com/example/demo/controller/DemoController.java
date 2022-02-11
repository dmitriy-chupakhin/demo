package com.example.demo.controller;

import com.example.demo.model.Charge;
import com.example.demo.model.Organization;
import com.example.demo.service.ChargeService;
import com.example.demo.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private ChargeService chargeService;

    @GetMapping("/")
    public String getIndex() {
        return "Hello";
    }

    @GetMapping("/get-organization/{inn}")
    public Organization getOrganizationByInn(@PathVariable String inn) {
        return organizationService.getOrganizationByInn(inn);
    }

    @GetMapping(value = "/get-charges/{inn}")
    public ResponseEntity<List<Charge>> getAllChargesByOrgInn(@PathVariable String inn) {
        return ResponseEntity.ok(chargeService.getAllChargesByOrgInn(inn));
    }

    @GetMapping("/get-organization")
    public List<Organization> getAllOrganization() {
        return organizationService.getAllOrganization();
    }
}
