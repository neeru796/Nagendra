Feature: login Functionality 

@data-driven
Scenario: Login with valid credentials 

	Given navigate to home page 
	
	#When user enters username and password 
	
	Then user logged in Successfully 
	
@data-driven
Scenario: The one where user picks different product through search functionality 

   #When larry searches below products in the search box:
   #|Head |
  # |Travel |
   #|Laptop |
   
   Then product should be added in the cart if available
   
   @user-specific
   Scenario Outline: Login with valid credentials 
   Given navigate to home page 
   When user enters "<uname>" and "<pwd>"
   When user logged in Successfully 
	
	Examples:
	
	|uname|pwd|
	|lalitha|password123|
	|ABC|XYZ|
   
   