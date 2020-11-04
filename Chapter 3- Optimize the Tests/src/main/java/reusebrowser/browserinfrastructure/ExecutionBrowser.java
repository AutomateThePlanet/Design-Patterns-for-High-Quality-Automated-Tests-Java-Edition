package reusebrowser.browserinfrastructure;

import reusebrowser.Browser;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target( { ElementType.TYPE, ElementType.METHOD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface ExecutionBrowser {
    Browser useBrowser() default Browser.Chrome;
    BrowserBehavior useBrowserBehavior() default BrowserBehavior.RestartEveryTime;
}