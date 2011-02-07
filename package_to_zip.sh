#!/bin/bash
# Clean up
PACKAGE=spring-hibernate-exercises
rm spring-hibernate.zip
rm -rf $PACKAGE
mkdir $PACKAGE

# Clean up and prepare the exercises
for exercise in $(ls -d exercise?)
do
    pushd $exercise
    echo "****** Preparing $exercise ******"
    echo ""
    rm -rf bin/
    rm -rf build
    rm -rf .settings/
    rm -rf .springBeans/
    
    if [ -e build.gradle ]; then
      rm -rf lib
      gradle clean copyToLib
      rm -rf .gradle/
    fi
    popd
done

cp -a README exercise? $PACKAGE
# Zip the archive
zip --exclude *.svn* -r $PACKAGE.zip $PACKAGE
rm -rf $PACKAGE
