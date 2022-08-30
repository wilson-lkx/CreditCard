package com.my.wilson.service;

import com.my.wilson.model.ApiModel;
import com.my.wilson.model.CreditCard;
import org.springframework.stereotype.Service;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    @Override
    public ApiModel validateCreditCard(CreditCard creditCard) {
        ApiModel apiModel = new ApiModel();
        String strCardNumber = creditCard.getCardNumber();
        if (strCardNumber != null) {
            if (!strCardNumber.isEmpty()) {
                if (strCardNumber.length() != 16) {
                    apiModel.setDesc("Card number must contain exactly 16 digits!");
                } else {
                    if (!strCardNumber.matches("\\d+")) {
                        apiModel.setDesc("Card number must only consist of digits (0-9)!");
                    } else {
                        boolean hasRepeatedDigit = false;
                        for (int i = 0; i <= strCardNumber.length() - 4 && !hasRepeatedDigit; i++) {
                            String newString = strCardNumber.substring(i, i + 4);
                            hasRepeatedDigit = (newString.charAt(0) == newString.charAt(1)) && (newString.charAt(0) == newString.charAt(2)) && (newString.charAt(0) == newString.charAt(3));
                        }
                        if (hasRepeatedDigit) {
                            apiModel.setDesc("Card number must NOT have 4 or more consecutive repeated digits!");
                        }
                    }
                }
            } else {
                apiModel.setDesc("Card number cannot be empty!");
            }
        } else {
            apiModel.setDesc("Card number is missing!");
        }
        return apiModel;
    }
}
