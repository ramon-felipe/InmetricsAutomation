Feature: Inmetrics Company Tests

  @firstScenario
  Scenario Outline: Creating a task
    Given I access the page <page>
    And I create a new account <name>, <login>, <password>
    And I create a new task <title>, <dateLimit>, <timeLimit>, <desc>, <isDone>
    Then I validate the task created

    Examples: 
      | page                                  | name                                                  | login                    | password         | title                    | dateLimit | timeLimit | desc              | isDone       |
      | http://www.juliodelima.com.br/taskit/ | <RANDOM>[A-Z][a-z]{4,5} [A-Z][a-z]{2} [A-Z][a-z]{5,6} | <RANDOM>\\w{4,6}\\d{1,4} | <RANDOM>\\w{5,6} | <RANDOM>[A-Z][a-z]{8,10} | Today     | 12:30     | Nova tarefa teste | <RANDOM>[12] |

  @secondScenario
  Scenario Outline: API Test
    Given I perform GET operation for URI <URI>
    And I show the titles returned that director is <director> and producer contains <producer>

    Examples: 
      | URI                       | director     | producer      |
      | http://swapi.co/api/films | George Lucas | Rick McCallum |
