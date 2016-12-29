FROM docker.base
EXPOSE 8080
ADD target/doctor.jar doctor.jar
ADD src/main/resources/docker/start.sh start.sh
RUN sh -c 'touch /doctor.jar'
RUN sh -c 'chmod u+x start.sh'
ENTRYPOINT ["./start.sh"]
