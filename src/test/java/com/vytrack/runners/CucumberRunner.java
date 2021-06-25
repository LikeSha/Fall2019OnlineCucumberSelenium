package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/vytrack/step_definitions",//right click step_definitions package-->copy path-->path from Source Root
        features = "src/test/resources",//right click feature package-->copy path-->Path From Content Root
        dryRun = false,
        strict = false,
        tags = "@sales_manager",// we can also say tags = "not @ driver"--> run everything except driver tag
        plugin = {            // tags = "@sales_manager" or @driver" we running both of them
                              // tags="@dashboard and @driver" runs scenario has both tags ONLY
                "html:target/default-report",// plugin= "html:target/cucumber-html-report" this line generate cucumber report
                "json:target/cucumber1.json",
                "rerun:target/rerun.txt"
        }

) // If you want to generate report ,you have to remove all tags ,set like this :tags="",
// report is inside target folder
public class CucumberRunner {


}

/*
April 11 ,2020

April 12 ---Holiday , no class

Cucumber itself doesn't run test ,it run with JUnit or testNG, it has to be on top of JUnit or testNG engine

to search your tag in feature file :  ctrl+shift+f, then typing your tag inside bar, it will show you where is used.


Tuesday--review excel + writing data into excel file.

   Agenda :
                BDD, TDD ,and DDT (DDT--one of THE MOST IMPORTANT DATA DRIVEN TESTING IN TESTNG)
                Cucumber BDD

                TDD ----TEST DRIVEN DEVELOPMENT
                BDD----BEHAVIOR DRIVEN DEVELOPMENT  ( this one is about agile method)

                TDD is about = unit testing
                BDD is about = How to write requirement document
                ################################################

Java ---to write a code
Intellij IDE ----Where we write a code
Maven ----project builder tool
Selenium WebDriver ----tool for automating web-based applications
TestNG ---unit ,system and e2e(end to end) testing framework
(unit test just targeting certain class ,or code to test.  e2e ---end to end testing)

Test Driven Development (TDD)--Developers write test first BEFORE they write functionality,
test first based on the requirement, then test ,if all tests passed, then developing later!
TDD is about unit testing .In case of TDD , we are dealing with raw code.

Behavior Driven Development (BDD)   BDD is about how to process requirement documents,
how to write them. In case of BDD/BDT = its about testing the functionality from end-user perspective.
So we are not dealing with raw code.BDD it's about UI point of view

Behavior Driven Testing(BDT)

They are both about development and  automated testing  ( unit test is automated testing )

In both cases , tests will be written before development process

In case of TDD , we are dealing with raw code.

In case of BDD/BDT = its about testing the functionality from end-user perspective.
So we are not dealing with raw code.

BDD it's about UI point of view  test scenario will be written BEFORE CODE IMPLEMENTATION!

BDD != TDD

Java unit testing tools/frameworks : TestNG and JUnit

To implement BDD in our test automation framework we gonna use Cucumber BDD

https://cucumber.io/    official site
mvnrepository.com  to find all dependencies ___search cucumber ---> choose Cucumber JVM :Junit

New project : in IntelliJ click file ---- new ---project then add :
<properties>
        <maven.compiler.source>12</maven.compiler.source>
        <maven.compiler.target>12</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <configuration>
                    <source>12</source>
                    <target>12</target>
                </configuration>
            </plugin>
        </plugins>
    </build>


    dont forget add cucumber plugins: hit shift twice on keyboard,
    then search " Gherkin" and "Cucumber for Java"   total we need these 2 plugins.


     Right click on src/test/java:
        create a package : com.vytrack.pages

     Right click on vytrack -->new -->package:
        utilities
        runners
        step_definitions

    right click on src/test-->new-->directory-->resources
    right click on resources folder --> mark as --> test resources root folder
    right click on src/test/resource-->new-->directory-->features

    //@RunWith => comes from Junit. It allows to have custom test configuration
//cucumber has it's own flow to run test - during runtime turns into executable test
//@CucumberOptions => stands for parameterization for test execution
//glue => trigger of cucumber test.
Runner class needs to know where are step definition and feature file
//path to step definition, right click on step_definitions - copy from source root
//features => specifies path to the feature files right click on features - copy from content root

package com.vytrack.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/vytrack/step_definitions",
        features = "src/test/resources/features"

)
public class CucumberRunner {


}
 ##############These 2 parameters are mandatory!!!####################

glue--path to the package with step definition methods:
right click step definition-->copy-->copy path-->copy from source root"

features - path to the folder/directory with feature files.
 right click feature file ,click" copy" or right click " copy path-->
 then select " copy from content root"

REMEMBER!! DON'T ADD SUBSTEPS PLUGIN!! IF YOU HAVE IT --- DELETE IT !!

You need 2 plugins :

Cucumber for Java ---by JebBrains
Gherkin           ---By JetBrains

After installation, restart IntelliJ

then, all your feature files will have a green icon

if feature file icon is blue ---delete substeps plugin

if feature file icon is gray, even after installing plugins :

Check Settings-->Editor-->File Types.
Verify that Cucumber Scenario is set to a Registered Pattern of *.feature.

command + option + esc ----force quit some program
control + alt + delete ---right on program --->end task

How do we create feature files??


Right click on the features directory --> new --> file --> *.feature

#### User Gherkin by JetBrains


There is a chance that you intellij version is too old, and plugin cannot be installed.
So you need to update intellij first.

1. Create a feature file.
2. Write scenario
3. Go to runner class and perform dry run
4. Copy from terminal unimplemented step definitions and paste them in step definition class.


You can implement missing steps with the snippets below:

@Given("user is on the login page")
public void user_is_on_the_login_page() {
// Write code here that turns the phrase above into concrete actions
throw new io.cucumber.java.PendingException();
}

@When("user logs in as a sales manager")
public void user_logs_in_as_a_sales_manager() {
// Write code here that turns the phrase above into concrete actions
throw new io.cucumber.java.PendingException();
}

@Then("user should verify that title is a Dashboard")
public void user_should_verify_that_title_is_a_Dashboard() {
// Write code here that turns the phrase above into concrete actions
throw new io.cucumber.java.PendingException();
}



Process finished with exit code 0



WARNING: No features found at - path to feature files folder in the cucumber runner class is not correct.

dry Run - to make sure that every test step has a code implementation.
If no, cucumber will throw step definition snippets into console.


DELETE ALL COMMENTS FROM FEATURE FILE FOR NOW


If some steps don't have a code implementation yet, cucumber will throw:

io.cucumber.junit.UndefinedStepException Some step is undefined.
You can implement it using the snippet(s) below:


If you already implemented steps and performing dry run,
cucumber will show you that scenarios were skipped.

strict - true if undefined and pending steps should be treated as errors.

dryRun - true if glue code execution should be skipped.

dryRun = false - execute test
dryRun = true - DON'T execute test, check if every step is implemented.

Remove pending exception from auto-generated step definition.


make sure that you don't have step definitions with the description. Otherwise,
cucumber will throw some kind of exception: ambiguous step definitions


Update intellij and update all plugins then latest cucumber version will work fine.



How do we create feature files??

Right click on the features directory -->new-->file-->*.feature
we store our test cases into feature file ,or we can say .feature file used to store BDD test scenarios.
inside feature file, we don't write java code inside feature file,only plain English text,
every test scenario consist of test steps. every test step has a coding implementation,
it calls step definition.. Inside step definition ,we write extra codes

#### User Gherkin by JebBrains

There is a chance that you intellij version is too old, and plugin cannot be installed .
So you need to update intellij first.


########################################################################################################

How do we start testing our project using cucumber framework ?

steps :

1, set up all framework well first ,( crate packages: pages, runnders, step_definitions,utilities,
.gitignore,configuration.properties...)

2, we first thing go to runners package, and create CucumberRuner class.

    in side @CucumberOptions ()  how to glue step_definitions package ?
    // right click step_definitions package-->copy path-->path from Source Root

 features : this specify the feature files.
 // right click feature package-->copy path-->Path From Content Root

3, create feature file : under feature package ,
right click folder --> new --> file --> Login.feature ( every feature file must have .feature extention)

4, then we write feature and scenario in the file, for example,
I just write a scenario : Login as sales manager and verify that title is Dashboad
    and I put Given ,When, Then conditions under this scenario already, what is the next ?
    how to implement this scenario into code ?

5, we go to CucumberRunner class, inside CucumberOption block,
under features = "src/test/resources/features" we added a line :
   dryRun = true,
   ( we set dryRun = true is because we need to cucumber generate code implementation snippet to us ,
   so that we can copy paste it to our step_definition class.)

   then right click " CucumberRunner class" , click" run CucumberRunner class" ,
   then the implementation codes showing up on the console. it contains 3 snippets, Given ,When ,Then
   correspondence to our scenario " Login as sales manager and verify that title is Dashboad" in Login feature .

6, so what we will do now ? we copy all of them ( 3 of them)  .
then go to --> LoginStepDefinitions class ---> paste them .

7, delete all content inside these three methods that cucumber generated for us .
and write our own codes inside ,

8, after code done, go back to CucumberRunner class ,make dryRun = false. so we can run the test.
   to run the test ,just click run button on CucumberRunner class.




Today is April 15, 2020
    Agenda:
        Cucumber BDD recap
        dryRun recap
        tags
        hooks (before and after hooks)
######################################

    BDD - behavior driven development,
    methodology that is used to write requirement documents from end-user perspective.
    SO business (BAs, POs, Devs and Testers) can seat together and
     discuss requirements that are written in the plain text.

    BDD helps to fill the gap between business and technical teams.

    Business requirements will be written as a user story.
    Every story starts like: As user, I want to be able to....
    User story contains acceptance criteria and it defines how feature should behave.
    Basically, what feature should be able to do and what not.

    We as testers, develop test automation scripts based on user story acceptance criteria.

    What are the steps:

        1. Read and analyze user story. If needed, ask questions during grooming sessions.
        Or, we can ask questions any time, not only during the meetings.

        2. Write feature file/files with test scenarios.

        3. Dry run - to generate step definitions.

        4. Place step definition methods into step definition classes.

        5. Allocate all required web elements and develop required methods
        for interaction with those elements.

        6. Create page objects in the step definition classes and use them
        to provide code implementation for every test step. Every step (phrase) defines it's behavior.

        7. When everything is done, generate HTML report and push the code to github,
        from your branch, and create a pull request for code review.

        8. When review is completed, you can move your task from in progress/review to done column
        in Jira board.

How do we implement BDD in test automation?
    We use Cucumber BDD.
    For test cases, we create .feature files. Every feature file consists of test scenarios.
    Every test scenario consists of test steps. Every test step has to start with gherkin keyword:
    -Given
    -When
    -Then
    -And
    -But

    Also, feature has a description:

    Feature: Create a car
            As user, I want to be able to add new cars.
    Scenario: 1. Add some car
        Given user is on the login page

Cucumber BDD book: https://www.amazon.com/Cucumber-Java-Book-Behaviour-Driven-Development-ebook/dp/B00V20IEXM/ref=sr_1_3?dchild=1&keywords=cucumber+bdd&qid=1586993955&sr=8-3

Then, composition of cucumber framework:
    pages               page classes
    runners             cucumber test runners. We need them to execute feature files

        @RunWith(Cucumber.class)
        @CucumberOptions(
           glue = "com/vytrack/step_definitions",      path to step definitions
           features = "src/test/resources/features", path to the folder with feature files
           dryRun = false,  true - to generate unimplemented step definitions before real test execution.
           strict = true - enforce step definition implementation
                )

           public class CucumberRunner {

                }
                You can also specify path to only one specific feature file:
                features = "src/test/resources/features/Login.feature",
                Or, path yo group of feature files:
                features = {
                            "src/test/resources/features/Login.feature",
                            "src/test/resources/features/CreateCar.feature"
                            }
                This approach is useful for minor regression. When you need to test not entire system,
                just some component or couple of them.

    step_definitions
         simple java classes, where we keep code implementation of test steps.

          //Login.feature file
         @When("user logs in as a sales manager")       -> When user logs in as a sales manager
         public void user_logs_in_as_a_sales_manager() {
            System.out.println("Login as sales manager");
            loginPage.login("salesmanager110", "UserUser123");
         }
         based on the description on top of the method,
         cucumber links step definitions with test steps in feature file.
    utilities
            reusable code
    features
            .feature

What if we want to run specific scenario?
    for this, we can use tags.
  @driver
  Scenario: Login as driver and verify that title is a Dashboard
    Given user is on the login page
    When user logs in as a driver
    Then user should verify that title is a Dashboard

  @driver - it's a tag.

we use tags to run specific scenarios and ignore others.
Or opposite, ignore specific scenarios and run others.

@CucumberOptions(
        tags = "@driver"   <--- to run scenarios that have this tag only.
)
tags = "not @driver" - run everything, except scenarios that have this tag.

In old cucumber version, it was like this:
    tags = "~@driver"

tags = "@driver"     - run scenarios only with this tag
strict - true - to mark unimplemented step definitions as errors.

To run scenarios, that have either or tags.

    tags = "@sales_manager or @driver"

To run scenarios, that have both tags

    tags = "@sales_manager and @driver"

failed to parse feature file means that syntax in feature file is wrong.

tags for specific setup
application version where this feature is present
tag with bug number, @know_issue @BUG_VYT4311. To label scenarios with known bugs.

@know_issue

tags = "not @know_issue"
To quickly verify that all bugs were fixed, run scenarios with the tag:
tags = "@know_issue"
It will work only if you previously labled scenarios that were reported as a bug.
#######################
In TestNG, we used @BeforeMethod and @AfterMethod to execute some code before and after every test scenario.
In cucumber, we have hooks for exactly same purpose.

How to create a hook?
it's just a public void method with @Before or @After annotations.
@Before hook - runs automatically BEFORE every test scenario.
@After  hook - runs automatically AFTER every test scenario.

What do we put into @Before hook ?
    some code to setup a connections (api, db, ssh, etc..), maximize window, etc...

What do we put into @After hook?
    some code to close connections, close browser, etc...
    also, to take a screenshot in case of test failure.

Where do we store hooks?
    We usually keep under step_definitions package. We can crate a separate class that calls Hooks
package com.vytrack.step_definitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
public class Hooks {
    @Before
    public void setup(){
        System.out.println("Test setup");
    }
    @After
    public void tearDown(){
        System.out.println("Test clean up");
    }
}
plugin = "html:target/cucumber-html-report" - will generate cucumber HTML report
mvn dependency:tree - download all dependencies.
    @Before("@driver")
    public void specialSetup(){
        System.out.println("Setup for driver only");
    }
    @After("@driver")
    public void specialTearDown(){
        System.out.println("Tear down for driver only");
    }

We can create hooks that will be running only for specific scenarios, based on tags
Hook without any tags will still executed for every single scenario.

We can change order of hooks priority
    @Before(order = 2)
    public void setup(){
        System.out.println("Test setup");
        Driver.getDriver().manage().window().maximize();
    }
    @Before(value = "@driver", order = 1)
    public void specialSetup(){
        System.out.println("Setup for driver only");
    }
Lower number - higher priority.
cucumber is not autonomous. it has to work along with junit or testng.
Like in any car there is an engine and transmission
(except electric cars, I know someone will tell me this).


 */

/*
April 18 2020

   Agenda :

      Cucumber Parameters-->string and integers
      Backgroud
      HTML Report
      Data tables

      //command + shift + f => to deep search where tags (activities) is used

      //our framework creates json file, some plugin takes jason file
      and generates a nice HTML report
//json looks like plain text, has "properties,values" , arrays,Strings,integers,
//json object vs java object
//json object has only properties no method; java object has both properties and methods
//We add json plugin => "json:target/cucumber.json" => to let it generate by our framework

data table when we first time create scenario in feature.:

@Then("user verifies new calendar event was created successfully")
    public void user_verifies_new_calendar_event_was_created_successfully(Map<String,String> dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();

        Agenda:
         Background
         Parameters --> strings and integers
         Maven Cucumber HTML Report
         Data tables
################################
    Background - common steps for all scenarios in one particular feature file.
    Similar to @Before hook, but not the same.

    For example:

  @sales_manager
  Scenario: Login as sales manager and verify that title is Dashboard
    Given user is on the login page
    When user logs in as a sales manager
    Then user should verify that title is a Dashboard

  @store_manager
  Scenario: Login as store manager and verify that title is Dashboard
    Given user is on the login page
    When user logs in as a store manager
    Then user should verify that title is a Dashboard

  @driver @dashboard
  Scenario: Login as driver and verify that title is a Dashboard
    Given user is on the login page
    When user logs in as a driver
    Then user should verify that title is a Dashboard

With a background, it will look like this:

Background: open login page
    Given user is on the login page

@sales_manager
  Scenario: Login as sales manager and verify that title is Dashboard
    When user logs in as a sales manager
    Then user should verify that title is a Dashboard

  @store_manager
  Scenario: Login as store manager and verify that title is Dashboard
    When user logs in as a store manager
    Then user should verify that title is a Dashboard

  @driver @dashboard
  Scenario: Login as driver and verify that title is a Dashboard
    When user logs in as a driver
    Then user should verify that title is a Dashboard

Order of execution:

    Before hook --> Background steps --> Scenario --> After hook

If hook applies on all feature files,
Background will be applied only for the feature file where it was declared.

Background - can take as many steps as you need.

Usually, it's used when you are keep repeating Given step in some feature file.

In Jira Xray, Background is equals to Precondition.

############################################################################

Anything in double quotes becomes a parameter (string).

#In feature file
    When user enters "storemanager85" username and "UserUser123" password

#In step definition class
    @When("user enters {string} username and {string} password")
    public void user_enters_username_and_password(String string, String string2) {

    }

string - will have value "storemanager85"

string2 - will have value "UserUser123"

Once we have implemented steps, we can change values in double quotes. Because - it's a parameter.
%s - string

order is from left right always!

Step definitions independent from steps; can be reused by other scenarios as well.
Cucumber goes into steps and then goes to

step definitions looks for matching steps.
Cucumber take step definitions as blocks.
But for same step 2 different implementation is not possible !!

sometimes, webdriver performs text input very slow. To fit it, we use explicit wait:

wait.until(ExpectedConditions.attributeToBe(element, "value", text));

value attribute stores text input, so we just wait until it will receive entire text input.

for example, in our test case ,we have this :
 public void enterCalendarEventTitle(String titleValue) {
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(title)).sendKeys(titleValue);
        wait.until((ExpectedConditions.attributeToBe(title,"value",titleValue)));
    }

    public void enterCalendarEventDescription(String description) {
        BrowserUtilities.wait(5);
        BrowserUtilities.waitForPageToLoad(20);
        //wait until frame is available and switch to it
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(descriptionFrame));
        descriptionTextArea.sendKeys(description);
        wait.until(ExpectedConditions.textToBePresentInElement(descriptionTextArea,description));
        driver.switchTo().defaultContent();//exit from the frame
    }

System.out.printf("User clicks on the %s tab and navigates to %s module\n",tab,module);
printf--formatted print

#################################################

JavaScript Object Notation (JSON, pronounced /ˈdʒeɪsən/; also /ˈdʒeɪˌsɒn/[note 1])
is an open standard file format, and data

interchange format, that uses human-readable text to store and transmit data objects
consisting of attribute–value pairs and array data types (or any other serializable value)

JSON - javascript object notation. Contains only properties, objects and collections.
There is no methods. Very popular type of document to transmit information between 2 programs -->
used for API.

JSON natively supported by javascript, because it derives from it.

Java as well as other languages have lots of libraries that allow to work with JSON files.

JSON - looks like a plain text file.
    {
        property: value
    }

Example of simple JSON file.
    {
        user: [
            name: "John"
            age: 25
            jobTitle: "SDET"
        ]
    }

Cucumber, is able to generate JSON report. Then, that json file,
can be used by 3rd party plugins to generate some fancy HTML report. (not that ugly as default one)

One of the most popular is Maven Cucumber HTML report. To add it,
we just need to insert it into pom.xml file as a plugin.

github of the report: https://github.com/damianszczepanik/maven-cucumber-reporting
we need to add maven-surefire plugin, to execute our tests with maven command.
to generate report, we need to run verify maven goal.

either:

mvn verify
or from intellij --> maven --> life cycle --> verify

also, clean before running tests:
mvn clean verify

clean - to delete target folder.

report will be generate only with verify goal. If you will run CucumbeRunner class manually,
this report won't be generated.

mvn clean verify -q

-q - quite execution. minimizes maven console log

If mvn command gives error, that means maven is no installed. Still you can use maven from intellij,
but you won't be able to use outside of intellij, as CLI tool.

How to run our test in intelliJ using maven to generate JSON cucumber report ?
1, go to our runners class, and set tags=""
2, make sure dryRun = false, strict = false,
3,in terminal we run this command : mvn clean verify ( this is when you have maven installed )
  if you don't have maven installed ,just click " clean" on the right side of intelliJ under" Maven"
  we do this is that we want to delete current target folder first ,so that we can see clearly the new reports
  going to generated soon.

4,  then, click "verify" in Maven to execute the tests and generate JSON(cucumber.json report) report.
   it will only generate report when you click " verify" under Maven in intelliJ.
##############################################

Cucumber Data Table - is used to extend test step. It allows to attach table to test step.

Cucumber data table:
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.

1 column - List<String>

2 columns - Map<String, String> - where keys will be always on the left, and values on the right.

2+ columns - List<Map<String, String>> - where keys will be always on the first row.

2+ columns - Map<String, List<String>>

If you specified data type as a Map, use get("keyName") to read values:
        dataTable.get("description");
        dataTable.get("title");

By default, any step definition method with data table will have a parameter - io.cucumber.datatable.DataTable dataTable;

DataTable - data structure from Cucumber BDD.
Can be transformed into something more commonly used like: List, Map, List<Map>, etc..
depends on how many columns do you have in the data table.
Don't use DataTable, change it to something else....
if you specify non-existing key name, you will get - NULL.
make sure, that key name is correct.

#########################################

    Background - common steps in the beginning

    Parameters - used to make test steps more flexible.
    To provide a parameter surround some phrase with double quotes,
    then it will be injected into step definition as a parameter.

    Cucumber HTML report - 3rd party reporting plugin,
    not officially developed by cucumber team. To use it,
    add plugin into pom.xml file.
    Make sure you also have maven-surefire/maven-failsafe plugin to trigger CucumberRunner class.
    Also, don't forget to specify in runner class json report:

    "json:target/cucumber.json"
    to get the report, execute verify maven goal.

    Data table
        is used to extend some test step. It allows to fit more test data into one step.
        Data will stored as a table. Values reside in between pipes |values|.
        Tomorrow, we will continue data tables.

        in intelliJ, if you wanna remove the target folder after test ,
        just click "clean" on the right side " Maven" tag, under "Lifecycle" ,
        so the target folder cleaned up .no more ! then click "verify" to run the test,
        then go find out report under target folder --> cucumber html reports--> right click" overview-featrues.html

about tags :

if you put the tag on the top of Feature , means on the super top of the page, it means, this tag will
run entire feature file, if you place the tag on a top of specific scenario, when you call the tag in
runner class, it only run this specific scenario. example like below :

@activities
Feature: Create calendar event
  As user, I want to be able to create calendar events.

  Scenario: Create calendar event as sales manager
    Given user is on the login page
    When user logs in as a sales manager
    And user navigates to "Activities" and "Calendar Events"
    Then user clicks on create calendar event button
    And user enters "On this meeting we discuss what went well, what went wrong and what can be improved" as a description
    And user enters "Sprint Retrospective" as a title
    Then user click on save and close button
    And user verifies that description of new calendar event is "On this meeting we discuss what went well,
    what went wrong and what can be improved"
    And user verifies that title of new calendar event is "Sprint Retrospective"


  @create_calendar_event_2
  Scenario: Create calendar event as sales manager with data table
    Given user is on the login page
    When user logs in as a sales manager
    And user navigates to "Activities" and "Calendar Events"
    Then user clicks on create calendar event button
    And user enters new calendar event information:
      | description | On this meeting we discuss what went well, what went wrong and what can be improved |
      | title       | Sprint Retrospective                                                                |
    Then user click on save and close button
    And user verifies new calendar event was created successfully
      | description | On this meeting we discuss what went well, what went wrong and what can be improved |
      | title       | Sprint Retrospective                                                                |

the above entire Feature file will run if you call "activities"  tag in runner class

pay attention : printf to print parameter related content ,for example

 @When("user navigates to {string} and {string}")
    public void user_navigates_to_and(String tab, String module) {
        System.out.printf("User clicks on the %s tab and navigates to %s module\n",tab,module); //printf
        loginPage.navigateTo(tab,module);

to search your tag in feature file :  ctrl+shift+f, then typing your tag inside bar, it will show you where is used.

 */

/*
April 19,2020  data table topic

   watch a 20 minutes short video about how to create cucumber project in slack .

   https://learn.cybertekschool.com/courses/283/pages/create-cucumber-project?module_item_id=21707

   TDD: Creating Unit Test before writing the actual code.

   Data tables in Cucumber
   Scenario Outline--> Data Driven Testing 9similar to @DataProvider in TestNG)

   ########################################################################################

   Data tables in cucumber simply used to extend test step.

   When user logs in as "driver" | value in double quotes is a parameter

   When user logs in as "admin"--> @When(user logs in as {string})
                                    public void user_logs_in_as(String String){
                                      //turn this phrase into action

                                    }

    Then user creates a new car with "testplates" car plates and "black" color "Toyota" make, "Camry"
    model

    @Then (user creates a new car with {string} car plates and {string} color {string} make, {string} model)
    public void user_creates_a_new_car_with_car_plates and _color_make_model(String string, String string,
    String string3, String string4){

    }

    Data table can make it look better and expand test step:

    Then user creates a new car with following info:
      |car plates |testplates |
      |color      |black      |
      |make       |Toyota     |
      |model      |Camry      |

        key         Value

      default step definition method:

      @Then(user creates a new car with following info:)
      public void user_creates_a_new_car_with_following-info(DataTable dataTable){

      }

      we can change DataTable to something else,
      so cucumber will automatically transform it into some other data structure.

      #AFTER---we changed DataTable into the Map

      @Then("user creates a new car with following info:")
      public void user_creates_a_new_car_with_following_info(Map<String,String> data){
         dataTable.get("color");-->black
         dataTable.get("car_plates")-->testplates
      }

      Remember : Data table must be specified immediately after the test step

      Can we have multiple data tables in one scenario?

         YES !


      Given user logs in with following credentials:
      |username|stroemanager85|
      |password|UserUser123   |

      Then user creates a new car with following info:

      |car plates |testplates |
      |color      |black      |
      |make       |Toyota     |
      |model      |Camry      |

      If values were modified in scenario, it will affect on step definition.
      Step definition gets data from the scenario.

      Can we have 3 or 4 columns?

         yes !

         How to manage step definition with more than 2 cloumns in the test step?

      Then user creates a new car with following info:

      |car plates |color      |make  |model| <-----------always reserved for key names(List<Map<String,String)>>)
      |sdet       |red        |Toyota|Camry| 0
      |driver     |purple     |Mazda |RX8  | 1
      |racer      |blue       |Lincoln|MKS | 2

      @Then("user creates a new car with following info:")
      public void user_creates_a_new_car_with_following_info(List<Map<String,String> data){

          data.get(0)-->get data from first row(skipping column names)
          data.get(0).get("color")-->red
          data.get(1).get("make")--Mazda
      }

     to line up feature file, use option + command + L(for Mac), windows users Control +Alt + L



    datatype goes inside the curly braces.(all double quotes content is datatype and goes into curly braces)

    Scenario: User permissions
    Given I login as a "sales manager"
    When I navigate to "Activities""Calendar Events"
    Then View Per Page menu should have following options
    |10|
    |25|
    |50|
    |100|

   As you know ,if it is only one column in data, best selection is List
   as for List, the first value is always value itself. How Cucumber knows this ?
   Cucumber has its rules to identify the data structure, if Cucumber identify there is only one column,
   it will take each value as value itself. Because List doesn't require any column name.

   List is the data structure that values are referenced by index, not by Key name
   Map is the data structure that values are referenced by Key
   the example is as following methods

   if it is a two columns dataTable, Cucumber takes it as Map structure , and
   we choose Map<String,String>, the Key always on the left side ,the value is on the right side.

   if it is a multiple column table, Cucumber automatically take is as List of Map
   (List<Map<String,String> data)
   it doesn't matter how many rows you have ,the first row always the column names,
   and start from the second row , its values



    #Before



@Then("View Per Page menu should have following options")
public void view_per_page_menu_should_have_following_options(DataTable dataTable){

}

   #After

    @Then("View Per Page menu should have following options")
    public void view_Per_Page_menu_should_have_following options(List<String> dataTable){
         dataTable.get(0)-->"10"
         dataTable.get(1)-->"25"
         dataTable.get(2)-->"50"    this collection gonna be String type
         dataTable.get(3)-->"100"


    }

    @Then("View Per Page menu should have following options")
    public void view_Per_Page_menu_should_have_following options(List<Integer> dataTable){
         dataTable.get(0)-->10
         dataTable.get(1)-->25
         dataTable.get(2)-->50    this collection gonna be Integer type
         dataTable.get(3)-->100


    }


    Scenario: User permissions
    Given user is on the login page
    When user navigates to "Activities" and "Calendar Events"
    Then View Per Page menu should have following options
    | 10 |
    | 25 |
    | 50 |
    | 100|

    Failed to execute goal net.masterthought:maven-cucumber-reporting:4.8.0:generate (default-cli) on project Fall2019OnlineCucumberSelenium: The parameters 'jsonFiles' for goal net.masterthought:maven-cucumber-reporting:4.8.0:generate are missing or invalid


You will get this error when there is no matching .json reports in the target folder.

please see the automation class day 31, 04.19.2020 classNote.


April 21,2020 regular class

Agenda : Scenario Outline

scenario Outline is GOOD FOR SMOKE TEST !

###################

Scenario Outline is used for data driven testing.Whenever you have couple of scenarios with
exactly same test steps but different test data, use scenario outline.

################
 Scenario Outline is used for data driven testing.
 Whenever you have couple of scenarios with exactly same test steps but different test data, use scenario outline.

 Scenario Outline must be followed by Examples table

 To use values from the table, specify parameter name in between angled brackets <name>
 One scenario outline can have couple examples tables
 As many rows of records you have in examples table, as many times scenario outline will be execute

 Every row in examples table represents some test case
 Scenario Outline can be used only when group of tests have same steps but different test data

 Scenario Outline: User names test
    Given user is on the landing page
    When user enters "<username>" username and "<password>" password
    Then user name should be "<name>"
    Examples:
      | username        | password    | name             |
      | user187         | UserUser123 | Jerel Vandervort | 1
      | user200         | UserUser123 | Lonzo Leuschke   | 2
      | storemanager52  | UserUser123 | Roma Medhurst    | 3
      | storemanager66  | UserUser123 | Carlos Ernser    | 4
      | salesmanager125 | UserUser123 | Cleveland Heller | 5
      | salesmanager140 | UserUser123 | Jameson Paucek   | 6

Whenever we want to use steps, we need to use "" (double quote), this is explained example table
why we need to put "<username>" and "<password>" and "<name>" inside double quote,we repeatedly
use those parameters in our test steps. it means we only use double quote when we use it in step definition

#  Test + DataProvider = Scenario Outline + Examples table

Scenario: 1. User names test
    Given user is on the landing page
    When user enters "user187" username and "UserUser123" password
    Then user name should be "Jerel Vandervort"
Scenario: 2. User names test
    Given user is on the landing page
    When user enters "user200" username and "UserUser123" password
    Then user name should be "Lonzo Leuschke"
Scenario: 3. User names test
    Given user is on the landing page
    When user enters "storemanager52" username and "UserUser123" password
    Then user name should be "Roma Medhurst"
Scenario: 4. User names test
    Given user is on the landing page
    When user enters "storemanager66" username and "UserUser123" password
    Then user name should be "Carlos Ernser"
Scenario: 5. User names test
    Given user is on the landing page
    When user enters "salesmanager125" username and "UserUser123" password
    Then user name should be "Cleveland Heller"
Scenario: 6. User names test
    Given user is on the landing page
    When user enters "salesmanager140" username and "UserUser123" password
    Then user name should be "Jameson Paucek"

Examples is required by Scenario Outline. Wheres data table,
is optional and used to expand some test step. Basically, to fit more test data into one test step.

@scenario_outline_2
Feature: Login tests with Scenario Outline
  Scenario Outline: Go to <module> and verify title: <title>
    Given user is on the login page
    When user logs in as "<user_type>"
    And user navigates to "<tab>" and "<module>"
    Then user verifies that page title is "<title>"
    Examples:
      | user_type     | tab        | module          | title                                                              |
      | driver        | Fleet      | Vehicles        | Car - Entities - System - Car - Entities - System                  |
      | driver        | Fleet      | Vehicles Model  | Vehicles Model - Entities - System - Car - Entities - System       |
      | driver        | Customers  | Accounts        | Accounts - Customers                                               |
      | driver        | Customers  | Contacts        | Contacts - Customers                                               |
      | driver        | Activities | Calendar Events | Calendar Events - Activities                                       |
      | driver        | System     | Jobs            | Jobs - System                                                      |
      | sales manager | Fleet      | Vehicles        | All - Car - Entities - System - Car - Entities - System            |
      | sales manager | Fleet      | Vehicles Model  | All - Vehicles Model - Entities - System - Car - Entities - System |
      | sales manager | Customers  | Accounts        | All - Accounts - Customers                                         |
      | sales manager | Customers  | Contacts        | All - Contacts - Customers                                         |
      | sales manager | Activities | Calendar Events | All - Calendar Events - Activities                                 |
      | sales manager | System     | Jobs            | All - Jobs - System                                                |
      | store manager | Fleet      | Vehicles        | All - Car - Entities - System - Car - Entities - System            |
      | store manager | Fleet      | Vehicles Model  | All - Vehicles Model - Entities - System - Car - Entities - System |
      | store manager | Customers  | Accounts        | All - Accounts - Customers                                         |
      | store manager | Customers  | Contacts        | All - Contacts - Customers                                         |
      | store manager | Activities | Calendar Events | All - Calendar Events - Activities                                 |
      | store manager | System     | Jobs            | All - Jobs - System                                                |



scenario Outline is GOOD FOR SMOKE TEST !

*/

/*
April 22,2020 Regular class

   Cucumber review

       -tags
       -background
       -data tables
       -scenario outline

       Gherkin language -- is used to write BDD scenarios

   The biggest challenge is to understand environment ( Vysyl said so)

       -


   ############################################


   Agenda:
    Cucumber review
        - tags
        - background
        - data tables
        - scenario outline
        - hooks
        - runners
        - step definitions
        - report
        - annotations
        - feature

##################

    Gherkin language - is used to write BDD scenarios.

    Keywords:
        Given
        When
        Then
        And
        But
        Background
        Scenario
        Scenario Outline
        Examples

Test data - is stored in feature files. We use parameters, data tables,
examples table to store test data in feature files.

Who provides test data?
 1. yourself.

 2. If you are responsible only for automation, and test cases are written by manual testers,
 then they give you ready test with all steps and test data.

 3. developers can give you too

 Background - we use to reduce number of same steps.
 If all scenarios in same feature file have common beginning steps, we can put them under background.

Scenario = test = test case = test method (TestNG)
locators can be stored in page classes, in interfaces, and in property files.

Scenario Outline vs Scenario
Scenario = runs only once
Scenario Outline = runs as many times as many rows of test data in examples table
Scenario Outline - used for data driven testing. When we have 2 or more scenarios with exactly same steps
but different inputs, we use Scenario Outline.

Scenario Outline Must be followed by examples table.
data is stored in between pipes |value|
first is a table heading.

Parameters: we use them to make steps reusable:
    When user logs in as "driver" --> anything in double quotes will be provided as a parameter to step definition.
    Parameters can be: strings, integers and floats. Usually we use strings.

Data tables - we use to expand test steps and fit more test data into one step. We can have 1 or more columns.
1 column - List<E>
2 columns - Map<E, E> or List<Map<E, E>>
2 + columns - List<Map<E, E>>, Map<E, List<E>>

Tags - we used tags to run some test scenarios and ignore others or vice versa.
@tag - run scenarios only with this tag
@tag and @tag2 - run only scenarios that have both of them
@tag or @tag2  - run scenarios that have either @tag or @tag2
@tag or not @tag2 - run scenarios with a @tag that are not marked with @tag2
old syntax                                      current syntax
tags = {"@tag"} is unchanged
tags = {"~tag"} becomes tags =                    {"not tag"}
tags = {"@tag1,@tag2") becomes tags =             {"@tag1 or @tag2"}
tags = {"@tag1","@tag2"} becomes tags =         {"@tag1 and @tag2"}
tags = {"@tag1","@tag2,@tag3"} becomes tags =   {"@tag1 and (@tag2 or @tag3)"}

what kind of tags do you have?
    module name
    jira issue tag (bug or story)
    smoke test - scenarios that belong to smoke test

Hooks - methods that are running before and after every test scenario.
We used @Before hook to prepare environment for test, and @After hook to clean up environment after test.

@After - take a screenshot in case of failure, attach that screenshot to report and close browser.

@Before
public void setup(){
    this code will be executed
    before every scenario
}
same think applies to after hook:
@After
public void cleanup(){
    this code will be executed
    after every scenario
}

We can have couple of hooks marked with some tag:

@Before("@special")
public void specialHookBefore(){
    this code will be executed
    only before scenarios with
    a tag @special
}
same think applies to after hook:
@After("@special")
public void specialHookAfter(){
    this code will be executed
    only after scenarios with
    a tag @special
}

Runner class: - used to kick off cucumber test scenarios.
 - it must know where are the step definitions and hooks

         glue = "com/vytrack/step_definitions",
 - it must know where are the features
         features = "src/test/resources",
 - Cucumber generates couple of reports, but to get them, you need to configure plugin part of @CucumberOptions.
 - it must have @CucumberOptions and @RunWith(Cucumber.class) tags on top of class!

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/vytrack/step_definitions",
        features = "src/test/resources",
        dryRun = false,
        strict = false,
        tags = "@create_car_ddt",
        plugin = {
                "html:target/default-report",
                "json:target/cucumber1.json"
        }
)
public class CucumberRunner {
}

dryRun = true, to check if every test step has been implemented.
dryRun = false, to run tests indeed.
strict = true, to mark unimplemented steps as errors.
plugin = {
                "html:target/default-report", - to get default html report
                "json:target/cucumber1.json" - to get JSON report that later can be used
                                               to generate nice HTML report by 3rd party plugins,
                                               for example - maven-cucumber reporting plugin.
        }

########################
1. Create maven project
        project name: CucumberWebOrdersFall2019
        group id:     com.weborders
        artifact id:  CucumberWebOrdersFall2019

        add this first into pom.xml file : google search :maven compiler plugin-->
        click search result: "Apache Maven Compiler Plugin--setting the -source and ....",
        then -->on the left side of the page ,there is a list about compiler ,
        we choose " Compile Using-source and -target javac Options",
        then we copy " configure the plugin directly" in the middle of page ,
        this is inside a frame , about 19 lines of code. copy that into pom.xml file.

2. Add dependencies: ( go to MVNREPOSITORY webpage ,search dependencies you need)

    <properties>
        <maven.compiler.source>12</maven.compiler.source>
        <maven.compiler.target>12</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <configuration>
                    <source>12</source>
                    <target>12</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
    <dependencies>
        <dependency>( go to MVNREPOSITORY webpage ,search: SLF4J select latest version of cucumber )
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>1.7.30</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-simple</artifactId>
            <version>1.7.30</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-java -->
        <dependency>  ( go to MVNREPOSITORY webpage ,search: cucumber JVM ,select latest version of cucumber )
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>5.6.0</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-junit -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>5.6.0</version>
            <scope>test</scope>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
        <dependency>( go to MVNREPOSITORY webpage ,search: Selenium Java select latest version of cucumber )
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.141.59</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager -->
        <dependency>( go to MVNREPOSITORY webpage ,search: Webdriver manager select latest version of cucumber )
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>3.8.1</version>
        </dependency>
    </dependencies>

3. Create .gitignore with a following content:
        .idea
        *.iml
        target
        .DS_Store
        test-output
Add more items if needed.

4. Create packages:
    right click on src -> test -> java.
    create a package: com.weborders
            pages - for page classes
            runners - cucumber test runners classes
            step_definitions - to keep step definition methods,
            that are used for code implementation of tests scenarios.
            utilities - reusable code

    right click on src -> test --> new directory - resources/features
    under features, we keep all feature files
    under resources, we keep all test data along with feature files.

5. Create configuration.properties file with following content:
    browser=chrome
    url=http://secure.smartbearsoftware.com/samples/testcomplete12/weborders
    username=Tester
    password=test
    We use properties file to store some project configuration info.

    For example:
        environment URLs for UI, API and Data Base.
        credentials
        API end points
        selenium grid configuration --> info about servers and how to connect to them

6. Add utilities for manipulations with:
    browser
    files
    date and time
    api
    data base
    pdf files
    excel files
    etc....

7. Create a runner class:
    import io.cucumber.junit.Cucumber;
    import io.cucumber.junit.CucumberOptions;
    import org.junit.runner.RunWith;
    @RunWith(Cucumber.class)
    @CucumberOptions(
            glue = "com/vytrack/step_definitions",
            features = "src/test/resources",
            dryRun = false,
            strict = false,
            tags = "@create_car_ddt",
            plugin = {
                    "html:target/default-report",
                    "json:target/cucumber1.json"
            }
    )
    public class CucumberRunner {
    }

8. Add LoginStepDefintions class under step_defintions package.

9. Create you first feature file called Login.feature under resources --> features
    - you need to create at least one scenario

10. Perform dry run and paste generated steps from console into LoginStepDefintions class.

11. Create base page class
    - initialize page factory
    - allocate all common locators and store them  in this class.
    It shouldn't be done overnight, you can re-factor this any time.

12. Create LoginPage class and allocate all required by previously created test cases web element
    and store them under corresponding page classes, in case you need more than just login page class.
    This class as any other page class must inherit from BasePage class.

13. Create a page object of LoginPage in LoginStepDefinitions class to be able to
    interact with the page as part of your test case.

14. Add Hooks class.

    - create a @Before hook
        maximize window
    - create a @After hook
        take a screenshoot and attach it to report. close a driver at the end.

15. Create local git repository and commit code to github
    git init
    git add .
    git commit -m "first commit"

    - Go to github and create  a repository with corresponding name: CucumberWebOrdersFall2019
    go back to intellij and execute commands for exiting git project that github will display to you.
break until 9:02




API TESTING PROCESS :

1.    Maven compiler plugin
2.    CUCUMBER JUNIT Dep
3.    Cucumber Java Dep
4.    Selenium Dep
5.    SLF4J-api Dep
6.    SLF4J-simple Dep
7.    Io.github.bonigaricia
 */

/*
 The last Cucumber class :

 April 25,2020

 to run parallel testing ,make sure comment out "tag" in CucumberRunner class, so it can use all threads
 to run all features, parallel ONLY run features file. We can run classes, methods,or both.

what on earth is smoke test ? very simple : just verify ( make sure ) all components on the application
page can be opened !!! lets say vytrack , when I click Vehicles page ,activities page,... whatever page I clicked
and it can open smoothly, easily ,and nothing wrong ,every content in side page, all components, tags, tabs
are works fine. Normally we use admins credential ( why? because we can only use who has authorization
to log in page) to test components ( to test smoke test) ,salesmanager also can control everything in this
application ,so we can also use salesmanager credential to test every components .

when we do smoke testing , for example ,a feature with @smoke tag on top, it means we need to smoke test it
this feature contains example table, in the table, there are so many rows, some rows are exactly same except
username, but the functionality need to be tested are same ,in this case ,we only pick one row to test, for example:

in LoginDDT.feature, our table is big ,we have driver, sales manager, store manager, each person has some
conteng, but among these three persons, they have something exactly same, like driver move to Fleet tab , click
Vehicles, and verify title. this functionality storemanager also have , they all showing on table. we just pick
one person ,either driver or store manager to test.we don.t need to put entire table to smoke test , to make it
easy, we simply create a smokeTest.feature , this feature file exclusively doing smoke test ,and we can make
adjustment on the table, make it very short, please see " SmokeTest.feature" . in this smoke test example,
we removed all other roles, only keep sales manager to test, but we can also verify  Fleet, Customers
Sales, Activities, Marketing,Repor&Segments, System .....( all components under tabs functionalities).
our case  is not a completely smoke test. WE ONLY TEST MAIN COMPONENTS, MEANS MAJOR FUNCTIONALITIES ON
SMOKE TEST.


   Agenda : Parallel testing in Cucumber
            Smoke test ---When new build is deployed => smoke test must be triggered immediately.
            It is first step of verification that build was success.
            Regression testing
            Rerun failed test cases in Cucumber
            Summary of Cucumber framework

   ###################################################################




            notes for profile :
Maven profile : is used to create alternative build configurations. Currently we have only one.
By using profiles we can have couple build presets.
In Vasyl’s project they have profiles for smoke and reggession tests.

How to create profile for smoketest ? -
benefit is : whole configuration will be include inside pom file, no need long command
Perform whenever you need it
Tag build in pom is : build configuration - we have one currently
With mvn test we configure default one
How to ?
Create separate runner class for smoke test
create preset in pom,
type in terminal one command and it’s id =>  mvn test -P Smoke
Provides Advance configuration -Makes configuration easier
 mvn test -P Smoke => this command will use only Smoke, it will know based on profile id

 mvn clean verify -Dcucumber.options="--tags @smoke_test"

 Regression in 4 sentence =>
1.We test entire app.
2.there are Hundred of test cases,
3.done before release, we analyze the results
4.triggered from server, not from laptop

            ####################################################################



            Cucumber supports parallel testing by default.Everything happens through maven-surefire plugin or maven-failsafe plugin. In our project we use maven-surefire plugin. There are 2 options how parallelzation is done:

                -- runners classes
                -- feature file

            with junit, scenarios are not running in parallel within same feature file. But with TestNG we can run test scenarios in parallel.

            TWO very important keywords you MUST remember in parellel testing in Selenium :
            1.ThreadLocal Driver
            2.Synchronized method

            What is required ? First of all, webdriver has to support parallel exectution. For this we use ThreadLocal Java class.

            Each thread holds an implicit reference to its copy of a thread-local
            * variable as long as the thread is alive and the {@code ThreadLocal}
            * instance is accessible; after a thread goes away, all of its copies of
            * thread-local instances are subject to garbage collection (unless other
            * references to these copies exist).

            Option #1 Running cucumber runner classes in parallel. Include all your cucumber classes and specify how many threads do you need.

             1 thread = 1 test = 1 opened browser

             By increasing number of threads you can finish test execution faster. But don't forget that if you have only 2 runner classes, you cannot run more than 2 tests at the same time -->

             <plugin>
                     <groupId>org.apache.maven.plugins</groupId>
                     <artifactId>maven-surefire-plugin</artifactId>
                     <version>3.0.0-M4</version>
                     <configuration>
                         <!-- for parallel running Cucumber-->
                         <parallel>classes</parallel>
                         <threadCount>2</threadCount>
                         <perCoreThreadCount>false</perCoreThreadCount>
                         <forkCount>2C</forkCount>
                         <includes>
                            <!-- for run class or classes-->
//                            <include>**///*Runner.java</include>
//</includes>
//<testFailureIgnore>true</testFailureIgnore>
//</configuration>
//</plugin>
//
//        don't forget to run tests with maven goal:
//
//        mvn test or mvn verify or mvn install
//
//        Without ThreadLocal driver, we would need to create separate fork for every thread to completely isolate resource and to be able to run tests in parallel.
//
//        If we set up <UnlimitedCount>true<UnlimitedCount> and run all our feature files (currently we have 5 features total) at the same time by using "unlimted browsers" , this test is considered as regression test !!! yes ! We run all test cases altogether!  like this :
//
//<plugin>
//<groupId>org.apache.maven.plugins</groupId>
//<artifactId>maven-surefire-plugin</artifactId>
//<version>3.0.0-M4</version>
//<configuration>
//<!-- for parallel running Cucumber-->
//<parallel>methods</parallel>
//<useUnlimitedThreads>true</useUnlimitedThreads>
//<includes>
//<!-- for run class or classes-->
//<include>**/*Runner.java</include>
//                         </includes>
//                         <testFailureIgnore>true</testFailureIgnore>
//                     </configuration>
//             </plugin>
//
//             (JUnit 4.7 provider) Supports values {@code classes}, {@code methods}, {@code both} to run
//
//             both is old use classesAndMethods
//
//             <plugin>
//                     <groupId>org.apache.maven.plugins</groupId>
//                     <artifactId>maven-surefire-plugin</artifactId>
//                     <version>3.0.0-M4</version>
//                     <configuration>
//                         <!-- for parallel running Cucumber-->
//                         <parallel>classesAndMethods</parallel>
//                         <useUnlimitedThreads>true</useUnlimitedThreads>
//                         <includes>
//                            <!-- for run class or classes-->
//                            <include>**/CucumberRunner*.java</include>
//</includes>
//<testFailureIgnore>true</testFailureIgnore>
//</configuration>
//</plugin>
//
//
//        #######################################################################
//
//        Smoke test -- test suit that is always executed after deployment to ensure that environment is up and running and main functionality is working fine.
//
//        Sanity test -- lightweight version of smoke test, even smaller thant smoke test.
//
//        ##### How do we create a somke test ?
//
//        Smoke test can be created as an independent feature file that calls "SmokeTest.feature" ---> This is how it was done in my project.
//
//        Or , we can select specific scenarios among existing feature files by using tag @smoke_test . Based on tags, in cucumber, we group test. Smoke test -- its just another group of tests.
//
//        ### How many tests should be included into Smoke Test?
//
//        there is no concrete number, I've seen from 20--60 test cases in smoke test. In my project it was around 28.
//
//        Duration should be from 5--15 minutes.
//
//        For vytrack it's like 30 test cases. Check all components and that's it.Duration abount 10 minutes
//
//        nobody can verify your number.
//
//        Who create smoke test? Testers ! testers discuss with team and ask developers advice ,then decide which scenarios need to be put into smoke test .
//
//        How it should be triggered ? It should be triggered from CI/CD not from IDE (Intellij)
//        CI/CD is a tool that build automation process.
//
//        CI/CD -- continues integration/continues delivery and continues deployment . For example--Jenkins.This is what we are covering in the course. Also very famous CI/CD tools are--Bamboo, TravisCI, GitLab, TimCity, etc...
//
//        Them most popular is Jenkins.
//
//        Jenkins ---can auomatically exectue your tests based on some triggers.
//
//        Periodically - every morning , every hour
//
//        After deployment --new build was deployed to test environment, smoke test must be triggered automatically without human intervention.
//
//        Also ,usually smoke test is running every morning , and should be completed before everyone comes to work. If something fails,whole team should receive an email notification with report.
//
//        Who is gonna fix it ? not you . devops(or environment team) fix environment , developers fix code if something is broken because of bad code.
//
//        DevOps--person who builds code and also responible for operaions with code deployment.
//
//        mvn clean verify -Dcucumber.options="--tags @smoke_test" -q
//
//        -Dcucumber.options - are use to specify or override cucumber options that were specified in runner class.
//
//        -Dcucumber.options="--tags @smoke_test" - means run only test scenarios with tag @smoke_test
//
//                 *Optional
//                         -q - quiet execution, will make maven print less into the console.
//
//                         maven profile -- is used to create alternative build configurations. Currently we have only one. By using profiles. we can have couple build presets. In my projuect, we have profiles for smoke and regression tests.
//
//                         How to create profile for SmokeTest?
//
//<profiles>
//<profile>
//<id>Smoke</id>
//<build>
//<plugins>
//<plugin>
//<groupId>org.apache.maven.plugins</groupId>
//<artifactId>maven-compiler-plugin</artifactId>
//<version>3.8.1</version>
//<configuration>
//<source>12</source>
//<target>12</target>
//</configuration>
//</plugin>
//<plugin>
//<groupId>org.apache.maven.plugins</groupId>
//<artifactId>maven-surefire-plugin</artifactId>
//<version>3.0.0-M4</version>
//<configuration>
//<!-- for parallel running Cucumber-->
//<parallel>methods</parallel>
//<useUnlimitedThreads>true</useUnlimitedThreads>
//<includes>
//<!-- for run class or classes-->
//<include>**/SmokeTestRunner.java</include>
//</includes>
//<testFailureIgnore>true</testFailureIgnore>
//</configuration>
//</plugin>
//</plugins>
//</build>
//</profile>
//</profiles>
//
//
//        How do I run smokeTestRunner ( smoke test class) in terminal ?
//
//        in terminal , we write : mvn clean test -p Smoke
//
//        create profiles for smoke test is pre-configured build that can be executed when you just specify -p parameter and the name of the profile( in our case , the name id is " Smoke"), the whole configuration is done inside the profile and it can be performed whenever you need it !
//
//        This particular profile is triggering SmokeTestRunner class. In that runner class, we predefined setup for smoke test: included all test scenarios and specified report name.
//
//        package com.vytrack.runners;
//
//        import io.cucumber.junit.Cucumber;
//        import io.cucumber.junit.CucumberOptions;
//        import org.junit.runner.RunWith;
//
//@RunWith(Cucumber.class)
//@CucumberOptions(
//        glue = "com/vytrack/step_definitions",
//        features = "src/test/resources",
//        dryRun = false,
//        strict = false,
//        tags = "@smoke_test",
//        plugin = {
//                "html:target/smoke_test_default-report",
//                "json:target/cucumber1.json"
//        }
//
//)
//public class SmokeTestRunner {
//}
//
//
//
//        mvn clean test -P Smoke
//
//
//        -P <profile_id>
//
//
//In our project we have a feature file with smoke test scenarios:
//
//
//@smoke_test
//Feature: Smoke test
//
//        Scenario Outline: Go to <module> and verify title: <title>
//Given user is on the login page
//        When user logs in as "<user_type>"
//        And user navigates to "<tab>" and "<module>"
//        Then user verifies that page title is "<title>"
//
//        Examples:
//        | user_type | tab | module | title |
//        | sales manager | Fleet | Vehicles | All - Car - Entities - System - Car - Entities - System |
//        | sales manager | Fleet | Vehicles Model | All - Vehicles Model - Entities - System - Car - Entities - System |
//        | sales manager | Customers | Accounts | All - Accounts - Customers |
//        | sales manager | Customers | Contacts | All - Contacts - Customers |
//        | sales manager | Activities | Calendar Events | All - Calendar Events - Activities |
//
//        mvn clean verify -X --> this command for debugging purpose, maven will done everyting, whatever happens during the build process you will see it in the console. this command may help you understand why plug-in doesnt work.
//
//
//        ###############################################################################################################
//
//        How to rerun failed tests in Cucumber?
//
//        This plugin-->"rerun:target/rerun txt" will generate text file with list of failed test scenarios at the end of test execution
//
//        the best solution is : have another runner class ,and exclusively run those failed tests ,for example ,we name our runner class is " FailedRunner" the difference is only this line : features = "@target/retun.txt"  rest code all same as normal runner class.
//        geatures = "@target/retun.txt"
//        in the plugin ={
//
//        "html:target/failed-default-report",
//        "json:target/failed_report.json",
//
//        } , inside this curley bracket, we dont need to add "@target/retun.txt" on the bottom anymore.
//
//        file:src/test/resources/features/activities/ViewCalendarEvents.feature:5
//
//        This line means that in feature file ViewCalendarEvents, some scenario on the line # 5 failed.
//
//        A Build Lifecycle is Made Up of Phases
//        Each of these build lifecycles is defined by a different list of build phases, wherein a build phase represents a stage in the lifecycle.
//
//        For example, the default lifecycle comprises of the following phases (for a complete list of the lifecycle phases, refer to the Lifecycle Reference):
//
//        validate - validate the project is correct and all necessary information is available
//        compile - compile the source code of the project
//        test - test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed
//        package - take the compiled code and package it in its distributable format, such as a JAR.
//        verify - run any checks on results of integration tests to ensure quality criteria are met
//        install - install the package into the local repository, for use as a dependency in other projects locally
//        deploy - done in the build environment, copies the final package to the remote repository for sharing with other developers and projects.
//
//
//
//
//
//
//
//
//
















//        Regression testing ---it's type of functional testing that is performed before release. Regression suit includes all tests cases, so we are convering entire application.














//        */