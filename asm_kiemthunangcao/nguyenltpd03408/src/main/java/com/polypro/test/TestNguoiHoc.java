/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polypro.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestNguoiHoc {

    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String url = "jdbc:sqlserver://localhost:1433;Database=Poly_Pro";
    private static String user = "DBuser";
    private static String password = "12345";

    public static void main(String[] args) {
    }

    public static void insert() {
        try {
            Class.forName(driver);
            Connection connec = DriverManager.getConnection(url, user, password);
            Statement st = connec.createStatement();
            String sql = "INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV)";
            st.executeUpdate(sql);
            connec.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
