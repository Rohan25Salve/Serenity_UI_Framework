@Admin
Feature:Admin

  @admin_01
  Scenario:  Validate admin Section
    Given User logged into Orange application as "Admin" profile user
    And User Click on "Admin" Side bar tab
    When User logs out the application
