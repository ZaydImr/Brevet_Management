<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Brevet</title>
	<!-- bootstrap 5 css -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous" />
  <!-- BOX ICONS CSS-->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <style>
  	* {
	  margin: 0;
	  padding: 0;
	  box-sizing: border-box;
	}
	
	body {
	  min-height: 100vh;
	  background-color: #fff;
	}
	
	.side-navbar {
	  width: 250px;
	  height: 100%;
	  position: fixed;
	  margin-left: -300px;
	  background-color: #100901;
	  transition: 0.5s;
	}
	
	.nav-link:active,
	.nav-link:focus,
	.nav-link:hover {
	  background-color: #fff;
	}
	
	.nav-link{
		color: white;
	}
	
	.nav-link i {
		width: 1rem;
		text-align: center;
	}
	
	.my-container {
	  transition: 0.4s;
	}
	
	.active-nav {
	  margin-left: 0;
	}
	
	/* for main section */
	.active-cont {
	  margin-left: 250px;
	}
	
	#menu-btn {
	  background-color: #100901;
	  color: #fff;
	  margin-left: -62px;
	}
	
	.my-container input {
	  border-radius: 2rem;
	  padding: 2px 20px;
	}
	  	
  </style>
</head>
<body>
	 <!-- Side-Nav -->
	  <div class="side-navbar active-nav d-flex justify-content-between flex-wrap flex-column" id="sidebar">
	    <ul class="nav flex-column text-white w-100">
	      <p class="h3 text-white m-2 p-2">
	        Brevet <br/> management
	      </p>
	      <a href="<%= request.getContextPath() %>/" class="nav-link">
	        <i class="fa-solid fa-chart-line"></i>
	        <span class="mx-2">Home</span>
	      </a>
	      <a href="<%= request.getContextPath() %>/domaine" class="nav-link">
	       	<i class="fa-solid fa-qrcode"></i>
	        <span class="mx-2">Domaine</span>
	      </a>
	      <a href="<%= request.getContextPath() %>/entreprise" class="nav-link">
	        <i class="fa-solid fa-building"></i>
	        <span class="mx-2">Entreprise</span>
	      </a>
	      <a href="<%= request.getContextPath() %>/inventeur" class="nav-link">
	        <i class="fa-solid fa-people-group"></i>
	        <span class="mx-2">Inventeur</span>
	      </a>
	      <a href="<%= request.getContextPath() %>/invention" class="nav-link">
	        <i class="fa-solid fa-building"></i>
	        <span class="mx-2">Invention</span>
	      </a>
	      <a href="<%= request.getContextPath() %>/brevet" class="nav-link">
	        <i class="fa-solid fa-certificate"></i>
	        <span class="mx-2">Brevet</span>
	      </a>
	    </ul>
	
	    <span href="#" class="nav-link h4 w-100 mb-5">
	      <a href=""><i class="bx bxl-instagram-alt text-white"></i></a>
	      <a href=""><i class="bx bxl-twitter px-2 text-white"></i></a>
	      <a href=""><i class="bx bxl-facebook text-white"></i></a>
	    </span>
	  </div>
	<main class="p-1 my-container active-cont">
		<!-- Top Nav -->
	    <nav class="navbar top-navbar navbar-light bg-light px-5">
	      <a class="btn border-0" id="menu-btn"><i class="fa-solid fa-bars"></i></a>
	    </nav>
		<jsp:include page="${page }"></jsp:include>
	</main>
</body>
<script type="text/javascript">
var menu_btn = document.querySelector("#menu-btn");
var sidebar = document.querySelector("#sidebar");
var container = document.querySelector(".my-container");
menu_btn.addEventListener("click", () => {
  sidebar.classList.toggle("active-nav");
  container.classList.toggle("active-cont");
});
</script>
</html>