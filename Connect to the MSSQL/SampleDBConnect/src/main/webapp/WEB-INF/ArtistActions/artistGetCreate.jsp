<%-- 
    Document   : artist
    Created on : Jan 15, 2026, 9:55:36 AM
    Author     : sh
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Artist"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="<% out.print(request.getContextPath()); %>/lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <header data-bs-theme="dark">
            <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">FPT Music Store</a> <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button> 
                    <div class="collapse navbar-collapse" id="navbarCollapse">
                        <ul class="navbar-nav me-auto mb-2 mb-md-0">
                            <li class="nav-item"> <a class="nav-link" href="#">Artist</a> </li>
                            <li class="nav-item"> <a class="nav-link" href="#">Album</a> </li>
                            <li class="nav-item"> <a class="nav-link" href="#">Track</a> </li>
                        </ul>
                        <ul class="nav nav-pills">
                            <li class="nav-item"> <a class="nav-link" href="#">Login</a> </li>
                            <li class="nav-item"> <a class="nav-link" href="#">Theme</a> </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>
        <main>
            <div class="container col-xxl-8 px-4 py-5">
                <div class="row flex-lg-row-reverse align-items-center g-5 py-5">
                    <form class="has-validation" action="<% out.print(request.getContextPath()); %>/artist?action=create" method="POST">
                        <div class="row mb-3">
                            <label for="inputId" class="col-sm-2 col-form-label">ID</label>
                            <div class="col-sm-10 has-validation">
                                <input type="text" class="form-control" id="inputId" name="inputId" required pattern="[0-9]*">
                            </div>
                        </div>
                        <div class="row mb-3">
                            <label for="inputName" class="col-sm-2 col-form-label">Artist Name</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputName" name="inputName" required pattern="[A-Za-z ]*">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Add</button>
                    </form>
                </div>
            </div>
        </main>
        <script src="<% out.print(request.getContextPath());%>/lib/bootstrap/dist/js/bootstrap.bundle.js"></script>
    </body>
</html>
