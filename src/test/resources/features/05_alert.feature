Feature: alerts
@alert
Scenario: TC01 alert
  Given kullanici "https://testcenter.techproeducation.com/index.php?page=javascript-alerts" adresine gider
  And alert prompt butonuna tiklar
  And kullanici alerte "hello" metnini yazar ve ok tiklar
  And kullanici sonucun "hello" icerdigini dogrular







#Selenide de Alert
  #alert pencereler açıldığında kabul veya reddedilmeden otomasyon ilerlemesini engeller
  #dolayısıyla alert önce çözülmelidir.
  #switchTo().alert().sendKeys(text); alert e geçiş için selenide nin swictchTo() metodu kullanılır
  #switchTo().alert().accept(); accept kullnımı bu şekildedir
  #testCenterPage.sonuc.shouldHave(text(yazi)); propmt a yazılan yazının ekranda doğrulaması için shouldHave ve text metodu kullanilir