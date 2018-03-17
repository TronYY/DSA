package org.ynu.iacs.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CH01 {
	// 创建静态全局变量  
    static Connection conn;  
  
    static Statement st;  
    static PreparedStatement pstmt ;
  
    public static void main(String[] args) {  
        insert();   //插入添加记录  
        update();   //更新记录数据  
        delete();   //删除记录  
        query();    //查询记录并显示  
        queryOther();//查询记录并显示
        deleteOther();
    }  
      
    /* 插入数据记录，并输出插入的数据记录数*/  
    public static void insert() {  
          
        conn = getConnection(); // 首先要获取连接，即连接到数据库  
  
        try {  
            String sql = "INSERT INTO student(Sno,Sname,Sex,Sage, Sdept)"  
                    + " VALUES ('20141103','Tom' ,'男',18, '数学系')";  // 插入数据的sql语句  
              
            st = (Statement) conn.createStatement();    // 创建用于执行静态sql语句的Statement对象  
              
            int count = st.executeUpdate(sql);  // 执行插入操作的sql语句，并返回插入数据的个数  
              
            System.out.println("向student表中插入 " + count + " 条数据"); //输出插入操作的处理结果  
              
            conn.close();   //关闭数据库连接  
              
        } catch (SQLException e) {  
            System.out.println("插入数据失败" + e.getMessage());  
            while (e != null) {
            	System.out.println(e.getSQLState());
            	System.out.println(e.getMessage());
            	System.out.println(e.getErrorCode());
            	e = e.getNextException();
            }
        }  
    }  
      
    /* 更新符合要求的记录，并返回更新的记录数目*/  
    public static void update() {  
        conn = getConnection(); //同样先要获取连接，即连接到数据库  
        try {  
            String sql = "update student set Sage='20' where Sname = 'Tom'";// 更新数据的sql语句  
              
            st = (Statement) conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量  
              
            int count = st.executeUpdate(sql);// 执行更新操作的sql语句，返回更新数据的个数  
              
            System.out.println("student表中更新 " + count + " 条数据");      //输出更新操作的处理结果  
              
            conn.close();   //关闭数据库连接  
              
        } catch (SQLException e) {  
            System.out.println("更新数据失败");  
        }  
    }  
  
    
    /* 查询数据库，输出符合要求的记录的情况*/  
    public static void query() {  
          
        conn = getConnection(); //同样先要获取连接，即连接到数据库  
        try {  
            String sql = "select * from student";     // 查询数据的sql语句  
             st = (Statement) conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量  
              
            ResultSet rs = st.executeQuery(sql);    //执行sql查询语句，返回查询数据的结果集  
            System.out.println("最后的查询结果为：");  
            while (rs.next()) { // 判断是否还有下一个数据  
                  
                // 根据字段名获取相应的值  
            	String number = rs.getString("Sno");  
                String name = rs.getString("Sname");  
                String sex = rs.getString("Sex");  
                int age = rs.getInt("Sage"); 
                 
                String depart = rs.getString("Sdept");  
                  
                //输出查到的记录的各个字段的值  
                System.out.println(number+""+name + " " + age + " " + sex +  " " + depart  );  
              
            }  
            conn.close();   //关闭数据库连接  
              
        } catch (SQLException e) {  
            System.out.println("查询数据失败");  
        }  
    }  
  
    /* 删除符合要求的记录，输出情况*/  
    public static void delete() {  
  
        conn = getConnection(); //同样先要获取连接，即连接到数据库  
        try {  
            String sql = "delete from student  where Sname = '张三'";// 删除数据的sql语句  
            st = (Statement) conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量  
              
            int count = st.executeUpdate(sql);// 执行sql删除语句，返回删除数据的数量  
              
            System.out.println("student表中删除 " + count + " 条数据\n");    //输出删除操作的处理结果  
              
            conn.close();   //关闭数据库连接  
              
        } catch (SQLException e) {  
            System.out.println("删除数据失败");  
        }  
          
    }  
    
    /* 删除符合要求的记录，输出情况*/  
    public static void deleteOther() {  
  
        conn = getConnection(); //同样先要获取连接，即连接到数据库  
        try {  
            String sql = "delete from student  where Sname = ? and Sage=?";// 删除数据的sql语句  
            pstmt =conn.prepareStatement(sql);   //创建用于执行静态sql语句的Statement对象，st属局部变量  

            pstmt.setString(1, "Tom");
            pstmt.setDouble(2, 20);

            int count = pstmt.executeUpdate(); // 执行sql删除语句，返回删除数据的数量  
              
            System.out.println("student表中删除(Other) " + count + " 条数据\n");    //输出删除操作的处理结果  
              
            conn.close();   //关闭数据库连接  
              
        } catch (SQLException e) {  
            System.out.println("删除数据失败");  
        }  
          
    }  
      
    /* 查询数据库，输出符合要求的记录的情况*/  
    public static void queryOther() {  
          
        conn = getConnection(); //同样先要获取连接，即连接到数据库  
        try {  
            String sql = "SELECT * FROM student " +
            		"WHERE Sex= ? and Sage > ?";     // 查询数据的sql语句  
            pstmt  = (PreparedStatement) conn.prepareStatement(sql);    //创建用于执行静态sql语句的prepareStatement对象，pstmt属局部变量  
           
            pstmt.setString(1, "男");
            pstmt.setInt(2, 18);
           
            ResultSet rs = pstmt.executeQuery();    //执行sql查询语句，返回查询数据的结果集  
            System.out.println("other最后的查询结果为：");  
            while (rs.next()) { // 判断是否还有下一个数据  
                  
                // 根据字段名获取相应的值  
            	String number = rs.getString("Sno");  
                String name = rs.getString("Sname");  
                String sex = rs.getString("Sex");  
                int age = rs.getInt("Sage"); 
                 
                String depart = rs.getString("Sdept");  
                  
                //输出查到的记录的各个字段的值  
                System.out.println(number+""+name + " " + age + " " + sex +  " " + depart  );  
              
            }  
            conn.close();   //关闭数据库连接  
              
        } catch (SQLException e) {  
            System.out.println("other查询数据失败");  
        }  
    } 
    /* 获取数据库连接的函数*/  
    public static Connection getConnection() {  
        Connection con = null;  //创建用于连接数据库的Connection对象  
        try {  
            Class.forName("com.mysql.jdbc.Driver");// 加载Mysql数据驱动  
              
            con = DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/mydb_test", "root", "123456");// 创建数据连接  
              
        } catch (Exception e) {  
            System.out.println("数据库连接失败" + e.getMessage());  
        }  
        return con; //返回所建立的数据库连接  
    }  

}
