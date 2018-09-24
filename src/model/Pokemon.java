
package model;

import java.applet.AudioClip;
import javax.swing.Icon;

public class Pokemon {
    private String nome, desc, tipo, encontro, evolucao;
    private int id, ataque, vida;
    private Icon sprite, sprite_b, icone;
    private AudioClip cry;
    
    public Pokemon (int id, String nome, String desc, int ataque, int vida, Icon sprite, Icon sprite_b, AudioClip cry, Icon icone, String tipo, String encontro, String evolucao){
        this.id = id;
        this.nome = nome;
        this.desc = desc;
        this.ataque = ataque;
        this.vida = vida;
        this.sprite = sprite;
        this.sprite_b = sprite_b;
        this.cry = cry;
        this.icone = icone;
        this.tipo = tipo;
        this.encontro = encontro;
        this.evolucao = evolucao;
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
    
    public int getAtaque(){
        return this.ataque;
    }
    
    public Icon getSprite(){
        return this.sprite;
    }
    
    public Icon getSprite_b(){
        return this.sprite_b;
    }
    
    public AudioClip getCry(){
        return this.cry;
    }
    
    public Icon getIcone(){
        return this.icone;
    }
    
    public int getVida(){
        return this.vida;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    public String getEvolucao(){
        return this.evolucao;
    }
    
}
