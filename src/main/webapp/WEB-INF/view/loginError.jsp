<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title> Online training </title>
    <link rel="stylesheet" href="static/styles/styleLogin.css"/>
    <link rel="icon" type="image/x-icon" href="static/resources/studying-blue.png">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body style="background-image: url(static/resources/background-40.png);">

	<header>
		<p><img src="static/resources/icon-studying.png" width="40" height="37" style="margin-left:14px;" align="middle"> Online	training<p/>
	</header>

	<div style="overflow:auto;">
		<div class="main">
			<h2 style="text-align:center; color:red">Invalid username/password. Try again</h2>
			<h2 style="text-align:center;">Login Form</h2>
				<div class="container">
				   <form method="post" action="controller?command=loginCommand" style="text-align:center;">
				   <label class="login-row" for="login">Username</label>
				   <input class="login-row" style="text-align:left" type="text" name="login"/>
				   <label class="login-row" for="password">Password</label>
				   <input class="login-row" style="text-align:left" type="password" name="password"/>
				   <br>
				   <button type="submit">Log in</button>
				   </form>
				</div>
		</div>
	</div>

	<footer>
	  <p>Contact us: +375 29 908 20 20</p>
	</footer>

</body>
</html>