Feature: explicitwait
  @explicitwait
  Scenario: explicit wait
  Given kullanici "https://the-internet.herokuapp.com/dynamic_loading/1" adresine gider
  And start butonuna tiklar
  Then kullanici "Hello World!" yazisini dogrular
  And sayfayi acik tutar








    # Selenide de ExplicitWait
    # selenide'de varsayılan dinamik bekleme süresi 4 saniyedir. fazlası için explicit wait kullanılır
    # belirli (local) elementler için maxsimum bekleme süresidir.(implicitwait genel)
    # İki farklı explicit wait kullanımı vardır.
    #1. wait.until(ExpectedConditions.visibilityOf(element));
    #2. element.should(visible, Duration.ofSeconds(20)); daha çok kullanılan budur