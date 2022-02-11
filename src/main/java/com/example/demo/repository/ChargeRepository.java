package com.example.demo.repository;

import com.example.demo.model.Charge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChargeRepository extends JpaRepository<Charge, Long> {

    @Query(nativeQuery = true, value = "select c from charges_test.organization o join charges_test.charge c on c.organization_id = o.id or c.organization_id in (select ofo.fake_orgs_id from charges_test.organization_fake_orgs ofo where ofo.organization_id = o.id) where o.inn = :orgInn")
    List<Charge> findAllNative(@Param("orgInn") String orgInn);
}
