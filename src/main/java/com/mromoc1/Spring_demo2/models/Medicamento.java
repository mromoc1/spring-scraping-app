package com.mromoc1.Spring_demo2.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;


@Document(indexName = "medicamento", shards = 1, replicas = 0, refreshInterval = "5s", createIndex = true)
@Setting(settingPath = "static/es-settings.json")
public class Medicamento {

    @Id
    @Field(type=FieldType.Keyword)
    private String id;

    @Field(type=FieldType.Text)
    private String nombre;

    @Field(type=FieldType.Text)
    private String descripcion;

    @Field(type=FieldType.Text)
    private String precio_tienda;

    @Field(type=FieldType.Text)
    private String precio_oferta;

    @Field(type=FieldType.Text)
    private String precio_online;

    @Field(type=FieldType.Text)
    private String formato;

    @Field(type=FieldType.Text)
    private String ultimo_escaneo;

    @Field(type=FieldType.Text)
    private String enlace;

    public void setId(String id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setPrecioTienda(String precio_tienda) {
        this.precio_tienda = precio_tienda;
    }
    public void setPrecioOferta(String precio_oferta) {
        this.precio_oferta = precio_oferta;
    }
    public void setPrecioOnline(String precio_online) {
        this.precio_online = precio_online;
    }
    public void setUltimo_escaneo(String ultimo_escaneo) {
        this.ultimo_escaneo = ultimo_escaneo;
    }
    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
    public void setFormato(String formato) {
        this.formato = formato;
    }
    public String getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String getPrecioTienda() {
        return precio_tienda;
    }
    public String getPrecioOferta() {
        return precio_oferta;
    }
    public String getPrecioOnline() {
        return precio_online;
    }
    public String getUltimo_escaneo() {
        return ultimo_escaneo;
    }
    public String getEnlace() {
        return enlace;
    }
    public String getFormato() {
        return formato;
    }
}
