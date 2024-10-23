package com.aluracursos.conversormonedas.models;

public record Currency(double conversion_rate, String base_code, String target_code, String time_last_update_utc) {
}
