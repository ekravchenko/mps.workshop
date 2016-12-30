FROM docker.base
EXPOSE 8888
ADD target/gateway.jar app.jar
ADD src/main/resources/docker/start.sh start.sh
RUN sh -c 'touch /app.jar'
RUN sh -c 'chmod u+x start.sh'
ENTRYPOINT ["./start.sh"]