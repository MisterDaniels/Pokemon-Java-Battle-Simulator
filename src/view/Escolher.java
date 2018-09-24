
package view;

import control.RenderLista;
import control.imgNtext;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import model.Pokemon;

public class Escolher extends javax.swing.JFrame {
    
    Batalha TelaB;
    Pokemon [] pokemons;
    Pokemon [] pokemons_user = new Pokemon [this.getQntPokemons_user()];
    int selecionado = 0;

    public Escolher() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.carregarPokemons_user();
        this.mostrarPokemons_user();
    }
    
    public void carregarPokemons_user(){
        TelaB = new Batalha(null);
        File arquivo = new File ("C:\\Users\\chica\\OneDrive\\Feira de Ciências\\Documentos\\NetBeansProjects\\BattleSimulator\\src\\data\\pokebag.txt");
        FileReader FR;
        BufferedReader BR;
        pokemons = TelaB.pokemons;
        int cont = 0;
        
        try {
            FR = new FileReader(arquivo);
            BR = new BufferedReader(FR);
                while (BR.ready()){
                    String linha = BR.readLine();
                        for (int i = 0; i < pokemons.length; i ++){
                            if (pokemons[i].getID() == Integer.parseInt(linha)){
                                pokemons_user[cont] = pokemons[i];
                            }
                        }
                    cont ++;
                }
            BR.close();
            FR.close();
        } catch (IOException Error){
            System.out.println(Error);
        }
    }
    
    public int getQntPokemons_user(){
        File arquivo = new File("C:\\Users\\chica\\OneDrive\\Feira de Ciências\\Documentos\\NetBeansProjects\\BattleSimulator\\src\\data\\pokebag.txt");
        FileReader FR;
        BufferedReader BR;
        int quantidade = 0;
        
        try {
            FR = new FileReader(arquivo);
            BR = new BufferedReader(FR);
                while(BR.ready()){
                    String linha = BR.readLine();
                    quantidade ++;
                }
            BR.close();
            FR.close();
        } catch (IOException Error){
            System.out.println(Error);
        }
        return quantidade;
    }
    
    public Pokemon [] getPokemons_user(){
        return this.pokemons_user;
    }
    
    public void mostrarPokemons_user(){
        DefaultListModel pokes = new DefaultListModel();
        for (int i = 0; i < pokemons_user.length; i ++){
            pokes.addElement(new imgNtext(pokemons_user[i].getNome(), pokemons_user[i].getIcone()));
        }
        ListaPokemons.setCellRenderer(new RenderLista());
        ListaPokemons.setModel(pokes);
    }
    
    public AudioClip reproduzirSelecionar(){
        AudioClip clicar = Applet.newAudioClip(getClass().getResource("/sound/effect/Choose.wav"));
        return clicar;
    }
    
    public Pokemon getPokemon_batalha(){
        return pokemons_user[selecionado];
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BTEscolher = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaPokemons = new javax.swing.JList<>();
        background = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BTEscolher.setText("ESCOLHER");
        BTEscolher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTEscolherActionPerformed(evt);
            }
        });
        getContentPane().add(BTEscolher, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 266, -1, -1));

        ListaPokemons.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ListaPokemons.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(ListaPokemons);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 25, 219, 214));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/window/escolher.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTEscolherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTEscolherActionPerformed
        if (ListaPokemons.isSelectionEmpty() == true){
            reproduzirSelecionar().play();
        } else {
            reproduzirSelecionar().play();            
            selecionado = ListaPokemons.getSelectedIndex();
            TelaB = new Batalha(pokemons_user[selecionado]);
            this.setVisible(false);
            TelaB.setVisible(true);
        }
    }//GEN-LAST:event_BTEscolherActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Escolher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Escolher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Escolher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Escolher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTEscolher;
    private javax.swing.JList<String> ListaPokemons;
    private javax.swing.JLabel background;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
