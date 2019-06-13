Sample story

Scenario:  Log in as a admin and register a user

Given I open browser
And I access http://localhost:8080/jira_project/user/showUserRegisterForm
And I enter the login username and password for admin and press login button
And I enter the details for the user registered
When I press the registerUser button
Then the list usersRegistered appears
