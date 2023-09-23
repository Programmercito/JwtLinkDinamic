
# JwtLinkDinamic

`JwtLinkDinamic` es una librería diseñada para generar enlaces que contienen un JWT (JSON Web Token) con datos que pueden ser mostrados en un frontend sin la necesidad de un backend.

## ¿Por qué usar JwtLinkDinamic?

La principal ventaja de usar `JwtLinkDinamic` es que permite mostrar datos en el frontend sin tener que almacenarlos en el backend. Dado que el JWT se valida en el frontend, los datos se pueden utilizar directamente para ser mostrados. Esto no solo simplifica la arquitectura, sino que también mejora la seguridad:

- **Firma Asimétrica**: `JwtLinkDinamic` utiliza firma asimétrica para los JWT. Esto es esencial ya que la llave pública estará expuesta en el frontend, pero la llave privada no. Esto garantiza que los datos no puedan ser modificados, ya que si se utilizara firma simétrica, este caso no podría funcionar de la misma manera. La firma asimétrica asegura que, aunque la llave pública esté expuesta, los datos no puedan ser alterados sin la llave privada.

- **Página pública**: Aunque la página debe ser pública, `JwtLinkDinamic` garantiza que los datos mostrados sean los correctos.
  
- **Prevención de ataques XSS**: Al no tener los datos en texto plano y al estar firmados en otro lugar, se evita la posibilidad de ataques XSS que podrían ocurrir si los datos estuvieran en texto plano.

## Instalación

Para agregar `JwtLinkDinamic` a tu proyecto Maven, simplemente añade la siguiente dependencia en tu archivo `pom.xml`:

```xml
<dependency>
  <groupId>io.github.programmercito</groupId>
  <artifactId>JwtLinkDinamic</artifactId>
  <version>1.0.1</version>
</dependency>
```

## Uso

Aquí tienes un ejemplo de cómo usar `JwtLinkDinamic`:

```java
public static void main(String[] args) {
    String link = "https://sitio.me/ruta/${jwt}";
    MonedaPrecio monedap = new MonedaPrecio();
    monedap.setMoneda("Dolar");
    monedap.setPrecio(33.23);
    String resul = JwtMessage.generate(link, monedap);
    System.out.println(resul);
}
```

Resultado del código:

```
https://sitio.me/ruta/eyJhbGciOiJSUzI1NiJ9.eyJleHAiOjE3NTg2NTgxNjAsInYiOiJ7XCJtb25lZGFcIjpcIkRvbGFyXCIsXCJwcmVjaW9cIjozMy4yM30ifQ.ia4631434O9eyTYWZ7x0PfC-0EQ_uS-ONL_-_zNQ0jp5DWChoDJiWl-q53aphP95vgVD3ZaZUe8S00OG7Xpzzd7W-t8g0msq3EpTDXxwjHTCN546z-iGTFTV3AWFNQS8posDf_8dNknsuKT56ZTV_PZC5A-UyocRmXsDXXqsJcjpBJWZbWPIdh87iNzcSsruVH-KS09rDPQFSLlfyTKg8VuOKgoe-9cnOP4P3lSV-0uBacLe8jDMkUqpHNIprDM8mpIylR3lQ1B7ZvAxkFmiI-ZVP2pLIu5C4pWbW_xpZUQCOzX51V3tPI56kK0FHVXj7FvBmafEu8PZATUpvUEGnQ
```
