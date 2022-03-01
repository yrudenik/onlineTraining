<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title> Online training </title>
    <link rel="stylesheet" href="static/styles/style.css"/>
    <link rel="icon" type="image/x-icon" href="WEB-INF/recourses/studying-blue.png">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body style="background-image: url(WEB-INF/recourses/background-40.png);">

	<header>
		<ul style="float:right;">
		  <li class="dropdown">
			<a href="javascript:void(0)" class="dropbtn">
			<img src="Eng.png" width="25" height="18" style="margin-top:0px;" align="top">
			EN
			<img src="WEB-INF/recourses/icon-down.png" width="10" height="10" style="margin-left:6px; margin-top:4px;" align="top"></a>
			<div class="dropdown-content">
			  <a href="#"><img src="Rus.png" width="18" height="14" style="margin-top:2px; margin-left:2px; margin-right:3px;" align="top"> RU</a>
			  <a href="#"><img src="Bel.png" width="20" height="15" style="margin-top:2px; margin-right:3px;" align="top"> BY</a>
			</div>
		  </li>
			  <li><a href="login page.html">Log out
			  <div style="background-image: url(WEB-INF/recourses/icons-logout.png);"></div>
			  </a></li>
		</ul>
		<p><a href="Main teacher.html">
		<img src="WEB-INF/recourses/icon-studying.png" width="40" height="37" style="margin-left:14px;" align="middle"> Online	training</a><p/>
	</header>

	<div style="overflow:auto;">
	    <div class="menu">
		    <div class="btn-group">
				<form action="Manage tasks.html"><button class="button">Manage tasks</button></form>
				<form action="Task checking.html"><button class="button">Task checking</button></form>
				<form action="Course journal teacher.html"><button class="button">Course journal</button></form>
		    </div>
	    </div>

		<div class="main">
			<h2 style="text-align:center;">Manage tasks</h2>
				<p>
				There would be information about avalaible courses and tasks.
				<br>
				Add task to the course.
				<br>
				Remove task from the course.
				</p>
		</div>
	</div>

	<footer>
	  <p>Contact us: +375 29 908 20 20</p>
	</footer>

</body>
</html>