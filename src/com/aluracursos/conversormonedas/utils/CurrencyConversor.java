package com.aluracursos.conversormonedas.utils;

import com.aluracursos.conversormonedas.models.Currency;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CurrencyConversor {

    String url = "https://v6.exchangerate-api.com/v6/bc5ace4f5995fb37db9924d0/pair/";
    private int currencyOption;
    private String baseCode;
    private String targetCode;

    // Arreglo de códigos de moneda base y objetivo
    private static final String[][] currencyPairs = {
            {"ARS", "USD"}, // Opción 1: Pesos argentinos (ARS) ==> Dólares americanos (USD)
            {"USD", "ARS"}, // Opción 2: Dólares americanos (USD) ==> Pesos argentinos (ARS)
            {"BRL", "USD"}, // Opción 3: Reales (BRL) ==> Dólares americanos (USD)
            {"USD", "BRL"}, // Opción 4: Dólares americanos (USD) ==> Reales (BRL)
            {"CLP", "USD"}, // Opción 5: Pesos chilenos (CLP) ==> Dólares americanos (USD)
            {"USD", "CLP"}, // Opción 6: Dólares americanos (USD) ==> Pesos chilenos (CLP)
            {"BOB", "COP"}, // Opción 7: Boliviano boliviano (BOB) ==> Peso colombiano (COP)
            {"MXN", "USD"}, // Opción 8: Pesos mexicanos (MXN) ==> Dólares americanos (USD)
            {"USD", "MXN"}, // Opción 9: Dólares americanos (USD) ==> Pesos mexicanos (MXN)
            {"CLP", "MXN"}, // Opción 10: Pesos chilenos (CLP) ==> Pesos mexicanos (MXN)
            {"MXN", "CLP"}  // Opción 11: Pesos mexicanos (MXN) ==> Pesos chilenos (CLP)
    };


    public CurrencyConversor(int currencyOption) {
        this.currencyOption = currencyOption;
    }


    private Currency consultPairConversion() {

        if (currencyOption < 1 || currencyOption > currencyPairs.length) {
            throw new RuntimeException("La opción no está disponible");
        }

        // Ajuste del índice para la opción ingresada (opciones empiezan en 1)
        baseCode = currencyPairs[currencyOption - 1][0];
        targetCode = currencyPairs[currencyOption - 1][1];

        ApiClient apiClient = new ApiClient(url.concat(baseCode + "/" + targetCode + "/"));
        try {
            HttpResponse<String> response = apiClient.requestToApiClient();
            return new Gson().fromJson(response.body(), Currency.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }


    }


    public String pairConvertion(Double value) {
        var pairConversion = consultPairConversion();
        this.baseCode = pairConversion.base_code();
        this.targetCode = pairConversion.target_code();

        NumberFormat format = new DecimalFormat("#0.00");
        Double convertedValue = pairConversion.conversion_rate() * value;
        return format.format(convertedValue);
    }

    public String getLastUpdate() {
        var pairConversion = consultPairConversion();
        return pairConversion.time_last_update_utc();
    }

    public String getBaseCode() {
        return baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }
}
