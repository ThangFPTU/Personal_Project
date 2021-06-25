<%-- 
    Document   : newjsp
    Created on : Mar 21, 2021, 1:38:28 AM
    Author     : Thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="" method="post">
            <button type="submit" onclick="a()"></button>
        </form>
        

    </body>
</html>
 <script type="text/javascript">
                                    function add(id) {
                                        document.f.action = "add?id=" + id",?cid=";
                                        document.f.submit();
                                    }
</script> 