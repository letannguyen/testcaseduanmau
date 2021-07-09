package junitTestModel;

import com.polypro.model.KhoaHoc;

import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KhoaHocTest {

	KhoaHoc kh;

	@Before
	public void beforeMethod() {
		kh = new KhoaHoc();
	}

	@After
	public void afterMethod() {
		kh = null;
	}

	@Test
	public void getGhiChuTest() {
		String expected = null;
		String actual = kh.getGhiChu();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void getHocPhiTest() {
		double expected = 0;
		double actual = kh.getHocPhi();
		Assert.assertTrue(expected == actual);
	}

	@Test
	public void getMaCDTest() {
		String expected = null;
		String actual = kh.getMaCD();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void getMaKHTest() {
		Integer expected = 0;
		Integer actual = kh.getMaKH();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void getMaNVTest() {
		String expected = null;
		String actual = kh.getMaNV();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void getNgayKGTest() {
		Date expected = null;
		Date actual = kh.getNgayKG();
		Assert.assertTrue(expected == actual);
	}

	@Test
	public void getNgayTaoTest() {
		Date expected = null;
		Date actual = kh.getNgayKG();
		Assert.assertTrue(expected == actual);
	}

	@Test
	public void getThoiLuongTest() {
		Integer expected = 0;
		Integer actual = kh.getThoiLuong();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void setGhiChuTest() {
		String expected = "testNG";
		kh.setGhiChu("testNG");
		String actual = kh.getGhiChu();
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void setGhiChuEmptyTest() {
		String expected = "";
		kh.setGhiChu("");
		String actual = kh.getGhiChu();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void setHocPhiTest() {
		double expected = 250000;
		kh.setHocPhi(250000);
		double actual = kh.getHocPhi();
		Assert.assertTrue(expected == actual);
	}
	
	@Test(expected = Exception.class)
	public void setHocPhiNegativeTest() {
		double expected = -250000;
		kh.setHocPhi(-250000);
		double actual = kh.getHocPhi();
		Assert.assertTrue(expected == actual);
	}
	
	@Test(expected = Exception.class)
	public void setHocPhiZeroTest() {
		double expected = 0;
		kh.setHocPhi(0);
		double actual = kh.getHocPhi();
		Assert.assertTrue(expected == actual);
	}

	@Test
	public void setMaCDTest() {
		String expected = "CD001";
		kh.setMaCD("CD001");
		String actual = kh.getMaCD();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(expected = Exception.class)
	public void setMaCDNullTest() {
		String expected = null;
		kh.setMaCD(null);
		String actual = kh.getMaCD();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void setMaKHTest() {
		Integer expected = 0;
		kh.setMaKH(0);
		Integer actual = kh.getMaKH();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(expected = Exception.class)
	public void setMaKHNullTest() {
		Integer expected = 0;
		kh.setMaKH(0);
		Integer actual = kh.getMaKH();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void setMaNVTest() {
		String expected = "NV001";
		kh.setMaNV("NV001");
		String actual = kh.getMaNV();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(expected = Exception.class)
	public void setMaNVNullTest() {
		String expected = null;
		kh.setMaNV(null);
		String actual = kh.getMaNV();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void setNgayKGTest() {
		Date expected = new Date();
		kh.setNgayKG(new Date());
		Date actual = kh.getNgayKG();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(expected = Exception.class)
	public void setNgayKGNullTest() {
		Date expected = null;
		kh.setNgayKG(null);
		Date actual = kh.getNgayKG();
		Assert.assertEquals(actual, expected);
	}


	@Test
	public void setNgayTaoTest() {
		Date expected = new Date();
		kh.setNgayTao(new Date());
		Date actual = kh.getNgayTao();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(expected  = Exception.class)
	public void setNgayTaoNullTest() {
		Date expected = new Date();
		kh.setNgayTao(new Date());
		Date actual = kh.getNgayTao();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void setThoiLuongTest() {
		Integer expected = 3;
		kh.setThoiLuong(3);
		Integer actual = kh.getThoiLuong();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(expected = Exception.class)
	public void setThoiLuongNullTest() {
		Integer expected = 0;
		kh.setThoiLuong(0);
		Integer actual = kh.getThoiLuong();
		Assert.assertEquals(actual, expected);
	}
}
