import javax.swing.*;

public class Ch17_1 {
    public static void main(String[] args) {
        JFrame frm = new JFrame("JFrame 視窗");
        frm.setSize(260, 150);
        //視窗大小
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //關閉視窗時結束程式
    }
}