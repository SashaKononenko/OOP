import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;

class main {
    public static void main(String[] args) {
		JFrame frame=new JFrame("Lab 1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		//Оголошення компонентів
		JButton btn=new JButton("Result");
		JTextField str = new JTextField();
		JTextField res = new JTextField();
		JTextField res2 = new JTextField();
		GridLayout gbl = new GridLayout(4,0);
		frame.setLayout(gbl);
		//Розміщення компонентів у вікнні
		frame.getContentPane().add(str);
		frame.getContentPane().add(btn);
		frame.getContentPane().add(res);
		frame.getContentPane().add(res2);
		//Розмір вікна
		frame.setSize(200,100);
		//Дія при натискані на кнопку "Result"
		btn.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{
					String a;
					int ku,kl,i;
					ku = 0;
					kl = 0;
					a = str.getText();
					for (i = 0; i<a.length();i++)
					{
						if (Character.isLetter(a.charAt(i)))
							if (Character.isLowerCase(a.charAt(i)))
								kl++;
							else
								ku++;
					}
					//System.out.println("large number of letters:"+ku+" number of small letters:"+kl);
					res.setText("large number of letters:"+ku);
					res2.setText("number of small letters:"+kl);
				}
			}
		);

		
    }
}