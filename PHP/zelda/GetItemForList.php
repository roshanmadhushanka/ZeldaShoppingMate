<?php

require 'Config.php';

$itemID = $_POST['itemID'];

//$con = mysqli_connect(db_host, db_user, db_password, db_database);
if (mysqli_connect_errno($con))
{
    echo "Failed to connect to MySQL: " . mysqli_connect_error();
}else {
    //User array
    $item_arr = array();
    $query = "SELECT I.id, P.id AS product_id, P.name, P.description, P.price, P.type, P.quantity FROM `item` AS I LEFT JOIN `product` AS P ON I.product_id = P.id WHERE I.id='$itemID' AND I.status='U'";

    $temp_res = mysqli_query($con, $query);
    while ($row = mysqli_fetch_assoc($temp_res)) {
        $data_arr = array();
        $data_arr['id'] = $row['id'];
        $data_arr['productId'] = $row['product_id'];
        $data_arr['name'] = $row['name'];
        $data_arr['description'] = $row['description'];
        $data_arr['price'] = $row['price'];
        $data_arr['type'] = $row['type'];
        $data_arr['quantity'] = $row['quantity'];
        $item_arr[] = $data_arr;
    }
    echo json_encode($item_arr);
}