package com.springcloud.purchaseservice.repository;

import com.springcloud.purchaseservice.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase,Long> {
}
