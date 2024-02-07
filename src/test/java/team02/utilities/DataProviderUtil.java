package team02.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {
    @DataProvider
    public Object[][] veriler() {
        return new Object[][]{{"erol"},{"evren"},{"ahmet"}};
    }
}
