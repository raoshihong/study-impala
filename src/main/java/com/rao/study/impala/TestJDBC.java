package com.rao.study.impala;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestJDBC {
    public static void main(String[] args) throws Exception{
        Class.forName("com.cloudera.impala.jdbc41.Driver");
        String url = "jdbc:impala://hadoop102:21050";
        //impala可以不用设置用户名和密码
//        String username = "root";
//        String password = "123";
        Connection connection = DriverManager.getConnection(url);

        PreparedStatement pstmt = connection.prepareStatement("select * from test1");

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);

            System.out.println("id="+id+",name="+name);
        }
    }
}
