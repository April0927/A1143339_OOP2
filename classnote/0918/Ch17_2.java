import javax.swing.*;

public class Ch17_2 {
    static JFrame frm = new JFrame("JButton Test");
    static JPanel pne = new JPanel();

    static JButton btn1 = new JButton("按鈕1");

    public static void main(String[] args) {
        pne.add(btn1); //按鈕加進容器裡
        frm.add(pne); // 容器加進視窗中
        //btn1.setRolloverEnabled(true);

        frm.setSize(260, 150);
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}