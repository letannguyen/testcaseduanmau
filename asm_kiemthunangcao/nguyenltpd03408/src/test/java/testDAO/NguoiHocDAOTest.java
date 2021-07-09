package testDAO;

import org.testng.annotations.Test;

import com.polypro.helper.DateHelper;
import com.polypro.helper.JdbcHelper;
import com.polypro.dao.NguoiHocDAO;
import com.polypro.model.NguoiHoc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mockito.ArgumentMatchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.Assert;
import org.testng.IObjectFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.ObjectFactory;

@PrepareForTest({ JdbcHelper.class, NguoiHocDAO.class })
public class NguoiHocDAOTest extends PowerMockTestCase{
	
	NguoiHocDAO dao;
	NguoiHocDAO daoSpy;
	
	@ObjectFactory
	public IObjectFactory getObjectFactory() {
		return new org.powermock.modules.testng.PowerMockObjectFactory();
	}

	@BeforeMethod
	public void beforeMethod() {
		dao = new NguoiHocDAO();
		PowerMockito.mockStatic(JdbcHelper.class);
		daoSpy = PowerMockito.spy(new NguoiHocDAO());
	}
	
	@AfterMethod
	public void afterMethod() {
		dao = null;
		daoSpy = null;
	}

	@Test(expectedExceptions = Exception.class)
	public void deleteWithMaNhNullTest() {
		String maCd = null;
		dao.delete(maCd);
	}

	@Test
	public void deleteWithMaNhValidTest() {
		String maCd = "NH010";
		dao.delete(maCd);
	}

	@Test(expectedExceptions = Exception.class)
	public void insertWithNullModelTest() {
		NguoiHoc model = null;
		dao.insert(model);
	}

	@Test(expectedExceptions = Exception.class)
	public void insertWithEmptyModelTest() {
		NguoiHoc model = new NguoiHoc();
		dao.insert(model);
	}

	@Test
	public void insertWithValidModelTest() {
		NguoiHoc model = new NguoiHoc();
		model.setDienThoai("0123456789");
		model.setEmail("mam@gmail.com");
		model.setGhiChu("testng");
		model.setGioiTinh(false);
		model.setHoTen("Nguyễn thị Mắm");
		model.setMaNH("NH010");
		model.setMaNV("NV001");
		model.setNgayDK(new Date());
		model.setNgaySinh( DateHelper.toDate("22/12/2000", "dd/MM/yyyy"));
		dao.insert(model);
	}

	@Test
	public void selectTest() throws Exception{
			List<NguoiHoc> expecteds = new ArrayList<>();
			PowerMockito.doReturn(expecteds).when(daoSpy, "select", ArgumentMatchers.anyString(),
					ArgumentMatchers.any());
			List<NguoiHoc> actuals = daoSpy.select1();

			Assert.assertEquals(expecteds, actuals);
	}

	@Test(expectedExceptions = Exception.class)
	public void updateWithNullModelTest() {
		NguoiHoc model = null;
		dao.update(model);
	}

	@Test(expectedExceptions = Exception.class)
	public void updateWithEmptyModelTest() {
		NguoiHoc model = new NguoiHoc();
		dao.update(model);
	}

	@Test
	public void updateWithValidModelTest() {
		NguoiHoc model = new NguoiHoc();
		model.setDienThoai("0123987654");
		model.setEmail("mam@gmail.com");
		model.setGhiChu("testnggggg");
		model.setGioiTinh(false);
		model.setHoTen("Nguyễn thị Mắm");
		model.setMaNH("NH010");
		model.setMaNV("NV001");
		model.setNgayDK(new Date());
		model.setNgaySinh( DateHelper.toDate("22/12/2000", "dd/MM/yyyy"));
		dao.update(model);
	}

	@Test
	public void findByIdWithValidModelTest() throws Exception{
			String maNh = "NH010";
			
			NguoiHoc expected = new NguoiHoc();
			List<NguoiHoc> resultList = new ArrayList<>();
			resultList.add(expected);

			PowerMockito.doReturn(resultList).when(daoSpy, "select",
					ArgumentMatchers.anyString(),
					ArgumentMatchers.any());

			NguoiHoc result = daoSpy.findById(maNh);
			
			System.out.println("--- ^^^ ++++ " + result);
			System.out.println("--- ^^^ ++++ " + expected);
			
			Assert.assertEquals(result, expected);		
	}
	
	@Test
	public void findByIdWithNotFoundTest() throws Exception{
			String maNH = "NH111";

			NguoiHoc expected = null;
			List<NguoiHoc> resultList = new ArrayList<>();

			PowerMockito.doReturn(resultList).when(daoSpy, "select",
					ArgumentMatchers.anyString(),
					ArgumentMatchers.any());

			NguoiHoc result = daoSpy.findById(maNH);

			Assert.assertEquals(result, expected);
	}
	
	@Test
	public void selectByCourseTest() throws Exception{
		Integer maKH = 111;

		NguoiHoc nh = new NguoiHoc();
		List<NguoiHoc> expected = new ArrayList<>();
		expected.add(nh);
		
		PowerMockito.doReturn(expected).when(daoSpy, "select",
				ArgumentMatchers.anyString(),
				ArgumentMatchers.any());

		List<NguoiHoc> result = daoSpy.selectByCourse(maKH);

		Assert.assertEquals(result, expected);
	}
	
	@Test
	public void selectByCourseNotFoundTest() throws Exception{
		Integer maKH = 111;

		List<NguoiHoc> expected = new ArrayList<>();
		
		PowerMockito.doReturn(expected).when(daoSpy, "select",
				ArgumentMatchers.anyString(),
				ArgumentMatchers.any());

		List<NguoiHoc> result = daoSpy.selectByCourse(maKH);

		Assert.assertEquals(result, expected);
	}

	@Test
	public void selectByKeywordTest() throws Exception{
		String name = "dat";

		NguoiHoc nh = new NguoiHoc();
		List<NguoiHoc> expected = new ArrayList<>();
		expected.add(nh);

		PowerMockito.doReturn(expected).when(daoSpy, "select",
				ArgumentMatchers.anyString(),
				ArgumentMatchers.any());

		List<NguoiHoc> result = daoSpy.selectByKeyword(name);

		Assert.assertEquals(result, expected);
	}
	
	@Test
	public void selectByKeywordNotFoundTest() throws Exception{
		Integer maKH = 111;
		
		List<NguoiHoc> expected = new ArrayList<>();	
		PowerMockito.doReturn(expected).when(daoSpy, "select",
				ArgumentMatchers.anyString(),
				ArgumentMatchers.any());

		List<NguoiHoc> result = daoSpy.selectByCourse(maKH);

		Assert.assertEquals(result, expected);
	}
}
