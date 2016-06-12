<?php session_name("HOB"); session_start();
	
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
		<?php
		
		$result = $db->query("SELECT min(score) as score, mac, date FROM Scores GROUP BY mac ORDER BY score ASC");	
		$cont = 1;			
		while($row = $result->fetch_assoc()){
			
			echo"<div id='score-item'>
					<a href='result.php?id=".$row['mac']."'>#$cont</a> - <b>Score:</b> ".$row['score']." 
					<span class='right'><b>Date:</b> ".$row['date']."</span>
				</div>";
			$cont++;
		}
		
	}else{
		echo "Conecting to DB error.";
	}

?>