<?php

require 'Config.php';

$itemID = $_POST['itemID'];

//$con = mysqli_connect(db_host, db_user, db_password, db_database);
if (mysqli_connect_errno($con))
{
    echo "Failed to connect to MySQL: " . mysqli_connect_error();
}else {
    $query = "SELECT `status` FROM `item` WHERE `id`='$itemID'";
    $temp_res = mysqli_query($con, $query);
    $data = "";
    while ($row = mysqli_fetch_assoc($temp_res)) {
        $data = $row['status'];
    }
    echo $data;
}