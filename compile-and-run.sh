#!/bin/bash

# Use command below to run graphical version of app
# ./target/image/bin/java -m com.school.app/com.school.app.Main

# Use command below to run CLI version of app
find ./src/main/ -type f -name "*.java" >sources.txt

javac -d ./output/ @sources.txt

java -cp ./output/ com.school.app.Main
