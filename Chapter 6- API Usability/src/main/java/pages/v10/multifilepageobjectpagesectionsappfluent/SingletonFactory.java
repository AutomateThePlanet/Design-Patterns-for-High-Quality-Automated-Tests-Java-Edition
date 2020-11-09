package pages.v10.multifilepageobjectpagesectionsappfluent;

import java.util.HashMap;
import java.util.Map;

// Based on http://neutrofoton.github.io/blog/2013/08/29/generic-singleton-pattern-in-java/
// Can be used inside App design pattern.
public class SingletonFactory {
    private static final SingletonFactory _instance = new SingletonFactory();

    private Map<String,Object> mapHolder = new HashMap<>();

    private SingletonFactory() {}

    public static <T> T getInstance(Class<T> classOf) {
        try
        {
            if(!_instance.mapHolder.containsKey(classOf.getName())){

                T obj = (T) classOf.getConstructors()[0].newInstance();
                _instance.mapHolder.put(classOf.getName(), obj);
            }

            return (T) _instance.mapHolder.get(classOf.getName());
        }
        catch (Exception e)
        {
            // not the best practice to return null. But probably we will never end here so it is OK.
            return null;
        }
    }
}
