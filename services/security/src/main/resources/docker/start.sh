#!/bin/bash

./wait-for-it.sh mysqldb:3306 -t 60 \
    && exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar