/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.configure;
import java.sql.*;
/**
 *
 * @author praty
 */
public class Record {
    
    public static Connection takeConnection()
    {
        Connection con=null;
           try 
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Pratyush@8055");
            }   
           catch (Exception e) 
            {
                e.printStackTrace();
            }
           return con;
            
    }
                public static String getBusAmount(String dest)
                {
                    String amount="";
                    try
                    {
                        Connection con=Record.takeConnection();
                        String s="select amount from bus_details where destination=?";
                        PreparedStatement st = con.prepareStatement(s);
                        st.setString(1,dest);
                        ResultSet rs=st.executeQuery();
                        if(rs.next())
                        {
                            amount=rs.getString(1);
                        }
                        con.close();
                    }
                    catch (Exception e) 
                    {
                        e.printStackTrace();
                    }
                return amount;
                }
                
                public static int getBusId(String dest)
                {
                    int id=0;
                    try
                    {
                        Connection con=Record.takeConnection();
                        String s="select bus_id from bus_details where destination=?";
                        PreparedStatement st = con.prepareStatement(s);
                        st.setString(1,dest);
                        ResultSet rs=st.executeQuery();
                        if(rs.next())
                        {
                            id=rs.getInt(1);
                        }
                        con.close();
                    }
                    catch (Exception e) 
                    {
                        e.printStackTrace();
                    }
                return id;
                }
                 public static void setPhoto(String path,int pnr_no)
                {
                    try
                    {
                        Connection con=Record.takeConnection();
                        String s="update passenger set photo=? where pnr_no=?";
                        PreparedStatement st = con.prepareStatement(s);
                        st.setString(1,path);
                        st.setInt(2,pnr_no);
                        st.executeUpdate();
                        con.close();
                    }
                    catch (Exception e) 
                    {
                        e.printStackTrace();
                    }
                }
                  public static int getPnr()
                {
                    int pnr=0;
                    try
                    {
                        Connection con=Record.takeConnection();
                        String s="select pnr_no from passenger order by pnr_no desc";
                      PreparedStatement st = con.prepareStatement(s);
                        ResultSet rs=st.executeQuery(s);
                        if(rs.next())
                        {
                           pnr=rs.getInt(1);
                        }
                        st.executeUpdate();
                        con.close();
                    }
                    catch (Exception e) 
                    {
                        e.printStackTrace();
                    }
                    return pnr;
                }
 }
