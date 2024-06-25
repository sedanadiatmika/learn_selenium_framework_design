@tag
  Feature: Error validation

    @ErrorValidation
    Scenario Outline: Positive Test of submitting the order
      Given I landed on Ecommerce Page
      When Logged in with username <name> and password <password>
      Then "Incorrect email or password." message is displayed
      Examples:
        | name          | password            |
        | sd3@mail.com  | Sedanadiatmika123!! |