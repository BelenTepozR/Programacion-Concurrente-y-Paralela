package JDrones;

import javax.swing.JFrame;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import javax.swing.JOptionPane;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.Log;
import org.jfree.util.PrintStreamLogTarget;
public class JDrones extends javax.swing.JFrame {
    private DibujaDrones panel;
    private NumDron n;
    private BufferedImage ima;
    private ArrayList<Dron> drones;
    private int met = 0;
    
    public JDrones() {
        n = new NumDron();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        try{                                        // PASARLO a MENU
            ima = ImageIO.read(new File("mapaCU.png"));
        }catch(IOException e){e.printStackTrace();}
        drones =new ArrayList<Dron>();
        panel= new DibujaDrones(ima,n);
        panel.setBounds(0, 0, 1370, 720);
        add(panel);
    }
    @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jMenu3 = new javax.swing.JMenu();
                jMenu4 = new javax.swing.JMenu();
                jMenu1 = new javax.swing.JMenu();
                jMenuItem1 = new javax.swing.JMenuItem();
                jMenuBar1 = new javax.swing.JMenuBar();
                jMenu2 = new javax.swing.JMenu();
                jMenuItem2 = new javax.swing.JMenuItem();
                jMenu5 = new javax.swing.JMenu();
                mutex = new javax.swing.JRadioButtonMenuItem();
                semaforos = new javax.swing.JRadioButtonMenuItem();
                monitores = new javax.swing.JRadioButtonMenuItem();
                barreras = new javax.swing.JRadioButtonMenuItem();
                vc = new javax.swing.JRadioButtonMenuItem();
                grafica = new javax.swing.JMenu();
                mostrarGrafica = new javax.swing.JRadioButtonMenuItem();

                jMenu3.setText("jMenu3");

                jMenu4.setText("jMenu4");

                jMenu1.setText("jMenu1");

                jMenuItem1.setText("jMenuItem1");

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setTitle("Proyecto Concurrente");

                jMenu2.setText("Drones");

                jMenuItem2.setText("Nuevo");
                jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jMenuItem2ActionPerformed(evt);
                        }
                });
                jMenu2.add(jMenuItem2);

                jMenuBar1.add(jMenu2);

                jMenu5.setText("Sicronizacion");

                mutex.setSelected(true);
                mutex.setText("Mutex");
                mutex.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                mutexActionPerformed(evt);
                        }
                });
                jMenu5.add(mutex);

                semaforos.setSelected(true);
                semaforos.setText("Semáforos");
                semaforos.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                semaforosActionPerformed(evt);
                        }
                });
                jMenu5.add(semaforos);

                monitores.setSelected(true);
                monitores.setText("Monitores");
                monitores.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                monitoresActionPerformed(evt);
                        }
                });
                jMenu5.add(monitores);

                barreras.setSelected(true);
                barreras.setText("Barreras");
                barreras.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                barrerasActionPerformed(evt);
                        }
                });
                jMenu5.add(barreras);

                vc.setSelected(true);
                vc.setText("Variable Condicion");
                vc.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                vcActionPerformed(evt);
                        }
                });
                jMenu5.add(vc);

                jMenuBar1.add(jMenu5);

                grafica.setText("Gráfica");

                mostrarGrafica.setSelected(true);
                mostrarGrafica.setText("Mostrar");
                mostrarGrafica.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                mostrarGraficaActionPerformed(evt);
                        }
                });
                grafica.add(mostrarGrafica);

                jMenuBar1.add(grafica);

                setJMenuBar(jMenuBar1);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 798, Short.MAX_VALUE)
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 435, Short.MAX_VALUE)
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
            if(n.getConta()<5){
                jMenu2.setText("Nuevo Dron - Activos: " + (n.getConta()+1)*2);
                n.setConta(n.getConta()+1);
                panel.setN(n);
                panel.setDrones(drones);
                Dron dro = new Dron(panel,panel.CreaCirculo(n.getConta()),met);
                
                drones.add(dro);  
                
                for(Dron d: drones){
                        if(!d.isAlive())
                        try{
                                d.start();
                        }catch(IllegalThreadStateException ex){ex.printStackTrace();}
                }
              }  else{
                      jMenu2.setText("Nuevo Dron - Activos: " + (n.getConta())*2 + " (número de Drones máximo)");
                      JOptionPane.showMessageDialog(null,"NOMAAS");
            }
        }//GEN-LAST:event_jMenuItem2ActionPerformed

        private void mutexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mutexActionPerformed
                this.met=0;// TODO add your handling code here:
        }//GEN-LAST:event_mutexActionPerformed

        private void semaforosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semaforosActionPerformed
               this.met = 1; // TODO add your handling code here:
        }//GEN-LAST:event_semaforosActionPerformed

        private void monitoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monitoresActionPerformed
               this.met = 2; // TODO add your handling code here:
        }//GEN-LAST:event_monitoresActionPerformed

        private void mostrarGraficaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarGraficaActionPerformed
                Log.getInstance().addTarget(new PrintStreamLogTarget());
                final area demo = new area("Area Chart Demo", new double[][] { 
                                                                                       { 1.0, 4.0, 3.0, 5.0, 5.0, 7.0, 7.0, 8.0 ,2.0,3.0,4.0,5.0},
                                                                                        { 5.0, 7.0, 6.0, 8.0, 4.0, 4.0, 2.0, 1.0 }, 
                                                                                        { 4.0, 3.0, 2.0, 3.0, 6.0, 3.0, 4.0, 3.0 },
                                                                                        {1.0, 6.0, .0, 5.0, 5.0, 7.0, 7.0, 8.0 ,2.0,3.0,4.0,5.0}});
                demo.pack();
                RefineryUtilities.centerFrameOnScreen(demo);
                demo.setVisible(true);// TODO add your handling code here:
        }//GEN-LAST:event_mostrarGraficaActionPerformed

        private void barrerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barrerasActionPerformed
                        this.met = 3 ; // TODO add your handling code here:
        }//GEN-LAST:event_barrerasActionPerformed

        private void vcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vcActionPerformed
               this.met = 4 ; // TODO add your handling code here:
        }//GEN-LAST:event_vcActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JDrones().setVisible(true);
            }
        });
    }
        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JRadioButtonMenuItem barreras;
        private javax.swing.JMenu grafica;
        private javax.swing.JMenu jMenu1;
        private javax.swing.JMenu jMenu2;
        private javax.swing.JMenu jMenu3;
        private javax.swing.JMenu jMenu4;
        private javax.swing.JMenu jMenu5;
        private javax.swing.JMenuBar jMenuBar1;
        private javax.swing.JMenuItem jMenuItem1;
        private javax.swing.JMenuItem jMenuItem2;
        private javax.swing.JRadioButtonMenuItem monitores;
        private javax.swing.JRadioButtonMenuItem mostrarGrafica;
        private javax.swing.JRadioButtonMenuItem mutex;
        private javax.swing.JRadioButtonMenuItem semaforos;
        private javax.swing.JRadioButtonMenuItem vc;
        // End of variables declaration//GEN-END:variables
}
