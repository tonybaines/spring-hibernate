#!/bin/bash
# Clean up
STAGING_DIR=spring-hibernate-exercises
rm spring-hibernate.zip
rm -rf $STAGING_DIR
mkdir $STAGING_DIR

# Clean up and prepare the exercises
for exercise in $(ls -d exercise?)
do
    pushd $exercise
    echo "****** Preparing $exercise ******"
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

cp -a README exercise? $STAGING_DIR
# Zip the archive
zip -r spring-hibernate.zip $STAGING_DIR
rm -rf $STAGING_DIR
