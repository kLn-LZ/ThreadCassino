package Controller;

import java.util.concurrent.Semaphore;

public class CassinoController extends Thread{

    Semaphore semaforo;
    int pontos;
    static int rank = 0;
    int idThread;
    public CassinoController(int idThread, Semaphore semaforo) {
        this.idThread = idThread;
        this.semaforo =semaforo;
    }

    @Override
    public void run() {
        jogarDados();
        try {
            semaforo.acquire();
            rankFinal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
          semaforo.release();
        }


    }



    private void rankFinal() {
        rank++;
        System.out.println("Competidor #" + idThread + " Venceu em " + rank + "º lugar");
        if(rank == 1) {
            System.out.println("Competidor #" + idThread + " ganhou 5000 dinheiros");
        } else if (rank == 2) {
            System.out.println("Competidor #" + idThread + " ganhou 4000 dinheiros");
        } else if (rank == 3) {
            System.out.println("Competidor #" + idThread + " ganhou 3000 dinheiros");
        } else {
            System.out.println("Competidor #" + idThread + " ganhou nada");
        }
    }

    private void jogarDados() {
        int dado1;
        int dado2;
        int somaDados;

        while(pontos < 5) {
            dado1 = (int) (Math.random() * 7) + 1;
            dado2 = (int) (Math.random() * 7) + 1;

            somaDados = dado1 + dado2;
            if(somaDados == 7 || somaDados == 11) {
                pontos++;
            }

        }

    }

}
