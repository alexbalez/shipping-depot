package ca.gbc.comp3095.comp3095rockstars.services;

import ca.gbc.comp3095.comp3095rockstars.model.CreditCardForm;
import ca.gbc.comp3095.comp3095rockstars.model.CreditProfile;
import ca.gbc.comp3095.comp3095rockstars.model.User;
import ca.gbc.comp3095.comp3095rockstars.repository.CreditProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CreditProfileServiceImpl implements CreditProfileService{

    @Autowired
    private CreditProfileRepository creditProfileRepository;

    @Override
    public CreditProfile findByCardNumber(Long cardNumber) {
        return creditProfileRepository.findByCardNumber(cardNumber);
    }

    public CreditProfile save(CreditCardForm creditProfileInfo) {
        CreditProfile creditProfile = new CreditProfile();
        creditProfile.setType(creditProfileInfo.getType());
        creditProfile.setExpiry(creditProfileInfo.getExpiry());
        creditProfile.setCardHolder(creditProfileInfo.getCardHolder());
        creditProfile.setCardNumber(creditProfileInfo.getCardNumber());
        creditProfile.setDefaultCreditCard(creditProfileInfo.getDefaultCreditCard());
        creditProfile.setDateCardCreated();
        creditProfile.setUser(creditProfileInfo.getUser());
        return creditProfileRepository.save(creditProfile);
    }

    @Override
    public Set<CreditProfile> findAll() {

        return new HashSet<>(creditProfileRepository.findAll());

    }

    @Override
    public CreditProfile findById(Long aLong) {

        return creditProfileRepository.findById(aLong).orElse(null);
    }

    @Override
    public void delete(CreditProfile object) {
        creditProfileRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        creditProfileRepository.deleteById(aLong);
    }
}
