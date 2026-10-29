import javax.swing.*;
import java.awt.*;

public class fixLoginWindow extends JFrame {
    private JTextField t1;
    private JPasswordField t2;

    public fixLoginWindow() {
        // 1. 設定視窗基本屬性
        setTitle("登入");
        setSize(320, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 設定關閉視窗時結束程式
        setLocationRelativeTo(null); // 視窗置中顯示

        // 2. 使用 LayoutManager 進行元件排版
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); // 設定外邊距

        JLabel l1 = new JLabel("帳號:");
        t1 = new JTextField();
        JLabel l2 = new JLabel("密碼:");
        t2 = new JPasswordField(); // 使用密碼輸入框以掩碼顯示
        JButton btn = new JButton("登入");

        // 3. 將元件加入面板
        panel.add(l1);
        panel.add(t1);
        panel.add(l2);
        panel.add(t2);
        panel.add(new JLabel()); // 佔位空元件以對齊按鈕
        panel.add(btn);

        add(panel);

        // 4. 設定按鈕事件監聽器
        btn.addActionListener(e -> {
            String username = t1.getText();
            String password = new String(t2.getPassword());

            // 正確使用 .equals() 比較字串內容
            if ("admin".equals(username) && "123456".equals(password)) {
                JOptionPane.showMessageDialog(this, "登入成功！", "訊息", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "帳號或密碼錯誤！", "錯誤", JOptionPane.ERROR_MESSAGE);
            }
        });

        // 5. 元件加載完畢後最後顯示視窗
        setVisible(true);
    }

    public static void main(String[] args) {
        // 在 Event Dispatch Thread (EDT) 中啟動 Swing GUI 確保執行緒安全
        SwingUtilities.invokeLater(() -> new fixLoginWindow());
    }
}
