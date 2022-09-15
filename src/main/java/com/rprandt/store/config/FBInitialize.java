package com.rprandt.store.config;

import java.io.FileInputStream;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FBInitialize {
    
    @PostConstruct
    public void initialize() throws IOException{
        FileInputStream serviceAccount =
        new FileInputStream("/creds/serviceAccountKey.json");
        FirebaseOptions.Builder builder = FirebaseOptions.builder();
        FirebaseOptions options = builder
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .build();
        FirebaseApp.initializeApp(options);
    }

}
