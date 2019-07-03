package no.maryam.dnb.opendata.clients;

import no.maryam.dnb.opendata.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

//@Service
public class DNBRestClient {

    @Value("${no.dnb.api.client.id}")
    String clientId;

    @Value("${no.dnb.api.client.secret}")
    String sclientSecret;

    @Value("${no.dnb.api.key}")
    String apiKey;

    @Value("${no.dnb.api.x.request.id}")
    String xRequestId;

    @Value("${no.dnb.api.base.url}")
    String baseUrl;

    @Value("${no.dnb.api.account}")
    String accountUrl;

    @Value("${no.dnb.api.consents}")
    String consentsUrl;


    @Autowired
    RestTemplate restTemplate;


    Account getAccountById(String accountId){

        HttpHeaders headers = getHeadersWithConsentId();

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange(baseUrl+accountUrl+accountId, HttpMethod.GET, entity, Account.class).getBody();
    }

    /* Step-2 */
    private String getConsentId(){
        HttpHeaders headers = getHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange(baseUrl+consentsUrl, HttpMethod.POST, entity, String.class).getBody();
    }

    /* Step-1 */
    private HttpHeaders getHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Request-ID", xRequestId);
        headers.set("PSU-ID","31125464346");
        headers.set("PSU-IP-Address","123.123.123.123");
        headers.set("TPP-Redirect-Preferred","true");
        headers.set("TPP-Redirect-URI","http://tpp-service.net");
        headers.set("X-Request-ID","");

        return headers;
    }

    /* Step-3 */
    private HttpHeaders getHeadersWithConsentId(){
        HttpHeaders headers = getHeaders();
        headers.set("Consent-ID", getConsentId());
        return headers;
    }
}
