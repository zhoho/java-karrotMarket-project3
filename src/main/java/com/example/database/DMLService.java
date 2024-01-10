package com.example.database;

import com.example.constant.Constant;
import com.example.view.OutputView;

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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATEFORMAT);
        String formattedDateTime = LocalDateTime.now().format(formatter);
        try(Connection conn = DBConnection.getConnection()){
            pstmt = conn.prepareStatement(ITEM_INSERT);
            pstmt.setString(Constant.ONE, seller);
            pstmt.setInt(Constant.TWO, price);
            pstmt.setString(Constant.THREE, itemName);
            pstmt.setString(Constant.FOUR, formattedDateTime);
            OutputView.dbAddExecutionCheck(pstmt.executeUpdate());
            closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int delete(int id) {
        int checker;
        try(Connection conn = DBConnection.getConnection()) {
            pstmt = conn.prepareStatement(ITEM_DELETE);
            pstmt.setInt(Constant.ONE,id);
            checker = pstmt.executeUpdate();
            OutputView.dbDeleteExecutionCheck(checker);
            closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return checker;
    }

    public static void editToInput(String seller, String itemName, int price, int indexForEdit) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATEFORMAT);
        String formattedDateTime = LocalDateTime.now().format(formatter);
        try(Connection conn = DBConnection.getConnection()) {
            pstmt = conn.prepareStatement(ITEM_UPDATE);
            pstmt.setString(Constant.ONE, seller);
            pstmt.setInt(Constant.TWO, price);
            pstmt.setString(Constant.THREE, itemName);
            pstmt.setString(Constant.FOUR, formattedDateTime);
            pstmt.setInt(Constant.FIVE,indexForEdit);
            OutputView.dbEditExecutionCheck(pstmt.executeUpdate());
            closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
