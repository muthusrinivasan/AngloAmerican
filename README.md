# GoJek

Prerequisite
----------------
Maven and JDK 1.8 required.

Require below environment variables

export JAVA_HOME=$(/usr/libexec/java_home)

export M2_HOME=/usr/local/Cellar/maven/3.6.1/libexec

export M2=${M2_HOME}/bin

export PATH=${PATH}:${M2_HOME}/bin

To check installation
--------------------------
java -version

mvn -version

output should be installed version number

Technologies
------------------------------
Project is created with:
* Java
* Maven
* TestNG
* YAML
* Selenium

To run this project
-----------------------------
Change working directory to qa (base directory of project, you can find pom.xml)

from terminal run command,

"mvn install" to install all dependencies.

"mvn -test" to run test.

Test Result
------------------------
cd test-output

open ExtentReport.html

This will open test result in browser.

Project Structure
-------------------------
	qa
	|
	|-- src/test/java
	|		- common
	|			- Common.java
	|			- ReportHelper.java
	|		- pages
	|			- BasePage.java
	|		- test
	|			- BaseTest.java
	|			- Tests.java
	|-- config											
	|		- application.properties
	|   	- config.xml
	|-- Data
	|		- Data.yml
	|-- test-output
	|		- ScreenShots
	|		- ExtentReport.html
	|-- pom.xml
	|-- testng.xml
	|-- README.md	