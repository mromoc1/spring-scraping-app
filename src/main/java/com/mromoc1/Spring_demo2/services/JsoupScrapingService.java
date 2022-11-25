package com.mromoc1.Spring_demo2.services;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.mromoc1.Spring_demo2.models.SitioWeb;

public class JsoupScrapingService {
    private static final String EBAY_GLOBAL_DEALS_URL = "https://www.ebay.com/globaldeals";

    private static final String PRODUCT_CARD_CLASS = "dne-itemtile-detail";
    private static final String PRODUCT_TITLE_CLASS = "dne-itemtile-title";
    private static final String PRODUCT_LINK_SELECTOR = ".dne-itemtile-title a";
    private static final String PRODUCT_PRICE_SELECTOR = ".dne-itemtile-price .first";

    public void iniciarScraping() {
        try {
            Document doc = Jsoup.connect(EBAY_GLOBAL_DEALS_URL).get();
            System.out.println("Title: " + doc.title());
            Elements productElements = doc.getElementsByClass(PRODUCT_CARD_CLASS);
            // obtiene todos los elementos de la clase
            for(Element productElement : productElements) { 
                System.out.print(productElement.text());
                // String title = productElement.getElementsByClass(PRODUCT_TITLE_CLASS).text();
                // String link = productElement.select(PRODUCT_LINK_SELECTOR).attr("href");
                // String price = productElement.select(PRODUCT_PRICE_SELECTOR).text();
                // System.out.println("Title: " + title);
                // System.out.println("Link: " + link);
                // System.out.println("Price: " + price);
                System.out.println("--------------------------------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
