<?php include("functions.php"); session_name("HOB"); session_start();?>

<html>
	<head>
		<title>KNYX - Computer Becnhmark</title>
		<link rel="icon" type="image/png" href="img/favicon-96x96.png" sizes="96x96">
		<link rel="stylesheet" href="css/style.css">
		<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,800,700,300' rel='stylesheet' type='text/css'>
	</head>
	<body>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>	
		<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>		
		<iframe id="you" src="https://www.youtube.com/embed/sT9R34SRvGQ?autoplay=1&controls=0&showinfo=0&iv_load_policy=3&rel=0&loop=1"></iframe>
		<div id="home-background"></div>
		<div id="header-container">
			<img src="img/logo-home.png"><br><br>
			<h1>EXPECT THE UNEXPECTED</h1><br>
			<h2>BENCHMARK YOUR COMPUTER</h2>
		</div>
		<div id="down"><a href="#statistics"><img src="img/down.png"></a></div>
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
				<a href="#download">Download</a>
				<a href="#statistics">View Statistics</a>
				<a href="http://demo.ckan.org/dataset/knyx">Open Data</a>		
				<a href="#">Home</a>				
			</div>	
		</div>
		<div id="statistics">
			<h1>View Statistics</h1>
			<div id="stat-container">
				<div id="stat-box">
					<div id="stat">
						<div id="stat-text"><?php echo getCoresAVG();?></div>
						<div id="stat-legend">Cores</div>
						<h3>CPU Cores AVG</h3>
					</div>
				</div>	
				<div id="stat-box">
					<div id="stat">						
						<div id="stat-text"><?php echo getFreqAVG();?></div>
						<div id="stat-legend">Ghz</div>
						<h3>CPU Frequency AVG</h3>
					</div>
				</div>	
				<div id="stat-box">
					<div id="stat">						
						<div id="stat-text"><?php echo getRamAVG();?></div>
						<div id="stat-legend">GB</div>
						<h3>RAM AVG</h3>
					</div>
				</div>		
				<div id="stat-box">
					<div id="stat">						
						<div id="stat-text"><?php echo getHddAVG();?></div>
						<div id="stat-legend">GB</div>
						<h3>HDD AVG</h3>
					</div>
				</div>		
				<div id="stat-box">
					<div id="stat">						
						<div id="cores"></div>
						<div id="stat-legend1">CPU Cores</div>
					</div>
				</div>	
				<div id="stat-box">
					<div id="stat">						
						<div id="vendor"></div>
						<div id="stat-legend1">CPU Vendors</div>
					</div>
				</div>	
				<div id="stat-box">
					<div id="stat">						
						<div id="name"></div>
						<div id="stat-legend1">CPU Model</div>
					</div>
				</div>	
				<div id="stat-box">
					<div id="stat">						
						<div id="os"></div>
						<div id="stat-legend1">Operative Systems</div>
					</div>
				</div>	
				<div id="stat-box">
					<div id="stat">
						<div id="osv"></div>
						<div id="stat-legend1">OS Versions</div>
					</div>
				</div>		
			</div>
		</div>
		<div id="download">
			<h1>Download</h1>
			<div id="download-img"><img src="img/download.png" width="100%"></div>
			<a href="downloads/knyx.zip">
				<div id="download-btn">
					<h3>Download</h3>
				</div>
			</a>
			Version 1.0.0 - Windows Mac and Linux suported.<br>
			<a href="">Java 8 is required.</a>
		</div>
		<script>
			function getMobileOperatingSystem() {
			  var userAgent = navigator.userAgent || navigator.vendor || window.opera;

			  if( userAgent.match( /iPad/i ) || userAgent.match( /iPhone/i ) || userAgent.match( /iPod/i ) )
			  {
				return 'iOS';

			  }
			  else if( userAgent.match( /Android/i ) )
			  {

				return 'Android';
			  }
			  else
			  {
				return 'unknown';
			  }
			}
			if(getMobileOperatingSystem()=='iOS' || getMobileOperatingSystem()=='Android'){			
				document.getElementById("home-background").style.backgroundImage = 'url(img/bg.jpg)';
				document.getElementById("you").style.visibility = "hidden";				
			}else{			
				$( document ).ready(function() {
					$('#header-container').fadeIn('fast').delay(3000).fadeOut('slow');
				});
			}
		</script>	
		
		<script type="text/javascript">
		  google.charts.load("current", {packages:["corechart"]});
		  google.charts.setOnLoadCallback(drawChart);
		  function drawChart() {
			var data = new google.visualization.DataTable();
			data.addColumn('string', 'Year');
			data.addColumn('number', 'Balance');
			data.addRows([<?php
							$values = getCoresRank(); $countArrayLength = count($values);
							for($i=0;$i<$countArrayLength;$i++){ echo "['" . $values[$i][0] . "'," . $values[$i][1] . "],"; } 
							?>
						]);
			var options = {
			  is3D: true,
			  legend: 'none',
			  backgroundColor: '#96110d'
			};
			var chart = new google.visualization.PieChart(document.getElementById('cores'));
			chart.draw(data, options);
			
			var data = new google.visualization.DataTable();
			data.addColumn('string', 'Year');
			data.addColumn('number', 'Balance');
			data.addRows([<?php
							$values = getVendorRank(); $countArrayLength = count($values);
							for($i=0;$i<$countArrayLength;$i++){ echo "['" . $values[$i][0] . "'," . $values[$i][1] . "],"; } 
							?>
						]);
			var chart = new google.visualization.PieChart(document.getElementById('vendor'));
			chart.draw(data, options);			
			
			var data = new google.visualization.DataTable();
			data.addColumn('string', 'Year');
			data.addColumn('number', 'Balance');
			data.addRows([<?php
							$values = getCpuModelRank(); $countArrayLength = count($values);
							for($i=0;$i<$countArrayLength;$i++){ echo "['" . $values[$i][0] . "'," . $values[$i][1] . "],"; } 
							?>
						]);
			var chart = new google.visualization.PieChart(document.getElementById('name'));
			chart.draw(data, options);
			
			var data = new google.visualization.DataTable();
			data.addColumn('string', 'Year');
			data.addColumn('number', 'Balance');
			data.addRows([<?php
							$values = getOsNameRank(); $countArrayLength = count($values);
							for($i=0;$i<$countArrayLength;$i++){ echo "['" . $values[$i][0] . "'," . $values[$i][1] . "],"; } 
							?>
						]);
			var chart = new google.visualization.PieChart(document.getElementById('os'));
			chart.draw(data, options);
			
			var data = new google.visualization.DataTable();
			data.addColumn('string', 'Year');
			data.addColumn('number', 'Balance');
			data.addRows([<?php
							$values = getOsVersionRank(); $countArrayLength = count($values);
							for($i=0;$i<$countArrayLength;$i++){ echo "['" . $values[$i][0] . "'," . $values[$i][1] . "],"; } 
							?>
						]);
			var chart = new google.visualization.PieChart(document.getElementById('osv'));
			chart.draw(data, options);
		  }
		</script>
		
	</body>
</html>