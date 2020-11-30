package com.example.joseph.springmicroservicejoseph.repository;

import com.example.joseph.springmicroservicejoseph.model.Purchase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, Long> {
}
