FROM java:8
#install Spring Boot artifact
VOLUME /tmp
ADD MicroService1-1.0.1.jar /var/app/app.jar
#ENTRYPOINT
["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
CMD java -jar /var/app/app.jar