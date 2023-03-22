import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimerForm extends JFrame implements ActionListener {

    private JLabel timeLabel;
    private JButton colorButton;
    private Timer timer;
    private boolean isRed = false;
    private Color previousColor = null;

    public TimerForm() {
        setTitle("Timer Form");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        timeLabel = new JLabel();
        timeLabel.setText(getCurrentTime());
        panel.add(timeLabel);

        colorButton = new JButton("Select Color");
        colorButton.addActionListener(this);
        panel.add(colorButton);

        JDialog dialog = new JDialog();
        dialog.setTitle("Settings");
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLayout(new BorderLayout());
        dialog.add(panel, BorderLayout.CENTER);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> startTimer());

        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(e -> stopTimer());

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> resetTimer());

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(startButton);
        buttonsPanel.add(stopButton);
        buttonsPanel.add(resetButton);

        dialog.add(buttonsPanel, BorderLayout.SOUTH);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == colorButton) {
            Color selectedColor = JColorChooser.showDialog(null, "Select a Color", timeLabel.getForeground());
            if (selectedColor != null) {
                previousColor = selectedColor;
                timeLabel.setForeground(selectedColor);
            }
        } else {
            timeLabel.setText(getCurrentTime());
        }
    }

    private String getCurrentTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }

    private void startTimer() {
        timer = new Timer(1000, e -> {
            timeLabel.setText(getCurrentTime());
            if (isRed) {
                timeLabel.setForeground(Color.RED);
            } else {
                if (previousColor == null) {
                    previousColor = timeLabel.getForeground();
                }
                timeLabel.setForeground(previousColor);
            }
            isRed = !isRed;
        });
        timer.start();
    }

    private void stopTimer() {
        if (timer != null) {
            timer.stop();
        }
    }

    private void resetTimer() {
        stopTimer();
        timeLabel.setText(getCurrentTime());
        timeLabel.setForeground(previousColor);
    }

    public static void main(String[] args) {
        int choice = JOptionPane.showOptionDialog(null, "Choose an option", "Options",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                new Object[]{"Settings", "Close"}, null);
        if (choice == JOptionPane.YES_OPTION) {
            new TimerForm();
        } else if (choice == JOptionPane.NO_OPTION) {
            System.exit(0);
        }
    }
}
