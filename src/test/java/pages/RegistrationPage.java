package pages;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPage {

    private String dayValue = ".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)",
            hobbyPicker = "//label[contains(text(),'%s')]";
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            phoneInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            monthOfCalendar = $(".react-datepicker__month-select"),
            yearOfCalendar = $(".react-datepicker__year-select"),
            subjectInput = $("#subjectsInput"),
            pictureUploadInput = $("#uploadPicture"),
            state = $(byText("Select State")),
            city = $(byText("Select City")),
            submitButton = $("#submit"),
            titleModalWindow = $("#example-modal-sizes-title-lg"),
            firstNameAndLastNameCell = $(byXpath("//table/tbody/tr[1]/td[2]")),
            emailCell = $x("//table/tbody/tr[2]/td[2]"),
            genderCell = $x("//table/tbody/tr[3]/td[2]"),
            phoneNumberCell = $x("//table/tbody/tr[4]/td[2]"),
            dateOfBirthCell = $x("//table/tbody/tr[5]/td[2]"),
            subjectCell = $x("//table/tbody/tr[6]/td[2]"),
            hobbyCell = $x("//table/tbody/tr[7]/td[2]"),
            imageCell = $x("//table/tbody/tr[8]/td[2]"),
            stateAndCityCell = $x("//table/tbody/tr[10]/td[2]");

    //input
    public void typeFirstName(String firstName) {
        firstNameInput.val(firstName);
    }

    public void typeLastName(String lastName) {
        lastNameInput.val(lastName);
    }

    public void typeUserEmail(String email) {
        emailInput.val(email);
    }

    public void selectUserGender(String gender) {
        $(byText(gender)).click();
    }

    public void typeUserPhone(String phone) {
        phoneInput.val(phone);
    }

    public void setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        monthOfCalendar.selectOption(month);
        yearOfCalendar.selectOption(year);
        $(String.format(dayValue, day)).click();
    }

    public void selectSubject(String value) {
        subjectInput.val(value).pressEnter();
    }

    public void selectHobby(String hobby) {
        $(byXpath(String.format(hobbyPicker, hobby))).click();
    }

    public void uploadPicture(File picture) {
        pictureUploadInput.uploadFile(picture);
    }

    public void selectState(String value) {
        state.scrollTo().click();
        $(byText(value)).click();
    }

    public void selectCity(String value) {
        city.click();
        $(byText(value)).click();
    }

    public void clickSubmit() {
        submitButton.click();
    }
    //checking

    private void verifyRowValue(String key, String value) {
        String xpath = String.format("//td[text()=\"%s\"]", key);
        $x(xpath).sibling(0).shouldHave(exactText(value));
    }

    public void verifyAllFilledCorrect(String firstName, String lastName, String email, String gender, String phoneNumber,
                                       String dayBirthday, String monthBirthday, String yearBirthday, String subject,
                                       String hobby, String fileName, String state, String city) {
        verifyRowValue("Student Name", firstName + " " + lastName);
        verifyRowValue("Student Email", email);
        verifyRowValue("Gender", gender);
        verifyRowValue("Mobile", phoneNumber);
        verifyRowValue("Date of Birth", dayBirthday + " " + monthBirthday + "," + yearBirthday);
        verifyRowValue("Subjects", subject);
        verifyRowValue("Hobbies", hobby);
        verifyRowValue("Picture", fileName);
        verifyRowValue("State and City", state + " " + city);
    }

}
