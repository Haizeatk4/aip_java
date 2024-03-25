/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import API.qlnvAPI;
import Model.user;
import com.google.gson.Gson;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import static spark.Spark.*;
/**
 *
 * @author ADMIN
 */
public class Mavenproject1 {
    public static PreparedStatement ps;
    public static ResultSet rs;
    public static Statement st;
    
    public static void main(String[] args) {
        qlnvAPI qlnv = new qlnvAPI();
        get("/hello", (req, res) -> "Hello World Bảo");
        post("/login", ((rqst, rspns) -> {
            String acc = rqst.queryParams("account");
            String pass = rqst.queryParams("pass");
            user u = new user(acc,pass);
            rspns.type("application/json");
            return new Gson().toJson(u);
        }));
    }
}

