import javax.swing.*;
import java.awt.*;

public class Ch17_5 {
    static JFrame frm = new JFrame("Flow Layout");

    public static void main(String[] args) {
        FlowLayout flow = new FlowLayout(FlowLayout.CENTER, 5, 10); //在這裡設定為FlowLayout.CENTER 托拽視窗大小可以看到按鈕依然在中間排列 但會自動換行
        frm.setLayout(flow); //將版面配置設定為FlowLayout

        frm.setSize(280, 180);
        
        frm.add(new JButton("East"));
        frm.add(new JButton("West"));
        frm.add(new JButton("South"));
        frm.add(new JButton("North"));
        frm.add(new JButton("Center"));

        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
}