package plus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableTest extends JFrame 
                                implements MouseListener, ActionListener{

 JTable table;
 JScrollPane scroll;
 JPanel northp,southp;
 JLabel label;
 JButton bt_add, bt_del, bt_up, bt_search;
 
 InputForm form;
 DefaultTableModel dtm;
 int srow;
 
 
 
 public JTableTest() {
    //setTitle("JTable�׽�Ʈ");
    form = new InputForm();

    Object[][] rowData={
                               {"ȫ�浿", 13, "�л�"}, //0��
                               {"������", 15, "ȭ��"}, //1��
                               {"�����", 16, "����"}  //2��
                               
              
                                };
    Object[] columnNames={"�̸�","����","����"};
    
    //JTable(TableModel dm)
    dtm = new DefaultTableModel(rowData, columnNames);
    
    table = new JTable(dtm);//(rowData,columnNames);
    scroll = new JScrollPane(table);
    //label = new JLabel("�ȳ� ���̺�~^^*");
    northp = new JPanel();
      northp.add(label);
      
    bt_add = new JButton("�߰�");  
    bt_del = new JButton("����");  
    bt_up = new JButton("����");  
    bt_search = new JButton("�˻�");  
    
    southp = new JPanel();
      southp.add(bt_add);
      southp.add(bt_del);
      southp.add(bt_up);
      southp.add(bt_search);
    
    
    //add("Center",table);
    add("Center",scroll);
    add("North",northp);
    add("South",southp);
    
    setBounds(400,300,300,300);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    eventUp();
 }//������
 

 private void eventUp(){
    table.addMouseListener(this);
    
    bt_add.addActionListener(this);
    bt_del.addActionListener(this);
    bt_up.addActionListener(this);
    
    form.bt_input.addActionListener(this);
    form.bt_cancel.addActionListener(this);
    
 }
 
 @Override
 public void actionPerformed(ActionEvent e) {
  //�̺�Ʈ �ҽ��� ���� ���� : 
  //object e.getSource(), String e.getActionCommand()
  
//  System.out.println(e.getActionCommand());

  Object ob=e.getSource();
  if(ob==bt_add){//�߰���ư Ŭ����
   form.initTF();
   //setVisible(false);
   form.setVisible(true);
  }else if(ob==form.bt_input){//�Է¹�ư Ŭ����(�Է���, ������)
      String name= form.tf_name.getText();
      String age= form.tf_age.getText();
      String job= form.tf_job.getText();
      
      if(name == null  || name.length() == 0){
      //name������ null���� ���� ���ɼ��� �� 1%�� �ִٸ�
      //null�� ���� üũ�� �ϴ� �� �ݵ�� �տ��� üũ�ؾ� ��.
      JOptionPane.showMessageDialog(form, "�̸��Է�!!"); 
         form.tf_name.requestFocus();
       return;
      }
      
      if(age.length()==0){
       //TextField���� null���� ������ �����Ƿ� nullüũ ��.
      JOptionPane.showMessageDialog(form, "�����Է�!!"); 
          form.tf_age.requestFocus();
       return;
      }
      
      if(job.length()==0){//�Էµ� ���ڰ� ���ٸ�
      JOptionPane.showMessageDialog(form, "�����Է�!!");
          form.tf_job.requestFocus();
       return;
      }
      

      if(form.getTitle().equals("�Է���")){//�Է����̾�����
      Object rowData[] = {name, age, job};
      dtm.addRow(rowData);
      }else{//�������̿�����
//       table.setValueAt(Object aValue, int row, int column)
       table.setValueAt(age, srow, 1);
       //���̼���
       table.setValueAt(job,srow
         , 2);
       //��������
      }
      form.setVisible(false);
      setVisible(true);
      
  }else if(ob==form.bt_cancel){
   form.setVisible(false);
   
   setVisible(true);
  }else if(ob==bt_del){
    //������ �̸�  �Է�
//   JOptionPane.showInputDialog(parentComponent, object message)
   String delName = JOptionPane.showInputDialog(this, "�������̸�:");
   //System.out.println("delName="+delName);
   //Ȯ��, ���, X : �Էµ� �̸� �Ǵ� ���ڿ�, null,null
   
//   delName.equals(table.getValueAt(0,0));
//   delName.equals(table.getValueAt(1,0));
//   delName.equals(table.getValueAt(2,0));
   //table.getRowCount();//��ü �హ��
   if(delName == null) return ; //���, X
    
   if(delName.length()==0){
    JOptionPane.showMessageDialog(this, "�������̸��Է�!!");
    
    return; //���ڿ� üũ
  }
    
//    table.getRowCount();
   for(int i=0; i<table.getRowCount(); i++){
    if(delName.equals(table.getValueAt(i,0))){
//     dtm.removeRow(int ���ε���)
     dtm.removeRow(i);
     
    }
    
    
   
  }//for
  
 
     }else if(ob==bt_up){//������ư�� Ŭ���ߴٸ�
//     table.getValueAt(row index, column index);
     srow = table.getSelectedRow(); 
     //JTable���� ���õ� ���� ���ٸ� -1���� ����.
     
     if(srow==-1){
      JOptionPane.showMessageDialog(this, "������ �༱��!!");
      return;
     }
     
     String name = (String) table.getValueAt(srow,0);
  String age  = table.getValueAt(srow,1).toString();
                    //nw Integer(13);
  String job  = (String) table.getValueAt(srow,2);
      
  form.tf_name.setText(name);
  form.tf_age.setText(age);
  form.tf_job.setText(job);
       
  form.initUp();
     
  setVisible(false);
  form.setVisible(true);
  }
  }
 @Override
 public void mouseClicked(MouseEvent e) {//�̺�Ʈ�ڵ鷯
     //System.out.println("mouseClicked");
     //JTable�� Ŭ�������� ���õǾ��� ���� ������������
     //JLabel�� ���.
     //��)   �̸�:ȫ�浿, ����:13, ����:�л�
     
     int srow= table.getSelectedRow();//���õ� �� �ε���
     //System.out.println("srow="+srow);
  //table.getValueAt(int row, int column)
     //column 0:�̸�, 1:����, 2:����
//     System.out.println(table.getValueAt(srow, 0));
//     System.out.println(table.getValueAt(srow, 1));
//     System.out.println(table.getValueAt(srow, 2));
     Object name=table.getValueAt(srow, 0);
     Object age=table.getValueAt(srow, 1);
     Object job=table.getValueAt(srow, 2);
     
     label.setText("�̸�:"+name+", ����:"+age+", ����:"+job);
     
 }
 
 
 public static void main(String[] args) {
    new JTableTest();

 }

 

 @Override
 public void mousePressed(MouseEvent e) {
  // TODO Auto-generated method stub
  
 }

 @Override
 public void mouseReleased(MouseEvent e) {
  // TODO Auto-generated method stub
  
 }

 @Override
 public void mouseEntered(MouseEvent e) {
  // TODO Auto-generated method stub
  
 }

 @Override
 public void mouseExited(MouseEvent e) {
  // TODO Auto-generated method stub
  
 }

 

}


