FROM docker.base
# download flyway CLI
ARG flyway_version=4.0.3
ARG flyway_gz=flyway-commandline-${flyway_version}-linux-x64.tar.gz
RUN wget https://repo1.maven.org/maven2/org/flywaydb/flyway-commandline/${flyway_version}/${flyway_gz}; \
    tar -xvzf ${flyway_gz}; \
    rm -rf ${flyway_gz}; \
    mv /flyway-${flyway_version} /flyway
# Add migration scripts
COPY src/main/resources/db/migration flyway/sql
# Add flyway config
COPY src/main/resources/docker/flyway.conf flyway/conf/flyway.conf
# Add scripts that will be executed on container start
COPY src/main/resources/docker/start.sh start.sh
RUN sh -c 'chmod u+x start.sh'
ENTRYPOINT ["./start.sh"]