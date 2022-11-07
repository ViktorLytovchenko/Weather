import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

//    Заговка!!!
//    @Test
//    public void test_name() {
//        System.setProperty("webdriver.chrome.driver", "/Applications/ChromeDriver/chromedriver");
//        WebDriver driver = new ChromeDriver();
//
//
//        driver.quit();
//    }

public class ViktorLytovchenkoTest {


    //TC_1_1  - Тест кейс:
//1. Открыть страницу https://openweathermap.org/
//2. Набрать в строке поиска город Paris
//3. Нажать пункт меню Search
//4. Из выпадающего списка выбрать Paris, FR
//5. Подтвердить, что заголовок изменился на "Paris, FR"

    @Test
    public void testH2TagText_WhenSearchingCityCountry() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/ChromeDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement searchCityField = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//input[@placeholder = 'Search city']")
        );

        searchCityField.click();
        searchCityField.sendKeys(cityName);
        Thread.sleep(3000);

        WebElement searchButton = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//button[@type = 'submit']")
        );

        searchButton.click();
        Thread.sleep(2000);

        WebElement parisFranceChoiceInDropDownMenu = driver.findElement(
                By.xpath("//ul[@class = 'search-dropdown-menu']/li/span[text() = 'Paris, FR ']")
        );
        parisFranceChoiceInDropDownMenu.click();

        WebElement h2CityCountryHeader = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//h2")
        );


        Thread.sleep(2000);
        String actualResult = h2CityCountryHeader.getText();


        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

//    TC_11_01
//1.  Открыть базовую ссылку
//2.  Нажать на пункт меню Guide
//3.  Подтвердить, что вы перешли на страницу со ссылкой https://openweathermap.org/guide и
//    что title этой страницы OpenWeatherMap API guide - OpenWeatherMap

    @Test
    public void testTitleOpenWeatherMap() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Applications/ChromeDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
//        String menuItem = "Guide";
        String expectedResult1 = "https://openweathermap.org/guide";
        String expectedResult2 = "OpenWeatherMap API guide - OpenWeatherMap";

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement openTheFirstMenuItem = driver.findElement(
                By.xpath("//div[@id = 'desktop-menu']//a[text() = 'Guide']")
        );

        openTheFirstMenuItem.click();
        Thread.sleep(3000);
//        openTheFirstMenuItem.sendKeys(menuItem);
        String actualResult2 = driver.getTitle();
        String actualResult1 = driver.getCurrentUrl();

        Assert.assertEquals(actualResult2, expectedResult2);
        Assert.assertEquals(actualResult1, expectedResult1);
        driver.quit();
    }

//    TC_11_02
//1.  Открыть базовую ссылку
//2.  Нажать на единицы измерения Imperial: °F, mph
//3.  Подтвердить, что температура для города показана в Фарингейтах
    @Test
    public void testTemperatureForTheCityFahrenheit() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Applications/ChromeDrivers/chromedriver/");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult = "true";

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement clickTheTempFahrenheit = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//div[text() = 'Imperial: °F, mph']")
        );

        clickTheTempFahrenheit.click();
        Thread.sleep(2000);

        WebElement confirmTheTempFahrenheit = driver.findElement(
                By.xpath(".//span[contains(text() ,'°F')]")
        );
        String actualResult = String.valueOf(confirmTheTempFahrenheit.getText().contains("°F"));

        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
    }

//    TC_11_03
//  1.Открыть базовую ссылку
//  2.Подтвердить, что внизу страницы есть панель с текстом “We use cookies
//    which are essential for the site to work. We also use non-essential
//    cookies to help us improve our services. Any data collected is anonymised.
//    You can allow all cookies or manage them individually.”
//  3.Подтвердить, что на панели внизу страницы есть 2 кнопки “Allow all” и “Manage cookies”

    @Test
    public void testConfirmWhatOnThePageUseCookies() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Applications/ChromeDrivers/chromedriver/");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult1 = "We use cookies which are essential for the site to work. " +
                "We also use non-essential cookies to help us improve our services. Any data " +
                "collected is anonymised. You can allow all cookies or manage them individually.";
        String expectedResult2 = "Allow all";
        String expectedResult3 = "Manage cookies";

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement thePageUseCookies = driver.findElement(
                By.xpath("//div[@id = 'stick-footer-panel']//p")
        );

        WebElement thePageAllowAll = driver.findElement(
                By.xpath("//div[@id = 'stick-footer-panel']//button[contains(text(),'Allow all')]")
        );

        WebElement thePageManageCookies = driver.findElement(
                By.xpath("//div[@id = 'stick-footer-panel']//a[contains(text(),' Manage cookies ')]")
        );
        String actualResult1 = thePageUseCookies.getText();
        String actualResult2 = thePageAllowAll.getText();
        String actualResult3 = thePageManageCookies.getText();

        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);
        Assert.assertEquals(actualResult3, expectedResult3);

        driver.quit();
    }
//    TC_11_04
//1.  Открыть базовую ссылку
//2.  Подтвердить, что в меню Support есть 3 подменю с названиями “FAQ”, “How to start” и “Ask a question”

    @Test
    public void testConfirmWhatSupportThreeSubmenu() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Applications/ChromeDrivers/chromedriver/");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult1 = "FAQ";
        String expectedResult2 = "How to start";
        String expectedResult3 = "Ask a question";

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement buttonSupport = driver.findElement(
                By.xpath("//div[@id = 'support-dropdown']")
        );
        buttonSupport.click();
        Thread.sleep(2000);

        WebElement theSubmenuFaq = driver.findElement(
                By.xpath("//ul[@id = 'support-dropdown-menu']//a[text() = 'FAQ']")
        );
        WebElement theSubmenuHowToStart = driver.findElement(
                By.xpath("//ul[@id = 'support-dropdown-menu']//a[text() = 'How to start']")
        );
        WebElement theSubmenuAskAQuestion = driver.findElement(
                By.xpath("//ul[@id = 'support-dropdown-menu']//a[text() = 'Ask a question']")
        );

        String actualResult1 = theSubmenuFaq.getText();
        String actualResult2 = theSubmenuHowToStart.getText();
        String actualResult3 = theSubmenuAskAQuestion.getText();

        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);
        Assert.assertEquals(actualResult3, expectedResult3);

        driver.quit();
    }

//    TC_11_05
//1. Открыть базовую ссылку
//2. Нажать пункт меню Support → Ask a question
//3. Заполнить поля Email, Subject, Message
//4. Не подтвердив CAPTCHA, нажать кнопку Submit
//5. Подтвердить, что пользователю будет показана ошибка “reCAPTCHA verification failed, please try again.”

    @Test
    public void testFromReCaptchaVerificationFailed() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Applications/ChromeDrivers/chromedriver/");
        WebDriver driver = new ChromeDriver();
        String url = "https://openweathermap.org/";
        String expectedResult1 = "reCAPTCHA verification failed, please try again.";
        String emailField = "tests@test.com";
        String wordField = "Hello";

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement buttonSupport = driver.findElement(
                By.xpath("//div[@id = 'support-dropdown']")
        );

        buttonSupport.click();
        Thread.sleep(2000);

        String originalWindow = driver.getWindowHandle();
        WebElement buttonAscQuestion = driver.findElement(
                By.xpath("//ul[@id = 'support-dropdown-menu']//li[3]/a")
        );

        buttonAscQuestion.click();
        Thread.sleep(2000);

        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        WebElement clickWindowMail = driver.findElement(
                By.xpath("//div[@class = 'form-group email required question_form_email']//div/input")
        );

        clickWindowMail.click();
        clickWindowMail.sendKeys(emailField);


        WebElement clickWindowSubject = driver.findElement(
                By.xpath("//div[@class = 'form-group select required question_form_subject']//div//select")
        );
        clickWindowSubject.click();

        WebElement chooseThreePosition = driver.findElement(
                By.xpath("//form[@id]/div[6]/div/select/option[3]")
        );
        chooseThreePosition.click();

        WebElement clickWindowMessage = driver.findElement(
                By.xpath("//div[@class = 'form-group text required question_form_message']" +
                        "//textarea[@class = 'form-control text required']")
        );
        clickWindowMessage.click();
        clickWindowMessage.sendKeys(wordField);
        Thread.sleep(3000);

        WebElement clickWindowSubmit = driver.findElement(
                By.xpath("//div//input[@class = 'btn btn-default']")
        );
        clickWindowSubmit.click();

        WebElement displayRecaptchaOnWindow = driver.findElement(
                By.xpath("//div//div[text() = 'reCAPTCHA verification failed, please try again.']")
        );
        String actualResult = displayRecaptchaOnWindow.getText();

        Assert.assertEquals(actualResult, expectedResult1);

        driver.quit();



    }

    //    TC_11_06
//    1.  Открыть базовую ссылку
//    2.  Нажать пункт меню Support → Ask a question
//    3.  Оставить значение по умолчанию в checkbox Are you an OpenWeather user?
//    4.  Оставить пустым поле Email
//    5.  Заполнить поля  Subject, Message
//    6.  Подтвердить CAPTCHA
//    7.  Нажать кнопку Submit
//    8.  Подтвердить, что в поле Email пользователю будет показана ошибка "can't be blank"

    @Test
    public void testErrorEmail() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/ChromeDrivers/chromedriver/");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String subject = "Other";
        String message = "Hi Lilu we are waiting for you";

        String expectedResult = "can't be blank";


        driver.get(url);

        Thread.sleep(5000);
        driver.manage().window().maximize();

        WebElement clickOnSupport = driver.findElement(By.xpath("//div[@id='support-dropdown']"));
        clickOnSupport.click();

        String originalWindow = driver.getWindowHandle();
        Thread.sleep(4000);
        WebElement selectSubmenu_AskAQuestion = driver.findElement(By.xpath(
                "//ul[@id='support-dropdown-menu']//a[@href='https://home.openweathermap.org/questions']"));
        selectSubmenu_AskAQuestion.click();

        Thread.sleep(4500);

        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Thread.sleep(3000);

        WebElement enterSubject = driver.findElement(By.xpath(
                "//select[@class='form-control select required']"));

        enterSubject.click();

        enterSubject.sendKeys(subject);

        Thread.sleep(4000);

        WebElement enterMessage = driver.findElement(By.xpath(
                "//textarea[@class='form-control text required']"));
        enterMessage.click();
        enterMessage.sendKeys(message);

        Thread.sleep(5000);

        String window2 = driver.getWindowHandle();

        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='reCAPTCHA']")));

        WebElement enterCaptcha = driver.findElement(By.xpath(
                "//span[@class='recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked "
                        + "rc-anchor-checkbox']"));
        enterCaptcha.click();

        Thread.sleep(10000);

        driver.switchTo().window(window2);

        WebElement pressSubmit = driver.findElement(By.xpath(
                "//input[@data-disable-with='Create Question form']"));
        pressSubmit.click();

        WebElement confirmErrorEmail = driver.findElement(By.xpath("//span[@class='help-block']"));

        String actualResult = confirmErrorEmail.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

//    TC_11_07.Открыть базовую ссылку
//2.  Нажать на единицы измерения Imperial: °F, mph
//3.  Нажать на единицы измерения Metric: °C, m/s
//4.  Подтвердить, что в результате этих действий, единицы измерения температуры изменились с F на С

    @Test

    public void testChangeTemperature() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/ChromeDrivers/chromedriver/");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult = "°F";
        String expectedResult1 = "°C";
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement clickButtonFahrenheit = driver.findElement(
                By.xpath("//div[text() = 'Imperial: °F, mph']")
        );
        clickButtonFahrenheit.click();
        Thread.sleep(4000);

        WebElement spanHeading = driver.findElement(
                By.xpath("//div[@class = 'current-container mobile-padding']//span[@class = 'heading']")
        );

        String spanHeadingTextFahre = spanHeading.getText();
        String actualResult = spanHeadingTextFahre.substring(spanHeadingTextFahre.length() - 2);

        Assert.assertEquals(actualResult, expectedResult);

        WebElement spanHeadingCelsium = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']/div/div/div/div/div/div[2]")
        );
        spanHeadingCelsium.click();
        Thread.sleep(4000);

        String spanHeadingTextCelsium  = spanHeading.getText();
        String actualResult1 = spanHeadingTextCelsium.substring(spanHeadingTextCelsium.length() -2);

        Assert.assertEquals(actualResult1, expectedResult1);

        driver.quit();




    }

//    TC_11_08
//1.  Открыть базовую ссылку
//2.  Нажать на лого компании
//3.  Дождаться, когда произойдет перезагрузка сайта, и подтвердить, что текущая ссылка не изменилась

    @Test
    public void checkSitereload() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/ChromeDrivers/chromedriver/");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "https://openweathermap.org/";
        driver.get(url);
        Thread.sleep(5000);

        WebElement imageLogoSite = driver.findElement(
                By.xpath("//body[@class = 'body-orange']//ul[@id = 'first-level-nav']//a/img")
        );
        imageLogoSite.click();
        Thread.sleep(5000);

        String expectedResult = "https://openweathermap.org/";
        String actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();

    }

//    TC_11_09
//1.  Открыть базовую ссылку
//2.  В строке поиска в навигационной панели набрать “Rome”
//3.  Нажать клавишу Enter
//4.  Подтвердить, что вы перешли на страницу в ссылке которой содержатся слова “find” и “Rome”
//5.  Подтвердить, что в строке поиска на новой странице вписано слово “Rome”


    @Test
    public void testTypeInSearchBarRome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/ChromeDrivers/chromedriver/");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        driver.manage().window().maximize();
        driver.get(url);
        Thread.sleep(5000);
        String cityName = "Rome";
        String expectedResult = "https://openweathermap.org/find?q=Rome";
        String expectedResult1 = "Rome";

        WebElement weatherInYourcity = driver.findElement(
                By.xpath("//div[@id = 'desktop-menu']/form/input[1]")
        );
        weatherInYourcity.click();
        weatherInYourcity.sendKeys(cityName);
        weatherInYourcity.submit();
        String actualResult = driver.getCurrentUrl();

        WebElement theWordIsWritten = driver.findElement(
                By.id("search_str")//поиск по id нужного элемента
        );
        String actualResult1 = theWordIsWritten.getAttribute("value");//ищем по значению

        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertEquals(actualResult1, expectedResult1);

        driver.quit();

    }





//    TC_11_10
//1.  Открыть базовую ссылку
//2.  Нажать на пункт меню API
//3.  Подтвердить, что на открывшейся странице пользователь видит 30 оранжевых кнопок

    @Test
    public void testDeskTopMenuClickAPIFind30Buttons1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/ChromeDrivers/chromedriver/");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        driver.get(url);
        driver.manage().window().maximize();
        int expectedResult = 30;
        Thread.sleep(5000);

        WebElement elementApi = driver.findElement(
                By.xpath("//div[@id = 'desktop-menu']//a[text()= 'API']"));
        elementApi.click();

        int countButton = driver.findElements(
                By.xpath("//a[contains(@class, 'btn_block orange round') " +
                        "or contains(@class, 'ow-btn round btn-orange') ]")).size();//проверяем наличие элементов

        int actualResult = countButton;


        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();

    }


}
