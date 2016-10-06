//package com.company; 
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;


class main{ 
	public static void main(String[] args) 
	{ 
		JFrame window = new JFrame("first laba"); 
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(400,400); 
		window.setVisible(true);
		JButton btn = new JButton("start"); 
		JTextField str1 = new JTextField(); 
		JTextField res = new JTextField(); 
		//створення компонентів 
		window.getContentPane().add(str1); 
		window.getContentPane().add(btn); 
		window.getContentPane().add(res); 
		} 
}