import javax.swing.*;
import java.awt.*; //注意這裡java沒有加x

public class Ch17_4 {
    static JFrame frm = new JFrame("Border Layout");
    public static void main(String[] args) {
        BorderLayout border = new BorderLayout(2, 5);
        frm.setLayout(border); //將版面配置設定為BorderLayout
        frm.setSize(600, 300); //改變尺寸後可以觀察到各個按鈕的大小也跟著改變(且依然滿版) 但方位不會改變
        frm.add(new JButton("北"), BorderLayout.NORTH);
        frm.add(new JButton("西"), BorderLayout.WEST);
        frm.add(new JButton("南"), BorderLayout.SOUTH);
        frm.add(new JButton("東"), BorderLayout.EAST);
        frm.add(new JButton("中"), BorderLayout.CENTER);

        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true); //一定放最後
    }
}
