package testDAO;

import org.testng.annotations.Test;

import com.polypro.helper.JdbcHelper;
import com.polypro.dao.NhanVienDAO;
import com.polypro.model.NhanVien;

import java.util.ArrayList;
import java.util.List;

import org.mockito.ArgumentMatchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.Assert;
import org.testng.IObjectFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.ObjectFactory;

@PrepareForTest({ JdbcHelper.class, NhanVienDAO.class })
public class NhanVienDAOTest extends PowerMockTestCase{

	NhanVienDAO dao;
	NhanVienDAO daoSpy;

	@ObjectFactory
	public IObjectFactory getObjectFactory() {
		return new org.powermock.modules.testng.PowerMockObjectFactory();
	}

	@BeforeMethod
	public void beforeMethod() {
		dao = new NhanVienDAO();
		PowerMockito.mockStatic(JdbcHelper.class);
		daoSpy = PowerMockito.spy(new NhanVienDAO());
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
		NhanVien model = null;
		dao.insert(model);
	}

	@Test(expectedExceptions = Exception.class)
	public void insertWithEmptyModelTest() {
		NhanVien model = new NhanVien();
		dao.insert(model);
	}

	@Test
	public void insertWithValidModelTest() {
		NhanVien model = new NhanVien();
		model.setHoTen("Nguyen Van Muoi");
		model.setMaNV("NV010");
		model.setMatKhau("123");
		model.setVaiTro(false);
		dao.insert(model);
	}

	@Test
	public void selectTest() throws Exception{
			List<NhanVien> expecteds = new ArrayList<>();
			PowerMockito.doReturn(expecteds).when(daoSpy, "select", ArgumentMatchers.anyString(),
					ArgumentMatchers.any());
			List<NhanVien> actuals = daoSpy.select1();

			Assert.assertEquals(actuals, expecteds);
	}

	@Test(expectedExceptions = Exception.class)
	public void updateWithNullModelTest() {
		NhanVien model = null;
		dao.update(model);
	}

	@Test(expectedExceptions = Exception.class)
	public void updateWithEmptyModelTest() {
		NhanVien model = new NhanVien();
		dao.update(model);
	}

	@Test
	public void updateWithValidModelTest() {
		NhanVien model = new NhanVien();
		model.setHoTen("Nguyen Van Muoi");
		model.setMaNV("NV010");
		model.setMatKhau("123");
		model.setVaiTro(false);
		dao.update(model);
	}

	@Test
	public void findByIdWithValidModelTest() throws Exception{
			String maNv = "NV001";
			
			NhanVien expected = new NhanVien();
			List<NhanVien> resultList = new ArrayList<>();
			resultList.add(expected);

			PowerMockito.doReturn(resultList).when(daoSpy, "select",
					ArgumentMatchers.anyString(),
					ArgumentMatchers.any());

			NhanVien result = daoSpy.findById(maNv);
			
			System.out.println("--- ^^^ ++++ " + result);
			System.out.println("--- ^^^ ++++ " + expected);
			
			Assert.assertEquals(result, expected);			
	}
	
	@Test
	public void findByIdWithNotFoundTest() throws Exception{
			String maNv = "NV111";

			NhanVien expected = null;
			List<NhanVien> resultList = new ArrayList<>();

			PowerMockito.doReturn(resultList).when(daoSpy, "select",
					ArgumentMatchers.anyString(),
					ArgumentMatchers.any());

			NhanVien result = daoSpy.findById(maNv);

			Assert.assertEquals(result, expected);
	}
}
