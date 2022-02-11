package com.example.demo.service;

import com.example.demo.model.Organization;
import com.example.demo.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    public Organization getOrganizationByInn(String inn) {
        return organizationRepository.findAllByInn(inn);
    }

    public List<Organization> getAllOrganization() {
        return organizationRepository.findAll();
    }
}
