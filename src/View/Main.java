package View;

import Controller.CassinoController;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        Semaphore semaforo = new Semaphore(1);
        for(int i = 1; i <= 10; i++) {
            CassinoController CC = new CassinoController(i, semaforo);
            CC.start();

        }



    }
}
