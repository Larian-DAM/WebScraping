package com.mycompany.webscaping.scraper;

import com.mycompany.webscaping.util.ConfigLoader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class WebScraper {
    private final ConfigLoader config;
    
    public WebScraper(ConfigLoader config) {
        this.config = config;
    }

    public List<ProductInfo> scrapeProducts() throws Exception {
        List<ProductInfo> products = new ArrayList<>();
        String url = config.getProperty("url");
        
        Document doc = Jsoup.connect(url)
                .userAgent(config.getProperty("userAgent"))
                .timeout(10000)
                .get();

        Elements items = doc.select("div.s-result-item");
        
        for (Element item : items) {
            try {
                String nombre = item.select("span.a-text-normal").first().text();
                String precio = item.select("span.a-price-whole").first().text() + "€";
                String disponibilidad = item.select("span.a-color-price").text();
                
                products.add(new ProductInfo(nombre, precio, disponibilidad));
            } catch (Exception e) {
                continue;
            }
        }
        
        return products;
    }
}