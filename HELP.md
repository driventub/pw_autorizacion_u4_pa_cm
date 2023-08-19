# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.2/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsinge/index.html#using.devtools)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsinge/index.html#data.sql.jpa-and-spring-data)
* [Spring Web Services](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsinge/index.html#io.webservices)
* [Spring Security](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsinge/index.html#web.security)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Producing a SOAP web service](https://spring.io/guides/gs/producing-web-service/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)

# Taller 39 
inyectar Spring security 
configurar la semilla el algoritmo de encriptacion, semilla, token

crear paquete security

En service se crea una interface de spring security.

## Taller 40

encabezdo, payload, verificacion de la semilla

- mecanimos de seguridad en el token: algoritmo de encriptacion, firma/semilla, tiempo de expiracion

- el estandar (buenas practicas) para la expiracion del actual token hasta el siguiente es de 3-5 min.

- la aplicacion deberia generar un nuevo token acabado el tiempo (da confianza) 

- como no correponde a ninguno de los estereotipos normales, la capa de seguridad va con @Component

- deben existir 2 apis, un api publica para poder registrarse o loguearse (token) y la segunda api para poder acceder a los recursos (api de negocios).

- Una sesion se puede configurar para manejar una sesion por peticion, una siempre o el no usar sesion.

- Sesion: espacio de memoria en donde estan los datos que manejamos.


**Tipos de Sesion**

- STATELESS: solamente cuando esta activa la sesion, se emplea el api y entonces la sesion termina.

- ALWAYS: mantiene la sesion activa "siempre"

- NEVER: sesion no se guarda al cerrar inclusive una pestaña

**Para Web Security**

- SecurityFilterChain
- DaoAuthenticationProvider
- PasswordEncoder
- AuthenticationManager



# Taller 41 

Antes de generar el token, se deberia generar la autenticacion, solamente cuando esta autenticacion sea satisfatoria


La URL se usa desde el servicio, es decir localhost:8080/-----/-----/ no va, 


La capacidad Rest retorna un token generado, pero antes necesitamos autenticarle, implementando una funcionalidad para eso, (para las funcionalidades de negocio)

Finalmente lo que se compara es un usuario y contraseña de la base de datos

cuando reconoce Spring la contraseña en la base de datos, debe estar encriptado dentro de la base de datos  

Cuando se manda la autenticacion dentro del API debe estar en el body el username y password tal cual

- Oauth2.0, servidor de recursos

## Taller 42

- Unchecked: Excepciones que suceden en tiempo de ejecucion, pero no se controlan en compilacion. Es buena practica tratarlas. Lo mas comun es que el token expire (grant).
- El filtro (es previo) ayuda a interceptar la validacion del token. Siempre deben heredar "OncePerRequestFilter", va a pedir el metodo a ejecutar en este filto, se usa el "ToFilter".
- Antes de ejecutar/consumir el API.

- La posicion del token para utilizar en el API es en la metadata (header).
- El token se debe enviar en una cabecera de nombre "**Authorized**".Tambien debe venir con el valor, la siguiente nomenclatura "**Bearer_tokentokentoken**".

- Se necesita sacar a validar el token fuera del bearer.

- si el token no es valido, el request no se le permite pasar

