package com.my.wilson.controller;

import com.my.wilson.model.ApiModel;
import com.my.wilson.model.CreditCard;
import com.my.wilson.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/credit-cards")
public class CreditCardController {

    @Autowired
    CreditCardService creditCardService;

    @PostMapping
    public ResponseEntity<Object> addCreditCard(@RequestBody CreditCard creditCard) {
        ApiModel apiModel = creditCardService.validateCreditCard(creditCard);
        return apiModel.getDesc() != null ?
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiModel) : ResponseEntity.ok(null);
    }
}
