package com.springcloud.purchaseservice.controllers;

import com.springcloud.purchaseservice.model.Purchase;
import com.springcloud.purchaseservice.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private final PurchaseService service;

    public PurchaseController(PurchaseService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<Purchase> savePurchase(@RequestBody Purchase purchase){
       return new ResponseEntity<Purchase>(service.savePurchase(purchase), HttpStatus.OK);
    }

}
