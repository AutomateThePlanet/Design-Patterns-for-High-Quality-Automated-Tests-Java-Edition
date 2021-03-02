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

package pages.v8.multifilepageobjectsectionssingleton;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

// Based on http://neutrofoton.github.io/blog/2013/08/29/generic-singleton-pattern-in-java/
// Can be used inside App design pattern.
public class SingletonFactory {
    private static final SingletonFactory instance = new SingletonFactory();
    private final Map<String, Object> mapHolder = new HashMap<>();

    private SingletonFactory() {
    }

    public static <T> T getInstance(Class<T> classOf) {
        if (!instance.mapHolder.containsKey(classOf.getName())) {
            T obj = null;
            try {
                obj = (T) classOf.getConstructors()[0].newInstance();
            } catch (InstantiationException e) {
                return obj;
            } catch (IllegalAccessException e) {
                return obj;
            } catch (InvocationTargetException e) {
                return obj;
            }
            instance.mapHolder.put(classOf.getName(), obj);
        }

        return (T) instance.mapHolder.get(classOf.getName());
    }

    public static <T> T getSynchronizedInstance(Class<T> classOf) {
        synchronized (SingletonFactory.class) {
            if (!instance.mapHolder.containsKey(classOf.getName())) {
                T obj = null;
                try {
                    obj = (T) classOf.getConstructors()[0].newInstance();
                } catch (InstantiationException e) {
                    return obj;
                } catch (IllegalAccessException e) {
                    return obj;
                } catch (InvocationTargetException e) {
                    return obj;
                }
                instance.mapHolder.put(classOf.getName(), obj);
            }

            return (T) instance.mapHolder.get(classOf.getName());
        }
    }
}
