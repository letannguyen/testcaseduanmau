package junitTestModel;

import com.polypro.model.HocVien;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HocVienTest {

	HocVien hv;

	@Before
	public void beforeMethod() {
		hv = new HocVien();
	}

	@After
	public void afterMethod() {
		hv = null;
	}

	@Test
	public void getDiemTest() {
		double expected = -1;
		double actual = hv.getDiem();
		Assert.assertTrue(expected == actual);
	}

	@Test
	public void getMaHVTest() {
		int expected = 0;
		int actual = hv.getMaHV();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void getMaKHTest() {
		Integer expected = null;
		Integer actual = hv.getMaKH();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void getMaNHTest() {
		String expected = null;
	    String actual = hv.getMaNH();
	    Assert.assertEquals(expected, actual);
	}

	@Test
	public void setDiemTest() {
		double expected = 9.5;
		hv.setDiem(9.5);
		double actual = hv.getDiem();
		Assert.assertTrue(expected == actual);
	}
	
	@Test(expected = Exception.class)
	public void setDiemNegativeTest() {
		double expected = -9.5;
		hv.setDiem(-9.5);
		double actual = hv.getDiem();
		Assert.assertTrue(expected == actual);
	}
	
	@Test(expected = Exception.class)
	public void setDiemZeroTest() {
		double expected = 0;
		hv.setDiem(0);
		double actual = hv.getDiem();
		Assert.assertTrue(expected == actual);
	}

	@Test
	public void setMaHVTest() {
		int expected = 1;
		hv.setMaHV(1);
		int actual = hv.getMaHV();
		Assert.assertEquals(actual, expected);
	}
	@Test(expected = Exception.class)
	public void setMaHVNegativeTest() {
		int expected = -1;
		hv.setMaHV(-1);
		int actual = hv.getMaHV();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(expected = Exception.class)
	public void setMaHVZeroTest() {
		int expected = 0;
		hv.setMaHV(0);
		int actual = hv.getMaHV();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void setMaKHTest() {
		Integer expected = 1;
		hv.setMaKH(1);
		Integer actual = hv.getMaKH();
		Assert.assertEquals(actual, expected);
	}
	@Test(expected = Exception.class)
	public void setMaKHNullTest() {
		Integer expected = 0;
		hv.setMaKH(0);
		Integer actual = hv.getMaKH();
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void setMaNHTest() {
		String expected = "NH001";
		hv.setMaNH("NH001");;
		String actual = hv.getMaNH();
		Assert.assertEquals(actual, expected);
	}
	@Test(expected = Exception.class)
	public void setMaNHNullTest() {
		String expected = null;
		hv.setMaNH(null);
		String actual = hv.getMaNH();
		Assert.assertEquals(actual, expected);
	}
	
}
