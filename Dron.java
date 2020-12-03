package JDrones;
import javax.swing.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class Dron extends Thread{
    private MiX x;
    private MiY y;
    private DibujaDrones panel;
    private int a=1;
    private int b=1;
    private double[] datosX;
    private double[] datosY;
    private Lock mutex;
    Dron(MiX x, MiY y, DibujaDrones panel, double[] datosX,double[] datosY){
        this.x=x;
        this.y=y;
        this.datosX=datosX;
        this.datosY=datosY;
        this.panel=panel;
        mutex = new ReentrantLock();
    }
    public  void run(){
        int iter=0;
        while(true){
            try{
                if(mutex.tryLock()){
                    mutex.lock();
                        y.setY(y.getY()+b);// = y+b;
                        x.setX(x.getX()+a);//;=x+a;
                    mutex.unlock();
                }
                //datosX[iter]=x.getX();
                //datosY[iter]=y.getY();
               if (y.getY()==430)
                    b=-b;
                if (y.getY()==0)
                    b=-b;
                if (x.getX()==520)
                    a=-a;
                if (x.getX()==-2)
                    a=-a;
                panel.ActuaslizaXY(x,y);
                panel.repaint();
                Thread.sleep(500);
            }catch(Exception e){e.printStackTrace();}
            iter++;
        }
    }
}
