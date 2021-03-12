/** Project: < Comp3095 Rockstars Project >
 * Assignment: < assignment 3 >
 * Author(s): < Nikola Vojinovic, Corradina Dinatale, Noah Huboux, Alex Balez>
 * Student Number: < 101181089, 100645103, 101117858, 101219847>
 * Date: 11/08/2020
 * Description: <UserService that implements the crud service and adds additional methods to save to database and findByEmail>*/

package ca.gbc.comp3095.comp3095rockstars.services;

import ca.gbc.comp3095.comp3095rockstars.model.RegistrationForm;
import ca.gbc.comp3095.comp3095rockstars.model.User;


public interface UserService extends CrudService<User, Long>{
    User findByEmail(String email);
    User save(RegistrationForm registration);
    User saveAdmin(User user);
}
