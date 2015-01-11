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
    $model = $_POST['model'];
    $engine_power = $_POST['engine_power'];
    $fuel = $_POST['fuel'];
    $price = $_POST['price'];
    $color = $_POST['color'];
    $age = $_POST['age'];

    $query_del = "delete from car where id=".$id;


    $query_update = "update car set ".
                    " model='".$model.
                    "', engine_power='".$engine_power.
                    "', fuel='".$fuel.
                    "', price=".$price.
                    ", color='".$color.
                    "', age=".$age.
                    " where id=".$id;
    /*if ($con->query($query_del))
        echo "Success!";
    else
        echo mysqli_error($con);
    $query = "insert into car values (".
             $id.", \"".$model."\", \"".
             $engine_power."\", \"".
             $fuel."\", ".
             $price.", \"".
             $color."\", ".
             $age.")";*/
    if ($con->query($query_update))
        echo "Success!";
    else
        echo mysqli_error($con);

    mysqli_close($con);
?>