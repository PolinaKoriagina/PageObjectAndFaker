package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void setUp() {
        // choose the browser and size
        Configuration.startMaximized = true;
        System.out.println("commit 1");
        System.out.println("commit 2");
        System.out.println("commit 3");
    }
}