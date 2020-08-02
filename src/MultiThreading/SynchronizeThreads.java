package MultiThreading;

public class SynchronizeThreads {
    private int counter;

    public static void main(String[] args) throws InterruptedException {
        SynchronizeThreads test=new SynchronizeThreads();
        test.doWork();
    }

    public synchronized  void  increment(){
/*Only methods can use synchronized.In synchronized method's block everything
can be used only by  one thread at that moment .
A synchronized block in Java is synchronized on some object. */
            counter++;
    }

    public void doWork() throws InterruptedException {
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10000;i++)
                    increment();
            }
        });

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10000;i++)
                increment();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
/*Without join() method we can get value 0 , cause main thread doesnt wait
until thread1 and thread2 have been launched or are finished.
It immediately goes to the next line (sout).*/
        thread2.join();

        System.out.println(counter);
    }
}
