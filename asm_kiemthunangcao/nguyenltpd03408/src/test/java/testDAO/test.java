package testDAO;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.testng.PowerMockTestCase;

import com.mockrunner.mock.jdbc.MockConnection;
import com.mockrunner.mock.jdbc.MockResultSet;
import com.mockrunner.mock.jdbc.MockStatement;

import com.polypro.helper.JdbcHelper;
import com.polypro.dao.ThongKeDAO;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ JdbcHelper.class, ThongKeDAO.class })
public class test extends PowerMockTestCase{
	
	ThongKeDAO daoSpy;
	ThongKeDAO tkDAO;

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

		connect = PowerMockito.mock(MockConnection.class);
		statement = PowerMockito.mock(MockStatement.class);
		rs = PowerMockito.mock(MockResultSet.class);
	}
	
//	@Test
//	public void testt() {
//		System.out.println("----" + dao.findById("CD001"));
//		System.out.println("----" + dao.select1());
//		System.out.println("----" + tkDAO.getNguoiHoc().size());
//	}
	
	@Test
	public void getNguoiHocTest() throws Exception{
			
		rs = initMockResultTest();
		
		PowerMockito.when(JdbcHelper.executeQuery(ArgumentMatchers.anyString()))
			.thenReturn(rs);	
		
		PowerMockito.when(rs.getStatement()).thenReturn(statement);
		
		PowerMockito.when(statement.getConnection()).thenReturn(connect);
		
		int result = daoSpy.getNguoiHoc().size();
		
		System.out.println("-------" + daoSpy.getNguoiHoc());
		
		Assert.assertEquals(1, result);
	}
	
	@Test
	public void getNguoiHocWithMultipleDataTest() throws Exception{
		rs = initMultipleDataMockResultSet();
		
		PowerMockito.when(JdbcHelper.executeQuery(ArgumentMatchers.anyString()))
			.thenReturn(rs);	
		
		PowerMockito.when(rs.getStatement()).thenReturn(statement);
		
		PowerMockito.when(statement.getConnection()).thenReturn(connect);
		
		int result = daoSpy.getNguoiHoc().size();
		
		Assert.assertEquals(3, result);
	}
	
	private MockResultSet initMockResultTest() throws Exception {
		rs.addColumn("Nam", new Integer[] {2018});
		rs.addColumn("SoLuong", new Integer[] {10});
		rs.addColumn("DauTien", new java.sql.Date[] {
				new java.sql.Date(new java.util.Date().getTime())
		});
		rs.addColumn("CuoiCung", new java.sql.Date[] {
				new java.sql.Date(new java.util.Date().getTime())
		});
		rs.beforeFirst();

		return rs;
	}
	
	private MockResultSet initMultipleDataMockResultSet() throws Exception {
		rs.addColumn("Nam", new Integer[] {2018, 2019, 2020});
		rs.addColumn("SoLuong", new Integer[] {10, 10, 17});
		rs.addColumn("DauTien", new java.sql.Date[] {
				new java.sql.Date(new java.util.Date().getTime()),
				new java.sql.Date(new java.util.Date().getTime()),
				new java.sql.Date(new java.util.Date().getTime())
		});
		rs.addColumn("CuoiCung", new java.sql.Date[] {
				new java.sql.Date(new java.util.Date().getTime()),
				new java.sql.Date(new java.util.Date().getTime()),
				new java.sql.Date(new java.util.Date().getTime())
		});
		rs.beforeFirst();
		return rs;
	}
}
