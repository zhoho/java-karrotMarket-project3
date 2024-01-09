package com.example.crud;

import com.example.Item;
import com.example.constant.Constant;
import com.example.database.DBConnection;
import com.example.view.InputView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.example.database.DBConnection.closeConnection;
import static com.example.database.DBConnection.conn;

public class Create {
    static final String ITEM_INSERT = "insert into karrotItem (id, seller, price, itemName, dateTime) " + "values (?,?,?,?,?) ";
    public static final String DATEFORMAT = "M월 d일 HH시 mm분";
    public static void addItem() {
        InputView.getItemInfo();
    }

    public static void addToItemList(int id, String seller, String itemName, int price) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt;
        int checker = Constant.ZERO;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATEFORMAT);
        String formattedDateTime = LocalDateTime.now().format(formatter);
//        Item newitem = new Item(id, seller, itemName, price, formattedDateTime);
        try {
            pstmt = conn.prepareStatement(ITEM_INSERT);
            pstmt.setInt(1, id);
            pstmt.setString(2, seller);
            pstmt.setInt(3, price);
            pstmt.setString(4, itemName);
            pstmt.setString(5, formattedDateTime);

            checker = pstmt.executeUpdate();
            if(checker > 0) {
                System.out.println("성공!");
            }
            else{
                System.out.println("실패!");
            }
            closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        Item.items.add(newitem);
    }
}