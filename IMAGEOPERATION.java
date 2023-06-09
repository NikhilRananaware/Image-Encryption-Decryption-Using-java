import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

class IMAGEOPERATION extends JFrame 
{
	JButton b1;
	JTextField t1;
	JLabel l1,l2,l3,l4,l5;
	
	IMAGEOPERATION()
	{
		Container c=getContentPane();
		//FlowLayout f1=new FlowLayout();
		c.setLayout(null);
		c.setBackground(Color.cyan);
		
		Font ft=new Font("Roboto",Font.BOLD,25);
		Font ff=new Font("Roboto",Font.BOLD,15);
		Font fff=new Font("Roboto",Font.BOLD,20);
		
		l1=new JLabel("WELCOME TO IT DEPT");
		l2=new JLabel("WE ARE PROVIDING FACILITY OF ENCRYPTION & DECRYPTION");
		l3=new JLabel("LETS CHECK");
		l4=new JLabel("DEVELOPE BY-->NIKHIL");
		l5=new JLabel("");
		
		b1=new JButton("CLICK ME");
		
		t1=new JTextField(10);
		
		l1.setBounds(160,50,400,50);
		l2.setBounds(70,120,500,50);
		l3.setBounds(220,190,300,50);
		b1.setBounds(130,280,150,50);
		t1.setBounds(350,280,170,50);
		l4.setBounds(120,400,400,50);
		l5.setBounds(120,470,400,50);
		
		
		
		
		b1.setFont(fff);
		t1.setFont(ft);
		
		l1.setFont(ft);
		l2.setFont(ff);
		l3.setFont(ft);
		l4.setFont(ff);
		l5.setFont(ff);
		
		
		
		c.add(l1);
		c.add(l2);
		c.add(l3);
		c.add(b1);
		c.add(t1);
		c.add(l4);
		c.add(l5);
		
		b1.addActionListener(e->{
			
			String text=t1.getText();
			int temp=Integer.parseInt(text);
			
			operate(temp);
			
		});
		
		
	}
public void operate(int key)
	{
		
		
		
		JFileChooser filechooser=new JFileChooser();
	    filechooser.showOpenDialog(null);
		File file=filechooser.getSelectedFile();
	 
	 try
	 {
		 FileInputStream fis=new FileInputStream(file);
		 
		 byte []data=new byte[fis.available()];
		 fis.read(data);
		 int i=0;
		 for(byte b:data)
		 {
			 System.out.println(b);
			 data[i]=(byte)(b^key);
			 i++;
		 }
		 
		 FileOutputStream  fos=new FileOutputStream(file);
		 fos.write(data);
		 fos.close();
		 fis.close();
		 JOptionPane.showMessageDialog(null,"YOUR OPERATION IS SUCCESSFULLY DONE ");
		 
		 
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 
	}
	public static void main(String args[])
	{
		IMAGEOPERATION j1=new IMAGEOPERATION();
		j1.setVisible(true);
		j1.setTitle("IMAGE OPERATION");
		j1.setSize(600,600);
		j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
