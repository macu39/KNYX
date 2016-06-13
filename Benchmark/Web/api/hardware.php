<?php
		
	$conn = mysql_connect('localhost', 'root', 'usuariobchx13wmcorrf00208126m');
	$db = mysql_select_db('knyx',$conn);
	
	$sql = "SELECT * FROM Computers";
	$rec = mysql_query($sql) or die (mysql_error());
	
	$num_fields = mysql_num_fields($rec);		
	$header="";
	
	for($i = 0; $i < $num_fields; $i++ ){
		$header .= mysql_field_name($rec,$i).",";
	}
	
	while($row = mysql_fetch_row($rec)){
		
		$line = '';
		foreach($row as $value){      
		
			if((!isset($value)) || ($value == "")){
				$value = "";					
			}else{
				$value = str_replace( '"' , '""' , $value ).",";
			}
			$line .= $value;
		}
		$data .=$line."\n";
		
	}
	
	$data = str_replace("\\r" , "" , $data);
	
	if ($data == ""){
		$data = "\n No Record Found! \n ";                        
	}
	
	header("Content-type: application/octet-stream");
	header("Content-Disposition: attachment; filename=reports.csv");
	header("Pragma: no-cache");
	header("Expires: 0");
	print "$header \n $data";
	
?>