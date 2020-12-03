package JDrones;
import java.util.ArrayList;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import javax.swing.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Dron extends Thread{
    
    private MiX x;
    private MiY y;
    private DibujaDrones panel;
    private int a=1;
    private int b=1;
    private Circulos miC;
    private int met;
    private ArrayList<Dron> drones;
    private Lock mutex,mutexC;
    private     Semaphore semaforo;
    private Monitor monitor;
     CyclicBarrier barreraInicio;
     CyclicBarrier barreraFin;
      private Lock variableCondition;
           private Lock vc;
           private Condition condition;
   Dron( DibujaDrones panel, Circulos c,  int met /*, double[] datosX,double[] datosY*/){
        this.met = met;
        this.a=1;
        this.b=1;
        crearMet();
        this.x= c.getX();
        this.y = c.getY();
        this.miC = c;
        this.panel=panel;
        actualizar(panel.getDrones());
    }
   
    public  void run(){   
        while(true){ 
                switch(this.met){
                        case 0:                             
                                mutex.lock();
                                   SC();
                                   System.out.println("consume Mutex" );
                                   mutex.unlock();
                                break;
                       case 1:
                            try{
                                semaforo.acquire();
                              monitor =  new Monitor();}catch(Exception e){e.printStackTrace();}
                                              SC();
                                              System.out.println("consume Semaforo" ); 
                                               semaforo.release();
                            break;
                       case 2:
                               monitor.put();
                               SC();
                                System.out.println("consume Monitores" );     
                                monitor.get();
                               break;
                        case 3:
                
                        try {
                                barreraInicio.await();// Se queda bloqueado hasta que los 1 hilo termine.
                                barreraFin.await();// Se queda bloqueado hasta que los 1 hilo termine.
                                SC();
                                barreraInicio.await();
                                barreraFin.await();
                                 System.out.println("consume Barreras" );   
                        } catch (InterruptedException ex) {
                                Logger.getLogger(Dron.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (BrokenBarrierException ex) {
                                Logger.getLogger(Dron.class.getName()).log(Level.SEVERE, null, ex);
                        }
                
                               
                       break;
                        case 4:                            
                                try {
                                        mutexC.lock();
                                        condition.signal();
                                } catch (Exception ex) {
                                }finally{
                                        mutexC.unlock();
                                }     
                                SC();
                                System.out.println("consume Variable Condition" );   

                        break;
                }
                                
                                
                          
                }
          
    }
    
    public void crearMet(){{
            switch(this.met){
                    case 0:
                       mutex = new ReentrantLock();
                    break;
                     case 1:
                       semaforo = new Semaphore(1);
                    break;
                     case 2:
                        monitor =  new Monitor();
                    break;
                     case 3:
                           barreraInicio= new CyclicBarrier(1);
                           barreraFin = new CyclicBarrier( 1);
                    break;
                     case 4:
                           mutexC = new ReentrantLock();
                            variableCondition = new ReentrantLock();
                            condition = variableCondition.newCondition();                        
                    break;
            }
    }
            
    }
    
    public void SC(){
              y.setY(y.getY()+b);// = y+b;
                        x.setX(x.getX()+a);//;=x+a;
            
               if (y.getY()==miC.getLimYN())
                    b=-b;
                if (y.getY()==miC.getLimYP())
                    b=-b;
                if (x.getX()==miC.getLimXN())
                    a=-a;
                if (x.getX()==miC.getLimXP())
                    a=-a;
                miC.setX(x);
                miC.setY(y);
                panel.repaint();
            try {
                    Thread.sleep((int)( Math.random()+1) *5);
            } catch (InterruptedException ex) {
                    Logger.getLogger(Dron.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    

        void actualizar(ArrayList<Dron> drones) {
                for(Dron d: drones){
                       d.b  =1;
                       d.a  =1;
                }
        }
}
