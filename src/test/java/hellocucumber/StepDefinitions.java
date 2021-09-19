package hellocucumber;

import io.cucumber.java.hu.Akkor;
import io.cucumber.java.hu.Amikor;

public class StepDefinitions {

  Pages pages = new Pages();

  @Amikor("Megnyitom a(z) {string} oldalt")
  public void i_open_the_url(String url) {
    pages.iOpenPage(url);
  }

  @Akkor("A(z) {string} oldal betöltött")
  public void the_url_is_loaded(String url) {
    pages.theUrlIsLoaded(url);
  }

  @Akkor("Az oldalt bezárom")
  public void i_quit() {
    pages.quitBrowser();
  }

  @Amikor("A SIGNIN gombra kattintok")
  public void i_click() {
    pages.iClickOnSignIn();
  }

  @Akkor("Várok {int} másodpercet")
  public void i_wait_n_second(int sec) {
    pages.iWaitNSecond(sec);
  }

  @Amikor("Kiválasztom a {string} gender")
  public void i_select_gender(String gender) {
    pages.iSelectGender(gender);
  }

  @Amikor("Beírom az {string} címem")
  public void i_paste_my_email(String email) {
    pages.iPasteMyEmail(email);
  }

  @Amikor("A CREATE_ACCOUNT gombra kattintok")
  public void i_create_account() {
    pages.iCreateAccount();
  }

  @Amikor("Kitöltöm az adatokat")
  public void i_fill_the_data() {
    pages.iFillTheData();
  }

  @Amikor("Kitöltöm a hiányos adatokat")
  public void i_fill_with_missing_data() {
    pages.iFillTheMissingData();
  }

  @Amikor("A REGISTER gombra kattintok")
  public void i_register() {
    pages.iClickRegisterButoon();
  }

  @Akkor("Sikeres regisztráció")
  public void successful_registration() {
    pages.iCheckAccount();
  }

  @Akkor("Error megjelent")
  public void error_displayed() {
    pages.errorDisplayed();
  }

  @Amikor("Legörgetek az iFrame részig")
  public void scroll_until_iframe() {
    pages.scrollDownTillIFrame();
  }

  @Amikor("Átváltok az iFrame-re")
  public void i_switch_to_iframe() {
    pages.iSwtichToIFrame();
  }

  @Amikor("Visszaváltok a main frame-re")
  public void i_switch_back_to_main_frame() {
    pages.iSwitchBackToMainFrame();
  }

  @Amikor("A képre kattintok")
  public void i_click_to_the_image() {
    pages.iClickToTheImage();
  }

  @Amikor("Ellenőrzöm a tabokat")
  public void i_check_the_tabs() {
    pages.iCheckTheTabs();
  }

  @Amikor("Felgörgetek a HOME gombig")
  public void i_scroll_up() {
    pages.scrollUpTillHeader();
  }

  @Amikor("A Testing menu-re hoover-elek")
  public void i_hoover() {
    pages.iHoover();
  }

  @Amikor("Az oldal aljáig legörgetek")
  public void i_scroll_to_the_bottom() {
    pages.iScrollDownToTheBottom();
  }

  @Akkor("Várok amíg a Piros gomb megjelenik")
  public void i_wait_until_red_button() {
    pages.iWaitUntilButtonIsDisplayed();
  }

  @Akkor("Mozgatom az egeret")
  public void i_move_the_mouse() {
    pages.moveMose();
  }
  @Akkor("Legörgetek 100 pixelenként az oldal aljáig")
  public void i_scroll_by_pixel(){
    pages.iScrollDownByPixel();
  }
}
