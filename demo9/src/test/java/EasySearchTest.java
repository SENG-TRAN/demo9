import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EasySearchTest {
    WebDriver driver;

    @BeforeEach
    void setup() {
        // Tự động tải driver phù hợp với máy
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Chờ ngầm định 10 giây cho chắc
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    void testSearchProduct() throws InterruptedException {
        // 1. Truy cập trang eBay
        driver.get("https://www.ebay.com/");

        // 2. Sử dụng WebDriverWait để đợi ô tìm kiếm xuất hiện (Cực kỳ quan trọng!)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gh-ac")));

        // 3. Nhập sản phẩm và nhấn phím ENTER luôn (Không cần tìm nút Search nữa)
        // Cách này cực kỳ ổn định và giống người dùng thật
        searchBox.sendKeys("iPhone 15 Pro Max", Keys.ENTER);

        // 4. Đợi 5 giây để xem kết quả hiện ra rực rỡ
        Thread.sleep(5000);

    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit(); // Đóng trình duyệt sạch sẽ
        }
    }
}