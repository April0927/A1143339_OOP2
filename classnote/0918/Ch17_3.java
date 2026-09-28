import javax.swing.*;

public class Ch17_3 {
    static JFrame frm = new JFrame("JButton Test");
    static JPanel pne = new JPanel();

    static JButton btn1 = new JButton("上一張");
    static JButton btn2 = new JButton("下一張");

    static ImageIcon pic;
    static JLabel lab = new JLabel();

    public static void main(String[] args) {
        pic = new ImageIcon("C:\\OOP2_Java\\classnote\\0918\\blueflowers.jpg"); 
        pne.add(btn1);
        pne.add(btn2);
        pne.add(lab);
        
        frm.add(pne);
        lab.setIcon(pic);
        lab.setText("網路圖片");
        lab.setHorizontalTextPosition(JLabel.CENTER);
        lab.setVerticalTextPosition(JLabel.BOTTOM);

        frm.setSize(700, 600); //位置不夠的時候 每個物件會自動換行 否則皆為同列顯示
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
