package pagefactories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {

    WebDriver driver;

    public RegisterPage(WebDriver driverConstructor){
        driver = driverConstructor;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "firstName")
    WebElement firstNameField;

    @FindBy(name = "lastName")
    WebElement lastNameField;

    @FindBy(name = "phone")
    WebElement phoneNumberField;

    @FindBy(name = "userName")
    WebElement emailField;

    @FindBy(name = "address1")
    WebElement streetField;

    @FindBy(name = "city")
    WebElement cityField;

    @FindBy(name = "state")
    WebElement stateField;

    @FindBy(name = "postalCode")
    WebElement zipCodeField;

    @FindBy(name = "country")
    WebElement countryField;

    @FindBy(name = "email")
    WebElement userNameField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(name = "confirmPassword")
    WebElement confirmPasswordField;

    @FindBy(name = "submit")
    WebElement submitButton;

    public void fillFirstNameField(String input){
        firstNameField.sendKeys(input);
    }

    public void fillLastNameField(String input){
        lastNameField.sendKeys(input);
    }

    public void fillPhoneNumberField(String input){
        phoneNumberField.sendKeys(input);
    }

    public void fillEmailField(String input){
        emailField.sendKeys(input);
    }

    public void fillStreetField(String input){
        streetField.sendKeys(input);
    }

    public void fillCityField(String input){
        cityField.sendKeys(input);
    }

    public void fillStateField(String input){
        stateField.sendKeys(input);
    }

    public void fillZipCodeField(String input){
        zipCodeField.sendKeys(input);
    }

    public void setCountryField(String countryName){
        Select countryDropDown = new Select(countryField);
        countryDropDown.selectByValue(countryName);
    }

    public void fillUserNameField(String input){
        userNameField.sendKeys(input);
    }

    public void fillPasswordField(String input){
        passwordField.sendKeys(input);
        confirmPasswordField.sendKeys(input);
    }

    public void submitForm(){
        submitButton.click();
    }

}
