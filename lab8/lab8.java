import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class main
{
	public static void main(String[] args)
	{
		WorkWithClassHuman Work = new WorkWithClassHuman();
		Work.DrawWindow();
	}
}

class Telephone extends JPanel
{
	Color col;
	String maker;
	int prise;
	Color clr;

	Telephone() {
		
	}
	
	//Конструктори
	Telephone(String a)
	{
		maker = a;
	}
	Telephone(int a)
	{
		prise = a;
	}
	//Методи
	public void paint (Graphics g) 
	{
		g.setColor(col);
		g.drawRect(10,15,prise,50);
		g.drawString(maker, 50, 10);
	}

	void DrawWindow()
	{
		JFrame SetWin = new JFrame("Setting telephone");
		GridLayout gbl = new GridLayout(4,1);
		SetWin.setLayout(gbl);
		SetWin.setLocation(0,350);

		
		clr = Color.white;
		JButton changeCol = new JButton("");
		changeCol.setBackground(clr);
		
		String[] listMaterials = {
			"Alcatel",
			"Panasonic",
			"Philips",
			"Texet"
		};
		JComboBox mak = new JComboBox(listMaterials);
		
		JTextField  prs = new JTextField();
		JLabel L_SetCol = new JLabel("Color:");
		JLabel L_mat = new JLabel("Maker:");
		JLabel L_prs = new JLabel("Prise:");
		JButton apply = new JButton("Input data");

		SetWin.getContentPane().add(L_SetCol);
		SetWin.getContentPane().add(changeCol);
		SetWin.getContentPane().add(L_mat);
		SetWin.getContentPane().add(mak);
		SetWin.getContentPane().add(L_prs);
		SetWin.getContentPane().add(prs);
		SetWin.getContentPane().add(apply);
		
		SetWin.setVisible(true);
		SetWin.setSize(500,300);
		
		changeCol.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{
						clr = JColorChooser.showDialog(null, "Choose a background",clr);
						changeCol.setBackground(clr);
				}
			}
		);
		apply.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{
					inputData(clr,mak,prs);
					
				}
			}
		);
	}
	void inputData(Color a, JComboBox b, JTextField c)
	{
		col = a;
		maker = (String)b.getSelectedItem();
		prise = Integer.parseInt(c.getText());
	}

	String outputData()
	{
		String a = "col:"+col+"\n"+"maker:"+maker+"\n"+"prise:"+prise;
		return a;
	}
		
		
	
}

class Human
{
	Telephone tel;
}

class WorkWithClassHuman
{
	public void DrawWindow()
	{
		JFrame window = new JFrame("Lab8");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridLayout gbl = new GridLayout(2,0);
		window.setLayout(gbl);
		

		JTextArea result = new JTextArea();
		JButton showRes = new JButton("Output data");
		JButton set = new JButton("Setting");
		//Виведення елементів в вікно
		
		window.getContentPane().add(set);
		window.getContentPane().add(showRes);
		window.getContentPane().add(result);
		
		window.setVisible(true);
		window.setSize(500,300);

		
		set.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					
				}
			}
						
		);
		showRes.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					
				}
			}
						
		);
	}
}	

