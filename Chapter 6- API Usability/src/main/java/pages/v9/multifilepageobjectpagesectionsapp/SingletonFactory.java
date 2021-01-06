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

package pages.v9.multifilepageobjectpagesectionsapp;

import pages.v8.multifilepageobjectsectionssingleton.MainPage.MainPage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
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
