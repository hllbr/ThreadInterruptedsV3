
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.applet.Main;


public class NewClass {
    public static void main(String[] args) {
                List<Integer> list = new LinkedList<Integer>();
        
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread Çalışıyor");
                for(int i = 0 ;i<1000000;i++){
                    //burada bize herhangi bir interrupt yapılıp yapılmadığını kontrol etmem gerekiyor.
                    //ben bunu bir exception sayesinde yapmıyorum.Bu işlem için Thread metodu içindeki bir metodu kullanarak gerçekleştirmeye çalışacağım
                    if(Thread.currentThread().isInterrupted()){
                        //currentThread() = mevcut thread , isInterrupted()= interrupt uğradığysa true dönen yapımız.
                        System.out.println("Kesintiye Uğradı.");
                        return;//void metodumu return yardmı ile sonlandırabilirim.
                        
                    }
                    list.add(i);
                }
                    
                
                System.out.println("Thread Kesintiye Uğramadan Işini Bitirdi...");
            }
        });
        t1.start();
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        t1.interrupt();
        
    }
    
}
