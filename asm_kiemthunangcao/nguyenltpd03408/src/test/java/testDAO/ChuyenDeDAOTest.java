package testDAO;

import org.testng.annotations.Test;

import com.polypro.helper.JdbcHelper;
import com.polypro.dao.ChuyenDeDAO;
import com.polypro.model.ChuyenDe;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;


import java.util.ArrayList;
import java.util.List;

import org.mockito.ArgumentMatchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.Assert;
import org.testng.IObjectFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.ObjectFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

@PrepareForTest({ JdbcHelper.class, ChuyenDeDAO.class})
public class ChuyenDeDAOTest extends PowerMockTestCase{
	
	ChuyenDeDAO dao;
	ChuyenDeDAO daoSpy;
	
	@ObjectFactory
	public IObjectFactory getObjectFactory() {
		return new org.powermock.modules.testng.PowerMockObjectFactory();
	}
	
	@BeforeMethod
	public void beforeMethod() {
		dao = new ChuyenDeDAO();
		PowerMockito.mockStatic(JdbcHelper.class);
		daoSpy = PowerMockito.spy(new ChuyenDeDAO());
	}

	@AfterMethod
	public void afterMethod() {
		dao = null;
		daoSpy = null;
	}

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

	@BeforeSuite
	public void beforeSuite() {
	}

	@AfterSuite
	public void afterSuite() {
	}

	@Test(expectedExceptions = Exception.class)
	public void deleteWithMaCdNullTest() {
		String maCd = null;
		dao.delete(maCd);
	}

	@Test
	public void deleteWithMaKhValidTest() {
		String maCd = "CD003";
		dao.delete(maCd);
	}

	@Test(expectedExceptions = Exception.class)
	public void insertWithNullModelTest() {
		ChuyenDe model = null;
		dao.insert(model);
	}

	@Test(expectedExceptions = Exception.class)
	public void insertWithEmptyModelTest() {
		ChuyenDe model = new ChuyenDe();
		dao.insert(model);
	}

	@Test
	public void insertWithValidModelTest() {
		ChuyenDe model = new ChuyenDe();
		model.setHinh("C:\\Users\\ASDZ\\Pictures\\Family\\PD03134.jpg");
		model.setHocPhi(250000);
		model.setMaCD("CD001");
		model.setMoTa("testNG");
		model.setTenCD("SQL");
		model.setThoiLuong(3);
		dao.insert(model);
	}

	@Test
	public void selectTest() throws Exception{
			List<ChuyenDe> expecteds = new ArrayList<>();
			PowerMockito.doReturn(expecteds).when(daoSpy, "select",
					ArgumentMatchers.anyString(),
					ArgumentMatchers.any());
			List<ChuyenDe> actuals = daoSpy.select1();

			Assert.assertEquals(expecteds, actuals);
	}

	@Test(expectedExceptions = Exception.class)
	public void updateWithNullModelTest() {
		ChuyenDe model = null;
		dao.update(model);
	}

	@Test(expectedExceptions = Exception.class)
	public void updateWithEmptyModelTest() {
		ChuyenDe model = new ChuyenDe();
		dao.update(model);
	}

	@Test
	public void updateWithValidModelTest() {
		ChuyenDe model = new ChuyenDe();
		model.setHinh("C:\\Users\\ASDZ\\Pictures\\Family\\PD03134.jpg");
		model.setHocPhi(300000);
		model.setMaCD("CD001");
		model.setMoTa("testNG");
		model.setTenCD("SQL1");
		model.setThoiLuong(5);
		dao.update(model);
	}

	@Test
	public void findByIdWithValidModelTest() throws Exception{
			String maCd = "";
			
			ChuyenDe expected = new ChuyenDe();
			List<ChuyenDe> resultList = new ArrayList<>();
			resultList.add(expected);

			PowerMockito.doReturn(resultList).when(daoSpy, "select",
					ArgumentMatchers.anyString(),
					ArgumentMatchers.any());

			ChuyenDe result = daoSpy.findById(maCd);
			
			System.out.println("--- ^^^ ++++ " + result);
			System.out.println("--- ^^^ ++++ " + expected);
			
			Assert.assertEquals(result, expected);			
	}
	
	@Test
	public void findByIdWithNotFoundTest() throws Exception{
			String maCd = "";

			ChuyenDe expected = null;
			List<ChuyenDe> resultList = new ArrayList<>();

			PowerMockito.doReturn(resultList).when(daoSpy, "select",
					ArgumentMatchers.anyString(),
					ArgumentMatchers.any());

			ChuyenDe result = daoSpy.findById(maCd);

			Assert.assertEquals(result, expected);
	}
}
