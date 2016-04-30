<?php
require 'Config.php';

$result = array("Success");
$userName = $_POST['userName'];
$password = $_POST['password'];
$email = $_POST['email'];
$mobileNumber = $_POST['mobileNumber'];

//$con = mysqli_connect('mysql.hostinger.co.uk','u794725972_roti','0715894672roti','u794725972_zelda');
if (mysqli_connect_errno($con))
{
    echo "Failed to connect to MySQL: " . mysqli_connect_error();
}

$query = "INSERT INTO `user`(`name`, `password`, `email`, `mobile_number`) VALUES ('$userName','$password','$email','$mobileNumber')";
mysqli_query($con, $query);
mysqli_close($con);
echo "success";

?>