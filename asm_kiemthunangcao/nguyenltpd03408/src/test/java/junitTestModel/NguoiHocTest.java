package junitTestModel;


import com.polypro.helper.DateHelper;
import com.polypro.model.NguoiHoc;
import java.util.Date;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class NguoiHocTest {
	NguoiHoc nh;

	@Before
	public void beforeMethod() {
		nh = new NguoiHoc();
	}

	@After
	public void afterMethod() {
		nh = null;
	}

	@Test
	public void getDienThoaiTest() {
		String expected = null;
		String actual = nh.getDienThoai();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void getEmailTest() {
		String expected = null;
		String actual = nh.getEmail();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void getGhiChuTest() {
		String expected = null;
		String actual = nh.getGhiChu();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void getGioiTinhTest() {
		boolean expected = false;
		boolean actual = nh.isGioiTinh();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void getHoTenTest() {
		String expected = null;
		String actual = nh.getHoTen();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void getMaNHTest() {
		String expected = null;
		String actual = nh.getMaNH();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void getMaNVTest() {
		String expected = null;
		String actual = nh.getMaNV();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void getNgayDKTest() {
		String expected = DateHelper.toString(DateHelper.now());
		String actual = DateHelper.toString(nh.getNgayDK());
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void getNgaySinhTest() {
		Date expected = null;
		Date actual = nh.getNgaySinh();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void isGioiTinhTest() {
		boolean expected = false;
		boolean actual = nh.isGioiTinh();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void setDienThoaiTest() {
		String expected = "0384793266";
		nh.setDienThoai("0384793266");
		String actual = nh.getDienThoai();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(expected = Exception.class)
	public void setDienThoaiNullTest() {
		String expected = null;
		nh.setDienThoai(null);
		String actual = nh.getDienThoai();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void setEmailTest() {
		String expected = "duy@gmail.com";
		nh.setEmail("duy@gmail.com");
		String actual = nh.getEmail();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(expected = Exception.class)
	public void setEmailNullTest() {
		String expected = null;
		nh.setEmail(null);
		String actual = nh.getEmail();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void setGhiChuTest() {
		String expected = "testNG";
		nh.setGhiChu("testNG");;
		String actual = nh.getGhiChu();
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void setGhiChuEmptyTest() {
		String expected = "";
		nh.setGhiChu("");;
		String actual = nh.getGhiChu();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void setGioiTinhTrueTest() {
		boolean expected = true;
		nh.setGioiTinh(true);
		boolean actual = nh.isGioiTinh();
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void setGioiTinhFalseTest() {
		boolean expected = false;
		nh.setGioiTinh(false);
		boolean actual = nh.isGioiTinh();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void setHoTenTest() {
		String expected = "Nguyen Van Teo";
		nh.setHoTen("Nguyen Van Teo");
		String actual = nh.getHoTen();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(expected = Exception.class)
	public void setHoTenNullTest() {
		String expected = null;
		nh.setHoTen(null);
		String actual = nh.getHoTen();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void setMaNHTest() {
		String expected = "NH001";
		nh.setMaNH("NH001");
		String actual = nh.getMaNH();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(expected = Exception.class)
	public void setMaNHNullTest() {
		String expected = null;
		nh.setMaNH(null);
		String actual = nh.getMaNH();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void setMaNVTest() {
		String expected = "NV001";
		nh.setMaNV("NV001");
		String actual = nh.getMaNV();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(expected = Exception.class)
	public void setMaNVNullTest() {
		String expected = null;
		nh.setMaNV(null);
		String actual = nh.getMaNV();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void setNgayDKTest() {
		Date expected = DateHelper.toDate("29/06/2020", "dd/MM/yyyy");
		nh.setNgayDK(DateHelper.toDate("29/06/2020", "dd/MM/yyyy"));
		Date actual = nh.getNgayDK();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(expected = Exception.class)
	public void setNgayDKNullTest() {
		Date expected = null;
		nh.setNgayDK(null);
		Date actual = nh.getNgayDK();
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void setNgaySinhTest() {
		Date expected = DateHelper.toDate("22/12/2000", "dd/MM/yyyy");
		nh.setNgayDK(DateHelper.toDate("22/12/2000", "dd/MM/yyyy"));
		Date actual = nh.getNgayDK();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(expected = Exception.class)
	public void setNgaySinhNullTest() {
		Date expected = null;
		nh.setNgayDK(null);
		Date actual = nh.getNgayDK();
		Assert.assertEquals(actual, expected);
	}
}
