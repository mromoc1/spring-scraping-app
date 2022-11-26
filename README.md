# Spring_demo2
API que dispone al usuario informacion sobre los productos extraidos de sitios web de farmacias. El objetivo de esta API es permitir la comparacion de precios de productos farmaceuticos proporcionados por diferentes entidades.

## Requerimientos
<ul>
    <li>Open JDK 8</li>
    <li>Elasticsearch v7.13.1</li>
    <li>Para monitoreo (Opcionales):</li>
    <ul>
        <li>Logstash v7.13.1</li>
        <li>Filebeat v7.13.1</li>
        <li>Metricbeat v7.13.1</li>
        <li>Heartbeat v7.13.1</li>
        <li>Kibana v7.13.1</li>
    </ul>
</ul>

## Endpoints
<ul>
    <li><code>GET http://localhost:8080/api/status </code></li>
    <li><code>GET http://localhost:8080/scraping</code></li>
    <li><code>GET http://localhost:8080/api/sitioweb</code></li>
    <li><code>GET http://localhost:8080/api/sitioweb/{string:SITIO}</code></li>
    <li><code>POST http://localhost:8080/api/sitioweb</code></li>
    <li><code>DEL http://localhost:8080/api/sitioweb/delete/{string:ID}</code></li>
    <li><code>GET http://localhost:8080/api/medicamentos</code></li>
    <li><code>GET http://localhost:8080/api/medicamentos/{string:MEDICAMENTO}</code></li>
    <li><code>POST http://localhost:8080/api/medicamentos</code></li>
    <li><code>DEL http://localhost:8080/api/medicamentos/delete/{string:ID}</code></li>
</ul>

## POST example
Sitio Web

```
{
    "sitio": "farmaciasahumada",
    "url": "https://www.farmaciasahumada.cl/medicamentos/cardiovascular.html",
    "campo_busqueda": "//div[@class='product-item-info']",
    "campo_nombre": "product-brand-name",
    "campo_descripcion": "",
    "campo_precio_tienda": "",
    "campo_precio_oferta": ".//span[@class='special-price']",
    "campo_precio_online": ".//span[@class='old-price']",
    "campo_formato": "product-item-link"
}
```
Medicamento

```
{
    "nombre": "BAYER",
    "descripcion": "",
    "formato": "CITRACAL MAX DE 60 COMPRIMIDOS RECUBIERTOS",
    "ultimo_escaneo": "",
    "enlace": "https://salcobrand.cl/t/medicamentos/huesos-y-articulaciones",
    "precioTienda": "Precio farmacia: $13.399",
    "precioOferta": "Oferta:$10.987",
    "precioOnline": "Oferta:$10.987"
}
```


