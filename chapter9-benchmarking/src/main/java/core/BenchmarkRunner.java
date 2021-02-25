/*
 * Copyright 2021 Automate The Planet Ltd.
 * Author: Anton Angelov
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package core;

import core.browserinfrastructure.BaseBenchmark;
import core.browserinfrastructure.BrowserBehavior;
import core.browserinfrastructure.ExecutionBrowser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.profile.GCProfiler;
import org.openjdk.jmh.profile.StackProfiler;
import org.openjdk.jmh.profile.WinPerfAsmProfiler;
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
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Thread)
@Warmup(iterations = 0)
@Measurement(iterations = 10)
@ExecutionBrowser(browser = Browser.CHROME, browserBehavior = BrowserBehavior.RESTART_EVERY_TIME)
public class BenchmarkRunner extends BaseBenchmark {
    private final String TEST_PAGE = "http://htmlpreview.github.io/?https://github.com/angelovstanton/AutomateThePlanet/blob/master/WebDriver-Series/TestPage.html";

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BenchmarkRunner.class.getSimpleName())
                //.addProfiler(WinPerfAsmProfiler.class)
                .addProfiler(StackProfiler.class)
                 .addProfiler(GCProfiler.class)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Override
    public void setup(PluginState pluginState) throws NoSuchMethodException, ClassNotFoundException {
        setCurrentClass(BenchmarkRunner.class);
        super.setup(pluginState);
    }

    @Override
    public void init(Driver driver) {
        driver.goToUrl(TEST_PAGE);
    }

    @Benchmark
    public void benchmarkWebDriverClick(PluginState pluginState) {
        var buttons = PluginState.getDriver().findElements(By.xpath("//input[@value='Submit']"));
        for (var button : buttons) {
            button.click();
        }
    }

    @Benchmark
    public void benchmarkJavaScriptClick(PluginState pluginState) {
        var buttons = pluginState.getDriver().findElements(By.xpath("//input[@value='Submit']"));
        for (var button:buttons) {
            pluginState.getDriver().executeScript("arguments[0].click();", button);
        }
    }
}

//package core;
//
//        import io.github.bonigarcia.wdm.WebDriverManager;
//        import org.openjdk.jmh.annotations.*;
//        import org.openjdk.jmh.runner.Runner;
//        import org.openjdk.jmh.runner.RunnerException;
//        import org.openjdk.jmh.runner.options.Options;
//        import org.openjdk.jmh.runner.options.OptionsBuilder;
//        import org.openqa.selenium.By;
//        import org.openqa.selenium.JavascriptExecutor;
//        import org.openqa.selenium.WebDriver;
//        import org.openqa.selenium.chrome.ChromeDriver;
//
//        import java.util.concurrent.TimeUnit;

//@BenchmarkMode(Mode.AverageTime)
//@OutputTimeUnit(TimeUnit.MILLISECONDS)
//@State(Scope.Benchmark)
//@Warmup(iterations = 3)
//@Measurement(iterations = 8)
//public class BenchmarkRunner {
//    private final String TEST_PAGE = "http://htmlpreview.github.io/?https://github.com/angelovstanton/AutomateThePlanet/blob/master/WebDriver-Series/TestPage.html";
//    private WebDriver driver;
//
//    public static void main(String[] args) throws RunnerException {
//
//        Options opt = new OptionsBuilder()
//                .include(BenchmarkRunner.class.getSimpleName())
//                .forks(1)
//                .build();
//
//        new Runner(opt).run();
//    }
//
//    @Setup
//    public void setup() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.navigate().to(TEST_PAGE);
//    }
//
//    @TearDown
//    public void tearDown() {
//        driver.close();
//    }
//
//    @Benchmark
//    public void benchmarkWebDriverClick() {
//        var buttons = driver.findElements(By.xpath("//input[@value='Submit']"));
//        for (var button:buttons) {
//            button.click();
//        }
//    }
//
//    @Benchmark
//    public void benchmarkJavaScriptClick() {
//        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
//        var buttons = driver.findElements(By.xpath("//input[@value='Submit']"));
//        for (var button:buttons) {
//            javascriptExecutor.executeScript("arguments[0].click();", button);
//        }
//    }
//}