# Java Lab Pet Project
## Prerequisites
  
Before launching make sure you have [JDK 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) or JRE.

## Launch

1. Download a project. 
2. Create war file, go inside the project directory (outside the WEB-INF), then write the following in command line from that folder:
	```shell script
    jar -cvf school.war *
    ```
3. Install Tomcat, go to installed **tomcat/webapps** folder and paste school.war there.
4. Then go to **tomcat/bin** folder, start Tomcat by clicking startup.bat.
5. Put <code>localhost:port/project_name</code> in browser eg. <code>localhost:8080/school</code> (here my Tomcat run on port 8080)
