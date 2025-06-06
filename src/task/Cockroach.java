package task;

public class Cockroach implements Runnable {
    public int number;
    private static int winner;
    private static int sleep;
    private static int laps;

    public Cockroach(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 1; i <= laps; i++) {
            System.out.printf("Cockroach #%d: %d lap\n", number, i);
            try {
                Thread.sleep(Cockroach.sleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
//        System.out.printf("Cockroach #%d finished\n", number );
        if (Cockroach.winner == 0) {
            Cockroach.winner = number;
//            System.out.println("Winner is #" + number);
        }
    }

    public static int getWinner() {
        return winner;
    }

    public static void setSleep(int sleep) {
        Cockroach.sleep = sleep;
    }

    public static void setLaps(int laps) {
        Cockroach.laps = laps;
    }
}
