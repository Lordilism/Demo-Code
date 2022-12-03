package Chapter11_Multithreading;
// implement Runnable
class MyThread implements Runnable{
    String name;
    Thread thread;
    MyThread(String name){
        this.name= name;
        thread = new Thread(this);
    }

    @Override
    public void run() {
        for (int i=0; i<10; i++){

                System.out.println("Name "+ this.name+ "  i=> "+i);


        }

    }
    void start(){
        this.thread.start();
    }
    void join() throws InterruptedException {
        this.thread.join();

    }
}
//Extending Thread
// We use (Extend Thread) when our cannot extend anymore.
class MyThread2 extends Thread{
    String name;
    MyThread2(String name){
        this.name= name;
    }


    @Override
    public void run() {
        for (int i=1; i<11; i++){
            System.out.println("Name "+ this.name +" i=> "+ i);
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread m1 = new MyThread("Thread One");
        MyThread m2 = new MyThread("Thread Two");
        MyThread2 m3 = new MyThread2("Thread Three");
        System.out.println("Is m1 is alive before start " + m1.thread.isAlive());
        m1.thread.setPriority(Thread.MAX_PRIORITY);
        m1.start();
        System.out.println("Is m1 is alive after run "+ m1.thread.isAlive());
        m2.start();
        m3.start();
        try{
            m1.join();
            m2.join();
            m3.join();
            System.out.println("Main Done");
        }catch (InterruptedException e){
            e.printStackTrace();
        }



    }
}
