#Dockerfile para crear una imagen de un proyecto Java Spring Boot (descomentar segun la necesidad todos los comandos de cada bloque numerado)
#1/ Construccion hibrida o desacoplada.
######################################################################################################################################
# Utiliza una imagen base de Java, que debe ser compatible con la aplicacion
#FROM eclipse-temurin:17-jdk

# Establece el directorio de trabajo dentro del contenedor/imagen
#WORKDIR /home

# Copia el archivo JAR de tu aplicacion al contenedor. Para ello, habra que compilar el proyecto primero haciendo Maven install
#Usara el nombre que tiene en target o, si, como en este caso, se ha renombrado, el que se le haya puesto en este comando (app).
#COPY target/dockerDemo-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que escucha el proyecto (puerto 5000)
#EXPOSE 5000

# Comando para ejecutar la aplicacion Java.
#CMD ["java", "-jar", "app.jar"]
######################################################################################################################################
#2/ Compilacion y ejecucion en la misma imagen, que se realiza por etapas o stages.
#Para la compilacion de la aplicacion, 3.8.5-openjdk-17 es la etiqueta, sacada de Docker Hub
#FROM maven:3.8.5-openjdk-17 AS build
#WORKDIR /home
#COPY . /home
#RUN mvn -f /home/pom.xml clean package

#FROM eclipse-temurin:17-jre-alpine
#EXPOSE 5000
#COPY --from=build /home/target/*.jar app.jar
# sh es para que no de error al ejecutar el comando en el contenedor, ejecutando el comando en una shell. -c es para que se ejecute el comando como un string
#ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]
######################################################################################################################################
#3/ Compilacion y ejecucion en la misma imagen, que se realiza por etapas o stages. Pero esta vez, hacemos una primera compilacion
# con los archivos pom.xml, que es el que tiene las dependencias, y la clase DockerDemoApplication.java, que es la que tiene el main.
# Esto es para que no tenga que descargar todas las dependencias cada vez que se compila, sino solo la primera vez.
# En sucesivas compilaciones, solo se copiaran los archivos que han cambiado (se reutilizará el primer layer, que no habra cambiado), tardando menos debido a la utilizacion de la cache de Docker.
# Esto se hace porque normalmente, el pom.xml no cambia tanto como el resto de archivos del proyecto. Asi, si solo se cambia el codigo de la aplicacion, no es necesario volver a descargar todas las dependencias.
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /home
COPY ./pom.xml /home/pom.xml
COPY ./src/main/java/com/cursospring/dockerDemo/DockerDemoApplication.java /home/src/main/java/com/cursospring/dockerDemo/DockerDemoApplication.java
RUN mvn -f /home/pom.xml clean package

COPY . /home
RUN mvn -f /home/pom.xml clean package

FROM eclipse-temurin:17-jre-alpine
EXPOSE 5000
COPY --from=build /home/target/*.jar app.jar
ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]