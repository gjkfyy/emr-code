    <%@page contentType="text/html" pageEncoding="UTF-8"%>    
    <%@page import="java.util.List" %>    
 	<%@page import="java.sql.*"%>
    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"   
       "http://www.w3.org/TR/html4/loose.dtd">    
       
    <html>    
        <head>    
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
            <title></title>    
        </head>    
        <body>    
        
            <%    
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            String url = "jdbc:oracle:thin:@172.18.98.74:1521:orcl";
            String user = "iemr2_1117";
            String password = "123";
            Connection conn=DriverManager.getConnection(url, user, password);  
				 out.println("con==="+conn);
        if (conn == null) {
            out.println("is me!");
            out.println("Can't get connection");
            return;
        }
        ResultSet rs = null;
        ResultSetMetaData md = null;
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT sysdate FROM dual");
            md = rs.getMetaData();
            out.println("database time is ");
            while (rs.next()) {
                out.println("<BR>");
                /*for (int i = 1; i < md.getColumnCount(); i++) {
                    out.print(rs.getString(i) + ", ");
                }
                */
                  out.print(rs.getString(1) + ", ");
                
            }
            stmt.close();
            rs.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
 
            %>    
        </body>    
    </html>