import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Random;

public class diceSimulator2 extends JFrame implements ActionListener {
    // 微軟正黑體的系統字型名稱；若電腦沒有安裝，改用 SansSerif
    private static final String FONT_NAME = pickFont("Microsoft JhengHei", "微軟正黑體");

    private final Random random = new Random();
    private final JLabel lab1 = new JLabel("已擲 0 次，總和 0，平均 0.00", JLabel.CENTER); // 上方統計
    private final JLabel lab2 = new JLabel("點數: -", JLabel.CENTER);                    // 中央點數
    private final JButton btn = new JButton("擲骰子");

    private int sum = 0;
    private int count = 0;

    public diceSimulator2() {
        setTitle("骰子模擬器");
        setSize(400, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        lab1.setFont(new Font(FONT_NAME, Font.PLAIN, 18));
        lab1.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        lab2.setFont(new Font(FONT_NAME, Font.BOLD, 60));
        btn.setFont(new Font(FONT_NAME, Font.PLAIN, 24));
        btn.setFocusPainted(false);
        btn.addActionListener(this);

        add(lab1, BorderLayout.NORTH);
        add(lab2, BorderLayout.CENTER);
        add(btn, BorderLayout.SOUTH);

        setLocationRelativeTo(null); // 開啟時置中（需在 setSize 之後呼叫）
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int point = random.nextInt(6) + 1; // 1–6
        sum += point;
        count++;
        double avg = (double) sum / count;

        lab2.setText("點數: " + point);
        lab1.setText(String.format("已擲 %d 次，總和 %d，平均 %.2f", count, sum, avg));

        if (point == 6) {
            lab2.setForeground(new Color(0, 160, 0)); // 綠色（比 Color.GREEN 深，較易閱讀）
        } else if (point == 1) {
            lab2.setForeground(Color.RED);
        } else {
            lab2.setForeground(Color.BLACK);
        }
    }

    // 從候選字型中挑出系統已安裝的第一個
    private static String pickFont(String... candidates) {
        String[] installed = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getAvailableFontFamilyNames();
        for (String name : candidates) {
            if (Arrays.asList(installed).contains(name)) {
                return name;
            }
        }
        return Font.SANS_SERIF;
    }

    public static void main(String[] args) {
        // Swing 元件應在事件分派執行緒（EDT）上建立
        SwingUtilities.invokeLater(() -> new diceSimulator2().setVisible(true));
    }
}
