package com.testautomation;

import org.testng.annotations.*;

public class ConfigAnnotations {
    @BeforeSuite
    public void BeforeSuite(){
        System.out.println("chrome set - System Property");
    }

    @BeforeTest
    public void BeforeTest(){
        System.out.println("Chrome is Starting");
    }

    @BeforeClass
    public void OpenApp(){
        System.out.println("Start Test Application");
    }

    @BeforeMethod
    public void Login(){
        System.out.println("Enter Username and Pass");
    }

    @Test
    public void TestSearchBar(){
        System.out.println("Search for certain product");
    }

    @Test
    public void TestCart(){
        System.out.println("Check for selected products");
    }

    @AfterMethod
    public void Logout(){
        System.out.println("Press Logout");
    }

    @AfterClass
    public void CloseApp(){
        System.out.println("Close Application");
    }

    @AfterSuite
    public void CloseEnv(){
        System.out.println("Close Chrome");
    }

    @AfterTest
    public void CloseTest(){
        System.out.println("Chrome - Clean Cookies");
    }

}
