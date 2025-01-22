# Challenge Conversor de Monedas

Este es un proyecto desarrollado como parte del curso **Java Orientado a Objetos G7 - ONE** de Alura LATAM. El desafío consiste en crear una aplicación de consola en Java que permita la conversión de monedas utilizando una API de tasas de cambio.

## Descripción del Proyecto

El objetivo de este desafío es construir un conversor de monedas que realice las siguientes funciones:

- Realizar solicitudes a una API de tasas de cambio.
- Manipular datos JSON.
- Filtrar y mostrar las monedas de interés al usuario.

## Funcionalidades

La aplicación permite a los usuarios seleccionar entre varias opciones de conversión de monedas a través de un menú interactivo. Las opciones disponibles son:

1. Pesos argentinos (ARS) ==> Dólares americanos (USD)
2. Dólares americanos (USD) ==> Pesos argentinos (ARS)
3. Reales (BRL) ==> Dólares americanos (USD)
4. Dólares americanos (USD) ==> Reales (BRL)
5. Pesos chilenos (CLP) ==> Dólares americanos (USD)
6. Dólares americanos (USD) ==> Pesos chilenos (CLP)
7. Boliviano boliviano (BOB) ==> Peso colombiano (COP)
8. Pesos mexicanos (MXN) ==> Dólares americanos (USD)
9. Dólares americanos (USD) ==> Pesos mexicanos (MXN)
10. Pesos chilenos (CLP) ==> Pesos mexicanos (MXN)
11. Pesos mexicanos (MXN) ==> Pesos chilenos (CLP)
12. Salir

## Tecnologías Utilizadas

Para el desarrollo de esta aplicación se emplearon las siguientes tecnologías y conceptos:

- **Java**: Lenguaje de programación principal.
- **Scanner**: Para la entrada de datos del usuario.
- **HttpClient, HttpRequest, HttpResponse**: Para realizar consultas HTTP a la API de tasas de cambio.
- **GSON**: Para la conversión de respuestas JSON a objetos en Java.
- **Record**: Para la creación de estructuras de datos inmutables en Java.

## Requisitos

- Tener instalado **Java 17** o superior.
- Contar con una clave de acceso (API secret) válida para la API de tasas de cambio utilizada en el proyecto.

## Instalación y Uso

1. Clonar este repositorio:

   ```bash
   git clone https://github.com/mabimael700/challenge-conversor-monedas.git
   ```

2. Compilar el proyecto:

   ```bash
   javac -d bin src/*.java
   ```

3. Ejecutar la aplicación:

   ```bash
   java -cp bin Main
   ```

4. Introducir la opción deseada según el menú de consulta.

## Contribuciones

Las contribuciones son bienvenidas. Si deseas colaborar con mejoras o correcciones, puedes enviar un pull request o abrir un issue.

## Licencia

Este proyecto está bajo la licencia MIT. Puedes consultar el archivo LICENSE para más detalles.

---

*Desarrollado por Abimael Alexander Méndez Landero*

