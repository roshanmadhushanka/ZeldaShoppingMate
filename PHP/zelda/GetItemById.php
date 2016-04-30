<?php

require 'Config.php';

$itemID = $_POST['itemID'];

if (mysqli_connect_errno($con))
{
    echo "Failed to connect to MySQL: " . mysqli_connect_error();
}else {
    //User array
    $query = "SELECT I.id, P.id AS product_id, I.status, P.name, P.description, P.price, P.type, P.quantity FROM `item` AS I LEFT JOIN `product` AS P ON I.product_id = P.id WHERE I.id='$itemID' AND I.status='U'";

    $temp_res = mysqli_query($con, $query);
    $data_arr = array();
    while ($row = mysqli_fetch_assoc($temp_res)) {
        $data_arr['id'] = $row['id'];
        $data_arr['productId'] = $row['product_id'];
        $data_arr['status'] = $row['status'];
        $data_arr['name'] = $row['name'];
        $data_arr['description'] = $row['description'];
        $data_arr['price'] = $row['price'];
        $data_arr['type'] = $row['type'];
        $data_arr['quantity'] = $row['quantity'];
        break;
    }
    echo json_encode($data_arr);
}