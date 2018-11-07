<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/product.css"/>
<html>

    <head>
    </head>
    <body>
        <div class="container">
            <h3>Products</h3>
            <form:form method="POST"
              action="/addProduct" modelAttribute="product">
                 <table>
                    <tr>
                        <td><form:label path="name">Name</form:label></td>
                        <td><form:input path="name" required="required"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="description">description</form:label></td>
                        <td><form:input path="description" required="required"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="unitPrice">Unit Price</form:label></td>
                        <td><form:input path="unitPrice" type= "number" min="0" value="0" step=".01" required="required"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="quantityPerUnit">Quantity</form:label></td>
                        <td><form:input path="quantityPerUnit" type="number" min="0" required="required"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" class="button-primary" value="Add Product"/></td>
                    </tr>
                </table>
            </form:form>
            <td><input type="submit" class="button-secondary"  onclick="location.href='/products'" value="View Products"/></td>
        </div>
    </body>
</html>