package com.polypro.test;

import com.polypro.helper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJDBCHelper {

    public static void main(String[] args) throws SQLException {
        System.out.println("-----Thêm mới người học-----");
        insert();
        System.out.println("-----Update người học theo mã-----");
        update();
        System.out.println("-----Xóa người học theo mã-----");
        delete();
        System.out.println("-----Truy vấn người học theo mã-----");
        selectMaNH();
        System.out.println("-----Truy vấn tất cả người học-----");
        selectAllNguoiHoc();
        System.out.println("------------------------------------");

    }

    public static void insert() throws SQLException {
        String sql = "insert into NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai,Email, GhiChu, MaNV, NgayDangKy) "
                + "values (?,?,?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql, "NH01", "Trương Công Minh", "2000/09/04", true, "0935542810", "minh@gmail.com", null, "admin", "02/10/2019");
        JdbcHelper.executeUpdate(sql, "NH02", "Nguyễn Đình Hoàng", "1999/09/04", true, "0935542812", "hoang@gmail.com", null, "hoangnv", "02/10/2019");
        JdbcHelper.executeUpdate(sql, "NH03", "Nguyễn Lan Hương", "2001/05/08", false, "0935542813", "huong@gmail.com", null, "huongnl", "02/10/2019");
        JdbcHelper.executeUpdate(sql, "NH04", "Nguyễn Trung Khiết", "1998/12/11", true, "0935542814", "khiet@gmail.com", null, "khietnv", "02/10/2019");
        JdbcHelper.executeUpdate(sql, "NH05", "Đỗ Mỹ Linh", "2000/10/15", false, "0935542815", "linh@gmail.com", null, "linhdm", "02/10/2019");
        System.out.println("Complete insert");
    }

    public static void update() throws SQLException {
        String sql = "update NguoiHoc set HoTen=?, NgaySinh=?, GioiTinh=?, DienThoai=?,Email=?, GhiChu=?, MaNV=?, NgayDangKy=? where MaNH='NH05'";
        JdbcHelper.executeUpdate(sql, "Đỗ Mỹ Linh", "2000/10/14", false, "0905216677", "mylinhdo1410@gmail.com", null, "linhdm", "02/10/2019");
        System.out.println("Complete update");
    }

    public static void delete() throws SQLException {
        String sql = "delete from NguoiHoc where MaNH=? ";
        JdbcHelper.executeUpdate(sql, "NH05");
        System.out.println("Complete delete");
    }

    public static void selectMaNH() throws SQLException {
        ResultSet rs = JdbcHelper.executeQuery("select * from NguoiHoc where MaNH='NH01'");
        while (rs.next()) {
            System.out.println(rs.getString(1) + " , " + rs.getString(2) + " , " + rs.getString(3) + " , " + rs.getString(4) + " , " + rs.getString(5) + " , " + rs.getString(6) + " , " + rs.getString(7) + " , " + rs.getString(8) + " , " + rs.getString(9));
        }
        rs.close();
    }

    public static void selectAllNguoiHoc() throws SQLException {
        ResultSet rs = JdbcHelper.executeQuery("select * from NguoiHoc");
        while (rs.next()) {
            System.out.println(rs.getString(1) + " , " + rs.getString(2) + " , " + rs.getString(3) + " , " + rs.getString(4) + " , " + rs.getString(5) + " , " + rs.getString(6) + " , " + rs.getString(7) + " , " + rs.getString(8) + " , " + rs.getString(9));
        }
        rs.close();
    }


}
