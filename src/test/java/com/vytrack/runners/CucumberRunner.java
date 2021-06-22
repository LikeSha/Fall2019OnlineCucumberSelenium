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
        tags = "@sales_manager",
        plugin = {
                "html:target/default-report",// plugin= "html:target/cucumber-html-report"
                "json:target/cucumber1.json",
                "rerun:target/rerun.txt"
        }

)
public class CucumberRunner {


}

/*
April 11 ,2020

April 12 ---Holiday , no class

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
(unit test just targeting certian class ,or code to test.  e2e ---end to end testing)

Test Driven Development (TDD)--Developers write test first BEFORE they write functionality,
test first based on the requirement, then test ,if all tests passed, then developing later!
TDD is about unit testing .In case of TDD , we are dealing with raw code.

Behavior Driven Development (BDD)   BDD is about how to process requirement docutments,
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


    dont forget add cucumber plugins: hit shit twice on keyboard,
    then search " Gherkin" and "Cucumber for Java"   total we need these 2 plugins.


     Right click on src/test/java:
        create a package : com.vytrack.pages

     Right click on vytrack -->new -->package:
        utilities
        runners
        step_definitions

    right click on src/test-->new-->dirctory-->resources
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

REMEMBER!! DONT ADD SUBSTEPS PLUGIN!! IF YOU HAVE IT --- DELETE IT !!

You need 2 plugins :

Cucumber for Java ---by JebBrains
Gherkin           ---By JetBrains

After installation, restart IntelliJ

then, all your feature files will have a green icon

if feature file icon is blue ---delete substeps plugin

if feature file icon is gray, even after installing plugins :

Check Settings-->Editor-->File Types.
Verify that Cucumber Scenario is set to a Registered Pattern of *.feature.

comman + option + esc ----force quit some program
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
inside feature file, we don't write java code inside feature file,only plain Engliish text,
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
under features = "src/test/resouces/features" we added a line :
   dryRun = true,
   ( we set dryRun = true is because we need to cucumber generate code implementation snippet to us ,
   so that we can copy paste it to our step_definition class.)

   then right click " CucumberRunner class" , clickc" run CucumberRunner class" ,
   then the implementation codes showing up on the console. it contians 3 snippets, Given ,When ,Then
   correspondence to our scenario " Login as sales manager and verify that title is Dashboad" in Login feature .

6, so what we will do now ? we copy all of them ( 3 of them)  .
then go to --> LoginStepDefinitions class ---> paste them .

7, delete all content inside these three methods that cucumber generated for us .
and write our own codes inside ,

8, after code done, go back to CucumberRunner class ,make dryRun = false. so we can run the test.
   to run the test ,just click run button on CucumberRunner class.






 */