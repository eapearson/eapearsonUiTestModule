#!/bin/bash

echo "Running async job with ${1}, ${2}, ${3}"
find .
# app in-file out-file token
java -jar server-0.1.0-SNAPSHOT-standalone.jar ${1} ${2} ${3}
