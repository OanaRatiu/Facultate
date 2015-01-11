<?php
    // enable error display in page
    ini_set('display_errors',1);
    ini_set('display_startup_errors',1);
    error_reporting(-1);

    // q is of form color blue (option searchby)
    $q = $_GET['q'];
    $result = (explode(" ", $q));

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

    if ($result[0] == 'all')
        $query = "SELECT * FROM car";
    else
        $query="SELECT * FROM car WHERE ".$result[0]."=\"".$result[1]."\";";
    $result = mysqli_query($con, $query);

    // check for error in query
    // $result will be false if the query failed
    if (!$result) {
        printf("Error: %s\n", mysqli_error($con));
        exit();
    }
 
    echo "<table id=\"table1\" border=\"1 solid black\">".
        "<tr>".
         "<th>Model</th>".
         "<th>Engine Power</th>".
         "<th>Fuel</th>".
         "<th>Price</th>".
         "<th>Color</th>".
         "<th>Age</th>".
         "<th width=40px></th>".
         "</tr>";
    // mysqli_assoc gives me a relational array (id->1, model->VW)
    while($row = mysqli_fetch_array($result, MYSQLI_ASSOC)){
        echo "<tr id=\"".$row['id']. "\" border=\"1 solid black\">";
        echo "<td>".$row['model']. "</td>";
        echo "<td>".$row['engine_power']. "</td>";
        echo "<td>".$row['fuel']."</td>";
        echo "<td>".$row['price']."</td>";
        echo "<td>".$row['color']."</td>";
        echo "<td>".$row['age']."</td>";
        echo "<td><input type=\"button\" id=\"delete".$row['id']."\" value=\"Delete row\" onclick=\"delete_row(".$row['id'].")\"><input type=\"button\" id=\"update".$row['id']."\" value=\"Update row\" onclick=\"update_row(this, ".$row['id'].")\"></td>";
        echo "</tr>";
        }
    echo "</table><br>";
    mysqli_close($con);
?>