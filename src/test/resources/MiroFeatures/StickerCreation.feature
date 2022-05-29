@All
Feature:Create e2e test for cover functionality of sticker creation in Miro service

  @Regression
  Scenario: Verify that the sticker which was created on a board by the first user will appear on the board for the second user
    Given As a “User1” I login into service
    And I create a board with the name “Board”
    Then As a “User1” I open “Board” and create there sticker(sticker widget), by using left toolbar
    And As a “User1” I invite “User2” to “Board” by using “Share” button on the top right corner
    Then As a “User2” I login into service and open “Board”
    And As a “User2” I should see created sticker on “Board”
