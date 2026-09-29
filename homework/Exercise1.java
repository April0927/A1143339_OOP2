import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Exercise1 extends JFrame implements ActionListener {
    static Exercise1 frm = new Exercise1();
    static JButton btn = new JButton("擲骰子");
    Random random = new Random();
    private int sum = 0;
    private int count = 0;
    private double avg = 0.0;
    static JLabel lab1 = new JLabel("已擲 0 次，總和 0，平均 0.00");
    static JLabel lab2 = new JLabel();

    public void actionPerformed(ActionEvent e) { 
        int point = random.nextInt(6) + 1;
        lab2.setText("點數: " + point);
        sum += point;
        count++;
        avg = (double) sum / count;
        lab1.setText("已擲 " + count + " 次，總和 " + sum + "，平均 " + String.format("%.1f", avg));
        if (point == 6) {
            lab2.setForeground(Color.GREEN);
        } 
        else if (point == 1) {
            lab2.setForeground(Color.RED);
        }
        else {
            lab2.setForeground(Color.BLACK);
        }
    }
    
    public static void main(String[] args) {
        frm.setLayout(new BorderLayout());
        frm.setTitle("骰子模擬器");
        frm.setSize(400, 320);
        btn.addActionListener(frm);
        lab1.setHorizontalAlignment(JLabel.CENTER);
        lab2.setHorizontalAlignment(JLabel.CENTER);
        lab2.setVerticalAlignment(JLabel.CENTER);
        lab1.setFont(new Font("SansSerif", Font.PLAIN, 24));
        lab2.setFont(new Font("SansSerif", Font.BOLD, 60));
        btn.setFont(new Font("SansSerif", Font.PLAIN, 24));
        frm.add(lab1, BorderLayout.NORTH);
        frm.add(lab2, BorderLayout.CENTER);
        frm.add(btn, BorderLayout.SOUTH);

        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
}
