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
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container" style="margin-top:30px">
    <div class="row">
        <div class="col-sm-4">
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
                    <a class="nav-link disabled" href="#">Disabled</a>
                </li>
            </ul>
            <hr class="d-sm-none">
        </div>
        <div class="col-sm-8">
            <div class="container">
                <h2>THONG TIN HOC VIEN</h2>
                <table class="table">
                    <thead>
                    <tr>
                        <th>ID Book</th>
                        <th>Name</th>
                        <th>Mo Ta</th>
                        <th>anh</th>
                        <th>nsx</th>
                        <th>trang thai</th>
                        <th>the loai</th>
                        <th>vi tri</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listTaiLieu}" var="tailieu" varStatus="loop">
                        <tr>
                            <td>${tailieu.idBook}</td>
                            <td>${tailieu.nameBook}</td>
                            <td>${tailieu.descriptionBook}</td>
                            <td>${tailieu.image}</td>
                            <td>${tailieu.publishingBook}</td>
                            <td>${tailieu.statusBook}</td>
                            <td>${tailieu.categoryBook}</td>
                            <td>${tailieu.locationBook}</td>
                            <td>
                                <form>
                                    <a href="/tailieu?action=edit&index=${loop.index}" class="btn btn-warning">Edit</a>
                                </form>
                            </td>
                            <td>
                                <form>
                                    <a href="/tailieu?action=delete&index=${loop.index}"
                                       class="btn btn-danger">Delete</a>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<div class="jumbotron text-center" style="margin-bottom:0">
    <p>Footer</p>
</div>

</body>
</html>
