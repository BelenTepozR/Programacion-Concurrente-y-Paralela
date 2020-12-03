/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDrones;

import java.awt.geom.Ellipse2D;

/**
 *
 * @author btepozromero
 */
public class Circulos {
  
         Ellipse2D c;
         private MiX x;
         private MiY y;
         private int limXP;
         private int limYP;
         private int limXN;
         private int limYN;
          private  Dron d;
        Circulos( Ellipse2D c){
                this.c = c;
        }

        public Ellipse2D getC() {
                return c;
        }

        public void setC(Ellipse2D c) {
                this.c = c;
        }

        public MiX getX() {
                return x;
        }

        public void setX(MiX x) {
                this.x = x;
        }

        public MiY getY() {
                return y;
        }

        public void setY(MiY y) {
                this.y = y;
        }
         public void setXN(int x) {
                this.x.setX(x); 
         }
        public void setYN(int y) {
                this.y.setY(y);
        }

        public int getLimXP() {
                return limXP;
        }

        public void setLimXP(int limXP) {
                this.limXP = limXP;
        }

        public int getLimYP() {
                return limYP;
        }

        public void setLimYP(int limYP) {
                this.limYP = limYP;
        }

        public int getLimXN() {
                return limXN;
        }

        public void setLimXN(int limXN) {
                this.limXN = limXN;
        }

        public int getLimYN() {
                return limYN;
        }

        public void setLimYN(int limYN) {
                this.limYN = limYN;
        }

        public Dron getD() {
                return d;
        }

        public void setD(Dron d) {
                this.d = d;
        }
        
        
        
}
