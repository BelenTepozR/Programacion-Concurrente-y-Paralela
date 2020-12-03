package JDrones;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DronBarreras extends Thread{
   
    private DibujaDrones panel;
    private int a = 1;
    private int b = 1;
    int numeroHilos = 0;
    private int limXI = 0, limXS = 1000, limYI = 0, limYS = 650;
    private Dron dron;
    //private Barreras barr; 
    final CyclicBarrier barreraInicio;
    final CyclicBarrier barreraFin;
    DronBarreras(DibujaDrones panel, Dron dron){
        this.panel=panel;
        //barr = new Barreras();
        barreraInicio= new CyclicBarrier(numeroHilos + 1);
        barreraFin = new CyclicBarrier(numeroHilos + 1);
        this.dron = dron;
    }

    
      
    public void run(){
        while(true){
            try{
                barreraInicio.await();// Se queda bloqueado hasta que los 1 hilo termine.
      
                barreraFin.await();// Se queda bloqueado hasta que los 1 hilo termine.
                try{
                    System.out.println("levanto barrera");
            barreraInicio.await();
            barreraFin.await();
                    Thread.sleep(4);
                }catch(Exception e){e.printStackTrace();}
            }catch(InterruptedException ex){Logger.getLogger(DronBarreras.class.getName()).log(Level.SEVERE, null, ex);} catch (BrokenBarrierException ex) {
                Logger.getLogger(DronBarreras.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
   
    
}
