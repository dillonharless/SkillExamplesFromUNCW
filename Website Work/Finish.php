<?php
	session_start();
	require '../secure_conn.php';
	require 'includes/Header.php';
?>

<style>
.alert-warning {

padding: 185px;

}


</style>
	<div class= "alert-warning" role= "alert">

    <?php if (empty($_SESSION['cart_contents']) || !isset($_SESSION['cart_contents'])) {
        echo '<h2>There are no products in your cart.</h2>';
		echo '<h3>Please use the Shop link to shop.</h3>';
	} elseif (empty($_SESSION['email']) || !isset($_SESSION['email'])) { //user is not logged in ?>
		<h3>If you are a registered user, please log in using the link at the Top right</h3>
		<h3>Or choose one of the other options below</h3>
		<h3><a href='New_Customer.php'  class= "btn btn-primary">Register as a new user</a> or <a href='Address.php' class= "btn btn-primary">Continue checkout as a guest</a><h3>
	<?php }
	else  { //user logged in
		$firstName = $_SESSION['firstName']; //set at login ?>
		<h3>Hello <?php echo $firstName;?>,<br>
		<h3>Please choose one of the options below:</h3>
		<h3><a href='Shop_Index.php' class= "btn btn-warning">Keep Shopping</a> or <a href="View_Cart.php" class= "btn btn-primary">View Cart</a> or <a href='checkout.php?guest=no' class= "btn btn-success">Proceed to Checkout</a><h3>
	<?php } ?>

</div>
<?php include 'includes/Footer.php'; ?>
