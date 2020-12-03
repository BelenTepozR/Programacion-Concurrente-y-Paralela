package JDrones;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.util.ArrayList;
public class DibujaDrones extends JPanel{
    NumDron n;
    private BufferedImage ima;
    private ArrayList<Circulos> circulos;
     private ArrayList<Rectangle2D> rec;
     private ArrayList<Dron> drones;

        public ArrayList<Dron> getDrones() {
                return drones;
        }

        public void setDrones(ArrayList<Dron> drones) {
                this.drones = drones;
        }
    DibujaDrones(BufferedImage ima, NumDron n){
        setBackground(Color.GREEN);
        this.ima=ima;
        this.n=n;
        circulos= new ArrayList<Circulos>();
        this.n= n;
        rec= new ArrayList<Rectangle2D>();

    }
    public void paintComponent(Graphics g){
            
            
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(ima, 0, 0, this.getWidth(), this.getHeight(),this);
        g2.setColor(new Color(222 ,184, 135));
        for(Rectangle2D r : rec)
                g2.draw(r);  
        g2.setColor( new Color(60 ,179 ,113));
        for(Circulos c:circulos){
            c.getC().setFrame(c.getX().getX(), c.getY().getY(), 20, 20);
            g2.fill((Ellipse2D)c.getC());
            
            c.getC().setFrame(c.getX().getX()+(c.getLimXN()), c.getY().getY(), 20, 20);
            g2.fill((Ellipse2D)c.getC());
        }
    
    
    }
    public int num(){
            return n.getConta();
    }
    public Circulos CreaCirculo(int n){
        Circulos cs = new Circulos(new Ellipse2D.Double());     
        ActuaslizaXY(n,cs);
        circulos.add(cs);
        return cs;
    }
    
    public void ActuaslizaXY(int n, Circulos c){
            rec= new ArrayList<Rectangle2D>();

            System.out.println(n);
        switch(n){
                case 1:
                        c.setX(new MiX(0));
                        c.setY(new MiY(0));
                        c.setLimXP(0);
                        c.setLimXN(this.getWidth()/2);
                        c.setLimYP(0);
                        c.setLimYN(this.getHeight());   
                        rec.add(new Rectangle2D.Double(this.getWidth()/2, 0, 2, this.getHeight()));
                break;
                case 2:
                        
                        circulos.get(0).setXN(0);
                        circulos.get(0).setYN(0);
                        circulos.get(0).setLimXP(0);
                        circulos.get(0).setLimXN(this.getWidth()/2);
                        circulos.get(0).setLimYP(0);
                        circulos.get(0).setLimYN(this.getHeight()/2);   
                        rec.add(new Rectangle2D.Double(this.getWidth()/2, 0, 2, this.getHeight()));
                        
                         c.setX(new MiX(0));
                        c.setY(new MiY(this.getHeight()/2));
                        c.setLimXP(0);
                        c.setLimXN(this.getWidth()/2);
                        c.setLimYP(this.getHeight()/2);
                        c.setLimYN(this.getHeight());   
                        rec.add(new Rectangle2D.Double(0,this.getHeight()/2,   this.getWidth(),2));
                        
                break;
                case 3:
                        circulos.get(0).setXN(0);
                        circulos.get(0).setYN(0);
                        circulos.get(0).setLimXP(0);
                        circulos.get(0).setLimXN(this.getWidth()/2);
                        circulos.get(0).setLimYP(0);
                        circulos.get(0).setLimYN(this.getHeight()/3);   
                        rec.add(new Rectangle2D.Double(this.getWidth()/2, 0, 2, this.getHeight()));
                        
                        circulos.get(1).setXN(0);
                        circulos.get(1).setYN(this.getHeight()/3);
                        circulos.get(1).setLimXP(0);
                        circulos.get(1).setLimXN(this.getWidth()/2);
                        circulos.get(1).setLimYP(this.getHeight()/3);
                        circulos.get(1).setLimYN((this.getHeight()/3)*2);   
                        rec.add(new Rectangle2D.Double(0,this.getHeight()/3,   this.getWidth(),2));
                        
                        c.setX(new MiX(0));
                        c.setY(new MiY((this.getHeight()/3)*2));
                        c.setLimXP(0);
                        c.setLimXN(this.getWidth()/2);
                        c.setLimYP((this.getHeight()/3)*2);
                        c.setLimYN(this.getHeight());   
                        rec.add(new Rectangle2D.Double(0,(this.getHeight()/3)*2,   this.getWidth(),2));
                break;
               case 4:
                        circulos.get(0).setXN(0);
                        circulos.get(0).setYN(0);
                        circulos.get(0).setLimXP(0);
                        circulos.get(0).setLimXN(this.getWidth()/2);
                        circulos.get(0).setLimYP(0);
                        circulos.get(0).setLimYN(this.getHeight()/4);   
                        rec.add(new Rectangle2D.Double(this.getWidth()/2, 0, 2, this.getHeight()));
                        
                        circulos.get(1).setXN(0);
                        circulos.get(1).setYN(this.getHeight()/4);
                        circulos.get(1).setLimXP(0);
                        circulos.get(1).setLimXN(this.getWidth()/2);
                        circulos.get(1).setLimYP(this.getHeight()/4);
                        circulos.get(1).setLimYN((this.getHeight()/4)*2);   
                        rec.add(new Rectangle2D.Double(0,this.getHeight()/4,   this.getWidth(),2));
                        
                         circulos.get(2).setXN(0);
                        circulos.get(2).setYN((this.getHeight()/4)*2);
                        circulos.get(2).setLimXP(0);
                        circulos.get(2).setLimXN(this.getWidth()/2);
                        circulos.get(2).setLimYP((this.getHeight()/4)*2);   
                        circulos.get(2).setLimYN((this.getHeight()/4)*3);   
                        rec.add(new Rectangle2D.Double(0,(this.getHeight()/4)*2,   this.getWidth(),2));
                        
                         c.setX(new MiX(0));
                        c.setY(new MiY((this.getHeight()/4)*3));
                        c.setLimXP(0);
                        c.setLimXN(this.getWidth()/2);
                        c.setLimYP((this.getHeight()/4)*3);
                        c.setLimYN(this.getHeight());   
                        rec.add(new Rectangle2D.Double(0,(this.getHeight()/4)*3,   this.getWidth(),2));
                break;
                case 5:
                        circulos.get(0).setXN(0);
                        circulos.get(0).setYN(0);
                         circulos.get(0).setLimXP(0);
                        circulos.get(0).setLimXN(this.getWidth()/2);
                        circulos.get(0).setLimYP(0);
                        circulos.get(0).setLimYN(this.getHeight()/5);   
                        rec.add(new Rectangle2D.Double(this.getWidth()/2, 0, 2, this.getHeight()));
                        
                        circulos.get(1).setXN(0);
                        circulos.get(1).setYN(this.getHeight()/5);
                        circulos.get(1).setLimXP(0);
                        circulos.get(1).setLimXN(this.getWidth()/2);
                        circulos.get(1).setLimYP(this.getHeight()/5);
                        circulos.get(1).setLimYN((this.getHeight()/5)*2);   
                        rec.add(new Rectangle2D.Double(0,this.getHeight()/5,   this.getWidth(),2));
                        
                         circulos.get(2).setXN(0);
                        circulos.get(2).setYN((this.getHeight()/5)*2);
                        circulos.get(2).setLimXP(0);
                        circulos.get(2).setLimXN(this.getWidth()/2);
                        circulos.get(2).setLimYP((this.getHeight()/5)*2);   
                        circulos.get(2).setLimYN((this.getHeight()/5)*3);   
                        rec.add(new Rectangle2D.Double(0,(this.getHeight()/5)*2,   this.getWidth(),2));
                        
                        circulos.get(3).setXN(0);
                        circulos.get(3).setYN((this.getHeight()/5)*3);
                        circulos.get(3).setLimXP(0);
                        circulos.get(3).setLimXN(this.getWidth()/2);
                        circulos.get(3).setLimYP((this.getHeight()/5)*3);   
                        circulos.get(3).setLimYN((this.getHeight()/5)*4);   
                        rec.add(new Rectangle2D.Double(0,(this.getHeight()/5)*3,   this.getWidth(),2));
                        
                        c.setX(new MiX(0));
                        c.setY(new MiY((this.getHeight()/5)*4));
                        c.setLimXP(0);
                        c.setLimXN(this.getWidth()/2);
                        c.setLimYP((this.getHeight()/5)*4);
                        c.setLimYN(this.getHeight());   
                        rec.add(new Rectangle2D.Double(0,(this.getHeight()/5)*4,   this.getWidth(),2));
                break;
        }
        
    }

        public NumDron getN() {
                return n;
        }

        public void setN(NumDron n) {
                this.n = n;
        }
    
}
