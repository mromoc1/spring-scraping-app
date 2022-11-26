package com.mromoc1.Spring_demo2.services;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mromoc1.Spring_demo2.models.Medicamento;
import com.mromoc1.Spring_demo2.repositories.SeleniumScrapingRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class SeleniumScrapingService {

    private final SeleniumScrapingRepository seleniumScrapingRepository;
    @Autowired
    public SeleniumScrapingService(SeleniumScrapingRepository seleniumScrapingRepository) {
        this.seleniumScrapingRepository = seleniumScrapingRepository;
    }

    public void iniciarScraping() {
        JSONArray jsonArray = getJSON();
        if (jsonArray == null) {
            return;
        }
        System.out.println("jsonArray.length() = " + jsonArray.length());
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.get(jsonArray.getJSONObject(i).getString("url"));
                List<WebElement> elements = driver.findElements(By.xpath(jsonArray.getJSONObject(i).getString("campo_busqueda")));
                System.out.println("elements.size() = " + elements.size());
                for (WebElement element : elements) {
                    Medicamento medicamento = new Medicamento();
                    medicamento.setEnlace(jsonArray.getJSONObject(i).getString("url"));
                    try {
                        medicamento.setNombre(element.findElement(By.className(jsonArray.getJSONObject(i).getString("campo_nombre"))).getText());
                    } catch (Exception e) {
                        medicamento.setNombre("");
                    }
                    try {
                        medicamento.setDescripcion(element.findElement(By.xpath(jsonArray.getJSONObject(i).getString("campo_descripcion"))).getText());
                    } catch (Exception e) {
                        medicamento.setDescripcion("");
                    }
                    try {
                        medicamento.setPrecioTienda(element.findElement(By.xpath(jsonArray.getJSONObject(i).getString("campo_precio_tienda"))).getText());
                    } catch (Exception e) {
                        medicamento.setPrecioTienda("");
                    }
                    try {
                        medicamento.setPrecioOferta(element.findElement(By.xpath(jsonArray.getJSONObject(i).getString("campo_precio_oferta"))).getText());
                    } catch (Exception e) {
                        medicamento.setPrecioOferta("");
                    }
                    try {
                        medicamento.setPrecioOnline(element.findElement(By.xpath(jsonArray.getJSONObject(i).getString("campo_precio_online"))).getText());
                    } catch (Exception e) {
                        medicamento.setPrecioOnline("");
                    }
                    try {
                        medicamento.setFormato(element.findElement(By.className(jsonArray.getJSONObject(i).getString("campo_formato"))).getText());
                    } catch (Exception e) {
                        medicamento.setFormato("");
                    }
                    // imprimir medicamento
                    System.out.println(medicamento.getNombre());
                    System.out.println(medicamento.getDescripcion());
                    System.out.println(medicamento.getPrecioTienda());
                    System.out.println(medicamento.getPrecioOferta());
                    System.out.println(medicamento.getPrecioOnline());
                    System.out.println(medicamento.getFormato());
                    System.out.println("-------------------------------------------------");
                    seleniumScrapingRepository.save(medicamento);
                }
                driver.close();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private JSONArray getJSON() {
        JSONArray jsonarray = new JSONArray();
        try {
            URL obj = new URL("http://localhost:8080/api/sitioweb");
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
		    con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
    
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JSONObject jsonobject = new JSONObject(response.toString());
                jsonarray = jsonobject.getJSONArray("content");
            } else {
                System.out.println("GET request did not work.");
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonarray;
    }
}