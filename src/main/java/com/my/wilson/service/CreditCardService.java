package com.my.wilson.service;

import com.my.wilson.model.ApiModel;
import com.my.wilson.model.CreditCard;

public interface CreditCardService {

    ApiModel validateCreditCard(CreditCard creditCard);
}
