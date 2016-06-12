<?php session_name("HOB"); session_start();
	
	if(isset($_GET["id"]) && $_GET["id"]!=null){
		$mac = $_GET["id"];
		$db = new mysqli('localhost', 'root', 'usuariobchx13wmcorrf00208126m', 'knyx');			
		if(!$db->connect_error){
		
			$result = $db->query("SELECT * FROM Computers WHERE mac='$mac'");
			$row = $result->fetch_assoc();
		
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
							<img src="img/intel.png"><br>
							<b>CPU Model: </b><?=$row["cpu_model"];?><br><br>
							<b>CPU Frequency: </b><?=$row["cpu_frequency"];?> Mhz<br><br>
							<b>CPU Cores: </b><?=$row["cpu_cores"];?> cores<br><br>
							<b>RAM: </b><?=$row["ram"];?> MB<br><br>
							<b>HDD: </b><?=$row["hdd"];?> GB<br><br>
							<b>OS: </b><?=$row["os_version"];?><br>
							<a href="claim.php" class="right">Claim this computer</a>
						</div>
						
						
			<?php
			
			$result = $db->query("SELECT * FROM Scores WHERE mac='$mac' ORDER BY date");	
			$cont = 1;			
			while($row = $result->fetch_assoc()){
				
				echo"<div id='score-item'>
						#$cont - <b>Score:</b> ".$row['score']." 
						<span class='right'><b>Date:</b> ".$row['date']."</span>
					</div>";
				$cont++;
			}
			
			//Implementar posicion en el rank si da tiempo
			
		}else{
			echo "Conecting to DB error.";
		}
		
	}else{
		
		header("Location: index.php");
		
	}

?>