Sample story
					 
Scenario:  The scope is to access the form for registering a user with a admin account
Given I open browser
And I access http://localhost:8080/jira_project/user/showUserRegisterForm
And a text field for username with name username and value admin
And a text field for password with name password and value java123
When button login is pressed
Then displaying the table userRegisterFields
					 
