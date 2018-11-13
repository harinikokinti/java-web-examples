tomcatdown
./gradlew clean build war
cp build/libs/java-web-examples.war /opt/tomcat/apache-tomcat-9.0.12/webapps
tomcatup
