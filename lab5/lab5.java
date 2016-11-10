/*
Треба щоб обєкт Cup наслідував Dishes виникло 2 проблеми!
*/

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;

class main
{
	public static void main(String[] args)
	{
		JFrame window = new JFrame("Lab5");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Елементи інтерфейсу:
		GridLayout gbl = new GridLayout(3,2);
		window.setLayout(gbl);
		
		String[] listConstr = {
			"dishes(String a)",
			"dishes(int a)",
			"cup(int a, int b, int c)",
			"cup(int a, int b)"
		};
		JPanel pnl = new JPanel();
		JButton set = new JButton("Setting");
		JComboBox constr = new JComboBox(listConstr);
		JButton create = new JButton("Create");
		JTextArea result = new JTextArea();
		JButton showRes = new JButton("Result");
		//Виведення елементів в вікно
		window.getContentPane().add(constr);
		window.getContentPane().add(create);
		window.getContentPane().add(set);
		window.getContentPane().add(pnl);
		window.getContentPane().add(showRes);
		window.getContentPane().add(result);
		
		window.setVisible(true);
		window.setSize(500,300);
		
		
		//cup Cup = new cup(12,2,4);
		
		create.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if ((String)constr.getSelectedItem() == "dishes(String a)")
					{
						dishes Dishes =  new dishes("Glass");
						
					}
					if ((String)constr.getSelectedItem() == "dishes(int a)")
					{
						dishes Dishes =  new dishes(143);
					}
					if ((String)constr.getSelectedItem() == "cup(int a, int b, int c)")
					{
						cup Cup =  new cup(23,12,43);
					}
					if ((String)constr.getSelectedItem() == "cup(int a, int b)")
					{
						cup Cup =  new cup(12,23);
					}
				}
			}						
		);
	}
}

class dishes extends JPanel
{
	Color col;
	String material;
	int prise;
	//Конструктори
	dishes(String a)
	{
		material = a;
	}
	dishes(int a)
	{
		prise = a;
	}
	//Методи
	void DrawWindowDishes()
	{
		JFrame SetWin = new JFrame("Setting cup");
		GridLayout gbl = new GridLayout(4,1);
		SetWin.setLayout(gbl);
		
		JButton changeCol = new JButton("");
		
		String[] listMaterials = {
			"Glass",
			"Ceramics",
			"Stainless Steel",
			"Plastic"
		};
		JComboBox mat = new JComboBox(listMaterials);
		
		JTextField  prs = new JTextField();
		JLabel L_SetCol = new JLabel("Color:");
		JLabel L_mat = new JLabel("Material:");
		JLabel L_prs = new JLabel("Prise:");
		
		SetWin.getContentPane().add(L_SetCol);
		SetWin.getContentPane().add(changeCol);
		SetWin.getContentPane().add(L_mat);
		SetWin.getContentPane().add(mat);
		SetWin.getContentPane().add(L_prs);
		SetWin.getContentPane().add(prs);
		SetWin.setVisible(true);
		SetWin.setSize(500,300);
		
		
	}
}

class cup extends dishes
{
	int diameter;
	int height;
	int volume;
	//Конструктори
	cup(int a, int b, int c)
	{
		diameter = a;
		height = b;
		volume = c;
	}
	cup(int a, int b)
	{
		diameter = a;
		height = b;
		volume = a * b;
	}
	//Методи
	void DrawWindow()
	{
		JFrame SetWin = new JFrame("Setting cup");
		GridLayout gbl = new GridLayout(4,1);
		SetWin.setLayout(gbl);
		
		JTextField  diam = new JTextField();
		JTextField  heig = new JTextField();
		JTextField  vol = new JTextField();
		JLabel L_diam = new JLabel("diameter:");
		JLabel L_heig = new JLabel("height:");
		JLabel L_vol = new JLabel("volume:");
		
		SetWin.getContentPane().add(L_diam);
		SetWin.getContentPane().add(diam);
		SetWin.getContentPane().add(L_heig);
		SetWin.getContentPane().add(heig);
		SetWin.getContentPane().add(L_vol);
		SetWin.getContentPane().add(vol);
		SetWin.setVisible(true);
		SetWin.setSize(500,300);
	}
	
	
}



















