package br.nom.dailton.pocresttemplateinterceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/tokenprovider")
public class TokenController {
    public record TokenRequest(String clientId, String clientSecret) {}
    private static final Logger log = LoggerFactory.getLogger(TokenController.class);

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> provideToken(@RequestBody TokenRequest request) {
        log.atInfo().log("RECEIVED TOKEN REQUEST: {}", request);
        return Map.of("token", "TOKEN_FROM_PROVIDER");
    }

}
