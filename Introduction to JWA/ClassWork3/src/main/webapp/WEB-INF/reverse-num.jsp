<%-- 
    Document   : respond-reverse
    Created on : Jan 13, 2026, 7:46:34 AM
    Author     : sh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reverse Number</title>
    </head>
    <body>
        <h1>Reverse number:</h1>
        <p>
            <% 
                StringBuilder strResult = new StringBuilder(request.getParameter("num_n"));
                if (request.getParameter("num_n").matches("[0-9]{3}")) {
                    out.println(strResult.reverse());
                } else {
                    out.println("Invalid number. Must be a number in range 99 < n < 1000");
                }
            %>
        </p>
    </body>
</html>
