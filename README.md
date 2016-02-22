# Rest-API for the tomato market

## Install

Compile the app with maven ```mvn install``` and copy the war file ```tomato-rest``` to your tomcat/webapps folder and start up tomcat.

With default tomcat setting the app should be deployed under:

```http://localhost:8080/tomato-rest/tomatoes/data```


## Usage

There is only one REST endpoint under /tomatoes/data that provides a JSON list of tomato providers. By default the list returns
3 items. You can specify a parameter ?size to retrieve a larger list. This parameter accepts values from 1 to 1000.
The maximum value can be changed in the property file ```src/main/resources/app.properties```