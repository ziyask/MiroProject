# ELM Test Assignment
###Task:
Create e2e test for cover functionality of sticker creation in Miro service.
Test case. Sticker creation functionality:
We have two users in Miro . Verify that the sticker which was created on a board by the
first user will appear on the board for the second user.

Steps:
1. As a “User1” I login into service and create a board with the name “Board”
2. As a “User1” I open “Board” and create there sticker(sticker widget), by using left
   toolbar
3. As a “User1” I invite “User2” to “Board” by using “Share” button on the top right
   corner
4. As a “User2” I login into service and open “Board”
5. As a “User2” I should see created sticker on “Board”

###Test Automation Prerequisites
Create Miro user1 and User2 for the E2E Test Script execution
Update the user credentials in Configuration.properties file before E2E Test script execution

###How to run the Test
Set Up Java on System
Set Up Eclipse IDE or Intellj IDE
Set Up Maven
Clone this GitHub Repository on your local machine
Import the project in your Eclipse IDE or Intellj IDE
Build the Maven project (download the required dependencies required E2E Test execution)
Update the Environment Configuration.properties file as mentioned above in Test Automation Prerequisites section
Run the Test 
1] Execute the test by right-clicking in the Cucumber-Test-Runner body and select Run As >> Java Application from below given path
src--> java --> CucumberTestRunner--> TestRunner.java
2] Run Cucumber Test from Command Line / Terminal
Open the command prompt and cd until the project root directory.
mvn clean test

###Environment Configuration
To start using this:
configs directory
The default required directory for configuration.properties files in configs under project root
Note