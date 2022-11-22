Feature: Application login
Scenario: Login with valid credentials
Given open any Browser
And Navigate to loginpage
When user enters username as "sethuram416@gmail.com" and password as "Sethu@416"
And User clicks on login button
Then Verify user is able to successfully login
