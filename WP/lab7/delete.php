<?php
    // enable error display in page
    ini_set('display_errors',1);
    ini_set('display_startup_errors',1);
    error_reporting(-1);

    $host = "localhost";
    $user = "root";
    $pass = "root";
    $db = "cars";

    // Create connection
    $con = mysqli_connect($host, $user, $pass, $db);

    // Check connection
    if (mysqli_connect_errno($con)) {
            echo "Failed to connect to MySQL: " . mysqli_connect_error();
    }

    echo "Connected";
    echo "<br><br>";

    $id = $_POST['id'];

    $query = "delete from car where id=".$id;
    if ($con->query($query))
        echo "Success!";
    else
        echo mysqli_error($con);

    mysqli_close($con);
?>