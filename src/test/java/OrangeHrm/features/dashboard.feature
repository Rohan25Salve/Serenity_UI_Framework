@dashboard
  Feature:Dashboard

    @dashboard_01
    Scenario:  Validated Dashboard with multiple Component
      Given User logged into Orange application as "Admin" profile user
      When User logs out the application


  @dashboard_02
  Scenario:  Validated Support and About in Profile Section
    Given User logged into Orange application as "Admin" profile user
    And User click on Profile button
  #  And User Click on About Button and verify description
    #  | Company Name | Version          | Active Employees | Employees Terminated |
    #  | OrangeHRM    | OrangeHRM OS 5.5 | 41               |                      |
   # And User click on Profile button
    And User click on Support and Verify email "ossupport@orangehrm.com" and Header "Getting Started with OrangeHRM"
    When User logs out the application


