#!/bin/bash

./wait-for-it.sh mysqldb:3306 -t 60 \
    && /flyway/flyway migrate