<%-- 
    Document   : numbers
    Created on : Jan 13, 2026, 8:18:18 AM
    Author     : sh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Results</h1>
        <p>
            <%     
                String inputNum = request.getParameter("input_number");
                out.println("Input number: " + inputNum); 
                
                if (inputNum.matches("[0-9]{1,9}")) {
                    try {
                        String isfactorialEnable = request.getParameter("isFactorial");
                        if (isfactorialEnable.equals("on")) {
                            int getNum = Integer.parseInt(inputNum.trim());
                            if (getNum < 12) {
                                int result = 1;
                                for (int i = 1; i <= getNum; i++) {
                                    result = result * i;
                                    if (result >= Integer.MAX_VALUE - 1) {
                                        break;
                                    }
                                }
                                out.println("<br>Result factorial is: " + result);
                            } else {
                                out.println("<br>Number is too large for factorial");
                            }                            
                        }
                    } catch (NullPointerException nullex) {
                        
                    }
                    
                    try {
                        String isReverseEnable = request.getParameter("isReverse");
                        if (isReverseEnable.equals("on")) {
                            StringBuilder strResult = new StringBuilder(request.getParameter("input_number"));
                            out.println("<br>Result reverse: " + strResult.reverse());
                        }
                    } catch (NullPointerException nullex) {
                        
                    }
                } else {
                    out.println("Input is not a number");
                }
            %>
        </p>
        <a onclick="history.back()" href="#">Go back</a>
    </body>
</html>
