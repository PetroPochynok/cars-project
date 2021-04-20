<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Login Page</title>

    <style>
        .login-form {
            width: 340px;
            margin: 150px auto;
            text-align: center;
        }
        .login-form form {
            margin-bottom: 15px;
            background: #f7f7f7;
            box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
            padding: 30px;
        }
    </style>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>
<body>

    <div class="login-form">

        <form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="post">
                <h2>Please Log In</h2>
            <c:if test="${param.error == null && param.logout == null}">
                <br>
            </c:if>

            <c:if test="${param.error != null}">
                <p style="color: red">Invalid username or password</p>
            </c:if>

            <c:if test="${param.logout != null}">
                    <p style="color: green">You have been logged out</p>
            </c:if>


            <div class="input-group mb-3">

                <input type="text" class="form-control" placeholder="Username" name="username">
            </div>

            <div class="input-group mb-3">

                <input type="password" class="form-control" placeholder="Password" name="password">
            </div>

            <div class="d-grid gap-2">
                <input class="btn btn-primary" type="submit" value="Login">
                <input class="btn btn-primary" type="button" onclick="window.location.href='/registration/showForm'" value="Registration">
             </div>
        </form:form>
    </div>

</body>
</html>