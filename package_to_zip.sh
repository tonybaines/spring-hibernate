#!/bin/bash
# Clean up
gradle clean
rm spring-hibernate.zip
rm -rf spring-hibernate-exercises
mkdir spring-hibernate-exercises

# Clean up and prepare the exercises
for num in 1 2 3 4 5 6 7
do
    pushd exercise$num
    echo "****** Preparing exercise$num ******"
    echo ""
    rm -rf bin/
    rm -rf .settings/
    rm -rf .springBeans/
    
    if [ -e build.gradle ]; then
      rm -rf lib
      gradle clean copyToLib
      rm -rf .gradle/
      rm -rf build
    fi
    popd
done

cp -a README exercise1 exercise2 exercise3 exercise4 exercise5 exercise6 exercise7 spring-hibernate-exercises
# Zip the archive
zip -r spring-hibernate.zip spring-hibernate-exercises
rm -rf spring-hibernate-exercises
