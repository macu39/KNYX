<?php session_name("HOB"); session_start();
	
	if(isset($_SESSION["user"]) && $_SESSION["rights"]==1 ){
		
		$action = $_GET["a"];

		if($action == null){
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
								<a href="claim.php" class="right">Claim Computer</a>
							</div>
							
							
				<?php
				$u=$_SESSION["user"];
				$result = $db->query("SELECT * FROM Computers WHERE owner='$u'");	
				$cont = 1;			
				while($row = $result->fetch_assoc()){
					
					echo"<div id='score-item'>
							#$cont - <a href='result.php?id=".$row['mac']."'><b>".$row['cpu_model']."</b>
							<a href='profile.php?a=del&m=".$row['mac']."'><span class='right'>Delete</span></a>
						</div>";
					$cont++;
				}
				
			}else{
				echo "Conecting to DB error.";
			}
			
		}else if($action=="del"){
			
			$mac = $_GET["m"];
			$db = new mysqli('localhost', 'root', 'usuariobchx13wmcorrf00208126m', 'knyx');			
			if(!$db->connect_error){
			
				$result = $db->query("DELETE FROM Computers WHERE mac='$mac'");
				$result = $db->query("DELETE FROM Scores WHERE mac='$mac'");
				
			}						
			header("Location: profile.php");
			
		}else{
			header("Location: profile.php");
		}
	}else{			
		header("Location: index.php");		
	}
?>