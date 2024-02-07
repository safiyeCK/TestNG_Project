package team02.tests.US_07;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import team02.utilities.Driver;
import team02.utilities.ReusableMethods;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CompareMethods {


/*

    public static void compare(WebElement element){
        ReusableMethods.click(element);
        ReusableMethods.bekle(3);
        WebElement description= Driver.getDriver().findElement(By.xpath("(//li)[13]"));
        ReusableMethods.scroll(description);
        ReusableMethods.bekle(2);
        WebElement copmareButton= Driver.getDriver().findElement(By.xpath("(//*[@title='Compare'])[1]"));
        ReusableMethods.click(copmareButton);
        ReusableMethods.bekle(2);
        ReusableMethods.click(Driver.getDriver().findElement(By.xpath("//*[@class='compare-clean']")));
    }



   public static void compare(WebElement element1, WebElement element2,WebElement element3,WebElement element4, WebElement element5){
       List<WebElement> urunler= new ArrayList<WebElement>();
       urunler.add(element1);
       urunler.add(element2);
       urunler.add(element3);
       urunler.add(element4);
       urunler.add(element5);
       for (int i = 1; i < 6; i++) {
           ReusableMethods.click(urunler.get(i));
           ReusableMethods.bekle(3);

           WebElement description= Driver.getDriver().findElement(By.xpath("(//li)[13]"));
           ReusableMethods.scroll(description);
           ReusableMethods.bekle(2);

           WebElement copmareButton= Driver.getDriver().findElement(By.xpath("(//*[@title='Compare'])[1]"));
           ReusableMethods.click(copmareButton);
           ReusableMethods.bekle(2);
           Driver.getDriver().navigate().back();

       }

    }


    public static void compare(int urunidx){

        for (int i = 0; i < 4; i++) {
            ReusableMethods.click(Driver.getDriver().findElement(By.xpath("(//a[@class='woocommerce-LoopProduct-link woocommerce-loop-product__link'])["+(urunidx+i)+"]")));
            ReusableMethods.bekle(3);

            WebElement description= Driver.getDriver().findElement(By.xpath("(//li)[13]"));
            ReusableMethods.scroll(description);
            ReusableMethods.bekle(2);

            WebElement copmareButton= Driver.getDriver().findElement(By.xpath("(//*[@title='Compare'])[1]"));
            ReusableMethods.click(copmareButton);
            ReusableMethods.bekle(2);
            Driver.getDriver().navigate().back();
        }

    }
    static Random random = new Random();
    static Actions actions=new Actions(Driver.getDriver());
    public static void urunSec (){
        int randomNum = random.nextInt(32); // 0 dahil, 32 hariç
        List<Integer> numOfNonproduct= Arrays.asList(4,5,6,7,8,9,14,15);
        if (!numOfNonproduct.contains(randomNum)){
            List<WebElement> allProducts= Driver.getDriver().findElements(By.xpath("//a[@class='woocommerce-LoopProduct-link woocommerce-loop-product__link']"));
            WebElement randomProduct= allProducts.get(randomNum);
            ReusableMethods.scroll(randomProduct);
            actions.sendKeys(Keys.PAGE_DOWN);
            ReusableMethods.click(randomProduct);
        } else {
            urunSec();
        }
    }


 */




















    /*public static void compare(int urunidx, int idx){
        Actions actions= new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN,Keys.PAGE_DOWN);

        for (int i = 0; i < 5; i++) {

            actions.moveToElement(Driver.getDriver().
                    findElement(By.xpath("(//a[@class='woocommerce-LoopProduct-link woocommerce-loop-product__link'])["+(urunidx+i)+"]"))).perform();
            ReusableMethods.bekle(1);
            Driver.getDriver().findElement(By.xpath("(//a[@class='compare btn-product-icon'])["+(idx+i)+"]")).click();
            ReusableMethods.bekle(1);

        }
    }

     */


}
