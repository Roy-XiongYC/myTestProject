    <%@ page language="java" contentType="text/html; charset=utf-8"
             pageEncoding="utf-8"%>
        <%@ page import="com.xiong.system.controller.Uploader" %>

            <%
    request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
    Uploader up = new Uploader(request);
    up.setSavePath("upload");
    String[] fileType = {".gif" , ".png" , ".jpg" , ".jpeg" , ".bmp"};
    up.setAllowFiles(fileType);
    up.setMaxSize(10000); //单位KB
    up.upload();

    String callback = request.getParameter("callback");

    String result = "{\"name\":\""+ up.getFileName() +"\", \"originalName\": \""+ up.getOriginalName() +"\", \"size\": "+ up.getSize() +", \"state\": \""+ up.getState() +"\", \"type\": \""+ up.getType() +"\", \"url\": \""+ up.getUrl() +"\"}";

    result = result.replaceAll( "\\\\", "\\\\" );

    if( callback == null ){
        System.out.println(callback);
        response.getWriter().print( result );
    }else{
        System.out.println(callback);
        response.getWriter().print("<script>"+ callback +"(" + result + ")</script>");
    }
    %>
