Sample story

Scenario:  The scope is to access the form for registering a user with a user account
Given I open browser
And I access http://localhost:8080/jira_project/user/showUserRegisterForm
And a text field for username with name username and value user
And a text field for password with name password and value password
When button login is pressed
Then the page containing the error403 is displaying