
#Note:
Have the chaged the number of items to fetch to 50 to reduce the number of calls
http://api.viki.io/v4/videos.json?app=100250a&per_page=50&page=0

The project uses restassured to make the rest API calls and validates the response.TestNG tests are used to execute the calls.
Steps to run:
1) import the maven project 
2)Run the class file src/test/java/com/rest/test/ApiTest.java as TestNG test
