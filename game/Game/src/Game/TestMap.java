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
				cell[i][j].setStatus(1);//全部细胞活的状态下
			}
		}
		Map.getLiving(cell);
		for(int i=0;i<20;i++) {
			for(int j=0;j<20;j++) {
				if(i>0&&i<19&&j>0&&j<19) assertEquals(8,cell[i][j].getLiving());//测试除了边角的细胞外，每一个细胞周围都有8个活细胞
				else if((i==0||i==19)&&(j>0&&j<19)||(j==0||j==19)&&(i>0&&i<19)) assertEquals(5,cell[i][j].getLiving());//测试每一个边细胞周围都有8个活细胞
				else assertEquals(3,cell[i][j].getLiving());//测试每一个角细胞周围都有8个活细胞
			}
		}
		for(int i=0;i<20;i++) {
			for(int j=0;j<20;j++) {
				cell[i][j].setStatus(0);//全部细胞死的状态下
			}
		}
		map.getLiving(cell);
		for(int i=0;i<20;i++) {
			for(int j=0;j<20;j++) {
				assertEquals(0,cell[i][j].getLiving());//所有细胞周围都没有细胞
			}
		}
	}

	@Test
	public void testUpdate() {
		for(int i=0;i<20;i++) {
			for(int j=0;j<20;j++) {
				cell[i][j].setStatus(1);//所有细胞活的情况
			}
		}
		map.getLiving(cell);//演化
		assertEquals(4,map.update(cell));//演化后，状态不变的细胞应该有四个
		for(int i=0;i<20;i++) {
			for(int j=0;j<20;j++) {
				cell[i][j].setStatus(0);//所有细胞死的情况
			}
		}
		map.getLiving(cell);//演化
		assertEquals(400,map.update(cell));//演化后，状态不变的细胞应该有400个
	}

}

