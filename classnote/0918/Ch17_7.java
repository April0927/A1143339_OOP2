import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ch17_7 extends JFrame implements ActionListener{ //讓Ch17_6繼承JFrame類別 並實作
    static Ch17_7 frm = new Ch17_7(); //已經繼承 所以可以直接建立frm物件
    static JButton btn = new JButton("Click Me");
    public void actionPerformed(ActionEvent e) { //實作ActionListener介面裡的actionPerformed方法
        btn.setText("Hello World");
        frm.getContentPane().setBackground(Color.YELLOW); //改變背景顏色
    }
    public static void main(String[] args) {
        btn.addActionListener(frm);//frm:傾聽者 向 btn:事件來源者 "註冊"
        
        frm.setLayout(new FlowLayout());
        frm.setTitle("Action Event");
        frm.setSize(280, 150);
        frm.add(btn); 
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
}
//frm先向btn註冊
//按下按鈕後 btn會產生一個ActionEvent類別的物件 然後傳遞給frm
//frm進行工作指派 誰會收到? actionPerformed method裡的參數e(這個e就是ActionEvent類別的物件)