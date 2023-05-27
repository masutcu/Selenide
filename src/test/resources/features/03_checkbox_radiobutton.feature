Feature: checkbox ve radiobutton
  @checkbox
  Scenario: TC01 checkbox
    Given kullanici "https://testcenter.techproeducation.com/index.php?page=checkboxes" adresine gider
    And 3 saniye bekler
    And "Checkbox1" secili degilse sec
    And 3 saniye bekler
    And "Checkbox2" secili degilse sec
    And 3 saniye bekler
    And sayfayi acik tutar

    @radiobutton
    Scenario: TC02 radiobutton
      Given kullanici "https://testcenter.techproeducation.com/index.php?page=radio-buttons" adresine gider
      And 3 saniye bekler
      And "Red" secili degilse sec
      And 3 saniye bekler
      And sayfayi acik tutar

  @radiobutton
  Scenario: TC03 radiobutton
    Given kullanici "https://testcenter.techproeducation.com/index.php?page=radio-buttons" adresine gider
    And 3 saniye bekler
    And "Football" secili degilse sec
    And 3 saniye bekler
    And sayfayi acik tutar
