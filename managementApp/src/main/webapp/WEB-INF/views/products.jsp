<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <html>
        <head>
<style>
#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

#products td, #products th {
    border: 1px solid #ddd;
    padding: 8px;
}

#products tr:nth-child(even){background-color: #f2f2f2;}

#products tr:hover {background-color: #ddd;}

#products th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #4CAF50;
    color: white;
}

input[type=submit] {
    width: 100%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #45a049;
}
</style>
        </head>
        <body>
            <h3>Products</h3>
            <td><input type="submit" class="button-secondary"  onclick="location.href='/managementController/product'" value="create product"/></td>
            <table id="products">
                <tr>
                    <th>PRODUCT ID</th>
                    <th>NAME</th>
                    <th>DESCRIPTION</th>
                    <th>PRICE</th>
                    <th>QUANTITY</th>
                </tr>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <td>
                            <c:out value="${product.id}"></c:out>
                        </td>
                        <td>
                            <c:out value="${product.name}"></c:out>
                        </td>
                        <td>
                            <c:out value="${product.description}"></c:out>
                        </td>
                        <td>
                            <c:out value="${product.unitPrice}"></c:out>
                        </td>
                        <td>
                            <c:out value="${product.quantityPerUnit}"></c:out>
                        </td>
                    </tr>
                </c:forEach>
            </table

        </body>