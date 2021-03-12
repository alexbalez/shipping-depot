/** Project: < Comp3095 Rockstars Project >
 * Assignment: < assignment 3 >
 * Author(s): < Nikola Vojinovic, Corradina Dinatale, Noah Huboux, Alex Balez>
 * Student Number: < 101181089, 100645103, 101117858, 101219847>
 * Date: 11/08/2020
 * Description: <Test Controller that is a rest controller that will print out the contents of the database for viewing access>*/

package ca.gbc.comp3095.comp3095rockstars.controllers;

import ca.gbc.comp3095.comp3095rockstars.model.*;
import ca.gbc.comp3095.comp3095rockstars.repository.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api/public")
public class TestController {

    UserRepository userRepository;
    CreditProfileRepository creditProfileRepository;
    ProfileRepository profileRepository;
    MessageRepository messageRepository;

    public TestController(UserRepository userRepository,
                          MessageRepository messageRepository, ProfileRepository profileRepository,
                          CreditProfileRepository creditProfileRepository){

        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
        this.profileRepository = profileRepository;
        this.creditProfileRepository = creditProfileRepository;
    }

    @GetMapping("users")
    public List<User> allUsers(){
        return this.userRepository.findAll();
    }

    @GetMapping("messages")
    public List<Message> allMessages(){
        return this.messageRepository.findAll();
    }

    @GetMapping("profiles")
    public List<Profile> allProfiles(){
        return this.profileRepository.findAll();
    }

    @GetMapping("creditProfiles")
    public List<CreditProfile> allCreditProfiles(){
        return this.creditProfileRepository.findAll();
    }
}
