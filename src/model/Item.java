
package model;

import javax.swing.Icon;

public class Item {
    private String nome, desc, tipo;
    private int id;
    private int preco;
    private Icon icone;
    
    public Item(int id, String nome, String desc, int preco, Icon icone, String tipo){
        this.id = id;
        this.nome = nome;
        this.desc = desc;
        this.preco = preco;
        this.icone = icone;
        this.tipo = tipo;
    }
    
    public int getID(){
        return this.id;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getDesc(){
        return this.desc;
    }
    
    public int getPreco(){
        return this.preco;
    }
    
    public Icon getIcone(){
        return this.icone;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
}
