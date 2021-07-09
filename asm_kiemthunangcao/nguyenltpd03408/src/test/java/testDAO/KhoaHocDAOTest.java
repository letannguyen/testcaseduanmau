package testDAO;

import org.testng.annotations.Test;

import com.polypro.helper.JdbcHelper;
import com.polypro.dao.KhoaHocDAO;
import com.polypro.model.KhoaHoc;

import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mockito.ArgumentMatchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.testng.Assert;
import org.testng.IObjectFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.ObjectFactory;
import org.testng.annotations.AfterTest;

@PrepareForTest({ JdbcHelper.class, KhoaHocDAO.class })
public class KhoaHocDAOTest {

	KhoaHocDAO dao;
	KhoaHocDAO daoSpy;

	@ObjectFactory
	public IObjectFactory getObjectFactory() {
		return new org.powermock.modules.testng.PowerMockObjectFactory();
	}

	@BeforeMethod
	public void beforeMethod() {
		dao = new KhoaHocDAO();
		PowerMockito.mockStatic(JdbcHelper.class);
		daoSpy = PowerMockito.spy(new KhoaHocDAO());
	}

	@AfterMethod
	public void afterMethod() {
		dao = null;
		daoSpy = null;
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

	@Test(expectedExceptions = Exception.class)
	public void deleteWithMaKhNullTest() {
		Integer maKH = null;
		KhoaHocDAO instance = new KhoaHocDAO();
		instance.delete(maKH);
	}

	@Test
	public void deleteWithMaKhValidTest() {
		Integer maKH = 10;
		KhoaHocDAO instance = new KhoaHocDAO();
		instance.delete(maKH);
	}

	@Test(expectedExceptions = Exception.class)
	public void insertWithNullModelTest() {
		KhoaHoc model = null;
		KhoaHocDAO instance = new KhoaHocDAO();
		instance.insert(model);
	}

	@Test(expectedExceptions = Exception.class)
	public void insertWithEmptyModelTest() {
		KhoaHoc model = new KhoaHoc();
		KhoaHocDAO instance = new KhoaHocDAO();
		instance.insert(model);
	}

	@Test
	public void insertWithValidModelTest() {
		KhoaHoc model = new KhoaHoc();
		model.setGhiChu("testng");
		model.setHocPhi(500000);
		model.setMaCD("CD001");
		model.setMaKH(11);
		model.setMaNV("NV001");
		model.setNgayKG(new Date());
		model.setNgayTao(new Date());
		model.setThoiLuong(3);
		KhoaHocDAO instance = new KhoaHocDAO();
		instance.insert(model);
	}

	@Test
	public void selectTest() throws Exception {
			List<KhoaHoc> expecteds = new ArrayList<>();
			PowerMockito.doReturn(expecteds).when(daoSpy, "select", ArgumentMatchers.anyString(),
					ArgumentMatchers.any());
			List<KhoaHoc> actuals = daoSpy.select1();

			Assert.assertEquals(expecteds, actuals);

	}

	@Test(expectedExceptions = Exception.class)
	public void updateWithNullModelTest() {
		KhoaHoc model = null;
		KhoaHocDAO instance = new KhoaHocDAO();
		instance.update(model);
	}

	@Test(expectedExceptions = Exception.class)
	public void updateWithEmptyModelTest() {
		KhoaHoc model = new KhoaHoc();
		KhoaHocDAO instance = new KhoaHocDAO();
		instance.update(model);
	}

	@Test
	public void updateWithValidModelTest() {
		KhoaHoc model = new KhoaHoc();
		model.setGhiChu("testng");
		model.setHocPhi(300000);
		model.setMaCD("CD001");
		model.setMaKH(11);
		model.setMaNV("NV001");
		model.setNgayKG(new Date());
		model.setNgayTao(new Date());
		model.setThoiLuong(5);
		KhoaHocDAO instance = new KhoaHocDAO();
		instance.update(model);
	}

	@Test
	public void findByIdWithValidModelTest() throws Exception {
			Integer maKH = 11;

			KhoaHoc expected = new KhoaHoc();
			List<KhoaHoc> resultList = new ArrayList<>();
			resultList.add(expected);

			PowerMockito.doReturn(resultList).when(daoSpy, "select", ArgumentMatchers.anyString(),
					ArgumentMatchers.any());

			KhoaHoc result = daoSpy.findById(maKH);

			Assert.assertEquals(result, expected);

	}
	
	@Test
	public void findByIdWithNontFoundTest() throws Exception {
			Integer maKh = 11;

			KhoaHoc expected = null;
			List<KhoaHoc> resultList = new ArrayList<>();

			PowerMockito.doReturn(resultList).when(daoSpy, "select", ArgumentMatchers.anyString(),
					ArgumentMatchers.any());

			KhoaHoc result = daoSpy.findById(maKh);

			Assert.assertEquals(result, expected);

	}
}
