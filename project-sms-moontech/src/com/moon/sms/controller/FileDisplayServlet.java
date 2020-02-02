package com.moon.sms.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDisplayServlet
 */
@WebServlet("/displayFile")
public class FileDisplayServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
        
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      try {
         request.setCharacterEncoding("UTF-8");
         process(request, response);
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      try {
         request.setCharacterEncoding("UTF-8");
         process(request, response);
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      
   }
   
   private void process(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
      System.out.println("displayFile");
      
      String fileName = request.getParameter("fileName");
      
      System.out.println("fileName ====> " + fileName);
      String uploadFilePath = request.getServletContext().getRealPath("/") + "picture/";
      String dFileName = request.getParameter("fileName");
      response.setHeader("Content-Type","image/png");
      java.io.File file = new java.io.File(uploadFilePath+dFileName);
      System.out.println(file);
      byte b[] = new byte[(int)file.length()];
      
      response.setHeader("Content-Disposition","attachement:fileName="+new String(dFileName.getBytes("UTF-8"))+";");
      
      if(file.isFile()){
         
         System.out.println("isFile ");
         
          BufferedInputStream fin = new BufferedInputStream(new FileInputStream(file));
          BufferedOutputStream outs = new BufferedOutputStream(response.getOutputStream());
          int read = 0;
          while ((read=fin.read(b))!=-1){
              outs.write(b,0,read);
          }
          outs.close();
          fin.close();
      }
}
}