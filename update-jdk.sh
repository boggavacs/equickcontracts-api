#!/bin/bash
echo "Updating JAVA_HOME and PATH for JDK 17.0.17"
echo "set JAVA_HOME - jdk folder path"
read -p "Enter the JDK installation path (e.g., /home/user/java/jdk17.0.17): " jdk_path
export JAVA_HOME=$jdk_path
export PATH=$JAVA_HOME/bin:$PATH
echo "JAVA_HOME is set to: $JAVA_HOME"
java -version