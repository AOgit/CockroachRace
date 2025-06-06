import task.Cockroach;

import java.util.Random;
import java.util.Scanner;

public class CockroachRaceAppl {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of cockroaches: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter distance(number of iterations): ");
        int laps = scanner.nextInt();
        scanner.close();


        Random random = new Random();
        int randomSleep = random.nextInt(4) + 1;
        Cockroach.setLaps(laps);
        Cockroach.setSleep(randomSleep);

        Thread[] threads = new Thread[quantity];

        for (int i = 0; i < quantity; i++) {
           threads[i] = new Thread(new Cockroach(i+1));
           threads[i].start();
        }

        for (int i = 0; i < quantity; i++) {
            threads[i].join();
        }

        System.out.println("Winner is cockroach #" + Cockroach.getWinner());
    }
}
