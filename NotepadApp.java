import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class NotepadApp extends JFrame {
    private JTextArea textArea;
    private JFileChooser fileChooser;

    public NotepadApp() {
        // Set up the frame
        setTitle("Simple Notepad");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the text area
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create File menu
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        // Add menu items
        addMenuItem(fileMenu, "New", e -> newFile());
        addMenuItem(fileMenu, "Open", e -> openFile());
        addMenuItem(fileMenu, "Save", e -> saveFile());
        addMenuItem(fileMenu, "Exit", e -> System.exit(0));

        setJMenuBar(menuBar);
        fileChooser = new JFileChooser();
    }

    private void addMenuItem(JMenu menu, String name, ActionListener action) {
        JMenuItem menuItem = new JMenuItem(name);
        menuItem.addActionListener(action);
        menu.add(menuItem);
    }

    private void newFile() {
        textArea.setText("");
    }

    private void openFile() {
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                textArea.setText("");
                String line;
                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error opening file: " + e.getMessage());
            }
        }
    }

    private void saveFile() {
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
        int returnValue = fileChooser.showSaveDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(textArea.getText());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error saving file: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NotepadApp notepad = new NotepadApp();
            notepad.setVisible(true);
        });
    }
}
