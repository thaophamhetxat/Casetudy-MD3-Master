<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap 4 Website Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        .fakeimg {
            height: 200px;
            background: #aaa;
        }
    </style>
</head>
<body>

<div class="jumbotron text-center" style="margin-bottom:0">
    <h1>My First Bootstrap 4 Page</h1>
    <p>Resize this responsive page to see the effect!</p>
</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <a class="navbar-brand" href="/tailieu?action=quit">Home Admin</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/tailieu?action=homeND">Home ND</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/tailieu?action=create">New</a>
            </li>
        </ul>
        <div class="search-container">
            <form action="/tailieu?action=find" method="post">
                <input type="text" placeholder="Search.." name="findName"/>
            </form>
        </div>
    </div>
</nav>
<%--        ---------------------%>
<div class="col-sm-12">
    <div class="container">
        <h2>THONG TIN TAI LIEU</h2>
        <form method="post">
            <table class="table table-bordered">
                <thead class="thead-dark">
                <tr>
                    <th>ID Book</th>
                    <th>Name</th>
                    <th>MoTa</th>
                    <th>Image</th>
                    <th>NSX</th>
                    <th>Status</th>
                    <th>theLoai</th>
                    <th>viTri</th>
                    <th>SoLuong</th>
                    <th>Price</th>

                </tr>
                </thead>
                <tbody>
                <tr>

                    <th>ID Book</th>
                    <td><input placeholder="enter idBook" name="idBook" value="${tailieu.idBook}"></td>
                </tr>
                <tr>
                    <th>Name</th>
                    <td><input placeholder="enter nameBook" name="nameBook" value="${tailieu.nameBook}"></td>
                </tr>
                <tr>
                    <th>Mo Ta</th>
                    <td><input placeholder="enter descriptionBook" name="descriptionBook"
                               value="${tailieu.descriptionBook}"></td>
                </tr>
                <tr>
                    <th>anh</th>
                    <td><input placeholder="enter image" name="image" value="${tailieu.image}"></td>
                </tr>
                <tr>
                    <th>nsx</th>
                    <td><input placeholder="enter publishingBook" name="publishingBook"
                               value="${tailieu.publishingBook}"></td>
                </tr>
                <tr>
                    <th>trang thai</th>
                    <td>
                        <select name="statusBook" >
                            <c:forEach items="${listStatus}" var="sbl">
                                <option value="${sbl.idStatus}">
                                        ${sbl.nameStatus}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>the loai</th>
                    <td>
                        <select name="categoryBook" >
                            <c:forEach items="${listCategory}" var="sbl">
                                <option value="${sbl.idCategory}">
                                        ${sbl.nameCategory}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>vi tri</th>
                    <td>
                        <select name="locationBook" >
                            <c:forEach items="${listLocation}" var="sbl">
                                <option value="${sbl.idLocation}">
                                        ${sbl.nameLocation}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>so luong</th>
                    <td><input placeholder="enter amount" name="amount" value="${tailieu.amount}"></td>
                </tr>
                <tr>
                    <th>Price</th>
                    <td><input placeholder="enter price" name="price" value="${tailieu.price}"></td>
                </tr>
                </tbody>
            </table>
            <button type="submit" class="btn btn-success">Edit</button>
            <a href="/tailieu?action=quit" class="btn btn-secondary">Quit</a>
        </form>
    </div>
</div>
</div>
</div>

<div class="jumbotron text-center" style="margin-bottom:0">
    <p>Footer</p>
</div>

</body>
</html>
