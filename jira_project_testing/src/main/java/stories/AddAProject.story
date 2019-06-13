Sample story

Scenario:  Log in as a admin and register a user

Given I open browser
And I access http://localhost:8080/jira_project/project/showAddProjectForm
And I enter the login username and password for admin and press login button
And I enter the details for the project added
When I press the addProjectButton button
Then the list listProjects appears
