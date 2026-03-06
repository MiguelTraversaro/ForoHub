# ForoHub - Challenge Back End (Java & Spring Boot)

## 📝 Descripción del Proyecto
ForoHub es una API REST diseñada para replicar el funcionamiento de un foro de discusión, centrada en la gestión de tópicos. Este proyecto forma parte del desafío final del programa **Oracle Next Education (ONE)** y aplica conceptos avanzados de desarrollo de microservicios con Spring Boot.

## 🚀 Funcionalidades Principales
* **CRUD de Tópicos**: Creación, consulta, actualización y eliminación de tópicos en el foro.
* **Seguridad (JWT)**: Autenticación mediante tokens JSON Web Token para proteger los recursos de la API.
* **Validación de Datos**: Reglas de negocio mediante Bean Validation para garantizar la integridad de la información.
* **Persistencia Automatizada**: Manejo de base de datos MySQL con control de versiones mediante Flyway.

## 🛠️ Tecnologías Utilizadas
* **Java 21**: Lenguaje de programación base.
* **Spring Boot 3.5.x**: Framework para el desarrollo de la API REST.
* **Spring Security**: Control de acceso y protección de endpoints.
* **Spring Data JPA**: Gestión de la persistencia de datos.
* **Hibernate**: Motor ORM para el mapeo objeto-relacional.
* **MySQL 8.0**: Motor de base de datos relacional.
* **Flyway**: Migraciones de base de datos.
* **Auth0 JWT**: Biblioteca para generación y validación de tokens.
* **Lombok**: Reducción de código repetitivo (Getters, Setters, Constructores).

## 🔐 Configuración de Seguridad e Inicio de Sesión
La API implementa un esquema de autenticación **Stateless**:
1. El usuario envía sus credenciales al endpoint `/login`.
2. El sistema valida las credenciales utilizando el hash **BCrypt** almacenado en la base de datos.
3. Se genera un Token JWT firmado con un algoritmo **HMAC256** y una fecha de expiración
4. Ejecuta la aplicación. Flyway detectará el esquema y aplicará las migraciones automáticamente.
5. Importante: Asegúrate de tener registrado un usuario en la tabla usuarios con la contraseña encriptada en BCrypt para realizar el primer login.

## 🧪 Endpoints Principales
* POST: 	   /login	Autentica un usuario y retorna el token JWT	Público
* GET:    	 /topicos	Lista todos los tópicos registrados	Privado
* POST: 	   /topicos	Registra un nuevo tópico	Privado
* PUT:  	   /topicos/{id}	Actualiza la información de un tópico existente	Privado
* DELETE:	   /topicos/{id}	Realiza la eliminación de un tópico	Privado
