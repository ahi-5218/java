import javax.swing.*;
import java.awt.event.*;

public class KeyBoardEvents extends JFrame implements KeyListener {
    private JTextArea textArea;

    public KeyBoardEvents() {
        setTitle("Key Event Demo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        textArea.addKeyListener(this);
        add(textArea);

        setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Handle key pressed events
        System.out.println("Key Pressed: " + e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Handle key released events
        System.out.println("Key Released: " + e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Handle key typed events
        textArea.append(e.getKeyChar());
    }

    public static void main(String[] args) {
        new KeyBoardEvents();
    }
}
