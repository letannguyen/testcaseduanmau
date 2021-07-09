package testModel;

import org.testng.annotations.Test;

import com.polypro.model.ChuyenDe;

import org.testng.annotations.BeforeMethod;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class ChuyenDeTest {
	ChuyenDe cd;

	@BeforeMethod
	public void beforeMethod() {
		cd = new ChuyenDe();
	}

	@AfterMethod
	public void afterMethod() {
		cd = null;
	}

	@Test
	public void getHinhTest() {
		String expected = null;
		String actual = cd.getHinh();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void getHocPhiTest() {
		double expected = 0;
		double actual = cd.getHocPhi();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void getMaCDTest() {
		String expected = null;
		String actual = cd.getMaCD();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void getMoTaTest() {
		String expected = null;
		String actual = cd.getMoTa();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void getTenCDTest() {
		String expected = null;
		String actual = cd.getTenCD();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void getThoiLuongTest() {
		Integer expected = 0;
		Integer actual = cd.getThoiLuong();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void setHinhTest() {		
		String expected = "C:\\Users\\ASDZ\\Pictures\\abc\\PD03183.jpg";
		cd.setHinh("C:\\Users\\ASDZ\\Pictures\\abc\\PD03183.jpg");
		String actual = cd.getHinh();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(expectedExceptions = Exception.class)
	public void setHinhNullTest() {		
		String actual = "";
		cd.setHinh("");
		String expected = cd.getHinh();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void setHocPhiTest() {
		double expected = 10;
		cd.setHocPhi(10);
		double actual = cd.getHocPhi();
		Assert.assertEquals(actual, expected);	
	}
	
	@Test(expectedExceptions = Exception.class)
	public void setHocPhiNegativeTest() {
		double expected = -10;
		cd.setHocPhi(-10);
		double actual = cd.getHocPhi();
		Assert.assertEquals(actual, expected);	
	}
	
	@Test(expectedExceptions = Exception.class)
	public void setHocPhiZeroTest() {
		double expected = 0;
		cd.setHocPhi(0);
		double actual = cd.getHocPhi();
		Assert.assertEquals(actual, expected);	
	}

	@Test
	public void setMaCDTest() {
		String expected = "CD011";
		cd.setMaCD("CD011");
		String actual = cd.getMaCD();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(expectedExceptions = Exception.class)
	public void setMaCDNullTest() {
		String expected = null;
		cd.setMaCD(null);
		String actual = cd.getMaCD();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void setMoTaTest() {
		String expected = "testNG";
		cd.setMoTa("testNG");
		String actual = cd.getMoTa();
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void setMoTaEmptyTest() {
		String expected = "";
		cd.setMoTa("");
		String actual = cd.getMoTa();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void setTenCDTest() {
		String expected = "SPRING";
		cd.setTenCD("SPRING");
		String actual = cd.getTenCD();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(expectedExceptions = Exception.class)
	public void setTenCDNullTest() {
		String expected = null;
		cd.setTenCD(null);
		String actual = cd.getTenCD();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void setThoiLuongTest() {
		Integer expected = 3;
		cd.setThoiLuong(3);
		Integer actual = cd.getThoiLuong();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(expectedExceptions = Exception.class)
	public void setThoiLuongNullTest() {
		Integer expected = 0;
		cd.setThoiLuong(0);
		Integer actual = cd.getThoiLuong();
		Assert.assertEquals(actual, expected);
	}
}
