
package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import model.Pokemon;

public class Pokebag extends javax.swing.JFrame {
    
    Pokemon [] pokemons;
    Pokemon [] pokemons_user = new Pokemon[this.getQntPokemons_user()];
    
    public Pokebag(Pokemon [] pokemons) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.pokemons = pokemons;
        this.carregarPokebag();
    }
    
    public void carregarPokebag(){
        File arquivo = new File ("C:\\Users\\chica\\OneDrive\\Feira de Ciências\\Documentos\\NetBeansProjects\\BattleSimulator\\src\\data\\pokebag.txt");
        FileReader FR;
        BufferedReader BR;
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(793, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(438, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
