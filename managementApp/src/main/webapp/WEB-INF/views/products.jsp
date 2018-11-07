<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/products.css"/>
    <html>
        <head>
        </head>
        <body>
            <h3>Products</h3>
            <td><input type="submit" class="button-secondary"  onclick="location.href='/product'" value="create product"/></td>
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