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
            <form action="/hocvien?action=find" method="post">
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
                    <th>Mo Ta</th>
                    <th>anh</th>
                    <th>nsx</th>
                    <th>trang thai</th>
                    <th>the loai</th>
                    <th>vi tri</th>
                    <th>amount</th>

                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><input placeholder="nhap idBook" name="idBook" value="${tailieu.idBook}"></td>
                    <td><input placeholder="nhap nameBook" name="nameBook" value="${tailieu.nameBook}"></td>
                    <td><input placeholder="nhap descriptionBook" name="descriptionBook"
                               value="${tailieu.descriptionBook}"></td>
                    <td><input placeholder="nhap image" name="image" value="${nhanvien.image}"></td>
                    <td><input placeholder="nhap publishingBook" name="publishingBook"
                               value="${tailieu.publishingBook}"></td>
                    <td><input placeholder="nhap statusBook" name="statusBook" value="${tailieu.statusBook}"></td>
                    <td><input placeholder="nhap categoryBook" name="categoryBook" value="${tailieu.categoryBook}"></td>
                    <td><input placeholder="nhap locationBook" name="locationBook" value="${tailieu.locationBook}"></td>
                    <td><input placeholder="nhap amount" name="amount" value="${tailieu.amount}"></td>
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
