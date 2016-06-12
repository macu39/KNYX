
  google.charts.load("current", {packages:["corechart"]});
  google.charts.setOnLoadCallback(drawChart);
  function drawChart() {
	var data = google.visualization.arrayToDataTable(<?php echo getCoresRank();?>);

	var options = {
	  title: 'My Daily Activities',
	  is3D: true,
	};

	var chart = new google.visualization.PieChart(document.getElementById('cores'));
	chart.draw(data, options);
  }