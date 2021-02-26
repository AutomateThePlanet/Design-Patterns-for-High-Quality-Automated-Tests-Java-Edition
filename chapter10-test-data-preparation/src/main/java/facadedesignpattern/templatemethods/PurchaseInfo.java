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

package facadedesignpattern.templatemethods;

import configuration.BillingInfoDefaultValues;
import configuration.ConfigurationService;

import java.io.IOException;

public class PurchaseInfo {
    private String firstName;
    private String lastName;
    private String company;
    private String country;
    private String address1;
    private String address2;
    private String city;
    private String zip;
    private String phone;
    private String email;
    private Boolean shouldCreateAccount = false;
    private Boolean shouldCheckPayment = false;

    public PurchaseInfo() {
        var billingInfoDefaultValues = ConfigurationService.get(BillingInfoDefaultValues.class);
        this.firstName = billingInfoDefaultValues.getFirstName();
        this.lastName = billingInfoDefaultValues.getLastName();
        this.company = billingInfoDefaultValues.getCompany();
        this.country = billingInfoDefaultValues.getCountry();
        this.address1 = billingInfoDefaultValues.getAddress1();
        this.address2 = billingInfoDefaultValues.getAddress2();
        this.city = billingInfoDefaultValues.getCity();
        this.zip = billingInfoDefaultValues.getZip();
        this.phone = billingInfoDefaultValues.getPhone();
        this.email = billingInfoDefaultValues.getEmail();
        this.shouldCreateAccount = true;
        this.shouldCheckPayment = true;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getShouldCreateAccount() {
        return shouldCreateAccount;
    }

    public void setShouldCreateAccount(Boolean shouldCreateAccount) {
        this.shouldCreateAccount = shouldCreateAccount;
    }

    public Boolean getShouldCheckPayment() {
        return shouldCheckPayment;
    }

    public void setShouldCheckPayment(Boolean shouldCheckPayment) {
        this.shouldCheckPayment = shouldCheckPayment;
    }
}

// JAVA 14 Records

//public record PurchaseInfo(
//        String firstName,
//        String lastName,
//        String company,
//        String country,
//        String address1,
//        String address2,
//        String city,
//        String zip,
//        String phone,
//        String email,
//        Boolean shouldCreateAccount,
//        Boolean shouldCheckPayment) {
//    public PurchaseInfo() {
//        this(ConfigurationService.get(BillingInfoDefaultValues.class).getFirstName(),
//                ConfigurationService.get(BillingInfoDefaultValues.class).getLastName(),
//                ConfigurationService.get(BillingInfoDefaultValues.class).getCompany(),
//                ConfigurationService.get(BillingInfoDefaultValues.class).getCountry(),
//                ConfigurationService.get(BillingInfoDefaultValues.class).getAddress1(),
//                ConfigurationService.get(BillingInfoDefaultValues.class).getAddress2(),
//                ConfigurationService.get(BillingInfoDefaultValues.class).getCity(),
//                ConfigurationService.get(BillingInfoDefaultValues.class).getZip(),
//                ConfigurationService.get(BillingInfoDefaultValues.class).getPhone(),
//                ConfigurationService.get(BillingInfoDefaultValues.class).getEmail(),
//                true,
//                true);
//    }
//}
