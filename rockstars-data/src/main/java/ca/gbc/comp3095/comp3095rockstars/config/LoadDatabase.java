/** Project: < Comp3095 Rockstars Project >
        * Assignment: < assignment 3 >
        * Author(s): < Nikola Vojinovic, Corradina Dinatale, Noah Huboux, Alex Balez>
        * Student Number: < 101181089, 100645103, 101117858, 101219847>
        * Date: 11/08/2020
        * Description: <Loads the database and inputs the first two Users into the database>*/


package ca.gbc.comp3095.comp3095rockstars.config;
import ca.gbc.comp3095.comp3095rockstars.model.Message;
import ca.gbc.comp3095.comp3095rockstars.repository.MessageRepository;
import ca.gbc.comp3095.comp3095rockstars.model.Message;
import ca.gbc.comp3095.comp3095rockstars.model.Profile;
import ca.gbc.comp3095.comp3095rockstars.repository.ProfileRepository;
import ca.gbc.comp3095.comp3095rockstars.repository.MessageRepository;
import ca.gbc.comp3095.comp3095rockstars.repository.UserRepository;
import ca.gbc.comp3095.comp3095rockstars.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class LoadDatabase implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final MessageRepository messageRepository;
    private final Date date;
    private final ProfileRepository profileRepository;

    public LoadDatabase(UserRepository userRepository , PasswordEncoder passwordEncoder,  MessageRepository messageRepository, ProfileRepository profileRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.messageRepository = messageRepository;

        this.date = new Date(2020);
        this.profileRepository = profileRepository;
    }

    @Override
    public void run(String... args) {
        // Delete all
        this.userRepository.deleteAll();
        this.profileRepository.deleteAll();
        this.messageRepository.deleteAll();

        // Crete users
        User bilbo = new User("Bilbo", "Baggins", "30 Stadium Rd","admin@isp.net", passwordEncoder.encode("P@ssword1"), "ADMIN");
        User admin = new User("Frodo", "Baggins", "30 Stadium Rd","frodo.baggins@gmail.com", passwordEncoder.encode("P@ssword2"), "USER");
        Profile profile1 = new Profile("Toronto", "Ca","n2n3n4", "address ex 1", "addess ex 2", "def address 1", "def address 2", LocalDate.now(), admin);
        Profile profile2 = new Profile("Toronto2", "ca","222222", "address ex 1", "addess ex 2", "def address 1", "def address 2", LocalDate.now(), bilbo);


        List<User> users = Arrays.asList(a, bilbo,admin,user);
        List<Profile> profiles = Arrays.asList(profile1,profile2,profile3,profile4,profile5,profile6);

        // Save to db
        this.userRepository.saveAll(users);
        this.profileRepository.saveAll(profiles);

        //this.messageRepository.saveAll(messages);
    }
}
