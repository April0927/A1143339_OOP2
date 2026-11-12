import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 單位換算器：視窗本身擔任事件傾聽者（委派事件模式）
public class unitConverter extends JFrame implements ActionListener {

    // 換算類型與各類型的單位
    private final String[] types = {"長度", "重量", "溫度"};
    private final String[][] units = {
            {"公尺", "公分", "英吋", "英尺"},
            {"公斤", "公克", "磅", "盎司"},
            {"攝氏", "華氏", "克氏"}
    };
    // 長度、重量：換成基準單位（公尺、公斤）的倍率
    private final double[][] factors = {
            {1.0, 0.01, 0.0254, 0.3048},
            {1.0, 0.001, 0.45359237, 0.028349523125}
    };

    private final JComboBox<String> cbType = new JComboBox<>(types);
    private final JTextField tfFrom = new JTextField();
    private final JTextField tfTo = new JTextField();
    private final JComboBox<String> cbFrom = new JComboBox<>();
    private final JComboBox<String> cbTo = new JComboBox<>();
    private final JButton btnConvert = new JButton("換算");

    public unitConverter() {
        super("單位換算器");
        setSize(480, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        Font font = new Font("微軟正黑體", Font.PLAIN, 18);

        // NORTH：換算類型
        cbType.setFont(font);
        add(cbType, BorderLayout.NORTH);

        // CENTER：兩列，每列 JTextField + JComboBox
        JPanel center = new JPanel(new GridLayout(2, 1, 10, 10));
        center.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        center.add(makeRow(tfFrom, cbFrom, font));
        center.add(makeRow(tfTo, cbTo, font));
        tfTo.setEditable(false);           // 結果欄只顯示，不讓使用者輸入
        add(center, BorderLayout.CENTER);

        // SOUTH：換算按鈕
        btnConvert.setFont(font);
        add(btnConvert, BorderLayout.SOUTH);

        // 向事件來源者註冊傾聽者
        cbType.addActionListener(this);
        btnConvert.addActionListener(this);

        updateUnits();                     // 先載入「長度」的單位
        setVisible(true);                  // 一定放最後
    }

    private JPanel makeRow(JTextField tf, JComboBox<String> cb, Font font) {
        JPanel row = new JPanel(new BorderLayout(10, 0));
        tf.setFont(font);
        cb.setFont(font);
        cb.setPreferredSize(new Dimension(110, 0));
        row.add(tf, BorderLayout.CENTER);
        row.add(cb, BorderLayout.EAST);
        return row;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cbType) {
            updateUnits();
        } else if (e.getSource() == btnConvert) {
            convert();
        }
    }

    // 切換換算類型時，兩個單位 JComboBox 的選項跟著換
    private void updateUnits() {
        String[] list = units[cbType.getSelectedIndex()];
        cbFrom.setModel(new DefaultComboBoxModel<>(list));
        cbTo.setModel(new DefaultComboBoxModel<>(list));
        cbTo.setSelectedIndex(1);          // 預設目標單位選第二個
        tfTo.setText("");
    }

    private void convert() {
        double value;
        try {
            value = Double.parseDouble(tfFrom.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "請輸入數字！");
            return;
        }

        int type = cbType.getSelectedIndex();
        int from = cbFrom.getSelectedIndex();
        int to = cbTo.getSelectedIndex();
        double result;

        if (type == 2) {
            // 溫度：先轉成攝氏，再轉成目標單位
            double c;
            if (from == 0) c = value;
            else if (from == 1) c = (value - 32) * 5 / 9;
            else c = value - 273.15;

            if (to == 0) result = c;
            else if (to == 1) result = c * 9 / 5 + 32;
            else result = c + 273.15;
        } else {
            // 長度、重量：來源 → 基準單位 → 目標
            result = value * factors[type][from] / factors[type][to];
        }

        tfTo.setText(String.format("%.4f", result).replaceAll("\\.?0+$", ""));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(unitConverter::new);
    }
}