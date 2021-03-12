package ca.gbc.comp3095.comp3095rockstars.services;

import ca.gbc.comp3095.comp3095rockstars.model.CreditCardForm;
import ca.gbc.comp3095.comp3095rockstars.model.CreditProfile;


public interface CreditProfileService extends CrudService<CreditProfile, Long>{
    CreditProfile findByCardNumber(Long cardNumber);

    CreditProfile save(CreditCardForm creditProfile);
}
