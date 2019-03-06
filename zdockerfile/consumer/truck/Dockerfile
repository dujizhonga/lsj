FROM java:8

WORKDIR /home/apps/

COPY ./*.jar app.jar

RUN sh -c 'touch app.jar'

ENTRYPOINT [ "sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar -Xmx256m app.jar" ]