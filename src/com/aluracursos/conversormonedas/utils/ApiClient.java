package com.aluracursos.conversormonedas.utils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ApiClient {

    private URI uriURL;

    public ApiClient(String url) {
        this.uriURL = URI.create(url);
    }

    public HttpResponse<String> requestToApiClient() throws IOException, InterruptedException {
        URI uriURL = this.uriURL;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uriURL)
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }


}
