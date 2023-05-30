@crossbrowser
Feature: cross browser
  @headless
  Scenario: TC01 headless
    Given kullanici browser tipini "headless" olarak secer
    Given kullanici "https://amazon.com/" adresine gider

  @firefox
  Scenario: TC02 firefox
    Given kullanici browser tipini "firefox" olarak secer
    Given kullanici "https://amazon.com/" adresine gider

  @edge
  Scenario: TC03 edge
    Given kullanici browser tipini "edge" olarak secer
    Given kullanici "https://amazon.com/" adresine gider

  @opera
  Scenario: TC04 opera
    Given kullanici browser tipini "opera" olarak secer
    Given kullanici "https://amazon.com/" adresine gider


