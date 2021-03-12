/** Project: < Comp3095 Rockstars Project >
 * Assignment: < assignment 3 >
 * Author(s): < Nikola Vojinovic, Corradina Dinatale, Noah Huboux, Alex Balez>
 * Student Number: < 101181089, 100645103, 101117858, 101219847>
 * Date: 11/08/2020
 * Description: <Abstract Captcha Service for captcha validation that implements the captcha service interface>*/

package ca.gbc.comp3095.comp3095rockstars.services.captchaServices;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import ca.gbc.comp3095.comp3095rockstars.captcha.CaptchaSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public abstract class AbstractCaptchaService implements ICaptchaService {

    private final static Logger LOGGER = LoggerFactory.getLogger(AbstractCaptchaService.class);

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    HttpServletRequest request =
            ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                    .getRequest();


    @Autowired
    protected CaptchaSettings captchaSettings;

    @Autowired
    protected ReCaptchaAttemptService reCaptchaAttemptService;

    @Autowired
    protected RestOperations restTemplate;

    protected static final Pattern RESPONSE_PATTERN = Pattern.compile("[A-Za-z0-9_-]+");

    protected static final String RECAPTCHA_URL_TEMPLATE = "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s&remoteip=%s";

    @Override
    public String getReCaptchaSite() {
        return captchaSettings.getSite();
    }

    @Override
    public String getReCaptchaSecret() {
        return captchaSettings.getSecret();
    }


    protected void securityCheck(final String response) {
        LOGGER.debug("Attempting to validate response {}", response);

        if (reCaptchaAttemptService.isBlocked(getClientIP())) {
            throw new RuntimeException();
        }

        if (!responseSanityCheck(response)) {
            throw new RuntimeException();
        }
    }

    protected boolean responseSanityCheck(final String response) {
        return StringUtils.hasLength(response) && RESPONSE_PATTERN.matcher(response).matches();
    }

    protected String getClientIP() {
        final String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null) {
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }
}
