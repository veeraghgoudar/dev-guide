# dev-guide
Introduction

The project provides a basic structure of Page object model framework for Selenium. It is also integrated with TestNG framework to run tests and generate Reports. The project uses maven to download the dependencies.


Software Requirements 

Operating system        Linux(Ubuntu), Windows 7, Windows 10
IDE						Eclipse
JAVA-version			jdk 8
Browser					Firefox, Chrome

Pre-requisites
Eclipse- Should have TestNG configured from the market place


Installation
1. Download the code from github.
2. Import as maven project in eclipse IDE.
3. Set java compiler version to 1.8

Running the project
1. From the file explorer navigate to src/main/java/ de.smava.config package. Verify the browser property in config.properties file. Default browser is set to firefox. Change the browser if required
2. From the project explorer, Right click on src/test/java
3. Select 'Run As TestNG Test'.
4. The tests will be executed and TestNG report will be generated in /test-output/index.html


Contributors
Name: Veeragh  Goudar
email: veeraghgoudar@gmail.com 
