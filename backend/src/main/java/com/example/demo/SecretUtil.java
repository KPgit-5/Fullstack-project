package com.example.demo;

import com.amazonaws.services.secretsmanager.*;
import com.amazonaws.services.secretsmanager.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class SecretUtil {

    public static Map<String, String> getSecret() throws Exception {
        String secretName = System.getenv("SECRET_NAME");

        AWSSecretsManager client = AWSSecretsManagerClientBuilder.defaultClient();
        GetSecretValueRequest request = new GetSecretValueRequest().withSecretId(secretName);

        GetSecretValueResult result = client.getSecretValue(request);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(result.getSecretString(), Map.class);
    }
}
