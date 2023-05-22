<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Forget Password</title>
</head>
<body>
    <h2>Forget Password</h2>

    <form action="/forget" method="post">
        <div>
            <label for="email">Email:</label>
            <input type="text" id="email" name="email">
        </div>
        <div>
            <input type="submit" value="Reset Password">
        </div>
    </form>
</body>
</html>
