<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <style>
        <%@include file="/resources/css/styles.css"%>
        table, td, th {
            text-align: center;
            font-weight: normal;
        }
    </style>

    <title>New Cars</title>

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

            <form:form class="d-flex" action="searchCar" method="get">
                <input class="form-control me-2" type="search" placeholder="Search Car" name="searchCar">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form:form>

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


<div style="margin: 25px auto; text-align: center; width: 22%">
    <form:form action="/cars/listOfNewCarsOnSaleByPriceRange" method="post">
        <span class="fs-4">Find new cars by price</span>
        <hr>
        <div class="input-group input-group-sm mb-3">
            <span class="input-group-text">Min</span>
            <input style="width: 20px" type="text" class="form-control" value="0" min="5000" placeholder="Min" name="min">
            <span class="input-group-text">Max</span>
            <input style="width: 20px" type="text" class="form-control" value="0" max="250000" placeholder="Max" name="max">
            <button type="submit" class="btn btn-secondary">Find</button>
        </div>

    </form:form>
</div>

    <table class="table" style="margin-left: auto; margin-right: auto; width: 80%;" border="1">
        <thead class="table-dark">
        <tr>
            <th>#</th>
            <th><a href="/cars/listOfNewCarsOnSaleOrderByBrandAsc" style="text-decoration: none">Brand</a></th>
            <th>Model</th>
            <th>Color</th>
            <th><a href="/cars/listOfNewCarsOnSaleOrderBySeatsDesc" style="text-decoration: none">Seats</a></th>
            <th>Fuel Type</th>
            <th><a href="/cars/listOfNewCarsOnSaleOrderByMileageAsc" style="text-decoration: none">Mileage</a></th>
            <th><a href="/cars/listOfNewCarsOnSaleOrderByPriceDesc" style="text-decoration: none">Price</a></th>
            <th>Action</th>
        </tr>
        </thead>
        <c:forEach var="tempCar" items="${cars}">

            <c:url var="updateLink" value="/cars/showFormForUpdateNewCar">
                <c:param name="carId" value="${tempCar.id}"/>
            </c:url>

            <c:url var="deleteLink" value="/cars/deleteNewCar">
                <c:param name="carId" value="${tempCar.id}"/>
            </c:url>

            <c:url var="buyNewCar" value="/cars/buyNewCar">
                <c:param name="carId" value="${tempCar.id}"/>
            </c:url>

            <tbody>
            <tr>
                <td>${tempCar.id}</td>
                <td>${tempCar.brand}</td>
                <td>${tempCar.model}</td>
                <td>${tempCar.color}</td>
                <td>${tempCar.seats}</td>
                <td>${tempCar.fuelType}</td>
                <td>${tempCar.mileage}</td>
                <td>${tempCar.price}$</td>
                <td>
                    <a href="${buyNewCar}" class="btn btn-success btn-sm">Buy Car</a>
                    <security:authorize access="hasRole('ADMIN')">

                        <a href="${updateLink}" class="btn btn-warning btn-sm">Update</a>

                        <a href="${deleteLink}" class="btn btn-danger btn-sm" onclick="if(!confirm('Are you sure you want to delete this car?')) return false">Delete</a>
                    </security:authorize>
                </td>
            </tr>
            </tbody>
        </c:forEach>
    </table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</body>
</html>