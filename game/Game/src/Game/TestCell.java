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
		assertEquals(0,cell.getStatus());//测试setLiving<2，状态应为死
		cell.setLiving(4);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());//测试setLiving>3，状态应为死
		cell.setStatus(0);
		cell.setLiving(3);
		cell.UpdateStatus();
		assertEquals(1,cell.getStatus());//测试setLiving=3，状态应为活
		cell.setStatus(1);
		cell.setLiving(2);
		cell.UpdateStatus();
		assertEquals(1,cell.getStatus());//测试setLiving!=3，状态应不变
		cell.setStatus(0);
		cell.setLiving(2);
		cell.UpdateStatus();
		assertEquals(0,cell.getStatus());//测试setLiving!=3，状态应不变
	}

}

