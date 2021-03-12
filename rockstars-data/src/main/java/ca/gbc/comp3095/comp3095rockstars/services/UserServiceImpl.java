/** Project: < Comp3095 Rockstars Project >
 * Assignment: < assignment 3 >
 * Author(s): < Nikola Vojinovic, Corradina Dinatale, Noah Huboux, Alex Balez>
 * Student Number: < 101181089, 100645103, 101117858, 101219847>
 * Date: 11/08/2020
 * Description: <The user Service implementation that saves the user to the user repository >*/

package ca.gbc.comp3095.comp3095rockstars.services;
import ca.gbc.comp3095.comp3095rockstars.model.RegistrationForm;
import ca.gbc.comp3095.comp3095rockstars.model.User;
import ca.gbc.comp3095.comp3095rockstars.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }



    public User save(RegistrationForm registrationInfo) {
        User user = new User();
        user.setFirstName(registrationInfo.getFirstName());
        user.setLastName(registrationInfo.getLastName());
        user.setAddress(registrationInfo.getAddress());
        user.setEmail(registrationInfo.getEmail());
        user.setPassword(passwordEncoder.encode(registrationInfo.getPassword()));
        user.setRoles();
        return userRepository.save(user);
    }

    @Override
    public User saveAdmin(User user) {
        return userRepository.save(user);
    }

    @Override
    public Set<User> findAll() {
        Set<User> users = new HashSet<>(userRepository.findAll());
        return users;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(User object) {
        userRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        userRepository.deleteById(aLong);
    }


}
