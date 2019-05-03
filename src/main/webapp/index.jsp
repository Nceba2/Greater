<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.Map" %>
<html>
    <head>
        <title>GreaterRA</title>

    <link href="style.css" rel="stylesheet">
    </head>
    <body class="body">

        <center>
        <div class="whitePanel">
                <h1>GreaterRA</h1>

                <form method="post" action"/greater">
                    <p>${ResponseText}</p>
                    <textarea name="responseArea" rows="4" cols="50">Respond...</textarea>
                    <br/>
                    <br/>
                    <input type="Submit" name="Submit" value="Submit" class="btn btn-primary" />
                </form>
         </div>
        </center>

    </body>
</html>