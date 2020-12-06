<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<link rel="apple-touch-icon" sizes="76x76"
	href="img/apple-icon.png">
<link rel="icon" type="image/png"
	href="img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<base href="${pageContext.request.contextPath}/">
<meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no'
	name='viewport' />
<!--     Fonts and icons     -->
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
<!-- CSS Files -->
<link href="css/material-dashboard.css?v=2.1.2"
	rel="stylesheet" />
<!-- CSS Just for demo purpose, don't include it in your project -->
<link href="demo/demo.css" rel="stylesheet" />
</head>
<body>

	<div class="wrapper ">
		<div class="sidebar" data-color="purple" data-background-color="white"
			data-image="img/sidebar-1.jpg">
			<div class="logo">
				<a class="simple-text logo-normal"> Lưu trữ Ảnh </a>
			</div>
			<div class="sidebar-wrapper">
				<ul class="nav">
					<li class="nav-item "><a class="nav-link" href="/Home/Index">
							<i class="material-icons">image</i>
							<p>Ảnh</p>
					</a></li>
					<li class="nav-item "><a class="nav-link" href="/Album">
							<i class="material-icons">folder</i>
							<p>Album</p>
					</a></li>
					<li class="nav-item "><a class="nav-link" href="/Home/Share">
							<i class="material-icons">share</i>
							<p>Được chia sẻ</p>
					</a></li>
				</ul>
			</div>
		</div>
		<div class="main-panel">
			<!-- Navbar -->
			<nav
				class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
				<div class="container-fluid">
					<div class="collapse navbar-collapse justify-content-end">
						<ul class="navbar-nav">
							<li class="nav-item"><a class="nav-link" href="javascript:;"
								style="display: flex"> <i class="material-icons">backup</i>
									<p style="display: block">Tải lên</p>
							</a></li>
							<li class="nav-item"><a class="nav-link" data-toggle="modal"
								data-target="#myModal" style="display: flex"> <i
									class="material-icons">note_add</i>
									<p style="display: block">Tạo Album mới</p>
							</a></li>
							<li class="nav-item dropdown"><a class="nav-link"
								href="/User/Logout" style="display: flex" aria-haspopup="true"
								aria-expanded="false"> <i class="material-icons">person</i>
									<p style="display: block">Đăng xuất</p>
							</a>
								<div class="dropdown-menu dropdown-menu-right"
									aria-labelledby="navbarDropdownProfile">
									<a class="dropdown-item" href="#">Thông tin</a> <a
										class="dropdown-item" href="#">Cài đặt</a>
									<div class="dropdown-divider"></div>
									<a class="dropdown-item" href="#">Đăng xuất</a>
								</div></li>
						</ul>
					</div>
				</div>
			</nav>
			<div id="myModal" class="modal fade" role="dialog">
				<div class="modal-dialog">
					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title">Tạo Album Mới</h4>
							<button type="button" class="close" data-dismiss="modal">&times;</button>
						</div>
						<div class="modal-body">
							<form action="/Home/ThemAlbum/" method="post">
								<div class="form-group row">
									<label class=" col-form-label">Tên Album</label> <input
										type="text" class="form-control" name="AlbumName" />
								</div>
								<div class="form-group row">
									<label class=" col-form-label">Mô tả</label> <input type="text"
										class="form-control" name="AlbumCaption" />
								</div>

								<button type="submit" style="float: left"
									class="btn btn-default">Thêm</button>
							</form>
						</div>
					</div>
				</div>
			</div>
			
			
			<div class="container-fluid">

    <form class="navbar-form navbar-right" action="/Home/SearchImage" method="post" style="position:relative;right:-700px; top:-30px">
        <div class="form-group bmd-form-group">

            <span style="display:inline">
                From          :
            </span><input type="date" name="tungay" class="form-control" value="01/01/1000" style="position:relative; width:120px;display:inline "><span></span>
            <span>To          :</span><input type="date" name="denngay" class="form-control" value="01/01/10000" style="position:relative;display:inline;  gray; width:120px">

            <button type="submit" class="btn btn-default" style="position:relative; left:0px;height:35px; ">
                <img src="/Content/images/icon-tim-kiem.png" width="18" height="16">
            </button>
        </div>
    </form>
    <div class="row" style="width:100%">
     <c:forEach items="${ Images}" var="item">
       
        <div class="col-md-3 text-center" style=" margin: 10px 0">
            <img src="Images/${User.userId}/${item.imageUrl}" style="width:100%;" data-toggle="modal"
                 data-target="#detailImg" data-whatever="@it.ImageUrl"  data-book-id=@it.ImageUrl id="" onclick="OnClickBtnDetail($(this).attr('data-book-id'))" />
            <div style="text-align:center; font-weight:500"> ${ item.imagedate}</div>
            <a class="btn btn-primary center-block" href="/Home/Delete/?ImageID=@it.ImageID">Xóa</a>
            <a class="btn  center-block" style="margin:auto" data-toggle="modal" data-book-id=@it.ImageID id="BtnChiaSe" onclick="OnClickBtnChiaSe($(this).attr('data-book-id'))"
               data-target="#modalShare">Chia Sẻ</a>
        </div>
            <div id="detailImg" class="modal fade bd-example-modal-lg" role="dialog">
                <div class="modal-dialog modal-lg">
                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Chi tiết</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        <div class="modal-body">
                            <img src="" style="width:100%;" id="imgDetail" data-toggle="modal" />
                        </div>
                    </div>
                </div>
            </div>
      </c:forEach>

    </div>
    <div id="modalShare" class="modal fade" role="dialog">
        <div class="modal-dialog">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Chia sẻ với</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <div class="modal-body">
                    <form action="/Home/ShareImage/" method="post">
                        <div class="form-group row">
                            <input type="text" class="form-control" name="AlbumID" id="AlbumID" hidden />
                            <label class=" col-form-label">Email người nhận</label>
                            <input type="text" class="form-control" name="UserEmail" />
                        </div>

                        <button type="submit" style="float:left" class="btn btn-default" id="BtnShare">Thêm</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    
    function OnClickBtnChiaSe(id) {
            var input_1 = document.getElementById("AlbumID")
            input_1.setAttribute("value", id);
        }
    function OnClickBtnDetail(url) {
            x = '/Content/Images/@user.UserID/' + url;
        document.getElementById("imgDetail").src =x
        
        }
</script>
</div>
	</div>



	<!--   Core JS Files   -->
	<script src="js/bootstrap.min.js"></script>

	<script src="js/core/jquery.min.js"></script>
	<script src="js/core/popper.min.js"></script>
	<script src="js/core/bootstrap-material-design.min.js"></script>
	<script src="js/plugins/perfect-scrollbar.jquery.min.js"></script>
	<!-- Plugin for the momentJs  -->
	<script src="js/plugins/moment.min.js"></script>
	<!--  Plugin for Sweet Alert -->
	<script src="js/plugins/sweetalert2.js"></script>
	<!-- Forms Validations Plugin -->
	<script src="js/plugins/jquery.validate.min.js"></script>
	<!-- Plugin for the Wizard, full documentation here: https://github.com/VinceG/twitter-bootstrap-wizard -->
	<script src="js/plugins/jquery.bootstrap-wizard.js"></script>
	<!--	Plugin for Select, full documentation here: http://silviomoreto.github.io/bootstrap-select -->
	<script src="js/plugins/bootstrap-selectpicker.js"></script>
	<!--  Plugin for the DateTimePicker, full documentation here: https://eonasdan.github.io/bootstrap-datetimepicker/ -->
	<script src="js/plugins/bootstrap-datetimepicker.min.js"></script>
	<!--  DataTables.net Plugin, full documentation here: https://datatables.net/  -->
	<script src="js/plugins/jquery.dataTables.min.js"></script>
	<!--	Plugin for Tags, full documentation here: https://github.com/bootstrap-tagsinput/bootstrap-tagsinputs  -->
	<script src="js/plugins/bootstrap-tagsinput.js"></script>
	<!-- Plugin for Fileupload, full documentation here: http://www.jasny.net/bootstrap/javascript/#fileinput -->
	<script src="js/plugins/jasny-bootstrap.min.js"></script>
	<!--  Full Calendar Plugin, full documentation here: https://github.com/fullcalendar/fullcalendar    -->
	<script src="js/plugins/fullcalendar.min.js"></script>
	<!-- Vector Map plugin, full documentation here: http://jvectormap.com/documentation/ -->
	<script src="js/plugins/jquery-jvectormap.js"></script>
	<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
	<script src="js/plugins/nouislider.min.js"></script>
	<!-- Include a polyfill for ES6 Promises (optional) for IE11, UC Browser and Android browser support SweetAlert -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/core-js/2.4.1/core.js"></script>
	<!-- Library for adding dinamically elements -->
	<script src="js/plugins/arrive.min.js"></script>
	<!-- Chartist JS -->
	<script src="js/plugins/chartist.min.js"></script>
	<!--  Notifications Plugin    -->
	<script src="js/plugins/bootstrap-notify.js"></script>
	<!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
	<script src="js/material-dashboard.js?v=2.1.2"
		type="text/javascript"></script>
	<!-- Material Dashboard DEMO methods, don't include it in your project! -->
	<script src="demo/demo.js"></script>
	<script>
        $(document).ready(function () {
            $().ready(function () {
                $sidebar = $('.sidebar');

                $sidebar_img_container = $sidebar.find('.sidebar-background');

                $full_page = $('.full-page');

                $sidebar_responsive = $('body > .navbar-collapse');

                window_width = $(window).width();

                fixed_plugin_open = $('.sidebar .sidebar-wrapper .nav li.active a p').html();

                if (window_width > 767 && fixed_plugin_open == 'Dashboard') {
                    if ($('.fixed-plugin .dropdown').hasClass('show-dropdown')) {
                        $('.fixed-plugin .dropdown').addClass('open');
                    }

                }

                $('.fixed-plugin a').click(function (event) {
                    // Alex if we click on switch, stop propagation of the event, so the dropdown will not be hide, otherwise we set the  section active
                    if ($(this).hasClass('switch-trigger')) {
                        if (event.stopPropagation) {
                            event.stopPropagation();
                        } else if (window.event) {
                            window.event.cancelBubble = true;
                        }
                    }
                });

                $('.fixed-plugin .active-color span').click(function () {
                    $full_page_background = $('.full-page-background');

                    $(this).siblings().removeClass('active');
                    $(this).addClass('active');

                    var new_color = $(this).data('color');

                    if ($sidebar.length != 0) {
                        $sidebar.attr('data-color', new_color);
                    }

                    if ($full_page.length != 0) {
                        $full_page.attr('filter-color', new_color);
                    }

                    if ($sidebar_responsive.length != 0) {
                        $sidebar_responsive.attr('data-color', new_color);
                    }
                });

                $('.fixed-plugin .background-color .badge').click(function () {
                    $(this).siblings().removeClass('active');
                    $(this).addClass('active');

                    var new_color = $(this).data('background-color');

                    if ($sidebar.length != 0) {
                        $sidebar.attr('data-background-color', new_color);
                    }
                });

                $('.fixed-plugin .img-holder').click(function () {
                    $full_page_background = $('.full-page-background');

                    $(this).parent('li').siblings().removeClass('active');
                    $(this).parent('li').addClass('active');


                    var new_image = $(this).find("img").attr('src');

                    if ($sidebar_img_container.length != 0 && $('.switch-sidebar-image input:checked').length != 0) {
                        $sidebar_img_container.fadeOut('fast', function () {
                            $sidebar_img_container.css('background-image', 'url("' + new_image + '")');
                            $sidebar_img_container.fadeIn('fast');
                        });
                    }

                    if ($full_page_background.length != 0 && $('.switch-sidebar-image input:checked').length != 0) {
                        var new_image_full_page = $('.fixed-plugin li.active .img-holder').find('img').data('src');

                        $full_page_background.fadeOut('fast', function () {
                            $full_page_background.css('background-image', 'url("' + new_image_full_page + '")');
                            $full_page_background.fadeIn('fast');
                        });
                    }

                    if ($('.switch-sidebar-image input:checked').length == 0) {
                        var new_image = $('.fixed-plugin li.active .img-holder').find("img").attr('src');
                        var new_image_full_page = $('.fixed-plugin li.active .img-holder').find('img').data('src');

                        $sidebar_img_container.css('background-image', 'url("' + new_image + '")');
                        $full_page_background.css('background-image', 'url("' + new_image_full_page + '")');
                    }

                    if ($sidebar_responsive.length != 0) {
                        $sidebar_responsive.css('background-image', 'url("' + new_image + '")');
                    }
                });

                $('.switch-sidebar-image input').change(function () {
                    $full_page_background = $('.full-page-background');

                    $input = $(this);

                    if ($input.is(':checked')) {
                        if ($sidebar_img_container.length != 0) {
                            $sidebar_img_container.fadeIn('fast');
                            $sidebar.attr('data-image', '#');
                        }

                        if ($full_page_background.length != 0) {
                            $full_page_background.fadeIn('fast');
                            $full_page.attr('data-image', '#');
                        }

                        background_image = true;
                    } else {
                        if ($sidebar_img_container.length != 0) {
                            $sidebar.removeAttr('data-image');
                            $sidebar_img_container.fadeOut('fast');
                        }

                        if ($full_page_background.length != 0) {
                            $full_page.removeAttr('data-image', '#');
                            $full_page_background.fadeOut('fast');
                        }

                        background_image = false;
                    }
                });

                $('.switch-sidebar-mini input').change(function () {
                    $body = $('body');

                    $input = $(this);

                    if (md.misc.sidebar_mini_active == true) {
                        $('body').removeClass('sidebar-mini');
                        md.misc.sidebar_mini_active = false;

                        $('.sidebar .sidebar-wrapper, .main-panel').perfectScrollbar();

                    } else {

                        $('.sidebar .sidebar-wrapper, .main-panel').perfectScrollbar('destroy');

                        setTimeout(function () {
                            $('body').addClass('sidebar-mini');

                            md.misc.sidebar_mini_active = true;
                        }, 300);
                    }

                    // we simulate the window Resize so the charts will get updated in realtime.
                    var simulateWindowResize = setInterval(function () {
                        window.dispatchEvent(new Event('resize'));
                    }, 180);

                    // we stop the simulation of Window Resize after the animations are completed
                    setTimeout(function () {
                        clearInterval(simulateWindowResize);
                    }, 1000);

                });
            });
        });
    </script>
	<script>
        $(document).ready(function () {
            // Javascript method's body can be found in assets/js/demos.js
            md.initDashboardPageCharts();

        });
    </script>

	<style>
.sidebar .nav li:hover, .sidebar .nav li a:visited {
	background-color: #9124a3
}
</style>

	<script>
    $('#modalShare').on('show.bs.modal', function(e) {
 
    //get data-id attribute of the clicked element
        albumID = $(e.relatedTarget).data('book-id');
        alert(albumID)
        $(e.currentTarget).find('input[name="AlbumID"]').val(albumID);
    });

    function OnClickBtnChiaSe(id) {
        var input_1 = document.getElementById("AlbumID")
        input_1.setAttribute("value", id);
    }

</script>
</body>



</html>