<?php
//DB details
$dbHost = '127.0.0.1';
$dbUsername = 'drh4179';
$dbPassword = '81oMEp4GG';
$dbName = 'narayan11';

//Create connection and select DB
$db = new mysqli($dbHost, $dbUsername, $dbPassword, $dbName);

if ($db->connect_error) {
    die("Unable to connect database: " . $db->connect_error);
}
?>
