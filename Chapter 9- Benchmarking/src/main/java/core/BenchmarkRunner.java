package core;

import core.browserinfrastructure.BaseBenchmark;
import core.browserinfrastructure.BrowserBehavior;
import core.browserinfrastructure.ExecutionBrowser;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Thread)
@Warmup(iterations = 0)
@Measurement(iterations = 10)
@ExecutionBrowser(browser = Browser.Chrome, browserBehavior = BrowserBehavior.RestartEveryTime)
public class BenchmarkRunner extends BaseBenchmark {
    private final String TEST_PAGE = "http://htmlpreview.github.io/?https://github.com/angelovstanton/AutomateThePlanet/blob/master/WebDriver-Series/TestPage.html";

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BenchmarkRunner.class.getSimpleName())
//                .addProfiler(WinPerfAsmProfiler.class)
//                .addProfiler(StackProfiler.class)
//                .addProfiler(GCProfiler.class)
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
        var buttons = pluginState.getDriver().findElements(By.xpath("//input[@value='Submit']"));
        for (var button:buttons) {
            button.click();
        }
    }

//    @Benchmark
//    public void benchmarkJavaScriptClick(PluginState pluginState) {
//        var buttons = pluginState.getDriver().findElements(By.xpath("//input[@value='Submit']"));
//        for (var button:buttons) {
//            pluginState.getDriver().executeScript("arguments[0].click();", button);
//        }
//    }
}