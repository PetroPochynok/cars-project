<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Change Profile</title>

    <style>
        .error{
            color: red;
        }
        .formForChangeProfile-form {
            width: 400px;
            margin: 0 auto;
        }
        .formForChangeProfile-form form {
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

<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #000000;">
    <div style="margin: 0 5%" class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/cars/listOfNewCarsOnSale">New Cars</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/cars/listOfUsedCarsOnSale">Used Car</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="${pageContext.request.contextPath}/cars/listOfCarsToRentOnSale">Rent Car</a>
                </li>
                <security:authorize access="hasRole('ADMIN')">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Add Car
                        </a>
                        <ul class="dropdown-menu active" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/cars/showFormForAddNewCarForSale">Add New Car</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/cars/showFormForAddUsedCarForSale">Add Used Car</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/cars/showFormForAddCarToRent">Add Car to Rent</a></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle"  id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Info
                        </a>
                        <ul class="dropdown-menu active" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/info/showListOfInfo">All Info</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/info/showInfoListOfCarsInRent">Cars in Rent</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/info/showInfoListOfBoughtCars">Bought Cars</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/info/showInfoListOfReturnedCars">Returned Cars</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/cars/listOfAllCars">List Of All Cars</a>
                    </li>
                </security:authorize>
            </ul>

            <div style="margin-bottom: -15px; margin-right: 354px">
                <form:form class="d-flex" action="searchCar" method="get">
                    <input class="form-control me-2" type="search" placeholder="Search Car" name="searchCar">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form:form>
            </div>

            <span class="navbar-text ">
                   Your Balance: ${user.money}$
            </span>

            <a class="nav-link" aria-current="page" href="${pageContext.request.contextPath}/deposit/showPage">Deposit</a>

            <form:form action="/logout" method="post">
                <button type="submit" value="Logout" class="btn btn-outline-light" style="margin-bottom: -15px">Logout</button>
            </form:form>
        </div>
    </div>
</nav>

<div style="margin: 25px auto; text-align: center; width: 400px">
    <h2>Change Profile</h2>
    <hr>
</div>

<div class="formForChangeProfile-form">
    <form:form action="saveFormForUpdateAdmin" modelAttribute="user" method="post">

        <form:hidden path="id"/>
        <form:hidden path="username"/>
        <form:hidden path="money"/>


        <form:errors path="firstName" cssClass="error"/>
        <div class="input-group mb-3">
            <span class="input-group-text">First Name</span>
            <form:input path="firstName" class="form-control"/>
        </div>

        <form:errors path="lastName" cssClass="error"/>
        <div class="input-group mb-3">
            <span class="input-group-text">Last Name</span>
            <form:input path="lastName" class="form-control"/>
        </div>


        <form:errors path="password" cssClass="error"/>
        <div class="input-group mb-3">
            <span class="input-group-text">Password</span>
            <form:password path="password" class="form-control"/>
        </div>


        <form:errors path="email" cssClass="error"/>
        <div class="input-group mb-3">
            <span class="input-group-text">Email</span>
            <form:input path="email" class="form-control"/>
        </div>



        Gender: <form:select path="gender" class="form-control">
        <form:option value="Male" >Male</form:option>
        <form:option value="Female">Female</form:option>
        <form:option value="Other">Other</form:option>
    </form:select>


        <br>

        <div class="d-grid gap-2">
            <input type="submit" value="Change" class="btn btn-primary">
        </div>

    </form:form>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</body>
</html>