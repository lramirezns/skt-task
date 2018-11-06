<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<html>
<style>
input[type=text], select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=submit] {

    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    height:50px;
    width:200px;
}

input[type=submit]:hover {
    background-color: #45a049;
}

div {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
}
</style>
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
                        <td><form:input path="unitPrice" required="required"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="quantityPerUnit">Quantity</form:label></td>
                        <td><form:input path="quantityPerUnit" required="required"/></td>
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