package MedunnaEndToEnd.pages;

public class MedunnaHomePage {
    public MedunnaHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "account-menu")
    public WebElement userIcon;

    @FindBy(id = "login-item")
    public WebElement signInOption;

    @FindBy(id = "entity-menu")
    public WebElement itemsdAndTitles;

    @FindBy(linkText = "Room")
    public WebElement roomOption;

}
