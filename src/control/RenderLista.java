
package control;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class RenderLista extends DefaultListCellRenderer implements ListCellRenderer<Object> {
    
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        imgNtext classe = (imgNtext) value;
        
        setText(classe.getText());
        setIcon(classe.getIcone());
        setFont(new Font("Arial", Font.BOLD, 12));
        if (isSelected){
            setBackground(Color.GRAY);
            setForeground(Color.BLACK);
        } else {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }
        
        return this;
    }
}
