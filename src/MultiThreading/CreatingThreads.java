package MultiThreading;

public class CreatingThreads {
    public static void main(String[] args) {//It is a thread itself
        MyThread myThread1=new MyThread();//First way
        myThread1.start();

        MyThread myThread2=new MyThread();//First way
        myThread2.start();

        Thread thread=new Thread(new Runner());//Second way
        thread.start();
    }
}

class MyThread extends Thread{
//First way to create class for threads.After extending our class becomes Thread.
    public void run(){
        for(int i=0;i<=20;i++){
            try {
                Thread.sleep(1000);
                //before doing next task it will wait for 1 sec.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello from MyThread "+i);
        }
    }
}

class Runner implements Runnable{//Second way to create class for threads

    @Override
    public void run() {
    for(int i=0;i<=20;i++){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    }
}