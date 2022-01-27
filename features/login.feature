Feature: Login into Facebook application

  @saran
  Scenario Outline: login Functionality
    Given user login into the application
    Then user enters "saravanan.pari005@gmail.com" and "saran2112" in login page
    And user click on "Login" button
    Then user verify the successful login and checks user lands to homepage

    Examples:
      | username                    | password  |
      | saravanan.pari005@gmail.com | saran2112 |

