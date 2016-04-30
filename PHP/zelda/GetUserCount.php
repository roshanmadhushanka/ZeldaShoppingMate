<?php
require 'Config.php';

$userName = $_POST['userName'];
$password = $_POST['password'];

//$con = mysqli_connect(db_host, db_user, db_password, db_database);
if (mysqli_connect_errno($con))
{
    echo "Failed to connect to MySQL: " . mysqli_connect_error();
}else {
    $result_arr = array();
    $query = "SELECT `id` FROM `user`";

    $temp_res = mysqli_query($con, $query);
    $count = mysqli_num_rows($temp_res);
    $result_arr['count'] = $count;
    echo json_encode([$result_arr]);
}