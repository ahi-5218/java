import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BouncingBall extends JPanel implements Runnable {
    private int ballX = 150;
    private int ballY = 150;
    private int ballDiameter = 30;
    private int ballSpeedX = 2;
    private int ballSpeedY = 2;
    private boolean running = false;

    public BouncingBall() {
        this.setPreferredSize(new Dimension(300, 300));
        this.setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startBouncing();
            }
        });
    }

    private synchronized void startBouncing() {
        if (!running) {
            running = true;
            Thread thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval(ballX, ballY, ballDiameter, ballDiameter);
    }

    @Override
    public void run() {
        while (running) {
            ballX += ballSpeedX;
            ballY += ballSpeedY;

            if (ballX < 0 || ballX + ballDiameter > getWidth()) {
                ballSpeedX = -ballSpeedX;
            }
            if (ballY < 0 || ballY + ballDiameter > getHeight()) {
                ballSpeedY = -ballSpeedY;
            }

            repaint();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Bouncing Ball");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new BouncingBall());
            frame.pack();
            frame.setVisible(true);
        });
    }
}
