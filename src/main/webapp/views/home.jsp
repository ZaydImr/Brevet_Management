<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col border rounded-3 p-4 mx-2">
		<h5>Invention par domaine</h5>
		<canvas id="barChart"></canvas>
	</div>
	<div class="col border rounded-3 p-4 mx-2">
		<h5>Invention par entreprise</h5>
		<canvas id="pieChart" ></canvas>
	</div>
</div>
<div class="row border rounded-3 p-4 mx-0 mt-4">
	<canvas id="lineChart"></canvas>
</div>


<script type="text/javascript" src="https://mdbcdn.b-cdn.net/wp-content/themes/mdbootstrap4/docs-app/js/bundles/4.20.0/compiled.min.js"></script>



<script>
	var ctxP = document.getElementById("pieChart").getContext('2d');
	var myPieChart = new Chart(ctxP, {
	  type: 'pie',
	  data: {
	    labels: [<c:forEach items="${inventionByEntreprise }" var="keyValue">"${keyValue.key}",</c:forEach>],
	    datasets: [{
	      data: [<c:forEach items="${inventionByEntreprise }" var="keyValue">${keyValue.value},</c:forEach>],
	      backgroundColor: ["#F7464A", "#46BFBD", "#FDB45C", "#949FB1", "#4D5360","#003f5c","#58508d","#bc5090","#ff6361","#ffa600","#004c6d","#de425b","#5383a1","#e9af86"],
	      hoverBackgroundColor: ["#FF5A5E", "#5AD3D1", "#FFC870", "#A8B3C5", "#616774"]
	    }]
	  },
	  options: {
	    responsive: true
	  }
	});
	
	//bar
	var ctxB = document.getElementById("barChart").getContext('2d');
	var myBarChart = new Chart(ctxB, {
	  type: 'bar',
	  data: {
	    labels: [<c:forEach items="${inventionByDomaine }" var="keyValue">"${keyValue.key}",</c:forEach>],
	    datasets: [{
	      label: '# of Votes',
	      data: [<c:forEach items="${inventionByDomaine }" var="keyValue">${keyValue.value},</c:forEach>],
	      backgroundColor: [
	        'rgba(255, 99, 132, 0.2)',
	        'rgba(54, 162, 235, 0.2)',
	        'rgba(255, 206, 86, 0.2)',
	        'rgba(75, 192, 192, 0.2)',
	        'rgba(153, 102, 255, 0.2)',
	        'rgba(255, 159, 64, 0.2)'
	      ],
	      borderColor: [
	        'rgba(255,99,132,1)',
	        'rgba(54, 162, 235, 1)',
	        'rgba(255, 206, 86, 1)',
	        'rgba(75, 192, 192, 1)',
	        'rgba(153, 102, 255, 1)',
	        'rgba(255, 159, 64, 1)'
	      ],
	      borderWidth: 1
	    }]
	  },
	  options: {
	    scales: {
	      yAxes: [{
	        ticks: {
	          beginAtZero: true
	        }
	      }]
	    }
	  }
	});
</script>

<script>
	//line
	var ctxL = document.getElementById("lineChart").getContext('2d');
	var myLineChart = new Chart(ctxL, {
	  type: 'line',
	  data: {
	    labels: ["January", "February", "March", "April", "May", "June", "July"],
	    datasets: [{
	      label: "My First dataset",
	      data: [65, 59, 80, 81, 56, 55, 40],
	      backgroundColor: [
	        'rgba(105, 0, 132, .2)',
	      ],
	      borderColor: [
	        'rgba(200, 99, 132, .7)',
	      ],
	      borderWidth: 2
	    },
	    {
	      label: "My Second dataset",
	      data: [28, 48, 40, 19, 86, 27, 90],
	      backgroundColor: [
	        'rgba(0, 137, 132, .2)',
	      ],
	      borderColor: [
	        'rgba(0, 10, 130, .7)',
	      ],
	      borderWidth: 2
	    }
	    ]
	  },
	  options: {
	    responsive: true
	  }
	});
</script>