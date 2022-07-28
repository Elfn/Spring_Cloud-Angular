package com.springcloud.purchaseservice.services;

import com.springcloud.purchaseservice.model.Purchase;

public interface PurchaseService {
    Purchase savePurchase(Purchase purchase);
}
