package com.mromoc1.Spring_demo2.models;

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
    private String url;

    @Field(type=FieldType.Text)
    private String campo_busqueda;

    @Field(type=FieldType.Text)
    private String campo_nombre;

    @Field(type=FieldType.Text)
    private String campo_descripcion;

    @Field(type=FieldType.Text)
    private String campo_precio_tienda;

    @Field(type=FieldType.Text)
    private String campo_precio_oferta;

    @Field(type=FieldType.Text)
    private String campo_precio_online;

    @Field(type=FieldType.Text)
    private String campo_formato;

    public void setId(String id) {
        this.id = id;
    }
    public void setSitio(String sitio) {
        this.sitio = sitio;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public void setCampoBusqueda(String campo_busqueda) {
        this.campo_busqueda = campo_busqueda;
    }
    public void setCampoNombre(String campo_nombre) {
        this.campo_nombre = campo_nombre;
    }
    public void setCampoDescripcion(String campo_descripcion) {
        this.campo_descripcion = campo_descripcion;
    }
    public void setCampoPrecioTienda(String campo_precio_tienda) {
        this.campo_precio_tienda = campo_precio_tienda;
    }
    public void setCampoPrecioOferta(String campo_precio_oferta) {
        this.campo_precio_oferta = campo_precio_oferta;
    }
    public void setCampoPrecioOnline(String campo_precio_online) {
        this.campo_precio_online = campo_precio_online;
    }
    public void setCampoFormato(String campo_formato) {
        this.campo_formato = campo_formato;
    }
    public String getId() {
        return id;
    }
    public String getSitio() {
        return sitio;
    }
    public String getUrl() {
        return url;
    }
    public String getCampo_busqueda() {
        return campo_busqueda;
    }
    public String getCampo_nombre() {
        return campo_nombre;
    }
    public String getCampo_descripcion() {
        return campo_descripcion;
    }
    public String getCampo_precio_tienda() {
        return campo_precio_tienda;
    }
    public String getCampo_precio_oferta() {
        return campo_precio_oferta;
    }
    public String getCampo_precio_online() {
        return campo_precio_online;
    }
    public String getCampo_formato() {
        return campo_formato;
    }
}
