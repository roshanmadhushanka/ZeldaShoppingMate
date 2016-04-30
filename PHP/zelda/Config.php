<?php
    define('db_host', 'mysql.hostinger.co.uk');
    define('db_user', 'u794725972_roti');
    define('db_password', '0715894672roti');
    define('db_database', 'u794725972_zelda');

    $con = mysqli_init();
    mysqli_ssl_set($con,"key.pem","cert.pem","cacert.pem",NULL,NULL);
    mysqli_real_connect($con,db_host,db_user,db_password,db_database);