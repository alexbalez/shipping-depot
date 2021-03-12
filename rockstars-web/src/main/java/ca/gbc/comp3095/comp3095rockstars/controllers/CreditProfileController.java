package ca.gbc.comp3095.comp3095rockstars.controllers;

import ca.gbc.comp3095.comp3095rockstars.model.CreditCardForm;
import ca.gbc.comp3095.comp3095rockstars.model.CreditProfile;
import ca.gbc.comp3095.comp3095rockstars.model.User;
import ca.gbc.comp3095.comp3095rockstars.repository.CreditProfileRepository;
import ca.gbc.comp3095.comp3095rockstars.security.UserPrincipal;
import ca.gbc.comp3095.comp3095rockstars.services.CreditProfileService;
import ca.gbc.comp3095.comp3095rockstars.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class CreditProfileController {

    public CreditProfileController() {
        super();
    }

    @Autowired
    private CreditProfileRepository creditProfileRepository;

    @Autowired
    private CreditProfileService creditProfileService;

    @ModelAttribute("creditCardForm")
    public CreditCardForm CreditCardForm() {
        return new CreditCardForm();
    }

    @GetMapping("delete/{id}")
    public String deleteCreditProfile(@PathVariable("id") long id, Model model) {
        creditProfileService.deleteById(id);
        return "users/creditProfileList";
    }

    @GetMapping({"creditProfileList", "creditProfileList.html"})
    public String creditProfileList(Model model){
        model.addAttribute("creditProfiles", creditProfileService.findAll());
        return "users/creditProfileList";
    }

    @GetMapping(path= "/creditProfile")
    public String creditProfile(Model model){
        return "users/creditProfile";
    }

    @PostMapping(path = "/creditProfile")
    public String submitCreditCard(@ModelAttribute("creditCardForm") @Valid CreditCardForm creditCardForm, BindingResult bindingResult,
                                   @AuthenticationPrincipal UserPrincipal user, Model model){

       // creditCardForm.setUser(user.getUser());

        CreditProfile existing = creditProfileService.findByCardNumber(creditCardForm.getCardNumber());
        if (existing != null) {
            bindingResult.rejectValue("cardNumber", null, "There is already a credit profile with that credit card number.");
        }
        if (!bindingResult.hasErrors()) {
            creditProfileService.save(creditCardForm);
        }
        return "redirect:creditProfileList";
    }
}


