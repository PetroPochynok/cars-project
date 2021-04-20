<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <style>
        .formForRentCar-form {
            width: 400px;
            margin: 0px auto;
        }
        .formForRentCar-form form {
            margin-bottom: 15px;
            background: #f7f7f7;
            box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
            padding: 30px;
        }
        p{
            font-size: large;
        }
    </style>

    <title>Rent a Car</title>

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

            <div style="margin-bottom: -15px; margin-right: 130px">
                <form:form class="d-flex" action="searchCar" method="get">
                    <input class="form-control me-2" type="search" placeholder="Search Car" name="searchCar">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form:form>
            </div>

            <span class="navbar-text ">
                     User:
                <security:authorize access="hasRole('ADMIN')"> <a style="text-decoration: none" href="${pageContext.request.contextPath}/registration/showFormForUpdateAdmin">${user.firstName} ${user.lastName}</a> (Admin)</security:authorize>
                <security:authorize access="hasRole('USER')"> <a style="text-decoration: none" href="${pageContext.request.contextPath}/registration/showFormForUpdateUser">${user.firstName} ${user.lastName}</a></security:authorize>
                |    Your Balance: ${user.money}$
            </span>

            <a class="nav-link" aria-current="page" href="${pageContext.request.contextPath}/deposit/showPage">Deposit</a>

            <form:form action="/logout" method="post">
                <button type="submit" value="Logout" class="btn btn-outline-light" style="margin-bottom: -15px">Logout</button>
            </form:form>
        </div>
    </div>
</nav>

<div style="margin: 25px auto; text-align: center; width: 700px">
    <h2>Rent a Car</h2>
    <hr>
</div>

<div class="formForRentCar-form">
    <form:form action="saveFormForRentCar" modelAttribute="car" method="post">

    <form:hidden path="id"/>
    <form:hidden path="brand"/>
    <form:hidden path="model"/>
    <form:hidden path="color"/>
    <form:hidden path="seats"/>
    <form:hidden path="fuelType"/>
    <form:hidden path="mileage"/>
    <form:hidden path="price"/>


        <h3 style="text-align: center">Info about car</h3>

        <hr>

        <p>Brand: ${car.brand}</p>

        <p>Model: ${car.model}</p>

        <p>Color: ${car.color}</p>

        <p>Seats: ${car.seats}</p>

        <p>Fuel Type: ${car.fuelType}</p>

        <p>Price per 1 day: ${pricePerOneDay}$</p>
        <hr>

        <br>
        <div class="input-group mb-3">
            <span class="input-group-text">Days to rent (1-30)</span>
            <input value="0" type="number" min="1" max="30" name="paidDays" class="form-control">
        </div>


<div class="d-grid gap-2">
    <input class="btn btn-success" type="submit" value="Rent" onclick="if(!confirm('Are you sure you want to rent this car?')) return false">
    <input class="btn btn-secondary" type="button" onclick="history.back(-1)" value="Back"/>
</div>

</form:form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</body>
</html>