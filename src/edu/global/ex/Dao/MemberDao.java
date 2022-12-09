package edu.global.ex.Dao;

import edu.global.ex.Dto.MemberDto;
import edu.global.ex.Dto.SalesDto;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {

    private DataSource dataSource = null;

    public MemberDao() {

        try {
            Context context = new InitialContext();
            dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<MemberDto> list() {

        System.out.println("list() ..");

        List<MemberDto> dtoList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();
            String query = "SELECT CUSTNO, CUSTNAME, PHONE, ADDRESS, JOINDATE, CITY," +
                    "CASE GRADE " +
                    "WHEN 'A' THEN 'VIP'" +
                    "WHEN 'B' THEN '일반'" +
                    "WHEN 'C' THEN '직원'" +
                    "END AS GRADE FROM MEMBER_TBL_02 ORDER BY CUSTNO ASC";

            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                int custNo = resultSet.getInt("custNo");
                String custName = resultSet.getString("custName");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                Date joinDate = resultSet.getDate("joinDate");
                String city = resultSet.getString("city");
                String grade = resultSet.getString("grade");

                MemberDto memberDto = new MemberDto(custNo, custName, phone, address, joinDate, grade, city);
                dtoList.add(memberDto);
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                if(resultSet != null) resultSet.close();
                if(preparedStatement != null) preparedStatement.close();
                if(connection != null) connection.close();
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return dtoList;
    }

    public String max_custNo() {

        System.out.println("max_custNo() ..");

        String custNo = null;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();
            String query = "SELECT MAX(CUSTNO) + 1 AS CUSTNO FROM MEMBER_TBL_02";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) custNo = resultSet.getString("custNo");
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                if(resultSet != null) resultSet.close();
                if(preparedStatement != null) preparedStatement.close();
                if(connection != null) connection.close();
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return custNo;
    }

    public void insert(String custNo, String custName, String phone,
                       String address, String joinDate, String grade, String city) {

        System.out.println("insert() ..");

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = dataSource.getConnection();
            String query = "INSERT INTO member_tbl_02 (CUSTNO, CUSTNAME, PHONE, ADDRESS, JOINDATE, GRADE, CITY) " +
                    "VALUES (?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(custNo));
            preparedStatement.setString(2,custName);
            preparedStatement.setString(3,phone);
            preparedStatement.setString(4,address);
            preparedStatement.setString(5,joinDate);
            preparedStatement.setString(6,grade);
            preparedStatement.setString(7,city);

            int insert = preparedStatement.executeUpdate();
            System.out.println("업데이트 갯수 : " + insert);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                if(preparedStatement != null) preparedStatement.close();
                if(connection != null) connection.close();
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<SalesDto> sales() {

        System.out.println("sales() ..");

        List<SalesDto> dtoList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();
            String query = "SELECT DISTINCT MEMBER_TBL_02.CUSTNO, MEMBER_TBL_02.CUSTNAME, CASE GRADE\n" +
                    "    WHEN 'A' THEN 'VIP'\n" +
                    "    WHEN 'B' THEN '일반'\n" +
                    "    WHEN 'C' THEN '직원'\n" +
                    "    END AS GRADE, PRICE.SALES\n" +
                    "FROM MEMBER_TBL_02,MONEY_TBL_02 ,(SELECT CUSTNO,SUM(PRICE) AS SALES FROM MONEY_TBL_02 GROUP BY CUSTNO) PRICE\n" +
                    "WHERE MEMBER_TBL_02.CUSTNO = MONEY_TBL_02.CUSTNO AND MEMBER_TBL_02.CUSTNO = PRICE.CUSTNO " +
                    "ORDER BY PRICE.SALES DESC";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int custNo = resultSet.getInt("custNo");
                String custName = resultSet.getString("custName");
                String grade = resultSet.getString("grade");
                int sales = resultSet.getInt("sales");

                SalesDto salesDto = new SalesDto(custNo, custName, grade, sales);
                dtoList.add(salesDto);
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                if(resultSet != null) resultSet.close();
                if(preparedStatement != null) preparedStatement.close();
                if(connection != null) connection.close();
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return dtoList;
    }

    public MemberDto content(String custNo) {

        MemberDto dto = null;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();
            String query = "SELECT * FROM MEMBER_TBL_02 WHERE CUSTNO = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(custNo));
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                int custNomber = resultSet.getInt("custNo");
                String custName = resultSet.getString("custName");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                Date joinDate = resultSet.getDate("joinDate");
                String city = resultSet.getString("city");
                String grade = resultSet.getString("grade");

                dto = new MemberDto(custNomber, custName, phone, address, joinDate, grade, city);
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                if(resultSet != null) resultSet.close();
                if(preparedStatement != null) preparedStatement.close();
                if(connection != null) connection.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dto;
    }

    public void create(String custNo, String custName, String phone,
                       String address, String joinDate, String grade, String city) {

        System.out.println("create() ..");

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = dataSource.getConnection();
            String query = "UPDATE MEMBER_TBL_02 " +
                           "SET CUSTNAME = ?, PHONE = ?, ADDRESS = ?, JOINDATE = ?, GRADE = ?, CITY = ? " +
                           "WHERE CUSTNO = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,custName);
            preparedStatement.setString(2,phone);
            preparedStatement.setString(3,address);
            preparedStatement.setString(4,joinDate);
            preparedStatement.setString(5,grade);
            preparedStatement.setString(6,city);
            preparedStatement.setInt(7, Integer.parseInt(custNo));

            int update = preparedStatement.executeUpdate();
            System.out.println("업데이트 갯수 : " + update);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                if(preparedStatement != null) preparedStatement.close();
                if(connection != null) connection.close();
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
