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
    <a class="navbar-brand" href="/nguoidung?action=homesp">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="#">Gio Hang</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">LogOut</a>
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

<div class="container" style="margin-top:30px">
    <div class="row">
        <div class="col-sm-2">
            <h2>About Me</h2>
            <h5>Photo of me:</h5>
            <div class="fakeimg">Fake Image</div>
            <p>Some text about me in culpa qui officia deserunt mollit anim..</p>
            <h3>Some Links</h3>
            <p>Lorem ipsum dolor sit ame.</p>
            <ul class="nav nav-pills flex-column">
                <li class="nav-item">
                    <a class="nav-link active" href="#">Active</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#">LogOut</a>
                </li>
            </ul>
            <hr class="d-sm-none">
        </div>
        <%--        -----%>
        <div class="col-sm-10">
            <div class="container">
                <h2>chon mua san pham</h2>
                <form method="post">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>idBook</th>
                            <th>nameBook</th>
                            <th>image</th>
                            <th>publishingBook</th>
                            <th>statusBook</th>
                            <th>categoryBook</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>${homeND.idBook}</td>
                            <td>${homeND.nameBook}</td>
                            <td><img src="${homeND.image}" width="100" height="100"></td>
                            <td>${homeND.publishingBook}</td>
                            <td>${homeND.statusBook}</td>
                            <td>${homeND.categoryBook}</td>
                            <td><input placeholder="enter so luong" name="amount"></td>
                            <td><a href="/nguoidung?action=buy" class="btn btn-warning">mua</a></td>
                            <a href="/nguoidung?action=quit" class="btn btn-secondary">Quit</a>
                        </tr>

                        </tbody>

                    </table>
                </form>
            </div>
        </div>
    </div>
</div>
</div>

<div class="jumbotron text-center" style="margin-bottom:0">
    <p>Footer</p>
</div>

</body>
</html>
