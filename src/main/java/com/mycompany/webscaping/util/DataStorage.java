package com.mycompany.webscaping.util;

import com.mycompany.webscaping.scraper.ProductInfo;
import java.io.*;
import java.util.List;

public class DataStorage {
    private final String filePath;

    public DataStorage(String filePath) {
        this.filePath = filePath;
        createFileIfNotExists();
    }

    private void createFileIfNotExists() {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
                try (FileWriter fw = new FileWriter(file)) {
                    fw.write("Nombre,Precio,Disponibilidad,Timestamp\n");
                }
            } catch (IOException e) {
                System.err.println("Error creando el archivo: " + e.getMessage());
            }
        }
    }

    public void saveProducts(List<ProductInfo> products) throws IOException {
        try (FileWriter fw = new FileWriter(filePath, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            
            for (ProductInfo product : products) {
                bw.write(String.format("%s,%s,%s,%s\n",
                    escapeCsv(product.getNombre()),
                    escapeCsv(product.getPrecio()),
                    escapeCsv(product.getDisponibilidad()),
                    product.getTimestamp()));
            }
        }
    }

    private String escapeCsv(String value) {
        return "\"" + value.replace("\"", "\"\"") + "\"";
    }
}