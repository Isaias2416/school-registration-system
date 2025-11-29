#!/bin/bash

find ./src/main/ -type f -name "*.java" >sources.txt

javac -d ./output/ @sources.txt

java -cp ./output/ com.school.app.Main
