/** Project: < Comp3095 Rockstars Project >
 * Assignment: < assignment 3 >
 * Author(s): < Nikola Vojinovic, Corradina Dinatale, Noah Huboux, Alex Balez>
 * Student Number: < 101181089, 100645103, 101117858, 101219847>
 * Date: 11/08/2020
 * Description: <Captcha interface that it used to create a method for processing response>*/

package ca.gbc.comp3095.comp3095rockstars.services.captchaServices;


public interface ICaptchaService {

    default void processResponse(final String response) {}

    String getReCaptchaSite();

    String getReCaptchaSecret();
}
