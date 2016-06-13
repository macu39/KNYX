<?php session_name("HOB"); session_start();

	$action = $_GET["a"];

	if($action == null){
		if(!isset($_SESSION["user"])){ 
		
			?>
			<html>
			<head>
				<title>KNYX - Computer Becnhmark</title>
				<link rel="icon" type="image/png" href="img/favicon-96x96.png" sizes="96x96">
				<link rel="stylesheet" href="css/style.css">
				<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,800,700,300' rel='stylesheet' type='text/css'>
			</head>
			<body>
				<div id="menu-container">
					<div id="menu">
						<img src="img/logo.png">	
						<?php 
							if(!isset($_SESSION["user"])){
								echo'<a href="login.php">Log in</a>';
							}else{
								echo'<a href="login.php?a=logout">Log out</a>';
								if($_SESSION["rights"]==10){
									echo'<a href="admin.php">Admin</a>';
								}else{
									echo'<a href="profile.php">Profile</a>';
								}
							}	
						?>
						<a href="rank.php">Ranking</a>							
						<a href="index.php#download">Download</a>
						<a href="index.php#statistics">View Statistics</a>
						<a href="index.php#">Home</a>				
					</div>	
				</div>
				<div id="result-container">	
					<div id="result">	
						<h1>Log in</h1>
						<div id="form">	
							<form action="?a=login" method="post">
								<input type="text" name="user" placeholder="User" required><br>
								<input type="password" name="password" placeholder="Password" required><br>
								<input type="submit" value="Log In"><br>
								<a href="login.php?a=register">Create an account</a>
							</form>		
						</div>
					</div>
			<?php
			
			if(isset($_SESSION["error"])){ echo $_SESSION["error"]; unset($_SESSION["error"]);}		
		
		}else{ 
			header('Location: index.php'); 
		}

	}else if($action == 'login'){

		$user=$_POST['user'];
		$password=$_POST['password'];
	
		$db = new mysqli('localhost', 'root', 'usuariobchx13wmcorrf00208126m', 'knyx');
		$result = $db->query("SELECT * FROM Users WHERE name='$user'");
		$row = $result->fetch_assoc();
		$pass = $row['password'];
			
		if($password == $pass){			
			$_SESSION["user"]=$user;	
			$_SESSION["rights"]=$row['rights'];
			header('Location: profile.php');			
		}else{
			$_SESSION["error"]="<div id='err'><span class='error'>Incorrect username or password.</span></div>";
			header('Location: login.php');
		}	

	}else if($action == 'logout'){

		session_destroy();	
		header('Location: login.php');

	}else if($action == 'register'){

		?>
		<html>
		<head>
			<title>KNYX - Computer Becnhmark</title>
			<link rel="icon" type="image/png" href="img/favicon-96x96.png" sizes="96x96">
			<link rel="stylesheet" href="css/style.css">
			<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,800,700,300' rel='stylesheet' type='text/css'>
		</head>
		<body>
			<div id="menu-container">
				<div id="menu">
					<img src="img/logo.png">	
					<?php 
						if(!isset($_SESSION["user"])){
							echo'<a href="login.php">Log in</a>';
						}else{
							echo'<a href="login.php?a=logout">Log out</a>';
							if($_SESSION["rights"]==10){
								echo'<a href="admin.php">Admin</a>';
							}else{
								echo'<a href="profile.php">Profile</a>';
							}
						}	
					?>
					<a href="rank.php">Ranking</a>							
					<a href="index.php#download">Download</a>
					<a href="index.php#statistics">View Statistics</a>
					<a href="index.php#">Home</a>				
				</div>	
			</div>
			<div id="result-container">	
				<div id="result">	
					<h1>Create Account</h1>
					<div id="form">	
						<form action="?a=up" method="post">
							<input type="text" name="user" placeholder="User" required><br>
							<input type="password" name="password" placeholder="Password" required><br>
							<input type="submit" value="Create Account">
						</form>		
					</div>
				</div>
		<?php
		
		if(isset($_SESSION["error"])){ echo $_SESSION["error"]; unset($_SESSION["error"]);}

	}else if($action == 'up'){

		$user=$_POST['user'];
		$password=$_POST['password'];
	
		if($user && $password){
	
			$db = new mysqli('localhost', 'root', 'usuariobchx13wmcorrf00208126m', 'knyx');			
			$result = $db->query("INSERT INTO Users (name, password) VALUES ('$user', '$password')");
							
			if($result){			
				$_SESSION["error"]="<div id='err'><span class='green'>Account created.</span></div>";
				header('Location: login.php');			
			}else{
				$_SESSION["error"]="<div id='err'><span class='error'>Unexpected error.</span></div>";
				header('Location: login.php?a=register');
			}	
			
		}else{
			$_SESSION["error"]="<div id='err'><span class='error'>Username or password empty.</span></div>";
			header('Location: login.php?a=register');
		}

	}else{
		header('Location: login.php');
	}
	
?>




		