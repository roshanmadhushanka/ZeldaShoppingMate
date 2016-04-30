<?php
/**
 * Created by PhpStorm.
 * User: User
 * Date: 4/23/2016
 * Time: 9:02 PM
 */
require 'Config.php';

//$userMobileNumber = $_POST['userMobileNumber'];
//$shopMobileNumber = $_POST['shopMobileNumber'];
//$amount = doubleval($_POST['amount']);

$userMobileNumber = "0715894672";
$shopMobileNumber = "0112291595";
$amount = doubleval("32250.00");

if (mysqli_connect_errno($con))
{
    echo "Failed to connect to MySQL: " . mysqli_connect_error();
}else {
    $query = "SELECT * FROM `payment_account` WHERE `user_mobile_number`='$userMobileNumber'";

    $temp_res = mysqli_query($con, $query);
    $user_data_arr = array();
    while ($row = mysqli_fetch_assoc($temp_res)) {
        $user_data_arr['id'] = $row['id'];
        $user_data_arr['user_mobile_number'] = $row['user_mobile_number'];
        $user_data_arr['balance'] = $row['balance'];
        $user_data_arr['pin'] = $row['pin'];
        break;
    }
    if($user_data_arr[balance] > $amount){
        echo "Success";
    }else{
        echo "Fail";
    }
}


