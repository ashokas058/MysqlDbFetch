<?php


$C_NAME=urldecode($_POST['C_NAME']);
$C_EMAIL=urldecode($_POST['C_EMAIL']);
$C_COLLEGE=urldecode($_POST['C_COLLEGE']);

$host = 'localhost';
$user = 'id117169';
$pass_db = 'U6k#';
$conn=mysqli_connect($host, $user, $pass_db,$user);

$dologin = "select id,pass from user where id = $id and pass = $pass ";
$insert=INSERT INTO `Person`(`id`, `name`, `email`, `college`)VALUES (null,$C_NAME,$C_EMAIL,$C_COLLEE);
if(mysqli_query($conn,$insert ))
echo "sucess";


?>
