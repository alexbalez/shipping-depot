/** Project: < Comp3095 Rockstars Project >
 * Assignment: < assignment 3 >
 * Author(s): < Nikola Vojinovic, Corradina Dinatale, Noah Huboux, Alex Balez>
 * Student Number: < 101181089, 100645103, 101117858, 101219847>
 * Date: 11/08/2020
 * Description: <Users Controller for dashboard and tabs for users (admin role users can also ping these pages)>*/

package ca.gbc.comp3095.comp3095rockstars.controllers;
import ca.gbc.comp3095.comp3095rockstars.model.Message;
import ca.gbc.comp3095.comp3095rockstars.model.User;
import ca.gbc.comp3095.comp3095rockstars.security.UserPrincipal;
import ca.gbc.comp3095.comp3095rockstars.services.MessageService;
import ca.gbc.comp3095.comp3095rockstars.model.Profile;
import ca.gbc.comp3095.comp3095rockstars.security.UserPrincipal;
import ca.gbc.comp3095.comp3095rockstars.security.UserPrincipalDetailsService;
import ca.gbc.comp3095.comp3095rockstars.services.ProfileService;
import ca.gbc.comp3095.comp3095rockstars.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import ca.gbc.comp3095.comp3095rockstars.model.Message;
import ca.gbc.comp3095.comp3095rockstars.model.User;
import ca.gbc.comp3095.comp3095rockstars.security.UserPrincipal;
import ca.gbc.comp3095.comp3095rockstars.services.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@RequestMapping("users")
public class UsersController {
    private final UserService userService;
    private final ProfileService profileService;
    private final MessageService messageService;

    @ModelAttribute("messageForm")
    public Message messageForm() {
        return new Message();
    }

    @ModelAttribute("profilesForm")
    public Profile profilesForm() {
        return new Profile();
    }
  
    public UsersController(UserService userService, ProfileService profileService,MessageService messageService) {
        this.userService = userService;
        this.profileService = profileService;
        this.messageService = messageService;
    }

    @PostMapping("myProfile")
    public String submitProfile(@Valid Profile profilesForm){

        User user = userService.findByEmail(profilesForm.getEmail());

        profilesForm.setUserForeignKey(user);
        profilesForm.setShippingAddressDefault(profilesForm.getShippingAddress());
        profilesForm.setBillingAddressDefault(profilesForm.getBillingAddress());
        profilesForm.setDateCreated(LocalDate.now());

        profileService.save(profilesForm);

        return "users/dashboard";
    }

    @GetMapping({"dashboard", "index"})
    public String dashboard(Model model ){
        model.addAttribute("users", userService.findAll());
        return "users/dashboard";
    }

    @GetMapping({"myProfile", "myProfile.html"})

    public String myProfile(Model model){
        model.addAttribute("users", userService.findAll());
        model.addAttribute("profiles", profileService.findAll());

        return "users/myProfile";
    }

    @GetMapping({"creditProfile", "creditProfile.html"})
    public String creditProfile(){
        return "users/creditProfile";
    }

    //for inbox.html in templates/users folder
    @GetMapping({"inbox", "inbox.html"})
    public String inbox(Model model){
        model.addAttribute("messages", messageService.findAll());
        return "users/inbox";

    }

    @GetMapping(path = "delete/{id}")
    public String deleteMessage(@PathVariable("id") long id) {
        messageService.deleteById(id);
        return "users/inbox";
    }

    //for readMessage.html in templates/users folder
    @GetMapping(path = "read/{id}")
    public String readMessage(@PathVariable("id") long id, Model model) {
        Message message = messageService.findById(id);
        model.addAttribute("message", message);
        return "users/readMessage";
    }

    //for support.html in templates/users folder
    @GetMapping({"support", "support.html"})
    public String support(Message message){
        return "users/support";
    }

    @PostMapping("add")
    public String addMessage(@Valid Message messageForm, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "users/support";
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        LocalDate date = LocalDate.now();
        formatter.format(date);
        messageForm.setDateCreated(date);
        String email = messageForm.getToWho();
        User user = userService.findByEmail(email);
        messageForm.setUser(user);
        messageService.save(messageForm);
        return "redirect:dashboard";
    }
}
