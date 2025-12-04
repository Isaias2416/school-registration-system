#!/bin/bash

# Only use this script to run terminal version of this project.
# Use mvn clean install, then mvn javafx:run

find ./src/main/ -type f -name "*.java" >sources.txt

javac -d ./output/ @sources.txt

java -cp ./output/ com.school.app.Main
