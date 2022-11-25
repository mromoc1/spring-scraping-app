package com.mromoc1.Spring_demo2.services;

import com.gargoylesoftware.htmlunit.WebClient;

import java.util.List;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;

public class HtmlScrapingService {
    
    public void iniciarScraping(){
        try {
            WebClient chromeWebClient = new WebClient(BrowserVersion.CHROME);
            chromeWebClient.getOptions().setUseInsecureSSL(true); // Permite hacer scraping de paginas web que no tienen certificado SSL
            chromeWebClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
            chromeWebClient.getOptions().setThrowExceptionOnScriptError(false);
            chromeWebClient.getOptions().setCssEnabled(false);
            chromeWebClient.getOptions().setJavaScriptEnabled(false);
            HtmlPage htmlPage = chromeWebClient.getPage("https://salcobrand.cl/t/medicamentos/huesos-y-articulaciones");
            // imprimit htmlpage
            System.out.println(htmlPage.asXml());
            // // DomNodeList<DomNode> blogHeadings = htmlPage.querySelectorAll("div.info");
            // // // imprimir cantidad blogHeadings
            // // System.out.println("Cantidad de elementos: " + blogHeadings.size());
            // List<Object> items = htmlPage.getByXPath("//li[@class='ais-Hits-item']");
            // // imprimir cantidad items
            // System.out.println("Cantidad de elementos: " + items.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
