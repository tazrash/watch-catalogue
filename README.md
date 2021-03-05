# watch-catalogue
This project can be used to checkout watches with some of them having discount

Steps to run the application:

1. Clone the repository and import into IDE(STS/ECCLIPSE/INTELLIJ) 

2. Run as a spring boot application.

3. We have used in memory hsql db to load the data and data will be loded during application start up only.

4. Use the below curl from postman to get the checkout api response.
  
curl --location --request POST 'http://localhost:8080/checkout' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--data-raw '[

"003",
"001",
"001",
"002",
"002",
"003",
"003"

]'

=========================================================================================================================

we have created a simple spring boot application in which we have used HsqlDB, java8 features junit test case execution in order to deliver watch catalouge project.

