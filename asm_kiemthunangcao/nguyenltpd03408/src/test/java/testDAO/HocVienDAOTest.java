package testDAO;

import org.testng.annotations.Test;

import com.polypro.helper.JdbcHelper;
import com.polypro.dao.HocVienDAO;
import com.polypro.model.HocVien;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.mockito.ArgumentMatchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.Assert;
import org.testng.IObjectFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.ObjectFactory;

@PrepareForTest({ HocVienDAO.class, JdbcHelper.class })
public class HocVienDAOTest extends PowerMockTestCase {

	HocVienDAO dao;
	HocVienDAO daoSpy;

	@ObjectFactory
	public IObjectFactory getObjectFactory() {
		return new org.powermock.modules.testng.PowerMockObjectFactory();
	}

	@BeforeMethod
	public void beforeMethod() {
		dao = new HocVienDAO();
		PowerMockito.mockStatic(JdbcHelper.class);
		daoSpy = PowerMockito.spy(new HocVienDAO());
	}

	@AfterMethod
	public void afterMethod() {
		dao = null;
		daoSpy = null;
	}

	@Test(expectedExceptions = Exception.class)
	public void deleteWithMaHvNegativeTest() {
		int maCd = -1;
		dao.delete(maCd);
	}

	@Test
	public void deleteWithMaKhValidTest() {
		int maCd = 10;
		dao.delete(maCd);
	}

	@Test(expectedExceptions = Exception.class)
	public void insertWithNullModelTest() {
		HocVien model = null;
		dao.insert(model);
	}

	@Test(expectedExceptions = Exception.class)
	public void insertWithEmptyModelTest() {
		HocVien model = new HocVien();
		dao.insert(model);
	}

	@Test
	public void insertWithValidModelTest() {
		HocVien model = new HocVien();
		model.setDiem(10);
		model.setMaHV(16);
		model.setMaKH(1);
		model.setMaNH("NH001");
		dao.insert(model);
	}

	@Test
	public void selectTest() throws Exception {
		List<HocVien> expecteds = new ArrayList<>();
		PowerMockito.doReturn(expecteds).when(daoSpy, "select", ArgumentMatchers.anyString(), ArgumentMatchers.any());
		List<HocVien> actuals = daoSpy.select1();

		Assert.assertEquals(expecteds, actuals);
	}

	@Test(expectedExceptions = Exception.class)
	public void updateWithNullModelTest() {
		HocVien model = null;
		dao.update(model);
	}

	@Test(expectedExceptions = Exception.class)
	public void updateWithEmptyModelTest() {
		HocVien model = new HocVien();
		dao.update(model);
	}

	@Test
	public void updateWithValidModelTest() {
		HocVien model = new HocVien();
		model.setDiem(10);
		model.setMaHV(16);
		model.setMaKH(1);
		model.setMaNH("NH001");
		dao.insert(model);
	}

	@Test
	public void findByIdWithValidModelTest() throws Exception {
		
		int maHV = 16;
		
		HocVien expResuilt = null;
		List<HocVien> resuiltList = new ArrayList<>();
		resuiltList.add(expResuilt);
		PowerMockito.doReturn(resuiltList).when(daoSpy, "select", ArgumentMatchers.anyString(), ArgumentMatchers.any());
		HocVien resuilt = daoSpy.findById(maHV);
		assertThat(resuilt, CoreMatchers.is(expResuilt));
	}

	@Test
	public void findByIdWithNotFoundTest() throws Exception {
		int maHv = 10;

		HocVien expected = null;
		List<HocVien> resultList = new ArrayList<>();

		PowerMockito.doReturn(resultList).when(daoSpy, "select", ArgumentMatchers.anyString(), ArgumentMatchers.any());

		HocVien result = daoSpy.findById(maHv);

		Assert.assertEquals(result, expected);
	}
}
