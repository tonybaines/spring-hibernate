#!/bin/sh
# Clean up
gradle clean

# Get the libs
gradle copyToLib

# Copy the libs to the projects that need them
for num in 3 4 5 
do
    cp -a lib exercise$num
done

# Zip the archive
zip -r spring-hibernate.zip exercise1 exercise2 exercise3 exercise4 exercise5 .project .classpath lib src build.gradle