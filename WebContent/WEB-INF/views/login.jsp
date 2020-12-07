<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="../img/apple-icon.png">
    <link rel="icon" type="image/png" href="../img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

    <meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no' name='viewport' />
    <!--     Fonts and icons     -->
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <!-- CSS Files -->
    <link href="../css/material-dashboard.css?v=2.1.2" rel="stylesheet" />
    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="demo/demo.css" rel="stylesheet" />
    @*<link href="../css/lich.css" rel="stylesheet" />
        <link href="../css/home-01.css" rel="stylesheet" />*@

</head>
<body style=" background-image: url(../Images/d88d1898002e09b461f2a150a3c002f5.jpg);
     background-size: cover; color:white ">
    <div style="width: 30%; text-align:center; margin: auto; padding: 50px 0;">
        <h2 style="font-weight: 500">Đăng nhập</h2>
        <form action="login.html" method="post">
            <div class="form-group row">
                <label class=" col-form-label">Tên đăng nhập</label>
                <input type="text" class="form-control" name="Username" />
            </div>
            <div class="form-group row">
                <label class="col-form-label">Mật khẩu</label>
                <input type="password" class="form-control" name="Passwords" />
            </div>
            <button type="submit" class="btn btn-primary">Đăng nhập</button>
        </form>

        <br />

        <p>
            Chưa có tài khoản?
            <a href="/BTL_Anh/User/Register.html">Đăng kí</a>
        </p>

    </div>


</body>
</html>


