@myInfo
Feature:myInfo

  @myInfo_01
  Scenario:  Validate admin Section
    Given User logged into Orange application as "Manager" profile user
    And User Click on "My Info" Side bar tab
    When User logs out the application

  @myInfo_02
  Scenario:  User validate personal Detail
    Given User logged into Orange application as "Admin" profile user
    And User Click on "My Info" Side bar tab
    When user click on "Personal Detail" tab
    When User logs out the application


  @myInfo_03
  Scenario Outline: Verify tab on Side Search bar
    Given User logged into Orange application as "Manager" profile user
    And User Validated side Search bar "<Tab>"
    When User logs out the application
    Examples:
      | Tab         |
      | PIM         |
      | Leave       |
      | Time        |
      | Recruitment |
      | My Info     |
      | Performance |
      | Dashboard   |
      | Directory   |
      | Maintenance |
      | Claim       |
      | Buzz        |




