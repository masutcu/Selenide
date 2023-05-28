@dropdown
Feature: dropdown
  Scenario: TC01 dropdown
    Given kullanici "https://testcenter.techproeducation.com/index.php?page=dropdown" adresine gider
    And kullanici yil olarak 1979, ay olarak "August", gun olarak 13 secer





  #Selenide de
  #Select objesi kullanmaya gerek yoktur. selenide de 3 temel select option vardır.
  #selectOption() ==> index alır
  #selectOption() ==> "" içinde yani string olarak visible text alarak kullanılır
  #selectOptionByValue ==> "" value değeri alır