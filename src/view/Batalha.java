
package view;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import model.Pokemon;

public class Batalha extends javax.swing.JFrame {
    Escolher TelaE;
    Pokemon [] pokemons = new Pokemon[this.getQntPokemons()];
    Pokemon [] batalha = new Pokemon[2];
    Icon [] sprites;
    AudioClip [] crys;
    Icon [] icones;
    int lifeEnemy, lifeFriend;
    int pokebolas;
    int dinheiro;

    public Batalha(Pokemon pokemon) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.carregarPokemons();
        this.carregarCenario();
        this.carregarBag();
        batalha[1] = pokemon;
        BTAtacar.setVisible(false);
        BTCapturar.setVisible(false);
        friend_life.setVisible(false);
        enemy_life.setVisible(false);
        if (batalha[1] != null){
            mensagem.setText("Vai " + batalha[1].getNome() + ", eu escolho você.");
            friend.setIcon(batalha[1].getSprite_b());
            friend_life.setMaximum(batalha[1].getVida());
            friend_life.setValue(MAXIMIZED_BOTH);
            batalha[1].getCry().play();
            lifeFriend = batalha[1].getVida();
        }
    }
    
    public void carregarPokemons(){
        File arquivo = new File ("\\src\\data\\pokemon.txt");
        FileReader FR;
        BufferedReader BR;
        int cont = 0, cont1 = 0;
        this.carregarSprites();
        this.carregarCrys();
        this.carregarIcones();
        
        try {
            FR = new FileReader(arquivo);
            BR = new BufferedReader(FR);
                while (BR.ready()){
                    String [] linhas = BR.readLine().split(";");
                    pokemons[cont] = new Pokemon (Integer.parseInt(linhas[0]),
                        linhas[1], linhas[2], Integer.parseInt(linhas[3]),
                            Integer.parseInt(linhas[4]), sprites[cont1], sprites[cont1+1], crys[cont], icones[cont], linhas[5], linhas[6], linhas[7]);
                    cont1 = cont1 + 2;
                    cont ++;
                }
            BR.close();
            FR.close();
        } catch (IOException Error){
            System.out.println(Error);
        }
        
        
    }
    
    public int getQntPokemons(){
        File arquivo = new File ("\\src\\data\\pokemon.txt");
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
    
    public void carregarSprites(){
        File pasta = new File ("\\src\\img\\sprites");
        String [] arquivos = pasta.list();
        sprites = new Icon [arquivos.length];
        
        for (int i = 0; i < arquivos.length; i ++){
            sprites[i] = (new javax.swing.ImageIcon(getClass().getResource("/img/sprites/" + arquivos[i])));
        }
    }
    
    public void carregarCrys(){
        File pasta = new File ("\\src\\sound\\cry");
        String [] arquivos = pasta.list();
        crys = new AudioClip[arquivos.length];
        
        for (int i = 0; i < crys.length; i ++){
            crys[i] = Applet.newAudioClip(getClass().getResource("/sound/cry/" + arquivos[i]));
        }
    }
    
    public void carregarIcones(){
        File pasta = new File ("\\src\\img\\icons");
        String [] arquivos = pasta.list();
        icones = new Icon [arquivos.length];
        
        for (int i = 0; i < arquivos.length; i ++){
            icones[i] = (new javax.swing.ImageIcon(getClass().getResource("/img/icons/" + arquivos[i])));
        }
    }
    
    public void mostrarPokemon(){
        Random aleatorio = new Random ();
        int valor = 0;       
        
        if (batalha[1] != null){
            do {
                valor = aleatorio.nextInt(pokemons.length);
            } while (pokemons[valor] == null);
            batalha[0] = pokemons[valor];
            enemy_life.setVisible(true);
            enemy.setIcon(batalha[0].getSprite());
            enemy_life.setMaximum(batalha[0].getVida());
            enemy_life.setValue(batalha[0].getVida());
            batalha[0].getCry().play();
            friend_life.setVisible(true);
            friend.setIcon(batalha[1].getSprite_b());
            friend_life.setMaximum(batalha[1].getVida());
            friend_life.setValue(batalha[1].getVida());
            lifeEnemy = batalha[0].getVida();
            lifeFriend = batalha[1].getVida();
            BTAtacar.setVisible(true);
            BTCapturar.setVisible(true);
            BTEscolher.setVisible(false);
            BTBatalhar.setVisible(false);
            mensagem.setText("Um " + batalha[0].getNome() + " selvagem apareceu.");
        } else {
            mensagem.setText("Tenho que escolher um Pokémon.");
        }    
    }
    
    public void carregarCenario(){
        File pasta = new File("\\src\\img\\plataformas");
        String [] plataformas = pasta.list();
        Random aleatorio = new Random();
        File pasta2 = new File("\\src\\img\\background");
        String [] backgrounds = pasta2.list();
        
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background/" + backgrounds[aleatorio.nextInt(backgrounds.length)])));
        enemy_plataforma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plataformas/" + plataformas[aleatorio.nextInt(plataformas.length)])));
    }
    
    public void escolherPokemon(){
        Escolher TelaE = new Escolher();
        TelaE.setVisible(true);
        batalha[1] = TelaE.getPokemon_batalha();
    }
    
    public Pokemon [] getPokemonsList(){
        return this.pokemons;
    }
    
    public void reproduzirSelecionar(){
        AudioClip clicar = Applet.newAudioClip(getClass().getResource("/sound/effect/Choose.wav"));
        clicar.play();
    }
    
    public void reproduzirAtaque(){
        AudioClip ataque = Applet.newAudioClip(getClass().getResource("/sound/effect/hit.wav"));
        ataque.play();
    }
    
    public void limpar(){
        BTAtacar.setVisible(false);
        BTCapturar.setVisible(false);
        BTEscolher.setVisible(true);
        BTBatalhar.setVisible(true);
        enemy_life.setVisible(false);
        friend_life.setVisible(false);
    }
    
    public void capturarPokemon(){
        File arquivo = new File ("\\src\\data\\pokebag.txt");
        FileWriter FW;
        
        try {
            FW = new FileWriter(arquivo, true);
            FW.write("\n" + batalha[0].getID());
            FW.close();
            mensagem.setText("Você capturou um " + batalha[0].getNome());
        } catch (IOException Error){
            System.out.println(Error);
        }
    }
    
    public void carregarBag(){
        File arquivo = new File ("\\src\\data\\bag.txt");
        FileReader FR;
        BufferedReader BR;
        
        try {
            FR = new FileReader(arquivo);
            BR = new BufferedReader(FR);
                while (BR.ready()){
                    String [] linha = BR.readLine().split(";");
                    pokebolas = Integer.parseInt(linha[0]);
                    dinheiro = Integer.parseInt(linha[1]);
                }
            BR.close();
            FR.close();
        } catch (IOException Error){
            System.out.println(Error);
        }
    
    }
    
    public void salvarBag(){
        File arquivo = new File ("\\src\\data\\bag.txt");
        FileWriter FW;
        
        try {
            FW = new FileWriter(arquivo, false);
            FW.write(String.valueOf(pokebolas)+ ";" + String.valueOf(this.dinheiro));
            FW.close();
        } catch (IOException Error){
            System.out.println(Error);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        friend_life = new javax.swing.JProgressBar();
        friend = new javax.swing.JLabel();
        enemy_life = new javax.swing.JProgressBar();
        enemy = new javax.swing.JLabel();
        enemy_plataforma = new javax.swing.JLabel();
        BTBatalhar = new javax.swing.JButton();
        BTEscolher = new javax.swing.JButton();
        BTCapturar = new javax.swing.JButton();
        BTAtacar = new javax.swing.JButton();
        BTPokedex = new javax.swing.JLabel();
        mensagem = new javax.swing.JLabel();
        BTLoja = new javax.swing.JLabel();
        botoes = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 230, 60));
        getContentPane().add(friend_life, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, 20));
        getContentPane().add(friend, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 160, 162));
        getContentPane().add(enemy_life, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, -1, 20));
        getContentPane().add(enemy, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 160, 162));
        getContentPane().add(enemy_plataforma, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 256, 128));

        BTBatalhar.setText("BATALHAR");
        BTBatalhar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTBatalharActionPerformed(evt);
            }
        });
        getContentPane().add(BTBatalhar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 540, -1, -1));

        BTEscolher.setText("ESCOLHER");
        BTEscolher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTEscolherActionPerformed(evt);
            }
        });
        getContentPane().add(BTEscolher, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 510, -1, -1));

        BTCapturar.setText("CAPTURAR");
        BTCapturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTCapturarActionPerformed(evt);
            }
        });
        getContentPane().add(BTCapturar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 540, -1, -1));

        BTAtacar.setText("ATACAR");
        BTAtacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTAtacarActionPerformed(evt);
            }
        });
        getContentPane().add(BTAtacar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 510, -1, -1));

        BTPokedex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/system/pokedex1.png"))); // NOI18N
        BTPokedex.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTPokedexMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BTPokedexMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BTPokedexMouseExited(evt);
            }
        });
        getContentPane().add(BTPokedex, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 380, 30, 30));

        mensagem.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        getContentPane().add(mensagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 400, 70));

        BTLoja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/system/shop1.png"))); // NOI18N
        BTLoja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTLojaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BTLojaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BTLojaMouseExited(evt);
            }
        });
        getContentPane().add(BTLoja, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 430, 30, 30));

        botoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/window/botoes.png"))); // NOI18N
        getContentPane().add(botoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 610, 90));
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTBatalharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTBatalharActionPerformed
        this.reproduzirSelecionar();
        this.mostrarPokemon();
    }//GEN-LAST:event_BTBatalharActionPerformed

    private void BTEscolherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTEscolherActionPerformed
        this.reproduzirSelecionar();
        TelaE = new Escolher();
        this.setVisible(false);
        TelaE.setVisible(true);
    }//GEN-LAST:event_BTEscolherActionPerformed

    private void BTAtacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTAtacarActionPerformed
        this.reproduzirSelecionar();
        Random aleatorio = new Random();
        mensagem.setText(batalha[1].getNome() + " ataque!");
        lifeEnemy = (lifeEnemy - aleatorio.nextInt(batalha[1].getAtaque()));
        enemy_life.setValue(lifeEnemy);
        this.reproduzirAtaque();
        lifeFriend = (lifeFriend - aleatorio.nextInt(batalha[0].getAtaque()));
        friend_life.setValue(lifeFriend);           
        // Verificar vencedor
        if (lifeEnemy <= 0){
            int dinheiro_ganho = aleatorio.nextInt(50);
            this.dinheiro = this.dinheiro + dinheiro_ganho;
            mensagem.setText("Você venceu! Ganhou " + dinheiro_ganho + "$.");
            batalha[0].getCry().play();
            enemy.setIcon(null);
            this.limpar();
        } else if (lifeFriend <= 0){
            int dinheiro_perdido = aleatorio.nextInt(50);
            this.dinheiro = this.dinheiro + dinheiro_perdido;
            mensagem.setText("Você perdeu! Perdeu " + dinheiro_perdido + "$.");
            batalha[1].getCry().play();
            friend.setIcon(null);
            batalha[1] = null;
            this.limpar();
        }
        this.salvarBag();
    }//GEN-LAST:event_BTAtacarActionPerformed

    private void BTCapturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTCapturarActionPerformed
        this.reproduzirSelecionar();
        Random aleatorio = new Random();
        if (pokebolas > 0){
            pokebolas --;
            this.salvarBag();
            if (lifeEnemy <= batalha[0].getVida()/2){
                if (aleatorio.nextInt(100) >= 50){
                    this.capturarPokemon();
                    this.limpar();
                } else {
                    mensagem.setText("Vai Pokebola! Restam " + this.pokebolas + " pokebolas.");
                }
            } else {
                if (aleatorio.nextInt(150) >= 100){
                    this.capturarPokemon();
                    this.limpar();
                } else {
                    mensagem.setText("Vai Pokebola! Restam " + this.pokebolas + " pokebolas.");
                }
            }
        } else {
            mensagem.setText("Eu não tenho mais pokebolas.");
        }
    }//GEN-LAST:event_BTCapturarActionPerformed

    private void BTLojaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTLojaMouseEntered
        BTLoja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/system/shop2.png")));
    }//GEN-LAST:event_BTLojaMouseEntered

    private void BTLojaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTLojaMouseExited
        BTLoja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/system/shop1.png")));
    }//GEN-LAST:event_BTLojaMouseExited

    private void BTLojaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTLojaMouseClicked
        this.reproduzirSelecionar();
        Loja TelaL = new Loja();
        TelaL.setVisible(true);
    }//GEN-LAST:event_BTLojaMouseClicked

    private void BTPokedexMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTPokedexMouseClicked
        this.reproduzirSelecionar();
        Pokedex TelaP = new Pokedex(this.pokemons);
        TelaP.setVisible(true);
    }//GEN-LAST:event_BTPokedexMouseClicked

    private void BTPokedexMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTPokedexMouseEntered
        BTPokedex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/system/pokedex2.png")));
    }//GEN-LAST:event_BTPokedexMouseEntered

    private void BTPokedexMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTPokedexMouseExited
        BTPokedex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/system/pokedex1.png")));
    }//GEN-LAST:event_BTPokedexMouseExited

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
            java.util.logging.Logger.getLogger(Batalha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Batalha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Batalha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Batalha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Batalha(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTAtacar;
    private javax.swing.JButton BTBatalhar;
    private javax.swing.JButton BTCapturar;
    private javax.swing.JButton BTEscolher;
    private javax.swing.JLabel BTLoja;
    private javax.swing.JLabel BTPokedex;
    private javax.swing.JLabel background;
    private javax.swing.JLabel botoes;
    private javax.swing.JLabel enemy;
    private javax.swing.JProgressBar enemy_life;
    private javax.swing.JLabel enemy_plataforma;
    private javax.swing.JLabel friend;
    private javax.swing.JProgressBar friend_life;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel mensagem;
    // End of variables declaration//GEN-END:variables
}
