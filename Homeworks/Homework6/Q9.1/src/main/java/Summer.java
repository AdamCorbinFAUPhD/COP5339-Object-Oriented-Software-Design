import java.util.Random;

public class Summer {

    int total = 0;
    int threadCountComplete = 0;

    /**
     * @param n the upper limit
     * @param k the number of threads
     * @return the sum 1 + 2 + ... + n computed with k threads
     * @throws InterruptedException possible for a thread to be interrupted
     */
    int sum(int n, int k) throws InterruptedException {
        for (int j = 0; j < k; j++) {
            final int finalJ = j;
            new Thread(() -> {
                try {
                    //The +1 is to shift the window to start a 1 and to include N
                    int start = (finalJ *n/k) + 1;
                    int end = ((finalJ + 1) * n/k) + 1;
                    addToTotal(addRange(start, end));
                    markThreadComplete();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        //Wait until all the threads have been completed
        while (threadCountComplete != k) {
            Thread.sleep(20);
        }

        threadCountComplete = 0; // reset the thread complete counts
        //Reset the total for another run
        int localTotal = total;
        total = 0;
        return localTotal;
    }

    /**
     * @param subTotal Adding the sub total to a thread protected total
     * @throws InterruptedException possible for a thread to be interrupted
     */
    public synchronized void addToTotal(int subTotal) throws InterruptedException {
        total += subTotal;
    }

    /**
     * Count of the threads that have finished processing
     * @throws InterruptedException possible for a thread to be interrupted
     */
    public synchronized void markThreadComplete() throws InterruptedException {
        threadCountComplete += 1;
    }

    /**
     * Simple function to add a range of values
     * @param start start range to be added
     * @param end end range to be added but not included
     * @return total between [start,end)
     */
    int addRange(int start, int end) {
        int localTotal = 0;
        for (int i = start; i < end; i++) {
            localTotal += i;
        }
        return localTotal;
    }

    public static void main(String[] args) throws InterruptedException {
        Summer summer = new Summer();
        Random random = new Random();
        // Test 5 random numbers with random number of loops

        System.out.println("Testing 5 random numbers with random number of threads");
        System.out.println("|Number test|# of threads\t|Summer Total\t|Formula total\t|Equal?|");
        for (int i = 0; i < 5; i++) {
            int n = random.nextInt(6204);
            int randThreads = random.nextInt(42);
            int total = summer.sum(n, randThreads);
            int testSum = n * (n+1) / 2;
            System.out.println("|" + n + "\t\t|" + randThreads + "\t\t\t\t|" + total + "\t\t|" + testSum + "\t\t|" + (total == testSum) );
        }
    }
}
