package com.example.database;

import com.example.constant.Constant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.example.crud.Create.DATEFORMAT;
import static com.example.database.DBConnection.closeConnection;


public class DMLService {
    static final String ITEM_INSERT = "insert into karrotItem (seller, price, itemName, dateTime) " + "values (?,?,?,?) ";
    static final String ITEM_DELETE = "delete from karrotItem where id = ? ";
    static final String ITEM_UPDATE = "UPDATE karrotItem SET seller = ?, price = ?, itemName = ?, dateTime = ? WHERE id = ?";

    static PreparedStatement pstmt;
    public static void addToItemList(String seller, String itemName, int price) {
        int checker;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATEFORMAT);
        String formattedDateTime = LocalDateTime.now().format(formatter);
        try(Connection conn = DBConnection.getConnection()){
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
        try(Connection conn = DBConnection.getConnection()) {
            pstmt = conn.prepareStatement(ITEM_DELETE);
            pstmt.setInt(1,id);
            checker = pstmt.executeUpdate();
            if(checker > Constant.ZERO) {
                System.out.println("삭제 성공!");
            }
            else{
                System.out.println("삭제 실패!");
            }
            closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return checker;
    }

    public static void editToInput(String seller, String itemName, int price, int indexForEdit) {
        int checker;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATEFORMAT);
        String formattedDateTime = LocalDateTime.now().format(formatter);
        try(Connection conn = DBConnection.getConnection()) {
            pstmt = conn.prepareStatement(ITEM_UPDATE);
            pstmt.setString(1, seller);
            pstmt.setInt(2, price);
            pstmt.setString(3, itemName);
            pstmt.setString(4, formattedDateTime);
            pstmt.setInt(5,indexForEdit);

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
