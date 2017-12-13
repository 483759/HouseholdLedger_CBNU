package plus;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InputForm extends JFrame{//입력폼
 
 JLabel la_name, la_age, la_job;
 public JTextField tf_name;
 public JTextField tf_age;
 public JTextField tf_job;
 public JButton bt_input, bt_cancel;
 
 public InputForm() {
 
  setTitle("입력폼");
  la_name = new JLabel("이름");
  la_age = new JLabel("나이");
  la_job = new JLabel("직업");

  tf_name = new JTextField();
  tf_age = new JTextField();
  tf_job = new JTextField();
  
  bt_input = new JButton("입력");
  bt_cancel = new JButton("취소");
 
  
  setLayout(null);
  la_name.setBounds(30, 30, 30, 30);//location+size
  la_age.setBounds(30, 80, 30, 30);//location+size
  la_job.setBounds(30, 130, 60, 30);//location+size
  
  tf_name.setBounds(80, 30, 80, 30);
  tf_age.setBounds(80, 80, 80, 30);
  tf_job.setBounds(80, 130, 80, 30);

  bt_input.setBounds(30, 190, 60, 30);
  bt_cancel.setBounds(100, 190, 60, 30);
  
  add(la_name);
  add(la_age);
  add(la_job);
  
  add(tf_name);
  add(tf_age);
  add(tf_job);

        add(bt_input);  
        add(bt_cancel);
        
        setBounds(300, 300, 220, 300);
 //       setVisible(true);
        setResizable(false);  //프레임 사이즈 변경 불가
        
 }//생성자
 public void initTF(){
  //텍스트필드 초기화
  setTitle("입력폼");
  tf_name.setEditable(true);
  tf_name.setText("");
  tf_age.setText("");
  tf_job.setText("");
  tf_name.requestFocus();
   
  
 }
 
 public void initUp(){//수정폼 초기화
  setTitle("수정폼");
  tf_name.setEditable(false);
//  tf_name.setEnabled(boolean enabled);
 
 }
 

 } 


