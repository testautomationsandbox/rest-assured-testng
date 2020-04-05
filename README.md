# REST Assured - TestNG

An example on how to use TestNG and REST Assured for API testing, using maven.

## How to run tests

Test are run as part of the Maven build process.

Just run `mvn clean package` and *all tests* will run in the build process.

To run specific test classes or methods, generate a [TestNG XML File](https://testng.org/doc/documentation-main.html#testng-xml) and set it up in the [pom.xml file](pom.xml)

```
<configuration>
    <suiteXmlFiles>
        <suiteXmlFile>${suiteXmlFile}</suiteXmlFile>
    </suiteXmlFiles>
</configuration>
``` 

And then run `mvn clean package -DsuiteXmlFile=your/testngxml/path/file.xml`

## Services under test
* [The Star Wars API](https://swapi.co/)
* [World time API](http://worldtimeapi.org/)

## High Level Structure

### Module `main`
This module includes the services clients, endpoint and responses definitions.

### Module `test`
This module includes the test classes and resources (TestNG Suite XML files)