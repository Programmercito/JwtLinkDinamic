# JwtLinkDinamic (Traducción al inglés)

`JwtLinkDinamic` is a library designed to generate links containing a JWT (JSON Web Token) with data that can be displayed on a frontend without the need for a backend.

## Why use JwtLinkDinamic?

The main advantage of using `JwtLinkDinamic` is that it allows displaying data on the frontend without having to store it on the backend. Since the JWT is validated on the frontend, the data can be used directly for display. This not only simplifies the architecture but also improves security:

- **Asymmetric Signature**: `JwtLinkDinamic` uses asymmetric signing for JWTs. This is essential as the public key will be exposed on the frontend, but the private key will not. This ensures that the data cannot be modified, as if symmetric signing were used, this case could not work in the same way. Asymmetric signing ensures that, even though the public key is exposed, the data cannot be altered without the private key.

- **Public Page**: Although the page must be public, `JwtLinkDinamic` ensures that the displayed data is correct.

- **Prevention of XSS attacks**: By not having the data in plain text and being signed elsewhere, the possibility of XSS attacks that could occur if the data were in plain text is avoided.

## Installation

To add `JwtLinkDinamic` to your Maven project, simply add the following dependency to your `pom.xml` file:

```xml
<dependency>
  <groupId>io.github.programmercito</groupId>
  <artifactId>JwtLinkDinamic</artifactId>
  <version>1.0.1</version>
</dependency>
```

## Usage

Here is an example of how to use `JwtLinkDinamic`:

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

Code result:

```
[https://sitio.me/ruta/eyJhbGciOiJSUzI1NiJ9.eyJleHAiOjE3NTg2NTgxNjAsInYiOiJ7XCJtb25lZGFcIjpcIkRvbGFyXCIsXCJwcmVjaW9cIjozMy4yM30ifQ.ia4631434O9eyTYWZ7x0PfC-0EQ_uS-ONL_-_zNQ0jp5DWChoDJiWl-q53aphP95vgVD3ZaZUe8S00OG7Xpzzd7W-t8g0msq3EpTDXxwjHTCN546z-iGTFTV3AWFNQS8posDf_8dNknsuKT56ZTV_PZC5A-UyocRmXsDXXqsJcjpBJWZbWPIdh87iNzcSsruVH-KS09rDPQFSLlfyTKg8VuOKgoe-9cnOP4P3lSV-0uBacLe8jDMkUqpHNIprDM8mpIylR3lQ1B7ZvAxkFmiI-ZVP2pLIu5C4pWbW_xpZUQCOzX51V3tPI56kK0FHVXj7FvBmafEu8PZATUpvUEGnQ](https://programmercito.github.io/jwtlink-web-example/#/example/eyJhbGciOiJSUzI1NiJ9.eyJleHAiOjE3NTg3NTQwNDUsInYiOiJ7XCJtb25lZGFcIjpcIkRvbGFyXCIsXCJwcmVjaW9cIjozMy4yM30ifQ.bFApTsTqufmxrc7p6Eu9KYvVGsrlmJPV2VMbIdT6I8FMSJzUnA0ERqGBLKPspfN3uzB0rkw-Ftu97EkVqcoQIgwsMKw2wa_7EJW8TTp9imQ5nXv2H-Z5Jk43O6JKYZrb7b87pQkf-uajVjWRmWDmsN5l457MiG7Ln0_H7v0uAQsI251UWyLCTvsyAUkm1c2sRBPBVHoTDERSNoWFdWfZLDyoviyNB_iPUHVcTPxMJZAXd6Dg0MNC-TdyAwPSXp94J_lXjzn7x_o4-IExY19JlrJBoZ5lRZAQIi57y92U0lZNlTrjPZI7jkH_CnKpGv3qaVTqq7V35cCG2BjE8wH79A)
```

Using our example:

https://programmercito.github.io/jwtlink-web-example/#/example/eyJhbGciOiJSUzI1NiJ9.eyJleHAiOjE3NTg3NTQwNDUsInYiOiJ7XCJtb25lZGFcIjpcIkRvbGFyXCIsXCJwcmVjaW9cIjozMy4yM30ifQ.bFApTsTqufmxrc7p6Eu9KYvVGsrlmJPV2VMbIdT6I8FMSJzUnA0ERqGBLKPspfN3uzB0rkw-Ftu97EkVqcoQIgwsMKw2wa_7EJW8TTp9imQ5nXv2H-Z5Jk43O6JKYZrb7b87pQkf-uajVjWRmWDmsN5l457MiG7Ln0_H7v0uAQsI251UWyLCTvsyAUkm1c2sRBPBVHoTDERSNoWFdWfZLDyoviyNB_iPUHVcTPxMJZAXd6Dg0MNC-TdyAwPSXp94J_lXjzn7x_o4-IExY19JlrJBoZ5lRZAQIi57y92U0lZNlTrjPZI7jkH_CnKpGv3qaVTqq7V35cCG2BjE8wH79A

Change the link, and returl in error

https://programmercito.github.io/jwtlink-web-example/#/example/eyJhbGciOiJSUzI1NiJ9.eyJleHAiOjE3NTg3NTQwNDUsInYiOiJ7XCJtb25lZGFcIjpcIkRvbGFyXCIsXCJwcmVjaW9cIjozMy4yM30ifQ.bFApTsTqufmxrc7p6Eu9KYvVGsrlmJPV2VMbIdT6I8FMSJzUnA0ERqGBLKPspfN3uzB0rkw-Ftu97EkVqcoQIgwsMKw2wa_7EJW8TTp9imQ5nXv2H-Z5Jk43O6JKYZrb7b87pQkf-uajVjWRmWDmsN5l457MiG7Ln0_H7v0uAQsI251UWyLCTvsyAUkm1c2sRBPBVHoTDERSNoWFdWfZLDyoviyNB_iPUHVcTPxMJZAXd6Dg0MNC-TdyAwPSXp94J_lXjzn7x_o4-IExY19JlrJBoZ5lRZAQIi57y92U0lZNlTrjPZI7jkH_CnKpGv3qaVTqq7V35cCG2BjE8wH79Aa

Try it! and enjoy creating websites with dynamic data without a backend as the links can be created on your local PC or cell phone and the site on GitHub.

Example:
https://github.com/Programmercito/JwtLinkDinamic-examples example for generation of links, with services servers
https://github.com/Programmercito/jwtlink-web-example web app with out backend
