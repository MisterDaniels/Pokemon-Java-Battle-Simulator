
package control;

import javax.swing.Icon;

public class imgNtext {
    private String text;
    private Icon icone;
    
    public imgNtext(String text, Icon icone){
        this.text = text;
        this.icone = icone;
    }
    
    public String getText(){
        return this.text;
    }
    
    public Icon getIcone(){
        return this.icone;
    }
    
}
