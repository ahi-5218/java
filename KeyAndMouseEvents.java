import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyAndMouseEvents extends JFrame {

    private JTextArea textArea;

    public KeyAndMouseEvents() {
        // Set up the frame
        setTitle("Key and Mouse Events Demo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a text area to display events
        textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Add mouse listener
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String message = String.format("Mouse clicked at [%d, %d]\n", e.getX(), e.getY());
                textArea.append(message);
            }
        });

        // Add key listener
        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                String message = String.format("Key pressed: %s\n", KeyEvent.getKeyText(e.getKeyCode()));
                textArea.append(message);
            }
        });

        // Make the text area focusable to capture key events
        textArea.setFocusable(true);
        textArea.requestFocusInWindow();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            KeyAndMouseEvents demo = new KeyAndMouseEvents();
            demo.setVisible(true);
        });
    }
}
