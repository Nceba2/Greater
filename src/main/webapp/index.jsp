<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.Map" %>
<html>
    <head>
        <title>GreaterRA</title>
    </head>
    <body>

        <center>
                <h1>GreaterRA</h1>

                <form method="post" action"/greater">
                    <p>${ResponseText}</p>
                    <textarea name="responseArea" rows="4" cols="50">Respond...</textarea>
                    <br/>
                    <input type="Submit" name="Submit" value="Submit"/>
                </form>
        </center>

    </body>
</html>