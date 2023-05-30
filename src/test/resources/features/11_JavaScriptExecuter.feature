Feature: js executer
  @scrollwithjs
  Scenario: js executer
    Given kullanici "https://amazon.com/" adresine gider
    And tum ekran goruntusunu alir
    And footerelementi gorunur sekilde goster
    And tum ekran goruntusunu alir
    Then sayfayi acik tutar
