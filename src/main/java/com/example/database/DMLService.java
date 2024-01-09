package com.example.database;

import com.example.constant.Constant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.example.crud.Create.DATEFORMAT;
import static com.example.database.DBConnection.closeConnection;
import static com.example.database.DBConnection.conn;

public class DMLService {
    static final String ITEM_INSERT = "insert into karrotItem (seller, price, itemName, dateTime) " + "values (?,?,?,?) ";
    static final String ITEM_DELETE = "delete from karrotItem where id = ? ";
    static final String ITEM_UPDATE = "update karrotItem set seller = ?, price = ?, itemName = ?, dateTime = ?";
    ;

    static Connection conn;
    static PreparedStatement pstmt;
    public DMLService(Connection conn) {
        this.conn = conn;
    }

    public static void addToItemList(String seller, String itemName, int price) {
        int checker;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATEFORMAT);
        String formattedDateTime = LocalDateTime.now().format(formatter);
        try {
            pstmt = conn.prepareStatement(ITEM_INSERT);
            pstmt.setString(1, seller);
            pstmt.setInt(2, price);
            pstmt.setString(3, itemName);
            pstmt.setString(4, formattedDateTime);

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
    }

    public static int delete(int id) {
        int checker;
        try {
            pstmt = conn.prepareStatement(ITEM_DELETE);
            pstmt.setInt(1,id);
            checker = pstmt.executeUpdate();
            if(checker > Constant.ZERO) {
                System.out.println("삭제 성공!");
            }
            else{
                System.out.println("삭제 실패!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return checker;
    }

    public static void editToInput(String seller, String itemName, int price) {
        int checker;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATEFORMAT);
        String formattedDateTime = LocalDateTime.now().format(formatter);
        try {
            pstmt = conn.prepareStatement(ITEM_UPDATE);
            pstmt.setString(1, seller);
            pstmt.setInt(2, price);
            pstmt.setString(3, itemName);
            pstmt.setString(4, formattedDateTime);

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
    }
}
