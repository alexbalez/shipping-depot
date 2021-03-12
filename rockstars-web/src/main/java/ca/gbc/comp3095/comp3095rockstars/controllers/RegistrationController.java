/** Project: < Comp3095 Rockstars Project >
 * Assignment: < assignment 3 >
 * Author(s): < Nikola Vojinovic, Corradina Dinatale, Noah Huboux, Alex Balez>
 * Student Number: < 101181089, 100645103, 101117858, 101219847>
 * Date: 11/08/2020
 * Description: <Registration controller that sends to login and updates the user repository>*/

package ca.gbc.comp3095.comp3095rockstars.controllers;


import ca.gbc.comp3095.comp3095rockstars.model.RegistrationForm;
import ca.gbc.comp3095.comp3095rockstars.model.User;
import ca.gbc.comp3095.comp3095rockstars.repository.UserRepository;
import ca.gbc.comp3095.comp3095rockstars.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;



@Controller
public class RegistrationController {


    public RegistrationController() {
        super();
    }

    private PasswordEncoder passwordEncoder;

    RegistrationController(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    //autowire user repository
    @Autowired
    private UserRepository userRepository;

    /*@Autowired
    private CaptchaService captchaService;*/

    @Autowired
    private UserService userService;

    @ModelAttribute("registrationForm")
    public RegistrationForm registrationForm() {
        return new RegistrationForm();
    }

    @GetMapping(path= "/registration")
    public String registration(Model model){
        return "registration";
    }

    @PostMapping(path = "/registration")
    public String submitRegistration(@ModelAttribute("registrationForm") @Valid RegistrationForm registrationForm, BindingResult bindingResult, HttpServletRequest request){
        /*String response = request.getParameter("g-recaptcha-response");
        captchaService.processResponse(response);*/


        User existing = userService.findByEmail(registrationForm.getEmail());
        if (existing != null) {
            bindingResult.rejectValue("email", null, "There is already an account registered with that email.");
        }
        if(bindingResult.hasErrors()){
            return "registration";
        }
        else {
            userService.save(registrationForm);
            return "index";
        }
    }
}
