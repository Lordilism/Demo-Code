package Chapter11_Multithreading;

public class MultiProgram {
    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();
        System.out.println("Name: "+ currentThread.getName());
        for(int i=0; i<10; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("I "+i );
        }
    }
}
