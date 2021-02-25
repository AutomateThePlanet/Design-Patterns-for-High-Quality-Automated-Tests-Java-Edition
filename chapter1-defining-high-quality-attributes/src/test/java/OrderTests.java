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

package test.java;

import attributes.DiscountCalculator;
import attributes.GoldDiscountCalculator;
import attributes.PlatinumDiscountCalculator;
import attributes.SilverDiscountCalculator;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class OrderTests {
    @Test
    public void createDiscountWithoutInterfaces() throws NoSuchMethodException {
        List<DiscountCalculator> discountCalculators = new ArrayList<>();
        discountCalculators.add(new SilverDiscountCalculator());
        discountCalculators.add(new GoldDiscountCalculator());
        discountCalculators.add(new PlatinumDiscountCalculator());
        for (var discountCalculator : discountCalculators) {
            double bonusPointsDiscount = discountCalculator.calculateBonusPointsDiscount(1250, 10);
        }
    }

//    @Test
//    public void createDiscountWithInterfaces() {
//        List<BonusPointsDiscountCalculator> discountCalculators = new ArrayList<>();
//        discountCalculators.add(new SilverDiscountCalculator());
//        discountCalculators.add(new GoldDiscountCalculator());
//        // discountCalculators.add(new PlatinumDiscountCalculator()); //we cannot add it
//        for (var discountCalculator : discountCalculators) {
//            double bonusPointsDiscount = discountCalculator.calculateBonusPointsDiscount(1250, 10);
//        }
//    }
}