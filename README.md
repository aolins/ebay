# ebay

Requires installed maven, java, free 8089 port.

How to compile and test
  *check out, 
  *cd to directory with project
  *mvn clean compile test 
  
To run locally:
  * cd to directory
  * mvn exec:java -Dexec.mainClass="de.mobile.aol.Main"

API 
GET http://localhost:8089/myapp/search/{search criteria}
This will produce JSON with all relevant data.

Limitations:
Data layer is omitted. Plan: H2 and Hibernate.
Data base schema is omitted. Plan: Hibernate auto-generate from classes will do the work.
Data are provided by static data provider, interface is in place.
UI is ommitted, API could be used by any JS-app in browser
