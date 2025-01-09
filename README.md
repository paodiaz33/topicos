
# Proyecto Tópicos - Alura Latam

Este proyecto es una API REST para la gestión de tópicos, desarrollada con Spring Boot. La API permite registrar, listar, actualizar y eliminar tópicos, así como autenticar usuarios y manejar errores.

## Estructura del Proyecto
src/ ├── main/ │ ├── java/ │ │ └── med/ │ │ └── topico/ │ │ └── api/ │ │ ├── ApiApplication.java │ │ ├── controller/ │ │ │ ├── AutenticacionController.java │ │ │ ├── HelloController.java │ │ │ └── TopicoController.java │ │ ├── domain/ │ │ │ ├── Topico/ │ │ │ │ ├── DatosActualizarTopico.java │ │ │ │ ├── DatosListadoTopico.java │ │ │ │ ├── DatosRegistroTopico.java │ │ │ │ ├── DatosRespuestaTopico.java │ │ │ │ ├── status.java │ │ │ │ ├── Topico.java │ │ │ │ └── TopicoRepository.java │ │ │ └── usuarios/ │ │ │ ├── DatosAutenticacionUsuario.java │ │ │ ├── Usuario.java │ │ │ └── UsuarioRepository.java │ │ └── infra/ │ │ ├── errores/ │ │ │ └── TratadorDeErrores.java │ │ └── security/ │ │ ├── AutenticacionService.java │ │ ├── DatosJWTToken.java │ │ ├── SecurityConfigurations.java │ │ ├── SecurityFilter.java │ │ └── TokenService.java │ └── resources/ │ ├── application.properties │ └── db/ │ └── migration/ │ ├── V1__create-table-topicos.sql │ └── V4__create-table-usuarios.sql └── test/ └── java/ └── med/ └── topico/ └── api/ └── ApiApplicationTests.java

## Requisitos

- Java 17
- Maven
- MySQL

## Configuración

1. Clonar el repositorio.
2. Configurar la base de datos en el archivo [`src/main/resources/application.properties`](src/main/resources/application.properties):
    ```properties
    spring.datasource.url=jdbc:mysql://localhost/topicos
    spring.datasource.username=root
    spring.datasource.password=root
    ```
3. Ejecutar las migraciones de la base de datos con Flyway.

## Ejecución

Para ejecutar la aplicación, usar el siguiente comando:

```sh
./mvnw spring-boot:run
Endpoints
Autenticación
Autenticar usuario
URL: /login
Método: POST
Tópicos
Registrar un nuevo tópico

URL: /topicos
Método: POST
Request Body:
Response:
Listar tópicos

URL: /topicos
Método: GET
Query Params:
size (opcional, default: 2)
Response:
Actualizar un tópico

URL: /topicos
Método: PUT
Request Body:
Response:
Eliminar un tópico (lógico)

URL: /topicos/{id}
Método: DELETE
Response: 204 No Content
Obtener datos de un tópico

URL: /topicos/{id}
Método: GET
Response:
Hello
Saludo de prueba
URL: /hello
Método: GET
Manejo de Errores
Los errores son manejados por la clase TratadorDeErrores, que captura excepciones comunes y retorna respuestas adecuadas.

Seguridad
La seguridad está configurada en la clase SecurityConfigurations y se implementa mediante JWT. Los detalles de autenticación se manejan en AutenticacionService y TokenService.

Pruebas
Las pruebas se encuentran en ApiApplicationTests y se ejecutan con JUnit.

Contribuciones
Las contribuciones son bienvenidas. Por favor, abrir un issue o enviar un pull request.

Licencia
Este proyecto está licenciado bajo la Licencia Apache 2.0. ```