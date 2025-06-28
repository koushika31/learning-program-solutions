package org.koushika.demo;

public class PerformanceTester {
    public void performTask() {
        try {
            
            Thread.sleep(300);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
