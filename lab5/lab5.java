import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;

class main
{

	static dishes Dishes;
	static cup Cup;
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
		window.getContentPane().add(showRes);
		window.getContentPane().add(result);
		window.getContentPane().add(set);
		//window.getContentPane().add(pnl);
		
		window.setVisible(true);
		window.setSize(500,300);
		
		create.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if(Dishes != null)
					{
						window.getContentPane().remove(Dishes);
						Dishes = null;
					}
					if(Cup != null)
					{
						window.getContentPane().remove(Cup);
						Cup = null;

					}

					if ((String)constr.getSelectedItem() == "dishes(String a)")
					{
						Dishes = new dishes("Glass");
						window.getContentPane().repaint();
						window.getContentPane().add(Dishes);
					}
					if ((String)constr.getSelectedItem() == "dishes(int a)")
					{
						Dishes =  new dishes(143);
						window.getContentPane().repaint();
						window.getContentPane().add(Dishes);
					}
					if ((String)constr.getSelectedItem() == "cup(int a, int b, int c)")
					{
						Cup =  new cup(23,12,43);
						window.getContentPane().repaint();
						window.getContentPane().add(Cup);
					}
					if ((String)constr.getSelectedItem() == "cup(int a, int b)")
					{
						Cup =  new cup(12,23);
						window.getContentPane().repaint();
						window.getContentPane().add(Cup);
					}
					result.setText("Create object");
				}
			}						
		);
		set.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if(Dishes != null)
					{
						Dishes.DrawWindow();
					}
					if(Cup != null)
					{
						Cup.DrawWindow();
					}
				}
			}						
		);
		showRes.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					
					if(Dishes != null)
					{
						window.getContentPane().repaint();
						window.getContentPane().add(Dishes);
						result.setText("col:"+Dishes.col+"\n"
									   +"material:"+Dishes.material+"\n"
									   +"prise:"+Dishes.prise);
					}
					if(Cup != null)
					{
						window.getContentPane().repaint();
						window.getContentPane().add(Cup);
						result.setText("diameter:"+Cup.diameter+"\n"
									   +"height:"+Cup.height+"\n"
									   +"volume:"+Cup.volume);
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
	
	dishes() {
		
	}
	
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
	public void paint (Graphics g) 
	{
		g.setColor(col);
		g.drawRect(10,15,prise,50);
		g.drawString(material, 50, 10);
	}

	void DrawWindow()
	{
		JFrame SetWin = new JFrame("Setting dishes");
		GridLayout gbl = new GridLayout(4,1);
		SetWin.setLayout(gbl);
		SetWin.setLocation(0,350);


		JButton changeCol = new JButton("");
		changeCol.setBackground(col);
		col = Color.white;
		
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
		JButton apply = new JButton("Apply");

		SetWin.getContentPane().add(L_SetCol);
		SetWin.getContentPane().add(changeCol);
		SetWin.getContentPane().add(L_mat);
		SetWin.getContentPane().add(mat);
		SetWin.getContentPane().add(L_prs);
		SetWin.getContentPane().add(prs);
		SetWin.getContentPane().add(apply);
		
		SetWin.setVisible(true);
		SetWin.setSize(500,300);
		
		changeCol.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{
						col = JColorChooser.showDialog(null, "Choose a background",col);
						changeCol.setBackground(col);
				}
			}
		);
		apply.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{
					material = (String)mat.getSelectedItem();
					prise = Integer.parseInt(prs.getText());
					
				}
			}
		);
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
	@Override
	public void paint (Graphics g) 
		{
			g.drawOval(20, diameter, height, volume);
		}
	void DrawWindow()
	{
		JFrame SetWin = new JFrame("Setting cup");
		GridLayout gbl = new GridLayout(4,1);
		SetWin.setLayout(gbl);
		SetWin.setLocation(0,350);

		JTextField  diam = new JTextField();
		JTextField  heig = new JTextField();
		JTextField  vol = new JTextField();
		JLabel L_diam = new JLabel("diameter:");
		JLabel L_heig = new JLabel("height:");
		JLabel L_vol = new JLabel("volume:");
		JButton apply = new JButton("Apply");
		
		SetWin.getContentPane().add(L_diam);
		SetWin.getContentPane().add(diam);
		SetWin.getContentPane().add(L_heig);
		SetWin.getContentPane().add(heig);
		SetWin.getContentPane().add(L_vol);
		SetWin.getContentPane().add(vol);
		SetWin.getContentPane().add(apply);
		SetWin.setVisible(true);
		SetWin.setSize(500,300);
		
		apply.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{
					diameter = Integer.parseInt(diam.getText());
					height = Integer.parseInt(heig.getText());
					volume = Integer.parseInt(vol.getText());
				}
			}
		);
	}
	
	
	
	
}



















