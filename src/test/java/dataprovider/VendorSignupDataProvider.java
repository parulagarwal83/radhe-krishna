package dataprovider;

import models.ui.TestData;
import org.testng.annotations.DataProvider;
import util.YamlReader;

import java.util.Random;

/**
 * Created by chandanjavaregowda on 25/06/17.
 */
public class VendorSignupDataProvider {
    private static TestData data = new YamlReader("data.yml").readTestData();

    @DataProvider(name = "signup")
    public static Object[][] dataProvider() {
        return new Object[][] {
                {generateRandomName(), generateRandomName(), generateRandomName(), generateRandomMobileNumber(), "Please enter a valid email address"},
                {generateRandomName(), generateRandomName(), generateRandomPassword()+data.getEmailId(), "96866", "Please use a country code starting with +(plus) along with phone number"}
        };
    }

    private static String generateRandomName(){
        String alphaNumerics = data.getRandomText();
        String name = "";
        for (int i = 0; i < 8; i++) {
            name += alphaNumerics.charAt((int) (Math.random() * alphaNumerics.length()));
        }
        return name;
    }

    private static String generateRandomMobileNumber(){
        String num = data.getMobileNumberPrefix();
        Random random = new Random();
        String endingNum = String.format("%04d", random.nextInt(10000));
        return num + endingNum;
    }

    private static String generateRandomPassword(){
        String alphaNumeric = data.getRandomText();
        String password = "";
        for (int i = 0; i < 8; i++) {
            password += alphaNumeric.charAt((int) (Math.random() * alphaNumeric.length()));
        }
        return password;
    }
}
