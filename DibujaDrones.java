package JDrones;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.util.ArrayList;
public class DibujaDrones extends JPanel{
    private MiX x;
    private MiY y;
    private NumDron n;
    private BufferedImage ima;
    private ArrayList<Ellipse2D> circulos;
    DibujaDrones(BufferedImage ima){
        setBackground(Color.GREEN);
        this.ima=ima;
        this.x=x;
        this.y=y;
        this.n=n;
        circulos= new ArrayList<Ellipse2D>();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(ima, 0, 0, this);
        g2.setColor(Color.black);
        g2.fill(new Rectangle2D.Double(600, 0, 10, 700));
        for(Ellipse2D c:circulos){
            c.setFrame(x.getX(), y.getY(), 20, 20);
            g2.fill((Ellipse2D)c);
        }
        g2.setColor(Color.white);
        //g2.drawString(String.valueOf(n.getConta()),x.getX()+8
        //        ,y.getY()+12);
    }
    public void CreaCirculo(){
        circulos.add(new Ellipse2D.Double());
    }
    public void ActuaslizaXY(MiX x, MiY y){
        this.x=x;
        this.y=y;
    }
}
