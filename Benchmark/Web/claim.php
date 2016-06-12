<?php session_name("HOB"); session_start();
	
	if(isset($_SESSION["user"]) && $_SESSION["rights"]==1){
		
		$action = $_GET["id"];

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
							<h1>Claim Computer</h1>
							<form action="claim.php?a=claim" method="get">
								<b>Insert the PCID given by the benchmark app<br> </b> <input type="text" name="id" placeholder="PCID" required>
								<input type="submit" value="Claim">
							</form>	
						</div>
			<?php
			if(isset($_SESSION["error"])){ echo $_SESSION["error"]; unset($_SESSION["error"]);}
			
		}else{
			
			$db = new mysqli('localhost', 'root', 'usuariobchx13wmcorrf00208126m', 'knyx');			
			if(!$db->connect_error){
			
				$user= $_SESSION["user"];
				$result = $db->query("UPDATE Computers SET owner='$user' WHERE mac='$action'");
			
				if($result){
					header("Location: profile.php");
				}else{
					$_SESSION["error"]="<span class='error'>Incorrect PCID.</span>";
					header("Location: claim.php");
				}	
				
			}
		}
		
	}else{			
		header("Location: login.php");		
	}
?>