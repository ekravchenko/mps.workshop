#!/bin/bash

./wait-for-it.sh config:8888 -t 120 \
    && exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /doctor.jar