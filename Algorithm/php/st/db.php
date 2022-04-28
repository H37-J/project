<?php

$host = 'localhost:3307';
$user = 'wp_vsaxm';
$pass = 'l0XNso9REQv5$?AB';
$dbName = 'wp_video_plugin';

$db = new mysqli($host, $user, $pass, $dbName);

if ($db) {
    var_dump('DB_CONNECTED');
} else {
    var_dump('NOT_CONNECTED');
}
$pre = 'qHUiZY_'; #Prefix Database
$arr = [];

$select = "SELECT * FROM ${pre}users";
$query_result = $db->query($select);
$count = $query_result->num_rows;

for ($i = 0; $i < $count; $i++) {
    $row = $query_result->fetch_object();
    $arr[$i] = $row;
}

var_dump($arr[0]->user_login);

$foo = array('bar' => 'baz');
#echo "Hello {$foo['bar']}!"; // Hello baz!