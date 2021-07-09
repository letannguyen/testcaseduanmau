package testModel;

import org.testng.annotations.Test;

import com.polypro.model.NhanVien;

import org.testng.annotations.BeforeMethod;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class NhanVienTest {
	NhanVien nv;

	@BeforeMethod
	public void beforeMethod() {
		nv = new NhanVien();
	}

	@AfterMethod
	public void afterMethod() {
		nv = null;
	}

	@Test
	public void getHoTenTest() {
		String expected = null;
		String actual =  nv.getHoTen();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void getMaNVTest() {
		String expected = null;
		String actual =  nv.getMaNV();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void getMatKhauTest() {
		String expected = null;
		String actual =  nv.getMatKhau();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void getVaiTroTest() {
		boolean expected = false;
		boolean actual =  nv.isVaiTro();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void isVaiTroTest() {
		boolean expected = false;
		boolean actual =  nv.isVaiTro();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void setHoTenTest() {
		String expected = "Nguyen Van Teo";
		nv.setHoTen("Nguyen Van Teo");
		String actual = nv.getHoTen();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(expectedExceptions = Exception.class)
	public void setHoTenNullTest() {
		String expected = null;
		nv.setHoTen(null);
		String actual = nv.getHoTen();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void setMaNVTest() {
		String expected = "NV010";
		nv.setMaNV("NV010");
		String actual = nv.getMaNV();
		Assert.assertEquals(actual, expected);	
	}
	
	@Test(expectedExceptions = Exception.class)
	public void setMaNVNullTest() {
		String expected = null;
		nv.setMaNV(null);
		String actual = nv.getMaNV();
		Assert.assertEquals(actual, expected);	
	}

	@Test
	public void setMatKhauTest() {
		String expected = "123456";
		nv.setMatKhau("123456");
		String actual = nv.getMatKhau();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(expectedExceptions = Exception.class)
	public void setMatKhauNullTest() {
		String expected = null;
		nv.setMatKhau(null);
		String actual = nv.getMatKhau();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void setVaiTroTrueTest() {
		boolean expected = true;
		nv.setVaiTro(true);
		boolean actual =  nv.isVaiTro();
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void setVaiTrofalseTest() {
		boolean expected = false;
		nv.setVaiTro(false);
		boolean actual =  nv.isVaiTro();
		Assert.assertEquals(actual, expected);
	}
}
