package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import site.nomoreparties.stellarburgers.page_object.MainPage;

import static org.junit.Assert.assertTrue;

@DisplayName("Тесты: конструктор")
public class ConstructorTest extends BaseTest {

    @DisplayName("Тест перехода к разделу 'Булки'")
    @Test
    public void testScrollToBunSection(){
        MainPage objMainPage = new MainPage(getDriver());
        objMainPage.clickFillingsSection();
        objMainPage.clickBunsSection();
        assertTrue(objMainPage.isFluorescentBunTitleDisplayed());
    }


    @DisplayName("Тест перехода к разделу 'Соусы'")
    @Test
    public void testScrollToSauceSection(){
        MainPage objMainPage = new MainPage(getDriver());
        objMainPage.clickSaucesSection();
        assertTrue(objMainPage.isSauceSpicyXTitleDisplayed());
    }

    @DisplayName("Тест перехода к разделу 'Начинки'")
    @Test
    public void testScrollToFillingsSection(){
        MainPage objMainPage = new MainPage(getDriver());
        objMainPage.clickFillingsSection();
        assertTrue(objMainPage.isBeefMeteoriteTitleDisplayed());
    }
}
