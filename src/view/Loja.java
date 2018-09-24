
package view;

import control.RenderLista;
import control.imgNtext;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import model.Item;

public class Loja extends javax.swing.JFrame {
    
    Item [] items = new Item[this.getQntItems()];
    Icon [] icones;
    int dinheiro, pokebolas;
    
    public Loja() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.carregarItems();
        this.mostrarItems();
        this.limpar();
        this.carregarBag();
        money.setText(String.valueOf(dinheiro));
        quantidade.setHorizontalAlignment(SwingConstants.CENTER);
        price.setHorizontalAlignment(SwingConstants.CENTER);
    }
    
    public void limpar(){
        BTComprar.setVisible(false);
        quantidadeSlider.setVisible(false);
        quantidade.setText("");
        label2.setText("");
    }
    
    public void carregarItems(){
        File arquivo = new File("\\src\\data\\items.txt");
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
        File arquivo = new File("\\src\\data\\items.txt");
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
        File pasta = new File ("\\src\\img\\items");
        String [] arquivos = pasta.list();
        icones = new Icon [arquivos.length];
        
            for (int i = 0; i < arquivos.length; i ++){
               icones[i] = (new javax.swing.ImageIcon(getClass().getResource("/img/items/" + arquivos[i]))); 
            }
    }
    
    public void mostrarItems(){
        DefaultListModel lista = new DefaultListModel();
        for (int i = 0;i < items.length; i ++){
            lista.addElement(new imgNtext(items[i].getNome(),items[i].getIcone()));
        }
        listaItems.setCellRenderer(new RenderLista());
        listaItems.setModel(lista);
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
    
    public void comprarItem(){
        File arquivo = new File ("\\src\\data\\bag.txt");
        FileWriter FW;
        
        try {
            FW = new FileWriter(arquivo, false);
            FW.write(this.pokebolas + ";" + String.valueOf(dinheiro));
            FW.close();
        } catch (IOException Error){
            System.out.println(Error);
        }
    }
    
    public void reproduzirSelecionar(){
        AudioClip clicar = Applet.newAudioClip(getClass().getResource("/sound/effect/Choose.wav"));
        clicar.play();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BTComprar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        background2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaItems = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        money = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        price = new javax.swing.JLabel();
        quantidade = new javax.swing.JLabel();
        quantidadeSlider = new javax.swing.JSlider();
        BTSair = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BTComprar.setBackground(new java.awt.Color(0, 0, 255));
        BTComprar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        BTComprar.setForeground(new java.awt.Color(255, 255, 255));
        BTComprar.setText("                         COMPRAR");
        BTComprar.setOpaque(true);
        BTComprar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTComprarMouseClicked(evt);
            }
        });
        getContentPane().add(BTComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 210, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/window/lojaLogo.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 430, 90));

        background2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/window/lista.png"))); // NOI18N
        getContentPane().add(background2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 330, 390));

        jScrollPane1.setBorder(null);

        listaItems.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaItems.setToolTipText("");
        listaItems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listaItemsMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(listaItems);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 100, 360, 360));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Dinheiro");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 60, 30));

        money.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        getContentPane().add(money, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 90, 100));

        label.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        label.setText("Preço");
        label.setFocusCycleRoot(true);
        getContentPane().add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, -1, -1));

        price.setText("                          ");
        getContentPane().add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 170, 50));
        getContentPane().add(quantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 40, 20));

        quantidadeSlider.setBackground(new java.awt.Color(255, 255, 255));
        quantidadeSlider.setMinimum(1);
        quantidadeSlider.setValue(1);
        quantidadeSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                quantidadeSliderStateChanged(evt);
            }
        });
        getContentPane().add(quantidadeSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 180, -1));

        BTSair.setBackground(new java.awt.Color(0, 0, 255));
        BTSair.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        BTSair.setForeground(new java.awt.Color(255, 255, 255));
        BTSair.setText("                              SAIR");
        BTSair.setOpaque(true);
        BTSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTSairMouseClicked(evt);
            }
        });
        getContentPane().add(BTSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 210, 30));

        label2.setText("Quantidade");
        getContentPane().add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/window/shop.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listaItemsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaItemsMousePressed
        this.reproduzirSelecionar();
        if (listaItems.getSelectedIndex() != -1){
            quantidade.setText("1");
            listaItems.setToolTipText(items[listaItems.getSelectedIndex()].getDesc());
            price.setText(String.valueOf(items[listaItems.getSelectedIndex()].getPreco()) + "$");
            BTComprar.setVisible(true);
            quantidadeSlider.setVisible(true);
            label2.setText("Quantidade");
        } else {
            price.setText("");
            this.limpar();
        }
    }//GEN-LAST:event_listaItemsMousePressed

    private void quantidadeSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_quantidadeSliderStateChanged
        quantidade.setText(String.valueOf(quantidadeSlider.getValue()));
    }//GEN-LAST:event_quantidadeSliderStateChanged

    private void BTComprarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTComprarMouseClicked
        this.reproduzirSelecionar();
        if (dinheiro < items[listaItems.getSelectedIndex()].getPreco() * Integer.parseInt(quantidade.getText())){
            JOptionPane.showMessageDialog(rootPane, "Desculpe, mas você não tem dinheiro suficiente");
        } else {
            int confirmacao = JOptionPane.showConfirmDialog(rootPane, "Tem certeza que deseja comprar " + quantidade.getText() + " " + 
                    items[listaItems.getSelectedIndex()].getNome(), "Confirmação", JOptionPane.YES_NO_OPTION);
            if (confirmacao == 0){
                this.pokebolas = this.pokebolas + Integer.parseInt(quantidade.getText());
                this.dinheiro = this.dinheiro - (items[listaItems.getSelectedIndex()].getPreco() * Integer.parseInt(quantidade.getText()));
                money.setText(String.valueOf(dinheiro));
                this.comprarItem();
                JOptionPane.showMessageDialog(rootPane, "Comprado!");
            } 
        } 
    }//GEN-LAST:event_BTComprarMouseClicked

    private void BTSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTSairMouseClicked
        this.reproduzirSelecionar();
        Batalha TelaB = new Batalha(null);
        TelaB.dinheiro = this.dinheiro;
        money.setText("");
        this.setVisible(false);
    }//GEN-LAST:event_BTSairMouseClicked

    public static void main(String args[]) {


    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BTComprar;
    private javax.swing.JLabel BTSair;
    private javax.swing.JLabel background;
    private javax.swing.JLabel background2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel label2;
    private javax.swing.JList<String> listaItems;
    private javax.swing.JLabel money;
    private javax.swing.JLabel price;
    private javax.swing.JLabel quantidade;
    private javax.swing.JSlider quantidadeSlider;
    // End of variables declaration//GEN-END:variables
}
