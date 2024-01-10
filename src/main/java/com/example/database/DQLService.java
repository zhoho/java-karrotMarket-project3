package com.example.database;

import com.example.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.Item.items;

public class DQLService {
    static final String SELECT_ALL = "select * from karrotItem ";
    static PreparedStatement pstmt;

    public static void getAllData() {
        items.clear();
        try(Connection conn = DBConnection.getConnection()) {
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

}
