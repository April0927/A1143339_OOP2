import javax.swing.*;
import java.awt.*;

public class Demo01_HelloFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("我的第一個視窗");
        frame.setSize(420, 280);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);                       // 手動座標模式
        frame.getContentPane().setBackground(new Color(0xF2F4F8));

        JLabel label = new JLabel("Hello, Swing!");
        label.setBounds(100, 90, 240, 40);           // x, y, width, height
        label.setFont(new Font("微軟正黑體", Font.BOLD, 26));
        label.setForeground(new Color(0x2E5AAC));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(label);

        frame.setVisible(true);                      // 一定放最後
    }
}
