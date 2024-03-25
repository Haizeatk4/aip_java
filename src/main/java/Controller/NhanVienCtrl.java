/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.NhanVien;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class NhanVienCtrl {
    //<editor-fold defaultstate="collapsed" desc="Var">
    public static PreparedStatement ps;
    public static ResultSet rs;
    public static Statement st;
    private ArrayList<NhanVien> arr = new ArrayList();
    //</editor-fold>
    public NhanVienCtrl(){}
    //<editor-fold defaultstate="collapsed" desc="Method">
    public ArrayList<NhanVien> createArr() throws SQLException{
        arr = new ArrayList<>();
        ps = connectDatabase.TaoKetNoi().prepareStatement("SELECT * FROM QLNhan_Vien");
        rs = ps.executeQuery();
        while(rs.next()){
           NhanVien tmp = new NhanVien();
           
           tmp.setMaNhanVien(rs.getString("MaNhanVien"));
           tmp.setTenNhanVien(rs.getString("TenNhanVien"));
           tmp.setPassword(rs.getString("Password"));
           tmp.setPhone(rs.getString("Phone"));
           tmp.setEmail(rs.getString("Email"));
           tmp.setCMND(rs.getString("CMND"));
           tmp.setNgayLamViec(rs.getDate("NgayLamViec"));
           tmp.setCaLamViec(rs.getString("CaLamViec"));
           tmp.setLuongCoBan(rs.getString("LuongCoBan"));
           tmp.setHeSoLuong(rs.getString("HeSoLuong"));
           tmp.setTienLuong(rs.getString("TienLuong"));
           
           arr.add(tmp);
        }
        return arr;
    }
    public boolean dangNhap(String taiKhoan, String pass) throws SQLException {
        boolean kt = false;
        try {
            ps = connectDatabase.TaoKetNoi().prepareStatement("SELECT * FROM QLNhan_Vien where MaNhanVien = ? and Password=?");
            ps.setString(1, taiKhoan);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                kt = true;
                ps.close();
            }
        } catch (Exception e) {
            return kt = false;
        }
        return kt;

    }

    public static ResultSet showTextfield(String sql) {
        try {
            ps = connectDatabase.TaoKetNoi().prepareStatement(sql);
            return ps.executeQuery();
        } catch (Exception e) {
            return null;
        }
    }

    public void InsertNhanVien(NhanVien nv) {
        String sql = "INSERT INTO QLNhan_Vien VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = connectDatabase.TaoKetNoi().prepareStatement(sql);
            ps.setString(1, nv.getMaNhanVien());
            ps.setString(2, nv.getTenNhanVien());
            ps.setString(3, nv.getPassword());
            ps.setString(4, nv.getPhone());
            ps.setString(5, nv.getEmail());
            ps.setString(6, nv.getCMND());
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String strDate = dateFormat.format(nv.getNgayLamViec());
            ps.setString(7, strDate);
            ps.setString(8, nv.getCaLamViec());
            ps.setString(9, nv.getLuongCoBan());
            ps.setString(10, nv.getHeSoLuong());
            ps.setString(11, nv.getTienLuong());
            ps.execute();
            
            ps.close();
        } catch (HeadlessException | SQLException e) {
            e.printStackTrace();
        }

    }

    public static boolean UpdateNhanVien(NhanVien nv) {
        try {
            ps = connectDatabase.TaoKetNoi().prepareStatement("UPDATE QLNhan_Vien SET TenNhanVien = ?,"
                    + "Phone = ?,Email=?,CMND=?,NgayLamViec=?,CaLamViec=?,LuongCoBan=? where MaNhanVien = ?");
            ps.setString(1, nv.getMaNhanVien());
            ps.setString(2, nv.getTenNhanVien());
            ps.setString(3, nv.getPassword());
            ps.setString(4, nv.getPhone());
            ps.setString(5, nv.getEmail());
            ps.setString(6, nv.getCMND());
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String strDate = dateFormat.format(nv.getNgayLamViec());
            ps.setString(7, strDate);
            ps.setString(8, nv.getCaLamViec());
            ps.setString(9, nv.getLuongCoBan());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean DeleteKhachHang(String MaNhanVien) {
        try {
            ps = connectDatabase.TaoKetNoi().prepareStatement("DELETE FROM QlNhan_Vien WHERE MaNhanVien = ?");
            ps.setString(1, MaNhanVien);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String taomaNhanVien() throws SQLException, ClassNotFoundException {
        Connection conn;
        Statement stmt;
        conn = connectDatabase.TaoKetNoi();
        String sql = "SELECT MaNhanVien FROM QLNhan_Vien order by MaNhanVien Desc";
        stmt = conn.createStatement();
        String manv;
        rs = stmt.executeQuery(sql);
        rs.next();
        manv = rs.getString("MaNhanVien").trim();
        stmt.close();
        conn.close();

        if ((Integer.valueOf(manv.substring(3)) + 1) < 10) {
            manv = "NV00" + (Integer.valueOf(manv.substring(3)) + 1);
        } else if (((Integer.valueOf(manv.substring(3)) + 1) >= 10) && ((Integer.valueOf(manv.substring(3)) + 1) < 100)) {
            manv = "NV0" + (Integer.valueOf(manv.substring(3)) + 1);
        } else {
            manv = "NV" + (Integer.valueOf(manv.substring(3)) + 1);
        }
        return manv;
    }

    public static boolean checkcmnd(String cmnd) throws ClassNotFoundException, SQLException {
        Connection con = null;
        boolean check = false;
        con = connectDatabase.TaoKetNoi();

        try {
            String SQL = "SELECT CMND FROM QLNhan_Vien Where CMND = ? ";
            PreparedStatement pre = con.prepareStatement(SQL);
            pre.setString(1, cmnd);
            try (ResultSet rs = pre.executeQuery()) {
                if (rs.next()) {
                    rs.close();
                    pre.close();
                    con.close();
                    check = true;
                } else {
                    rs.close();
                    pre.close();
                    con.close();
                    check = false;

                }
            }
        } catch (Exception e) {
            System.out.println("Error Trace: " + e.getMessage());
            e.printStackTrace();
        }

        return check;

    }

    public static boolean checkmail1(String mail) throws ClassNotFoundException, SQLException {
        Connection con = null;

        con = connectDatabase.TaoKetNoi();
        boolean check = false;
        try {
            String SQL = "SELECT Email FROM QLNhan_Vien Where Email = ? ";

            PreparedStatement pre = con.prepareStatement(SQL);
            pre.setString(1, mail);
            try (ResultSet rs = pre.executeQuery()) {
                if (rs.next()) {
                    rs.close();
                    pre.close();
                    con.close();
                    check = true;
                } else {
                    rs.close();
                    pre.close();
                    con.close();
                    check = false;
                }
            }
        } catch (Exception e) {
            System.out.println("Error Trace: " + e.getMessage());
            e.printStackTrace();
        }

        return check;
    }
    //</editor-fold>
}
