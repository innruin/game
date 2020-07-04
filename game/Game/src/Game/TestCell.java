package Game;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCell {
    private static Cell cell=new Cell();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		;
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		;
	}

	@Test
	public void testUpdateStatus() {
		cell.setLiving(1);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());//����setLiving<2��״̬ӦΪ��
		cell.setLiving(4);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());//����setLiving>3��״̬ӦΪ��
		cell.setStatus(0);
		cell.setLiving(3);
		cell.UpdateStatus();
		assertEquals(1,cell.getStatus());//����setLiving=3��״̬ӦΪ��
		cell.setStatus(1);
		cell.setLiving(2);
		cell.UpdateStatus();
		assertEquals(1,cell.getStatus());//����setLiving!=3��״̬Ӧ����
		cell.setStatus(0);
		cell.setLiving(2);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());//����setLiving!=3��״̬Ӧ����
	}

}

