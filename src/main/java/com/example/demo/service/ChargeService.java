package com.example.demo.service;

import com.example.demo.model.Charge;
import com.example.demo.repository.ChargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChargeService {

    @Autowired
    private ChargeRepository chargeRepository;

    public List<Charge> getAllChargesByOrgInn(String inn) {
        return chargeRepository.findAllNative(inn);
    }
}
