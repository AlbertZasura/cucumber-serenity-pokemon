Feature: get Pokemon's data

  Scenario: Crawling pokemon data
    Given system visit pokemon website page
    When system start crawl data
    Then system convert data to json
