import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;

class main
{
	public static Color col;
	public static void main(String[] args)
	{
		JFrame window = new JFrame("Lab 4");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CupTemplate Cup = new CupTemplate();
		
		//Елементи інтерфейсу:
		JLabel lab1 = new JLabel("Color:");
		JLabel lab2 = new JLabel("Valume water(ml):");
		JLabel lab3 = new JLabel("Material:");
		JLabel lab4 = new JLabel("Prise:");
		JLabel lab5 = new JLabel("Saucer:");
		JLabel lab6 = new JLabel("Result:");
		
		JButton changeCol = new JButton("");
		changeCol.setBackground(Cup.getCol());
		col = Color.white;
		
		JSlider volume = new JSlider(JSlider.HORIZONTAL,100,1000,100);
		
		String[] listMaterials = {
			"Glass",
			"Ceramics",
			"Stainless Steel",
			"Plastic"
		};
		JComboBox material = new JComboBox(listMaterials);
		
		JTextField prise = new JTextField("0");
		
		JCheckBox saucer = new JCheckBox("");
		
		JButton entry = new JButton("Data entry");
		JButton output = new JButton("Data output");
		JTextArea result = new JTextArea();
		
		//Вивдення елементів
		GridLayout gbl = new GridLayout(7,0);
		window.setLayout(gbl);
		
		window.getContentPane().add(lab1);
		window.getContentPane().add(changeCol);
		window.getContentPane().add(lab2);
		window.getContentPane().add(volume);
		window.getContentPane().add(lab3);
		window.getContentPane().add(material);
		window.getContentPane().add(lab4);
		window.getContentPane().add(prise);
		window.getContentPane().add(lab5);
		window.getContentPane().add(saucer);
		window.getContentPane().add(entry);
		window.getContentPane().add(output);
		window.getContentPane().add(lab6);
		window.getContentPane().add(result);
		
		window.setVisible(true);
		window.setSize(500,600);
		//обробка кнопок

		changeCol.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{
						col = JColorChooser.showDialog(null, "Choose a background",col);
						changeCol.setBackground(col);
				}
			}
		);
		entry.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{
					Cup.setCol(col);
					Cup.setVolume(volume.getValue());
					Cup.setMaterial((String)material.getSelectedItem());
					Cup.setPrise(prise.getText() );
					Cup.setSaucer(saucer.isSelected());
				}
			}
		);
		output.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{
					result.setText("Color:"+Cup.getCol()+"\n"+
					"Valume water(ml):"+Cup.getVolume()+"\n"+
					"Material:"+Cup.getMaterial()+"\n"+
					"Prise:"+Cup.getPrise()+"\n"+
					"Saucer:"+Cup.getSaucer());
				}
			}
		);
	}
	
	
}

class CupTemplate
{
	//поля
	private Color col = Color.white;
	private int volume = 0;
	private String material;
	private String prise;
	private boolean saucer = false;
	
	//set
	void setCol(Color c)
	{
		col = c;
	}
	void setVolume(int i)
	{
		volume = i;
	}
	void setMaterial(String s)
	{
		material = s;
	}
	void setPrise(String i)
	{
		prise = i;
	}
	void setSaucer(boolean b)
	{
		saucer  = b;
	}
	
	//get
	Color getCol()
	{
		return col;
	}
	int getVolume()
	{
		return volume;
	}
	String getMaterial()
	{
		return material;
	}
	String getPrise()
	{
		return prise;
	}
	boolean getSaucer()
	{
		return saucer;
	}
}