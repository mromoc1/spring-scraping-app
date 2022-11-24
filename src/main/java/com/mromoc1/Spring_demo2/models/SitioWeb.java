package com.mromoc1.Spring_demo2.models;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

@Document(indexName = "sitioweb", shards = 1, replicas = 0, refreshInterval = "5s", createIndex = true)
@Setting(settingPath = "static/es-settings.json")
public class SitioWeb {
    @Id
    @Field(type=FieldType.Keyword)
    private String id;

    @Field(type=FieldType.Text)
    private String sitio;

    @Field(type=FieldType.Text)
    private ArrayList<String> campos_busqueda;

    public void setId(String id) {
        this.id = id;
    }
    public void setSitio(String sitio) {
        this.sitio = sitio;
    }
    public void setCampos_busqueda(ArrayList<String> campos_busqueda) {
        this.campos_busqueda = campos_busqueda;
    }
    public String getId() {
        return id;
    }
    public String getSitio() {
        return sitio;
    }
    public ArrayList<String> getCampos_busqueda() {
        return campos_busqueda;
    }
}
