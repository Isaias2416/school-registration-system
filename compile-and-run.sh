#!/bin/bash

find ./src/ -type f -name "*.java" >sources.txt

javac -d ./output/ @sources.txt

java -cp ./output/ com.school.app.Main
