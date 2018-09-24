
package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.Icon;
import model.Item;

public class Bag extends javax.swing.JFrame {
    
    Item [] items;
    Icon [] icones;
    public Bag() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public void carregarItems(){
        File arquivo = new File("C:\\Users\\chica\\OneDrive\\Feira de Ciências\\Documentos\\NetBeansProjects\\BattleSimulator\\src\\data\\items.txt");
        FileReader FR;
        BufferedReader BR;
        int cont = 0;
        this.carregarIcones();
        
        try {
            FR = new FileReader(arquivo);
            BR = new BufferedReader(FR);
                while (BR.ready()){
                    String [] linhas = BR.readLine().split(";");
                    items[cont] = new Item(Integer.parseInt(linhas[0]), linhas[1],
                            linhas[2], Integer.parseInt(linhas[3]), icones[cont], linhas[3]);
                    cont ++;
                }
            BR.close();
            FR.close();
        } catch (IOException Error){
            System.out.println(Error);
        }
    }
    
    public int getQntItems(){
        File arquivo = new File("C:\\Users\\chica\\OneDrive\\Feira de Ciências\\Documentos\\NetBeansProjects\\BattleSimulator\\src\\data\\items.txt");
        FileReader FR;
        BufferedReader BR;
        int quantidade = 0;
        
        try {
            FR = new FileReader(arquivo);
            BR = new BufferedReader(FR);
                while (BR.ready()){
                    String [] linhas = BR.readLine().split(";");
                    quantidade ++;
                }
            BR.close();
            FR.close();
        } catch (IOException Error){
            System.out.println(Error);
        }        
        return quantidade;
    }
    
    public void carregarIcones(){
        File pasta = new File ("C:\\Users\\chica\\OneDrive\\Feira de Ciências\\Documentos\\NetBeansProjects\\BattleSimulator\\src\\img\\items");
        String [] arquivos = pasta.list();
        icones = new Icon [arquivos.length];
        
            for (int i = 0; i < arquivos.length; i ++){
               icones[i] = (new javax.swing.ImageIcon(getClass().getResource("/img/items/" + arquivos[i]))); 
            }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(303, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bag().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
