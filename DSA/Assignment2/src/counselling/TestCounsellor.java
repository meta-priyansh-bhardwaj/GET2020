package counselling;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;

import org.junit.Assert;
import org.junit.Test;

/**
 * Class to test Counsellor class
 *
 */
public class TestCounsellor {

	@Test
	public void testCounsellor() {
		try{
			Counsellor counsellor = new Counsellor();
			counsellor.allocatePrograms();
			String[] expectedAllocation = {"ECE", "CSE", "ECE", "IT", "EEE"};
			Workbook allocationWorkbook = Workbook.getWorkbook(new File("files/Allocation.xls"));
			Sheet allocationSheet = allocationWorkbook.getSheet(0);
			
			int length = allocationSheet.getRows();
			String[] resultAllocation = new String[length];
			for(int i=0;i<length;i++) {
				resultAllocation[i] = allocationSheet.getCell(1, i).getContents();
			}
			Assert.assertArrayEquals(resultAllocation, expectedAllocation);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
