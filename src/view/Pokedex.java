
package view;

import control.RenderLista;
import control.imgNtext;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import model.Pokemon;

public class Pokedex extends javax.swing.JFrame {
    Pokemon [] pokemons;
    Pokemon [] pokemons_user = new Pokemon [this.getQntPokemons_user()];
    
    public Pokedex(Pokemon [] pokemons) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.pokemons = pokemons;
        this.mostrarPokemons();
    }
    
    public void mostrarPokemons(){
        DefaultListModel pokes = new DefaultListModel();
        Icon icone = new javax.swing.ImageIcon(getClass().getResource("/img/system/pokedexOwned.png"));
        boolean encontrou = false;
        this.carregarPokemons_user();
        
        for (int i = 0; i < pokemons.length; i ++){
            for (int j = 0; j < pokemons_user.length; j ++){
                if (pokemons_user[j].getID() == pokemons[i].getID()){
                    pokes.addElement(new imgNtext(pokemons[i].getNome(), icone));
                    encontrou = true;
                    break;
                }
            }
            if (encontrou == false){
                pokes.addElement(new imgNtext(pokemons[i].getNome(), null));
            }
            encontrou = false;
        }
        quantidade.setText(pokemons_user.length + " | " + pokemons.length);
        lista.setCellRenderer(new RenderLista());
        lista.setModel(pokes);       
    }
    
    public void carregarPokemons_user(){
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
    
    public void verificaTipo(String elemento){
        if (elemento.equals("Fogo")){
            tipo.setBackground(Color.RED);
        } else if (elemento.equals("Agua")){
            tipo.setBackground(Color.BLUE);
        } else if (elemento.equals("Normal")){
            tipo.setBackground(Color.LIGHT_GRAY);
        } else if (elemento.equals("Grama")){
            tipo.setBackground(Color.GREEN);
        } else if (elemento.equals("Gelo")){
            tipo.setBackground(Color.WHITE);
        } else if (elemento.equals("Eletrico")){
            tipo.setBackground(Color.yellow);
        } else if (elemento.equals("Psiquico")){
            tipo.setBackground(Color.BLACK);
            tipo.setForeground(Color.WHITE);
        } else if (elemento.equals("Fada")){
            tipo.setBackground(Color.PINK);
        } else if (elemento.equals("Pedra")){
            tipo.setBackground(Color.GRAY);
        } else if (elemento.equals("Terra")){
            tipo.setBackground(Color.magenta);
        } else {
            tipo.setBackground(Color.ORANGE);
        }
        tipo.setText(elemento);
    }
    
    public void reproduzirSelecionar(){
        AudioClip clicar = Applet.newAudioClip(getClass().getResource("/sound/effect/Choose.wav"));
        clicar.play();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sprite = new javax.swing.JLabel();
        tipo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        nome = new javax.swing.JLabel();
        vida = new javax.swing.JLabel();
        ataque = new javax.swing.JLabel();
        quantidade = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        desc = new javax.swing.JTextArea();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(sprite, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 160, 162));

        tipo.setOpaque(true);
        getContentPane().add(tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 80, 40));

        lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lista);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 49, 184, 450));
        getContentPane().add(nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 320, 28));
        getContentPane().add(vida, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 320, 28));
        getContentPane().add(ataque, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 320, 28));
        getContentPane().add(quantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 80, 30));

        desc.setColumns(20);
        desc.setRows(5);
        jScrollPane2.setViewportView(desc);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 320, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaMouseClicked
        this.reproduzirSelecionar();
        int selecionado = lista.getSelectedIndex();
        
            nome.setText(pokemons[selecionado].getNome());
            ataque.setText(String.valueOf(pokemons[selecionado].getAtaque()));
            vida.setText(String.valueOf(pokemons[selecionado].getVida()));
            desc.setText(pokemons[selecionado].getDesc());
            sprite.setIcon(pokemons[selecionado].getSprite());
            this.verificaTipo(pokemons[selecionado].getTipo());

    }//GEN-LAST:event_listaMouseClicked

    public static void main(String args[]) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ataque;
    private javax.swing.JTextArea desc;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lista;
    private javax.swing.JLabel nome;
    private javax.swing.JLabel quantidade;
    private javax.swing.JLabel sprite;
    private javax.swing.JLabel tipo;
    private javax.swing.JLabel vida;
    // End of variables declaration//GEN-END:variables
}
