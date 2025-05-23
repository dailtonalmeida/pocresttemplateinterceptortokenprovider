package br.nom.dailton.pocresttemplateinterceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Clock;
import java.time.Instant;

@RestController
@RequestMapping("/tokenprovider")
public class TokenController {
    public record TokenRequest(String clientId, String clientSecret) {}
    public record TokenResponse(String token, Instant expiresAt) {}
    private static final Logger log = LoggerFactory.getLogger(TokenController.class);

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public TokenResponse provideToken(@RequestBody TokenRequest request) {
        log.atInfo().log("RECEIVED TOKEN REQUEST: {}", request);
        Instant expiresAt = Instant.now(Clock.systemUTC()).plusSeconds(4L);
        return new TokenResponse("TOKEN_FROM_PROVIDER", expiresAt);
    }

}
