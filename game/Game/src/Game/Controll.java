package Game;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class Controll {
    Controll() {
    	 final boolean Pause[] = {false};
    
    	JFrame jframe=new JFrame();
    	jframe.setSize(500,500);
    	JPanel jpanel=new JPanel();
    	FlowLayout flowLayout = (FlowLayout) jpanel.getLayout();
    	int count=0;
    	int change;
    	
    
    	Cell [][]cell=new Cell[20][20];
    	cell=Map.initial();
    	Map.getLiving(cell);
    	jframe.setTitle("这是第"+count+"次演化");
    	jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	jframe.setLocationRelativeTo(null);
    	jframe.getContentPane().setLayout(new BorderLayout(0,  0));
    	JButton button1 = new JButton("暂停");
    	jframe.getContentPane().add(button1, BorderLayout.SOUTH);
    	button1.addActionListener(new ActionListener() {

	        @Override
	        public void actionPerformed(ActionEvent arg0) {
	        	Pause[0]  = true;
	        }
	    });
    	JButton button2 = new JButton("继续");
    	jframe.getContentPane().add(button2, BorderLayout.NORTH);
    	button2.addActionListener(new ActionListener() {

	        @Override
	        public void actionPerformed(ActionEvent arg0) {
	        	Pause[0]  = false;
	        }
	    });
    	jframe.getContentPane().add(jpanel);
    	jframe.setVisible(true);
    	Graphics g=jpanel.getGraphics();
    	for(int i=0;i<30;i++) {
    		for(int j=0;j<30;j++) {
    			g.drawRect(i*20, j*20, 20, 20);
    		}
    	}
    	for(int i=0;i<20;i++) {
    		for(int j=0;j<20;j++) {
    			if(cell[i][j].getStatus()==1) {
    				g.fillRect(i*20, j*20, 20, 20);
    			}
    			else {
    				g.drawRect(i*20, j*20, 20, 20);
    			}
    		}
    	}
    	long d1= System.currentTimeMillis();
    	
    	while(true) {
    		if(Pause[0]) {
            continue;
    		}
    		long d2= System.currentTimeMillis();
    		if(d2-d1>300) {
    			
    			d1=d2;
    			jframe.repaint();
    			change=Map.update(cell);
    			Map.getLiving(cell);
    			for(int i=0;i<20;i++) {
    	    		for(int j=0;j<20;j++) {
    	    			g.drawRect(i*20, j*20, 20, 20);
    	    		}
    	    	}
    			for(int i=0;i<20;i++) {
    				for(int j=0;j<20;j++) {
    					if(cell[i][j].getStatus()==1) {
    	    				g.fillRect(i*20, j*20, 20, 20);
    	    			}
    	    			else {
    	    				g.drawRect(i*20, j*20, 20, 20);
    				    }
    				}
    			}
    		    count++;
    		    jframe.setTitle("这是第"+count+"次演化");
    			if(change==20*20) break;
    	    }	    	
      }
    	JOptionPane.showMessageDialog(jframe, "在第"+count+"次演化达到平衡", "提示", JOptionPane.PLAIN_MESSAGE);
}
}



