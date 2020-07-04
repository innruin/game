package Game;



import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestMap {
	private static Map map=new Map();
	private static Cell [][]cell=new Cell[20][20];
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cell=map.initial();
	}


	@Test
	public void testGetLiving() {
		for(int i=0;i<20;i++) {
			for(int j=0;j<20;j++) {
				cell[i][j].setStatus(1);//ȫ��ϸ�����״̬��
			}
		}
		Map.getLiving(cell);
		for(int i=0;i<20;i++) {
			for(int j=0;j<20;j++) {
				if(i>0&&i<19&&j>0&&j<19) assertEquals(8,cell[i][j].getLiving());//���Գ��˱߽ǵ�ϸ���⣬ÿһ��ϸ����Χ����8����ϸ��
				else if((i==0||i==19)&&(j>0&&j<19)||(j==0||j==19)&&(i>0&&i<19)) assertEquals(5,cell[i][j].getLiving());//����ÿһ����ϸ����Χ����8����ϸ��
				else assertEquals(3,cell[i][j].getLiving());//����ÿһ����ϸ����Χ����8����ϸ��
			}
		}
		for(int i=0;i<20;i++) {
			for(int j=0;j<20;j++) {
				cell[i][j].setStatus(0);//ȫ��ϸ������״̬��
			}
		}
		map.getLiving(cell);
		for(int i=0;i<20;i++) {
			for(int j=0;j<20;j++) {
				assertEquals(0,cell[i][j].getLiving());//����ϸ����Χ��û��ϸ��
			}
		}
	}

	@Test
	public void testUpdate() {
		for(int i=0;i<20;i++) {
			for(int j=0;j<20;j++) {
				cell[i][j].setStatus(1);//����ϸ��������
			}
		}
		map.getLiving(cell);//�ݻ�
		assertEquals(4,map.update(cell));//�ݻ���״̬�����ϸ��Ӧ�����ĸ�
		for(int i=0;i<20;i++) {
			for(int j=0;j<20;j++) {
				cell[i][j].setStatus(0);//����ϸ���������
			}
		}
		map.getLiving(cell);//�ݻ�
		assertEquals(400,map.update(cell));//�ݻ���״̬�����ϸ��Ӧ����400��
	}

}

