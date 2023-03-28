package org.example;

public class Launcher {
    public static void main(String[] args) throws Exception {
        System.out.println("Launcher");

        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("--->> Sleep");
            LoadNow loadNow = new LoadNow();
            System.out.println("Load now done");
        }).start();
    }
}
