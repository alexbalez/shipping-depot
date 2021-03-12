/** Project: < Comp3095 Rockstars Project >
 * Assignment: < assignment 3 >
 * Author(s): < Nikola Vojinovic, Corradina Dinatale, Noah Huboux, Alex Balez>
 * Student Number: < 101181089, 100645103, 101117858, 101219847>
 * Date: 11/08/2020
 * Description: <Login Controller to get to login and send to next page>*/

package ca.gbc.comp3095.comp3095rockstars.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping({"", "/", "index"})
    public String index(){
        return "index";
    }

    @PostMapping("/dashboard")
    public String dashboard(){

        return "users/dashboard";

    }
}
