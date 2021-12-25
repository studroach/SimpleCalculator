package calculator;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiInit {
	JFrame frame;
	JPanel pane;
	JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bs,ba,bm,bp,be,bb,bc,bd;
	JLabel ans;

	public GuiInit(Compute calc) {
		
		frame = new JFrame("Heckin' Calculator");
		pane = new JPanel();
		ans = new JLabel();
		b0 = new JButton("0");
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		bs = new JButton("/");
		ba = new JButton("*");
		bm = new JButton("-");
		bp = new JButton("+");
		be = new JButton("=");
		bb = new JButton("Del");
		bc = new JButton("C");
		bd = new JButton(".");
		
		frame.setVisible(true);
		frame.setSize(420, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(pane);
		
		pane.setLayout(null);
		pane.add(ans);
		pane.add(b0);
		pane.add(b1);
		pane.add(b2);
		pane.add(b3);
		pane.add(b4);
		pane.add(b5);
		pane.add(b6);
		pane.add(b7);
		pane.add(b8);
		pane.add(b9);
		pane.add(bs);
		pane.add(ba);
		pane.add(bm);
		pane.add(bp);
		pane.add(be);
		pane.add(bb);
		pane.add(bc);
		pane.add(bd);
		
		Layout();
		Listen(calc);
		
	}
	
	public void Layout() {
		ans.setBounds(50, 50, 300, 70);
		Border field = BorderFactory.createLineBorder(Color.GRAY, 1);
		Border margin = new EmptyBorder(10,10,10,10);
		ans.setBorder(new CompoundBorder(field, margin));
		ans.setBackground(Color.WHITE);
		ans.setOpaque(true);
		ans.setHorizontalAlignment(4);
		Font labelFont = ans.getFont();
		ans.setFont(new Font(labelFont.getName(), Font.PLAIN, 30));
		
		/////////////////////////////////////////////
		
		bs.setBounds(50, 160, 60, 60);
		bs.setBackground(Color.WHITE);
		
		ba.setBounds(130, 160, 60, 60);
		ba.setBackground(Color.WHITE);
		
		bm.setBounds(210, 160, 60, 60);
		bm.setBackground(Color.WHITE);
		
		bp.setBounds(290, 160, 60, 140);
		bp.setBackground(Color.WHITE);
		
		/////////////////////////////////////////////
		
		b7.setBounds(50, 240, 60, 60);
		b7.setBackground(new java.awt.Color(213, 224, 237));
		
		b8.setBounds(130, 240, 60, 60);
		b8.setBackground(new java.awt.Color(213, 224, 237));
		
		b9.setBounds(210, 240, 60, 60);
		b9.setBackground(new java.awt.Color(213, 224, 237));
		
		//////////////////////////////////////////////
		
		b4.setBounds(50, 320, 60, 60);
		b4.setBackground(new java.awt.Color(213, 224, 237));
		
		b5.setBounds(130, 320, 60, 60);
		b5.setBackground(new java.awt.Color(213, 224, 237));
		
		b6.setBounds(210, 320, 60, 60);
		b6.setBackground(new java.awt.Color(213, 224, 237));
		
		be.setBounds(290, 320, 60, 140);
		be.setBackground(Color.WHITE);
		
		//////////////////////////////////////////////
		
		b1.setBounds(50, 400, 60, 60);
		b1.setBackground(new java.awt.Color(213, 224, 237));
		
		b2.setBounds(130, 400, 60, 60);
		b2.setBackground(new java.awt.Color(213, 224, 237));
		
		b3.setBounds(210, 400, 60, 60);
		b3.setBackground(new java.awt.Color(213, 224, 237));
		
		//////////////////////////////////////////////
		
		bd.setBounds(50, 480, 60, 60);
		bd.setBackground(new java.awt.Color(167, 187, 211));
		
		b0.setBounds(130, 480, 60, 60);
		b0.setBackground(new java.awt.Color(213, 224, 237));
		
		bb.setBounds(210, 480, 60, 60);
		bb.setBackground(new java.awt.Color(229, 192, 174));
		
		bc.setBounds(290, 480, 60, 60);
		bc.setBackground(new java.awt.Color(209, 80, 54));
		
	}
	
	public void Listen(Compute calc) {
		ActionListener number = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Compute.Insert(((AbstractButton) e.getSource()).getText(), ans, calc);
			}
		};
		
		ActionListener operator = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Compute.Operate(((AbstractButton) e.getSource()).getText(), ans, calc);
			}
		};
		
		b0.addActionListener(number);
		b1.addActionListener(number);
		b2.addActionListener(number);
		b3.addActionListener(number);
		b4.addActionListener(number);
		b5.addActionListener(number);
		b6.addActionListener(number);
		b7.addActionListener(number);
		b8.addActionListener(number);
		b9.addActionListener(number);
		bd.addActionListener(number);
		bs.addActionListener(operator);
		ba.addActionListener(operator);
		bm.addActionListener(operator);
		bp.addActionListener(operator);
		be.addActionListener(operator);
		bb.addActionListener(operator);
		bc.addActionListener(operator);
	}
}












