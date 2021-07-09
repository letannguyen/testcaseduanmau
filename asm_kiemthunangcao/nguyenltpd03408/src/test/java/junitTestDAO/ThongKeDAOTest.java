package junitTestDAO;

import com.mockrunner.mock.jdbc.MockConnection;
import com.mockrunner.mock.jdbc.MockResultSet;
import com.mockrunner.mock.jdbc.MockStatement;

import com.polypro.helper.JdbcHelper;
import com.polypro.dao.ThongKeDAO;

import java.util.ArrayList;
import java.util.List;

import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ JdbcHelper.class, ThongKeDAO.class })
public class ThongKeDAOTest{

	ThongKeDAO daoSpy;

	@Mock
	MockConnection connect;
	@Mock
	MockStatement statement;
	@Spy
	@InjectMocks
	MockResultSet rs = new MockResultSet("myMock");

	@Before
	public void beforeMethod() {
		PowerMockito.mockStatic(JdbcHelper.class);
		daoSpy = PowerMockito.spy(new ThongKeDAO());

	}

	@After
	public void afterMethod() {
		rs = new MockResultSet("myMock");
	}

	@Test
	public void getBangDiemTest() throws Exception{
		rs = initBangDiemMockResultTest();

		PowerMockito.when(JdbcHelper.executeQuery(ArgumentMatchers.anyString(),
				ArgumentMatchers.anyString()))
				.thenReturn(rs);

		PowerMockito.when(rs.getStatement()).thenReturn(statement);

		PowerMockito.when(statement.getConnection()).thenReturn(connect);

		int result = daoSpy.getBangDiem(11).size();
		System.out.println("-----" + result);
		Assert.assertEquals(result, 1);
	}
	
	@Test
	public void getBangDiemMultipleDataTest() throws Exception{
		rs = initBangDiemMultipleDataMockResultSet();

		PowerMockito.when(JdbcHelper.executeQuery(ArgumentMatchers.anyString(),
				ArgumentMatchers.anyString()))
				.thenReturn(rs);

		PowerMockito.when(rs.getStatement()).thenReturn(statement);

		PowerMockito.when(statement.getConnection()).thenReturn(connect);

		List<Integer> listResult = new ArrayList<>();
		
		int result = daoSpy.getBangDiem(11).size();
		int result1 = daoSpy.getBangDiem(11).size();
		int result2 = daoSpy.getBangDiem(11).size();

		listResult.add(result);
		listResult.add(result2);
		listResult.add(result1);
		System.out.println("-----" + listResult.size());
		Assert.assertEquals(listResult.size(), 3);
	}

	@Test
	public void getDiemTheoChuyenDeTest() throws Exception {
		rs = initDiemMockResultTest();

		PowerMockito.when(JdbcHelper.executeQuery(ArgumentMatchers.anyString())).thenReturn(rs);

		PowerMockito.when(rs.getStatement()).thenReturn(statement);

		PowerMockito.when(statement.getConnection()).thenReturn(connect);

		int result = daoSpy.getDiemTheoChuyenDe().size();
		System.out.println("-----" + result);
		Assert.assertEquals(result, 1);
	}

	@Test
	public void getDiemTheoChuyenDeWithMultipleDataTest() throws Exception {
		rs = initDiemMultipleDataMockResultSet();

		PowerMockito.when(JdbcHelper.executeQuery(ArgumentMatchers.anyString())).thenReturn(rs);

		PowerMockito.when(rs.getStatement()).thenReturn(statement);

		PowerMockito.when(statement.getConnection()).thenReturn(connect);

		int result = daoSpy.getDiemTheoChuyenDe().size();
		System.out.println("-----" + result);
		Assert.assertEquals(result, 3);
	}

	@Test
	public void getDoanhThuTest() throws Exception {
		rs = initDtMockResultTest();

		PowerMockito.when(JdbcHelper.executeQuery(ArgumentMatchers.anyString(), ArgumentMatchers.anyInt()))
				.thenReturn(rs);

		PowerMockito.when(rs.getStatement()).thenReturn(statement);

		PowerMockito.when(statement.getConnection()).thenReturn(connect);

		int result = daoSpy.getDoanhThu(2019).size();
		System.out.println("-----" + result);
		Assert.assertEquals(result, 1);
	}

	@Test
	public void getDoanhThuWithMultipleDataTest() throws Exception {
		rs = initDtMultipleDataMockResultSet();

		PowerMockito.when(JdbcHelper.executeQuery(ArgumentMatchers.anyString(), ArgumentMatchers.anyInt()))
				.thenReturn(rs);

		PowerMockito.when(rs.getStatement()).thenReturn(statement);

		PowerMockito.when(statement.getConnection()).thenReturn(connect);

		List<Integer> listResult = new ArrayList<>();

		int result = daoSpy.getDoanhThu(2019).size();
		int result1 = daoSpy.getDoanhThu(2018).size();
		int result2 = daoSpy.getDoanhThu(2020).size();

		listResult.add(result);
		listResult.add(result2);
		listResult.add(result1);
		System.out.println("-----" + listResult.size());
		Assert.assertEquals(listResult.size(), 3);
	}

	@Test
	public void getNguoiHocTest() throws Exception {

		rs = initNhMockResultTest();

		PowerMockito.when(JdbcHelper.executeQuery(ArgumentMatchers.anyString())).thenReturn(rs);

		PowerMockito.when(rs.getStatement()).thenReturn(statement);

		PowerMockito.when(statement.getConnection()).thenReturn(connect);

		int result = daoSpy.getNguoiHoc().size();
		System.out.println("-----" + result);
		Assert.assertEquals(result, 1);
	}

	@Test
	public void getNguoiHocWithMultipleDataTest() throws Exception {
		rs = initNhMultipleDataMockResultSet();

		PowerMockito.when(JdbcHelper.executeQuery(ArgumentMatchers.anyString())).thenReturn(rs);

		PowerMockito.when(rs.getStatement()).thenReturn(statement);

		PowerMockito.when(statement.getConnection()).thenReturn(connect);

		int result = daoSpy.getNguoiHoc().size();

		System.out.println("-----" + result);

		Assert.assertEquals(result, 3);
	}

	private MockResultSet initNhMockResultTest() throws Exception {
		rs.addColumn("Nam", new Integer[] { 2018 });
		rs.addColumn("SoLuong", new Integer[] { 10 });
		rs.addColumn("DauTien", new java.sql.Date[] { new java.sql.Date(new java.util.Date().getTime()) });
		rs.addColumn("CuoiCung", new java.sql.Date[] { new java.sql.Date(new java.util.Date().getTime()) });
		rs.beforeFirst();
		return rs;
	}

	private MockResultSet initNhMultipleDataMockResultSet() throws Exception {
		rs.addColumn("Nam", new Integer[] { 2018, 2019, 2020 });
		rs.addColumn("SoLuong", new Integer[] { 10, 10, 17 });
		rs.addColumn("DauTien", new java.sql.Date[] { new java.sql.Date(new java.util.Date().getTime()),
				new java.sql.Date(new java.util.Date().getTime()), new java.sql.Date(new java.util.Date().getTime()) });
		rs.addColumn("CuoiCung", new java.sql.Date[] { new java.sql.Date(new java.util.Date().getTime()),
				new java.sql.Date(new java.util.Date().getTime()), new java.sql.Date(new java.util.Date().getTime()) });
		rs.beforeFirst();
		return rs;
	}

	private MockResultSet initDiemMockResultTest() throws Exception {
		rs.addColumn("ChuyenDe", new String[] { "Java 1" });
		rs.addColumn("SoHV", new Integer[] { 10 });
		rs.addColumn("ThapNhat", new Double[] { 5.0 });
		rs.addColumn("CaoNhat", new Double[] { 10.0 });
		rs.addColumn("TrungBinh", new Double[] { 8.0 });
		rs.beforeFirst();
		return rs;
	}

	private MockResultSet initDiemMultipleDataMockResultSet() throws Exception {
		rs.addColumn("ChuyenDe", new String[] { "Java 1", "SQL", "Angular" });
		rs.addColumn("SoHV", new Integer[] { 10, 13, 15 });
		rs.addColumn("ThapNhat", new Double[] { 5.0, 6.0, 7.0 });
		rs.addColumn("CaoNhat", new Double[] { 10.0, 8.0, 9.0 });
		rs.addColumn("TrungBinh", new Double[] { 7.5, 7.0, 8.0 });
		rs.beforeFirst();
		return rs;
	}

	private MockResultSet initDtMockResultTest() throws Exception {
		rs.addColumn("ChuyenDe", new String[] { "Java 1" });
		rs.addColumn("SoKH", new Integer[] { 1 });
		rs.addColumn("SoHV", new Integer[] { 10 });
		rs.addColumn("DoanhThu", new Double[] { 900000.0 });
		rs.addColumn("ThapNhat", new Double[] { 300000.0 });
		rs.addColumn("CaoNhat", new Double[] { 300000.0 });
		rs.addColumn("TrungBinh", new Double[] { 300000.0 });
		rs.beforeFirst();
		return rs;
	}

	private MockResultSet initDtMultipleDataMockResultSet() throws Exception {
		rs.addColumn("ChuyenDe", new String[] { "Java 1", "SQL", "Angular" });
		rs.addColumn("SoKH", new Integer[] { 1, 3, 5 });
		rs.addColumn("SoHV", new Integer[] { 3, 10, 10 });
		rs.addColumn("DoanhThu", new Double[] { 900000.0, 2000000.0, 3000000.0 });
		rs.addColumn("ThapNhat", new Double[] { 300000.0, 300000.0, 300000.0 });
		rs.addColumn("CaoNhat", new Double[] { 300000.0, 500000.0, 500000.0 });
		rs.addColumn("TrungBinh", new Double[] { 300000.0, 200000.0, 300000.0 });
		rs.beforeFirst();
		return rs;
	}

	private MockResultSet initBangDiemMockResultTest() throws Exception {
		rs.addColumn("maNguoiHoc", new String[] { "NH001" });
		rs.addColumn("hoVaTen", new String[] { "Nguyen Thi Mam" });
		rs.addColumn("diemTrungBinh", new Double[] { 10.0 });
		rs.addColumn("xepLoai", new String[] { "Xuat Sac" });
		rs.beforeFirst();
		return rs;
	}

	private MockResultSet initBangDiemMultipleDataMockResultSet() throws Exception {
		rs.addColumn("maNguoiHoc", new String[] { "NH001", "NH002", "NH003" });
		rs.addColumn("hoVaTen", new String[] { "Nguyen Thi Mam", "Nguyen Thi Muoi", "Nguyen Van Teo" });
		rs.addColumn("diemTrungBinh", new Double[] { 10.0, 5.0, 7.0 });
		rs.addColumn("xepLoai", new String[] { "Xuat Sac", "TrungBinh", "Kha" });
		rs.beforeFirst();
		return rs;
	}
}
