<?php 
$host='localhost:3306';
    $user='wp_59ix4';
    $pass='91N_Ys2Huq';
    $dbName='wp_pkby0';
    
   
    $conn =new mysqli($host,$user,$pass,$dbName);

    if($conn-> connect_errno){
        die('Connect Error: '.$conn->connect_error);
    }

$s="select * from `edu_user`";
$r=$conn->query($s) or die("select error:".$conn-error);


while($re=$r->fetch_object()){

$s2="select * from Q03gSE3_users where user_login='$re->name'";
$r4=$conn->query($s2) or die("select error:".$conn-error);
$user=$r4->fetch_object();

$bu='[부서] '.$re->bu;
$gub='[직급] '.$re->gub;
$we='[직위] '.$re->we;
$jong='[직종] '.$re->jong;





$post="select * from `Q03gSE3_posts` where post_title='$bu'";
$r2=$conn->query($post) or die("select error:".$conn-error);
$re2=$r2->fetch_object();

$post2="select * from `Q03gSE3_posts` where post_title='$gub'";
$r22=$conn->query($post2) or die("select error:".$conn-error);
$re22=$r22->fetch_object();

$post22="select * from `Q03gSE3_posts` where post_title='$we'";
$r222=$conn->query($post22) or die("select error:".$conn-error);
$re222=$r222->fetch_object();

$post222="select * from `Q03gSE3_posts` where post_title='$jong'";
$r2222=$conn->query($post222) or die("select error:".$conn-error);
$re2222=$r2222->fetch_object();

$meta='learndash_group_users_'.$re2->ID;

$gub='learndash_group_users_'.$re22->ID;

$we='learndash_group_users_'.$re222->ID;

$jong='learndash_group_users_'.$re2222->ID;

$insert="insert into `Q03gSE3_usermeta` (`user_id`,`meta_key`,`meta_value`) values('$user->ID','$meta','$re2->ID')";
$r3=$conn->query($insert) or die("select error:".$conn-error);

$insert2="insert into `Q03gSE3_usermeta` (`user_id`,`meta_key`,`meta_value`) values('$user->ID','$gub','$re22->ID')";
$r32=$conn->query($insert2) or die("select error:".$conn-error);

$insert22="insert into `Q03gSE3_usermeta` (`user_id`,`meta_key`,`meta_value`) values('$user->ID','$we','$re222->ID')";
$r322=$conn->query($insert22) or die("select error:".$conn-error);


$insert222="insert into `Q03gSE3_usermeta` (`user_id`,`meta_key`,`meta_value`) values('$user->ID','$jong','$re2222->ID')";
$r3222=$conn->query($insert222) or die("select error:".$conn-error);


}

