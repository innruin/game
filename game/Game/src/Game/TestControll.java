package Game;

import static org.junit.Assert.*;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.junit.Test;

public class TestControll {

	@Test
	public void testControll() {
		JFrame jframe=new JFrame();
    	jframe.setSize(500,500);
    	JPanel jpanel=new JPanel();
    	jpanel.setBounds(0,0,400,400);
    	int count=0;
    	int change;
    	Cell [][]cell=new Cell[20][20];
    	cell=Map.initial();
    	Map.getLiving(cell);
    	jframe.setTitle("���ǵ�"+count+"���ݻ�");
    	jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	jframe.setLocationRelativeTo(null);
    	jframe.add(jpanel);
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
    		    jframe.setTitle("���ǵ�"+count+"���ݻ�");
    			if(change==20*20) break;
    			//if(count>1000) break;
    	    }	    	
      }
    	JOptionPane.showMessageDialog(jframe, "�ڵ�"+count+"���ݻ��ﵽƽ��", "��ʾ", JOptionPane.PLAIN_MESSAGE);
    	//if(count<=1000)
    	assertEquals(change,400);//���������ݻ��ﵽƽ��ʱ�����з��鲻�ٷ����仯
	}
	}


