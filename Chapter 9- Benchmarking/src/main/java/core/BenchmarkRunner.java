package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 3)
@Measurement(iterations = 8)
public class BenchmarkRunner {
    private final String TEST_PAGE = "http://htmlpreview.github.io/?https://github.com/angelovstanton/AutomateThePlanet/blob/master/WebDriver-Series/TestPage.html";
    private WebDriver driver;

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(BenchmarkRunner.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Setup
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(TEST_PAGE);
    }

    @TearDown
    public void tearDown() {
        driver.close();
    }

    @Benchmark
    public void benchmarkWebDriverClick() {
        var buttons = driver.findElements(By.xpath("//input[@value='Submit']"));
        for (var button:buttons) {
            button.click();
        }
    }

    @Benchmark
    public void benchmarkJavaScriptClick() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        var buttons = driver.findElements(By.xpath("//input[@value='Submit']"));
        for (var button:buttons) {
            javascriptExecutor.executeScript("arguments[0].click();", button);
        }
    }
}