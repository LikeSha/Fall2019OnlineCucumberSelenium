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

      |car plates |color      |make  |model| <----------------always reserved for key names(List<Map<String,String)>>)
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
   if it is a two columns dataTable, we choose Map<String,String>


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


  */


