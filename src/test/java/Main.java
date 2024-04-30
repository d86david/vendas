import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        TextArea textArea = new TextArea();
        textArea.append("Texto inicial\n\n");
        
        // Inserir texto na coluna 5
        int coluna = 10;
        String texto = "Texto a ser inserido na coluna 10\n";
        textArea.insert(texto, coluna);
        
        frame.add(textArea);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}