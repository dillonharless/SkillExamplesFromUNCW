<?php $currentPage = basename($_SERVER['SCRIPT_FILENAME']); ?>

<!-- This creates the navigation bar across the top of the screen. -->

<nav class="navbar navbar-inverse navbar-fixed-top" style="background-color:#008080" >
<!-- <nav class="navbar navbar-light" style="background-color:#E15B5B" style="font-color:#E15B5B"> -->
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
      <a class="navbar-brand" href="#">
  <img src="images/Logo.png" width="150" height="120" class="d-inline-block align-top" alt="">
  Kyle's Art Gallery
</a>
			<!-- <a class="navbar-brand" href="Index.php">&copy; <b>Kyle Art Gallery</b></a> -->
			<!-- This presents options on the navigation bar for anyone who is not logged in -->
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-left">
				<li><a href="Index.php" <?php if ($currentPage == 'Index.php') {echo 'id="here"'; } ?>>Home</a></li>
				<li><a href="Shop_Index.php" <?php if ($currentPage == 'Shop_Index.php') {echo 'id="here"'; } ?>>Shop</a></li>
			</ul>
				<ul class="nav navbar-nav navbar-right">
				<li><a href="New_Customer.php" class="glyphicon glyphicon-user" <?php if($currentPage== 'New_Customer.php') {echo 'id="here"';} ?>></a></li>
				</ul>
				
				<!-- This presents extra options for a user that is logged in. -->
				<?php
							if(isset($_SESSION['email'])){ ?>
				<ul class="nav navbar-nav navbar-left">
				<li><a href="Orders.php" <?php if ($currentPage == 'Index.php') {echo 'id="here"'; } ?>>Orders</a></li>
				<li><a href="Shop_Index.php" <?php if ($currentPage == 'Shop_Index.php') {echo 'id="here"'; } ?>>Account</a></li>
				<li><a href="View_Cart.php" <?php if ($currentPage == 'Shop_Index.php') {echo 'id="here"'; } ?>>Cart</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
				<li><a href="Logged_Out.php" class="glyphicon glyphicon-eject"></a></li>
</ul>
				<?php }else {?>
					<ul class="nav navbar-nav navbar-right">
					<li><a href="Login.php" class="glyphicon glyphicon-off"<?php if($currentPage== 'Login.php') {echo 'id="here"';} ?>></a></li>
				</ul>
				<?php
			}

					?>



			<form action= "Search.php" method ="post" class="navbar-form navbar-right" >
				<input type="text" name="search_string" class="form-control" placeholder="Search...">
        <input type="Submit" class="form-control" name = "search" value ="search"/>
				<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
			</form>
		</div>
	</div>
</nav>

  </div>
