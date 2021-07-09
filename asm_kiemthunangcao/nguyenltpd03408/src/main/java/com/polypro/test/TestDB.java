/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polypro.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class TestDB {
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String url = "jdbc:sqlserver://localhost:1433;Database=Poly_Pro";
    private static String user = "DBuser";
    private static String password = "12345";
    
    public static void main(String[] args) {
        select();
        insert();
        update();
        sp_ThongKeNguoiHoc();
    }

    public static void insert() {
        try {
            Class.forName(driver);
            Connection connec = DriverManager.getConnection(url, user, password);
            Statement st = connec.createStatement();
            String sql = "insert into NhanVien (MaNV, MatKhau, HoTen, VaiTro)" 
                    + "values ('admin', '55555', N'Trương Công Minh','1'), "
                    + "('hoangnv', '44444', N'Nguyễn Đình Hoàng', '0'),"
                    + "('khietnv', '33333', N'Nguyễn Trung Khiết', '0'),"
                    + "('linhdm', '88888', N'Đỗ Mỹ Linh', '0'),"
                    + "('huongnl', '99999', N'Nguyễn Lan Hương', '0')";
            st.executeUpdate(sql);
            connec.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void update() {
        try {
            Class.forName(driver);
            Connection connec = DriverManager.getConnection(url, user, password);
            Statement st = connec.createStatement();
            String sql = "update NhanVien set MatKhau='44444', HoTen=N'Nguyễn Long Hoàng', Vaitro=0 where MaNV='HoangNV'";
            st.executeUpdate(sql);
            connec.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void select() {
        try {
            Class.forName(driver);
            Connection connec = DriverManager.getConnection(url, user, password);
            Statement st = connec.createStatement();
            String sql = "select * from NhanVien";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                System.out.print(rs.getString("MaNV")+",");
                System.out.print(rs.getString("MatKhau")+",");
                System.out.print(rs.getString("HoTen")+",");
                System.out.println(rs.getString("VaiTro"));
            }
            connec.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void sp_ThongKeNguoiHoc() {
        try {
            Class.forName(driver);
            Connection connec = DriverManager.getConnection(url, user, password);
            String sql = "{call sp_ThongKeNguoiHoc(?,?,?,?)}";
            CallableStatement st = connec.prepareCall(sql);
            st.setString(1, "admin"); 
            st.setString(2, "12345678");
            st.setString(3, "Trương Công Minh");
            st.setString(4, "1");
            st.executeUpdate();
            connec.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    

}
