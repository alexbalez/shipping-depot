/** Project: < Comp3095 Rockstars Project >
 * Assignment: < assignment 3 >
 * Author(s): < Nikola Vojinovic, Corradina Dinatale, Noah Huboux, Alex Balez>
 * Student Number: < 101181089, 100645103, 101117858, 101219847>
 * Date: 11/08/2020
 * Description: <Credit Profile Repository that extends the JPA repository to be able to write to the database and query>*/

package ca.gbc.comp3095.comp3095rockstars.repository;

import ca.gbc.comp3095.comp3095rockstars.model.CreditProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditProfileRepository extends JpaRepository<CreditProfile, Long> {
    CreditProfile findByCardNumber(Long cardNumber);
}
