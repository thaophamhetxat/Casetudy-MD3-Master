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

<div id="demo" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ul class="carousel-indicators">
        <li data-target="#demo" data-slide-to="0" class="active"></li>
        <li data-target="#demo" data-slide-to="1"></li>
        <li data-target="#demo" data-slide-to="2"></li>
    </ul>

    <!-- The slideshow -->
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="image/codegym1.png" alt="codegym 1" height="280" width="100%">
        </div>
        <div class="carousel-item">
            <img src="image/codegym2.png" alt="codegym 2" height="280" width="100%">
        </div>
        <div class="carousel-item">
            <img src="image/codegym3.png" alt="codegym 3" height="280" width="100%">
        </div>
    </div>

    <!-- Left and right controls -->
    <a class="carousel-control-prev" href="#demo" data-slide="prev">
        <span class="carousel-control-prev-icon"></span>
    </a>
    <a class="carousel-control-next" href="#demo" data-slide="next">
        <span class="carousel-control-next-icon"></span>
    </a>
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
<%-----------------------%>
<div class="col-sm-12">
    <div class="container">
        <h2>Muon tai lieu</h2>
        <form method="post">
            <table class="table table-bordered">
                <thead class="thead-dark">
                </thead>
                <tbody>
                <tr>
                    <th>ID Book</th>
                    <td><input name="idBook" value="${listGioHang.idBook}"></td>
                </tr>
                <tr>
                    <th>the loai</th>
                    <td><input name="idHD" value="${listGioHang.idHD}"></td>
                </tr>
                <tr>
                    <th>ID Book</th>
                    <td><input name="nameND" value="${listGioHang.nameND}"></td>
                </tr>
                <tr>
                    <th>Name</th>
                    <td><input name="nameBook" value="${listGioHang.nameBook}"></td>
                </tr>
                <tr>
                    <th>anh</th>
                    <td><input name="image" value="${listGioHang.image}"></td>
                </tr>
                <tr>
                    <th>trang thai</th>
                    <td><input name="statusBook" value="${listGioHang.statusBook}"></td>
                </tr>
                <tr>
                    <th>the loai</th>
                    <td><input name="categoryBook" value="${listGioHang.categoryBook}"></td>
                </tr>
                <tr>
                    <th>so luong</th>
                    <td><input placeholder="enter amount" name="amount" ></td>
                </tr>
                <tr>
                    <th>Ngay muon</th>
                    <td><input placeholder="enter dateHD" name="dateHD" ></td>
                </tr>

                </tbody>
            </table>
            <button type="submit" class="btn btn-success">Borrow</button>
            <a href="/nguoidung?action=quit" class="btn btn-secondary">Quit</a>
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
