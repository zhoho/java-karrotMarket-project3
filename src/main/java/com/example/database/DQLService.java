package com.example.database;

import com.example.Item;

import java.sql.*;

import static com.example.Item.items;

public class DQLService {
    static final String SELECT_ALL = "select * from karrotItem ";
    static final String SELECT_INCLUDE_NAME = "SELECT * FROM karrotItem WHERE itemName LIKE '%' || ? || '%' ORDER BY id";


    public static void getAllData() {
        items.clear();
        try(Connection conn = DBConnection.getConnection()) {
            PreparedStatement pstmt;
            pstmt = conn.prepareStatement(SELECT_ALL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String seller = rs.getString("seller");
                String itemName = rs.getString("itemName");
                int price = rs.getInt("price");
                String dateTime = rs.getString("dateTime");
                items.add(new Item(id, seller,itemName,price,dateTime));
            }
        } catch (SQLException e) {
            throw new RuntimeException("getAllData error");
        }
    }

    public static void getDataIncludeItemName(String inputItemName) {
        items.clear();
        try (Connection conn = DBConnection.getConnection()){
            PreparedStatement pstmt;
            pstmt = conn.prepareStatement(SELECT_INCLUDE_NAME);
            pstmt.setString(1, inputItemName);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String seller = rs.getString("seller");
                String itemName = rs.getString("itemName");
                int price = rs.getInt("price");
                String dateTime = rs.getString("dateTime");
                items.add(new Item(id, seller,itemName,price,dateTime));
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
     }
    }
