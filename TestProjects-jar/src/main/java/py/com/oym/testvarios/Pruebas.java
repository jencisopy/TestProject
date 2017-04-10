/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.testvarios;


/**
 *
 * @author Jorge Enciso
 */
public class Pruebas {

    public static void main(String[] args) throws Exception {
        Thread thread1 = new Thread(new Threads());
        Thread thread2 = new Thread(new Threads());
        Thread thread3 = new Thread(new Threads());
        thread1.start();
        thread2.start();
        thread3.start();
    }


    static class Threads implements Runnable {
        @Override
        public void run() {
            try {
                TestEjb test = new TestEjb();                
                for (int i = 0; i < 10; i++) {
                    test.test();
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + "-" + i);                    
                }
            } catch (Exception exp) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
