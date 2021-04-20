<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Registration Form</title>

    <style>
        .error{
            color: red;
        }
        .registration-form {
            width: 340px;
            margin: 100px auto;
        }
        .registration-form form {
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

<div class="registration-form">
    <h2 style="text-align: center">Registration Form</h2>
            <hr>
    <form:form action="saveForm" method="post" modelAttribute="user">

        <form:errors path="username" cssClass="error"/>
        <form:input path="username" class="form-control" placeholder="Username"/>

        <br>

        <form:errors path="password" cssClass="error"/>
        <form:password path="password" class="form-control" placeholder="Password"/>

        <br>

        <form:errors path="firstName" cssClass="error"/>
        <form:input path="firstName" class="form-control" placeholder="First Name"/>

        <br>

        <form:errors path="lastName" cssClass="error"/>
        <form:input path="lastName" class="form-control" placeholder="Last Name"/>

        <br>

        <form:errors path="email" cssClass="error"/>
        <form:input path="email" class="form-control" placeholder="Email"/>

        <br>

        <span style="font-size: large; margin-left: 5px;">Gender</span>
        <form:select path="gender" class="form-select">
        <form:option value="Male" >Male</form:option>
        <form:option value="Female">Female</form:option>
        <form:option value="Other">Other</form:option>
    </form:select>

        <br>

        <div class="d-grid gap-2">
            <input class="btn btn-primary" type="submit" value="Submit">
            <input class="btn btn-secondary" type="button" onclick="window.location.href='/showMyLoginPage'" value="Back to Login">
        </div>

    </form:form>

</div>

</body>
</html>
