// ��濡 �̹�������

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class test extends JFrame {
    JScrollPane scrollPane;

        // ��� �ʵ忡 ImageIcon Ŭ���� ������    

        ImageIcon icon;
    public test() {

        // �����ڿ� ico ȣ�� �ϰ� �̹��� ��� ����...(����η� �ȵɰ�� ������ ����)
        icon = new ImageIcon("C:\\Users\\���Ѻ�\\Desktop\\���� ����.png");

       // ��׶��� �̹��� ������ �޼ҵ忡 �̸����� Ŭ������ ����
        JPanel panel = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(icon.getImage(), 0, 0, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        //JButton button = new JButton("Hello");
        //panel.add(button);
        scrollPane = new JScrollPane(panel);
        setContentPane(scrollPane);
    }

    public static void main(String[] args) {
        test frame = new test();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}
