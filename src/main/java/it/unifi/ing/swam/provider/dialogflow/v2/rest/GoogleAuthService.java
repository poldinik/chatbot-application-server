package it.unifi.ing.swam.provider.dialogflow.v2.rest;

import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import lombok.extern.log4j.Log4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

@ApplicationScoped
@Log4j
public class GoogleAuthService {

    GoogleCredentials credentials;

    String accountService = "/Users/loretto/Downloads/ilmionuovoagente-qfbbbf-b0eecd65e31a.json";

    public GoogleAuthService(){
        try {
            this.credentials = GoogleCredentials.fromStream(new FileInputStream(accountService))
                    .createScoped(Arrays.asList("https://www.googleapis.com/auth/dialogflow", "https://www.googleapis.com/auth/cloud-platform"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getAccessToken() throws IOException {
        credentials.refreshIfExpired();
        AccessToken token = credentials.getAccessToken();
        return token.getTokenValue();
    }

//    @PostConstruct
//    public void initCredentials() throws IOException {
//        this.credentials = GoogleCredentials.fromStream(new FileInputStream(accountService))
//                .createScoped(Arrays.asList("https://www.googleapis.com/auth/dialogflow", "https://www.googleapis.com/auth/cloud-platform"));
//    }
}
