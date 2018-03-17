
import javax.servlet.http.HttpServletRequest;  
import Common.Encrypter; 
import Common.LeaveMessageTable;  
import Common.User;  
public class DB{      
//    定义数据库连接变量 
    private Connection connection    //    定义参数 
    private String sql_driver = "com.mysql.jdbc.Driver"   
    private String sql_url = "jdbc:mysql://localhost:3306/web_ly_table"       private String sql_username = "root"       private String sql_password = "hezuoan"        
    public DB()     { 
        try        { 
               //建立数据库的连接 
               Class.forName(sql_driver)  
               connection = DriverManager.getConnection(sql_url,sql_username,sql_password)              } 
        catch(Exception e)         { 
            e.printStackTrace()           }     }      
//    用于执行各种SQL语句的方法 
    private ResultSet execSQL(String sql , Object ...args)              throws SQLException     { 
        PreparedStatement pstmt = connection.prepareStatement(sql)  //        为PreparedStatement对象设置SQL参数         for (int i = 0  i < args.length  ++ i)         { 
            pstmt.setObject(1 + i, args[i])           } //        运行 
        pstmt.execute()   
        return  pstmt.getResultSet();      } 
//    核对用户输入的验证码是否正确 
    public boolean checkValidationCode(HttpServletRequest request ,              String validationCode)     { 
        String validationCodeSession = (String) request.getSession().getAttribute("validationCode")           if(validationCodeSession == null) 









        { 
//            给result.jsp设置信息 
            request.setAttribute("info" , "验证码过期")  //            给login.jsp设置信息 
            request.setAttribute("codeError", "验证码过期")              return false ;          } 
        if(!validationCode.equalsIgnoreCase(validationCodeSession))         { 
            request.setAttribute("info","验证码错误")              request.setAttribute("codeError", "验证码错误")              return false ;          } 
        return true;      } 
//    检查用户登录信息 
    public User checkUser(String username , String password)     { 
        try        { 
            String sql = "select * from user_table where username = ? and  password = ?"              ResultSet rs = execSQL(sql,username,password)               User user = new User()               while (rs.next())             {     
                user.setId(rs.getInt("id"))   
                user.setUsername(rs.getString("username"))                   user.setPassword(rs.getString("password"))                   return user              }  
            return null ;         } 
        catch(Exception e)         { 
            e.printStackTrace();             return null ;          }     } 
//    插入留言 
    public boolean addInfo(LeaveMessageTable ly){         try{ 
            String sql = "insert into ly_table(userId,data,title,content) values(?,?,?,?)" ;              execSQL(sql , ly.getUserId(), ly.getDate(),ly.getTitle(),ly.getContent());             return true;         }catch(Exception e){             e.printStackTrace();             return false;         }     } 
//    插入用户 
    public boolean insertUser(String username,String password){ 









        try{ 
            String sql = "insert into user_table(username,password) values(?,?)" ;              execSQL(sql ,username , password)                return true;         }catch(Exception e){             e.printStackTrace();             return false;         }     } 
//    获取留言信息。 
    public ArrayList findLyInfo()     { 
         ArrayList arrayList = new ArrayList()            try           { 
             String sql = "select * from ly_table"                ResultSet rs = execSQL(sql)                while(rs.next())              { 
                 LeaveMessageTable ly = new LeaveMessageTable()                    ly.setId(rs.getInt("id"))   
                 ly.setUserId(rs.getInt("userId"))                   ly.setDate(rs.getDate("data"))                    ly.setTitle(rs.getString("title"))                   ly.setContent(rs.getString("content"))                    arrayList.add(ly)                }              return arrayList            } 
         catch(Exception e)          { 
             e.printStackTrace()                return null ;           }     } 
//    获取用户名 
    public String getUserName(int id)     { 
        String username = null;         try{ 
            String sql = "select username from user_table where id = ?" ;             ResultSet rs= execSQL(sql , new Object[]{id});             while(rs.next()){ 
                 username=rs.getString(1);             } 
            return username;         }catch(Exception e){             e.printStackTrace();             return null;         }