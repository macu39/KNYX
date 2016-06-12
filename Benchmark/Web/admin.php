<?php session_name("HOB"); session_start();
	
	if(isset($_SESSION["user"]) && $_SESSION["rights"]==10){
		
		$action = $_GET["a"];

		if($action == null){
			
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
							<h1>Conected as <?=$_SESSION["user"];?></h1>
							<a href="admin.php?a=computers">Computers</a> - 
							<a href="admin.php?a=users">Users</a> - 
							<a href="admin.php?a=scores">Scores</a>
						</div>
			<?php
			
		}else if($action=="computers"){
			
			$db = new mysqli('localhost', 'root', 'usuariobchx13wmcorrf00208126m', 'knyx');			
			if(!$db->connect_error){
			
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
								<?php if(!isset($_SESSION["user"])){echo'<a href="login.php">Log in</a>';}else{echo'<a href="login.php?a=logout">Log out</a><a href="profile.php">Profile</a>';}	?>	
								<a href="rank.php">Ranking</a>								
								<a href="index.php#download">Download</a>
								<a href="index.php#statistics">View Statistics</a>	
								<a href="index.php#">Home</a>				
							</div>	
						</div>
						<div id="result-container">
							<div id="result">	
								<h1>Conected as <?=$_SESSION["user"];?></h1>
								<a href="admin.php?a=computers"><b>COMPUTERS</b></a> - 
								<a href="admin.php?a=users">Users</a> - 
								<a href="admin.php?a=scores">Scores</a>
							</div>
				<?php
				$u=$_SESSION["user"];
				$result = $db->query("SELECT * FROM Computers");	
				$cont = 1;			
				while($row = $result->fetch_assoc()){
					
					echo"<div id='score-item'>
							#$cont - <a href='result.php?id=".$row['mac']."'><b>".$row['cpu_model']."</b>
							<a href='admin.php?a=computers&b=del&m=".$row['mac']."'><span class='right'>Delete</span></a>
						</div>";
					$cont++;
				}
				
				if($_GET['b']=="del"){					
					$mac=$_GET["m"];					
					$result = $db->query("DELETE FROM Computers WHERE mac='$mac'");
					header("Location: admin.php?a=computers");
				}	
				
			}else{
				echo "Conecting to DB error.";
			}
			
		}else if($action=="users"){
			
			$db = new mysqli('localhost', 'root', 'usuariobchx13wmcorrf00208126m', 'knyx');			
			if(!$db->connect_error){
			
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
								<?php if(!isset($_SESSION["user"])){echo'<a href="login.php">Log in</a>';}else{echo'<a href="login.php?a=logout">Log out</a><a href="profile.php">Profile</a>';}	?>	
								<a href="rank.php">Ranking</a>								
								<a href="index.php#download">Download</a>
								<a href="index.php#statistics">View Statistics</a>	
								<a href="index.php#">Home</a>				
							</div>	
						</div>
						<div id="result-container">
							<div id="result">	
								<h1>Conected as <?=$_SESSION["user"];?></h1>
								<a href="admin.php?a=computers">Computers</a> - 
								<a href="admin.php?a=users"><b>USERS</b></a> - 
								<a href="admin.php?a=scores">Scores</a>
							</div>
							
							
				<?php
				$u=$_SESSION["user"];
				$result = $db->query("SELECT * FROM Users");	
				$cont = 1;			
				while($row = $result->fetch_assoc()){
					
					echo"<div id='score-item'>
							#$cont - <a href='result.php?id=".$row['name']."'><b>".$row['name']."</b>
							<a href='admin.php?a=users&b=del&m=".$row['name']."'><span class='right'>Delete</span></a>
						</div>";
					$cont++;
				}
				
				if($_GET['b']=="del"){					
					$mac=$_GET["m"];					
					$result = $db->query("DELETE FROM Users WHERE name='$mac'");
					header("Location: admin.php?a=users");
				}	
				
			}else{
				echo "Conecting to DB error.";
			}
		
		}else if($action=="scores"){
			
			$db = new mysqli('localhost', 'root', 'usuariobchx13wmcorrf00208126m', 'knyx');			
			if(!$db->connect_error){
			
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
								<?php if(!isset($_SESSION["user"])){echo'<a href="login.php">Log in</a>';}else{echo'<a href="login.php?a=logout">Log out</a><a href="profile.php">Profile</a>';}	?>	
								<a href="rank.php">Ranking</a>								
								<a href="index.php#download">Download</a>
								<a href="index.php#statistics">View Statistics</a>	
								<a href="index.php#">Home</a>				
							</div>	
						</div>
						<div id="result-container">
							<div id="result">	
								<h1>Conected as <?=$_SESSION["user"];?></h1>
								<a href="admin.php?a=computers">Computers</a> - 
								<a href="admin.php?a=users">Users</a> - 
								<a href="admin.php?a=scores"><b>SCORES</b></a>
							</div>
							
							
				<?php
				$u=$_SESSION["user"];
				$result = $db->query("SELECT * FROM Scores");	
				$cont = 1;			
				while($row = $result->fetch_assoc()){
					
					echo"<div id='score-item'>
							#$cont - <a href='result.php?id=".$row['id']."'><b>".$row['score']."</b>
							<a href='admin.php?a=scores&b=del&m=".$row['id']."'><span class='right'>Delete</span></a>
						</div>";
					$cont++;
				}
				
				if($_GET['b']=="del"){					
					$mac=$_GET["m"];					
					$result = $db->query("DELETE FROM Scores WHERE id='$mac'");
					header("Location: admin.php?a=scores");
				}				
				
			}else{
				echo "Conecting to DB error.";
			}
			
		}else{
			header("Location: admin.php");
		}
		
	}else{			
		header("Location: index.php");		
	}
?>