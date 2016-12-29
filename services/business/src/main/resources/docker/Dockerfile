FROM docker.base
EXPOSE 8080
ADD target/business.jar app.jar
ADD src/main/resources/docker/start.sh start.sh
RUN sh -c 'touch /app.jar'
RUN sh -c 'chmod u+x start.sh'
ENTRYPOINT ["./start.sh"]