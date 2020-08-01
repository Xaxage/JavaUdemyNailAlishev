package MultiThreading;

import java.util.Scanner;

public class VolatileThread {
    public static void main(String[] args) {
        MyThreadVolatile myThread1=new MyThreadVolatile();
        myThread1.start();

        Scanner scanner=new Scanner(System.in);
        scanner.nextLine();
//here our main thread stops and waits until we input smth.
// After input, in next line we close our "MyThreadVolatile" thread.

        myThread1.shutdown();
    }
}
class MyThreadVolatile extends Thread{
    private volatile boolean running=true;
    //If our threads use the same values we use "volatile",
    // so this variable will be synchronized in each thread using it.

    public void run(){
        while(running)
            System.out.println("Hello");
            try {
                Thread.sleep(1000);
                //before doing next task it will wait for 1 sec.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
     public void shutdown(){
        this.running=false;
     }
}
