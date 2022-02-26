# devops-git-project

General Use
1. Import the repository to your eclipse workspace.
2. Run the project on tomcat server.
3. Open up a web browser to access the localhost.

Jenkins
1. If you are unable to build the project, feel free to delete the test files and build the server first.
2. Add back the deleted testing files after building your server as the testing files require the Tomcat server to be running first.

Tomcat Server
1. Make sure your Tomcat server are running in the background when jenkins is building the project from git repository.

Maven Test
1. Make sure that your Tomcat server is running.
2. Run the maven test to activate the selenium testing.

Selenium Test
1. Make sure that your Tomcat server is running.
2. Right click on SeleniumTest file and run as TestNG to test the content of web application running on Tomcat server.

Junit Test
1. Right click on MaterialCollectionTest and run as Junit Test to test the use cases of material collection.
