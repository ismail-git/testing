package home;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by ismailosmanjan on 4/6/14.
 */
public class NavigationTab extends Base {


    @Test

    public void test() throws InterruptedException {

        List<WebElement> navTabLinks = getWebElementsByCss("#cnn_hdr-nav li");
        System.out.println(navTabLinks.size());
        for (int i = 1; i < navTabLinks.size(); i++) {
            if (i == 1 || i == 14 || i == 15) {
                navTabLinks.get(i).findElement(By.tagName("a")).click();
                navigateBack();
                sleep(2);
            } else {

                navTabLinks.get(i).findElement(By.tagName("a")).click();
                if (i == 5 || i == 6) {
                    navTabLinks = getWebElementsByCss("#cnn_hdr-nav li");
                    System.out.println("--------------------------- " + navTabLinks.get(i).getText() + " -----------------------------------------");
                    clickOnNews("#cnn_mtt1rgtarea .cnn_bulletbin");
                }
                sleep(2);
            }
            navTabLinks = getWebElementsByCss("#cnn_hdr-nav li");
        }

    }

    public void clickOnNews(String locator){
        List<String> news = getListOfString(locator);
        for (String st:news) {
            System.out.println(st);
        }
    }
}
