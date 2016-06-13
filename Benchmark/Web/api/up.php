<?php
	
	if($_POST["k"] == "12345678"){

		$values = $_POST["v"];
		
		list($cpu_vendor, $cpu_model, $cpu_freq, $cpu_cores, $ram, $hdd, $os, $os_version, $mac, $score) = split(";", $values, 10);
		
		$db = new mysqli('localhost', 'root', 'usuariobchx13wmcorrf00208126m', 'knyx');		
		
		if(!$db->connect_error){
		
			$result = $db->query("INSERT INTO Computers (cpu_vendor, cpu_model, cpu_frequency, cpu_cores, ram, hdd, os_name, os_version, mac, owner) VALUES ('$cpu_vendor', '$cpu_model', '$cpu_freq', '$cpu_cores', '$ram', '$hdd', '$os', '$os_version', '$mac', '')");
			
			if(!$result){ echo "Computer exists. "; }
			$date = date('Y-m-d');
			$result = $db->query("INSERT INTO Scores (mac, score, date) VALUES ('$mac', '$score', '$date')");
			
			if($result){
				echo "All done.";
			}else{
				echo "Unexpected error.";
			}
		}else{
			echo "Conecting to DB error.";
		}
		
	}else{
		
		echo"ACCESS DENIED.";
		
	}

?>