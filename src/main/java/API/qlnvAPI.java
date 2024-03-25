/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package API;

import Controller.NhanVienCtrl;
import Model.NhanVien;
import com.google.gson.Gson;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import static spark.Spark.get;
import static spark.Spark.post;

/**
 *
 * @author ADMIN
 */
public class qlnvAPI {
    
    public qlnvAPI() {
        get("/nhan_vien", (rqst,rspns) -> {
            NhanVienCtrl nv = new NhanVienCtrl();
            rspns.type("application/json");
            return new Gson().toJson(nv.createArr());
        });
        post("/nhan_vien/them", (rqst,rspns) -> {
            NhanVienCtrl nvCtrl = new NhanVienCtrl();
            NhanVien nv = new NhanVien();
            nv.setMaNhanVien(nvCtrl.taomaNhanVien());
            nv.setTenNhanVien(rqst.queryParams("TenNhanVien"));
            nv.setPassword(rqst.queryParams("Password"));
            nv.setPhone(rqst.queryParams("Phone"));
            nv.setEmail(rqst.queryParams("Email"));
            nv.setCMND(rqst.queryParams("CMND"));
            
            String d = rqst.queryParams("NgayLamViec");
            Date date = Date.valueOf(d);
            nv.setNgayLamViec(date);
            
            nv.setCaLamViec(rqst.queryParams("CaLamViec"));
            nv.setLuongCoBan(rqst.queryParams("LuongCoBan"));
            nv.setHeSoLuong(rqst.queryParams("HeSoLuong"));
            nv.setTienLuong(rqst.queryParams("TienLuong"));
            nvCtrl.InsertNhanVien(nv);
            rspns.type("application/json");
            return "{0}";
        });
        post("/nhan_vien/xoa", (rqst,rspns) -> {
            NhanVienCtrl nvCtrl = new NhanVienCtrl();
            String manv = rqst.queryParams("MaNhanVien");
            nvCtrl.DeleteKhachHang(manv);
            return nvCtrl.DeleteKhachHang(manv);
        });
        post("/nhan_vien/sua", (rqst,rspns) -> {
            NhanVienCtrl nvCtrl = new NhanVienCtrl();
            NhanVien nv = new NhanVien();
            nv.setMaNhanVien(rqst.queryParams("MaNhanVien"));
            nv.setTenNhanVien(rqst.queryParams("TenNhanVien"));
            nv.setPassword(rqst.queryParams("Password"));
            nv.setPhone(rqst.queryParams("Phone"));
            nv.setEmail(rqst.queryParams("Email"));
            nv.setCMND(rqst.queryParams("CMND"));
            
            String d = rqst.queryParams("NgayLamViec");
            Date date = Date.valueOf(d);
            nv.setNgayLamViec(date);
            
            nv.setCaLamViec(rqst.queryParams("CaLamViec"));
            nv.setLuongCoBan(rqst.queryParams("LuongCoBan"));
            nv.setHeSoLuong(rqst.queryParams("HeSoLuong"));
            nv.setTienLuong(rqst.queryParams("TienLuong"));
            nvCtrl.UpdateNhanVien(nv);
            rspns.type("application/json");
            return "{0}";
        });
    }
}
