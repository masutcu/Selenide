@ekranlar
Feature: screeenshots
  @screenshot
  Scenario: tum ekran goruntusu
  Given kullanici "https://www.google.com/" adresine gider
  And tum ekran goruntusunu alir

  @googleimg
  Scenario: belirli elementin ekran goruntusu
    Given kullanici "https://www.google.com/" adresine gider
    And google image goruntusunu alir









#ScreenShots
#Selenide fail olan testler için otomatik olarak ekran görüntüsü alır
#Bu sadece Selenide Assertions 'lar için geçerlidir. (Assert için değil)
#$("input").sholudBe(visible);
#$("input").sholud(exist);
#$("input").sholudHave(text("sometext"));
#$("input").sholudHave(exactText("sometext"));
#$("input").sholudNotHave(exactText("sometext"));

#Bu özellik geçersiz kılınabilir
#Configuration.screenshot=false
# Default olan Configuration.screenshot=true