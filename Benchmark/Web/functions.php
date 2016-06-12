<?php

	$db = new mysqli('localhost', 'root', 'usuariobchx13wmcorrf00208126m', 'knyx');

	function getCoresAVG(){
		
		global $db;
		$result = $db->query("SELECT AVG(cpu_cores) as cpu_cores FROM Computers");		
		$result = $result->fetch_assoc();
		$cores = round($result['cpu_cores']);
		return $cores;
		
	}
		
	function getFreqAVG(){
		
		global $db;
		$result = $db->query("SELECT AVG(cpu_frequency) as cpu_frequency FROM Computers");
		$result = $result->fetch_assoc();
		$freq = round($result['cpu_frequency']/1000, 2);
		return $freq;
		
	}
	
	function getRamAVG(){
		
		global $db;
		$result = $db->query("SELECT AVG(ram) as ram FROM Computers");
		$result = $result->fetch_assoc();
		$ram = round($result['ram']/1000,2);
		return $ram;
		
	}
	
	function getHddAVG(){
		
		global $db;
		$result = $db->query("SELECT AVG(hdd) as hdd FROM Computers");
		$result = $result->fetch_assoc();
		$hdd = round($result['hdd']);
		return $hdd;
		
	}
	
	function getCpuModelRank(){
		
		global $db;
		$result = $db->query("SELECT cpu_model, count(id) as count FROM Computers GROUP BY cpu_model");
		$rank;
		for($i = 0; $row = $result->fetch_assoc(); $i++) {			
			$rank[$i][0]=$row["cpu_model"];
			$rank[$i][1]=$row["count"];
		}		
		return $rank;
		
	}
	
	function getVendorRank(){
		
		global $db;
		$result = $db->query("SELECT cpu_vendor, count(id) as count FROM Computers GROUP BY cpu_vendor");
		for($i = 0; $row = $result->fetch_assoc(); $i++) {			
			$rank[$i][0]=$row["cpu_vendor"];
			$rank[$i][1]=$row["count"];
		}		
		return $rank;		
		
	}
	
	function getOsNameRank(){
		
		global $db;
		$result = $db->query("SELECT os_name, count(id) as count FROM Computers GROUP BY os_name");
		$rank;
		for($i = 0; $row = $result->fetch_assoc(); $i++) {			
			$rank[$i][0]=$row["os_name"];
			$rank[$i][1]=$row["count"];
		}		
		return $rank;		
		
	}
	
	function getOsVersionRank(){
		
		global $db;
		$result = $db->query("SELECT os_version, count(id) as count FROM Computers GROUP BY os_version");
		$rank;
		for($i = 0; $row = $result->fetch_assoc(); $i++) {			
			$rank[$i][0]=$row["os_version"];
			$rank[$i][1]=$row["count"];
		}		
		return $rank;		
		
	}
	
	function getCoresRank(){
		
		global $db;
		$result = $db->query("SELECT cpu_cores, count(id) as count FROM Computers GROUP BY cpu_cores");
		for($i = 0; $row = $result->fetch_assoc(); $i++) {			
			$rank[$i][0]=$row["cpu_cores"]." cores";
			$rank[$i][1]=$row["count"];
		}
		return $rank;
		
	}	
 

?>