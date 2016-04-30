<?php
require 'Config.php';

$userName = $_POST['userName'];
$password = $_POST['password'];

//$con = mysqli_connect(db_host, db_user, db_password, db_database);
if (mysqli_connect_errno($con))
{
    echo "Failed to connect to MySQL: " . mysqli_connect_error();
}else {
    //User array
    $user_arr = array();
    $query = "SELECT * FROM `user` WHERE `name`='$userName' AND `password`='$password'";

    $temp_res = mysqli_query($con, $query);
    while ($row = mysqli_fetch_assoc($temp_res)) {
        $data_arr = array();
        $data_arr['id'] = $row['id'];
        $data_arr['name'] = $row['name'];
        $data_arr['password'] = $row['password'];
        $data_arr['email'] = $row['email'];
        $data_arr['mobile_number'] = $row['mobile_number'];
        $user_arr[] = $data_arr;
    }
    echo json_encode($user_arr);
}