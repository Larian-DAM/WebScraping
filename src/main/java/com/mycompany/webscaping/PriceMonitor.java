package com.mycompany.webscaping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class PriceMonitor {
    private static final String TEST_URL = "https://www.amazon.es/b?node=937935031";

    public static void main(String[] args) {
        try {
            System.out.println("Iniciando prueba de conexión...");
            Document doc = Jsoup.connect(TEST_URL)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) Chrome/91.0.4472.124 Safari/537.36")
                .timeout(10000)
                .get();

            System.out.println("Conexión exitosa!");
            System.out.println("Título de la página: " + doc.title());
            System.out.println("Tamaño del HTML: " + doc.html().length() + " caracteres");
        } catch (Exception e) {
            System.err.println("Error al conectar: " + e.getMessage());
            e.printStackTrace();
        }
    }
}