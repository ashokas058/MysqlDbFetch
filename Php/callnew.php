<?php


$C_LOGID="dfff";
$C_DATE="dddd";
$C_TIME="dxs";
$C_MOBILE="ddd";
$C_GIOTAG="ddffs";
$SYSDATE="ddsfsd";


$host = 'localhost';
$user = 'id1247ddf';
$pass_db = 'lucifeaa';
$conn=mysqli_connect($host, $user, $pass_db,$user);

$dologin = "select id,pass from user where id = $id and pass = $pass ";
$insert=INSERT INTO `call_record`(`id`, `c-logid`, `c-date`, `c-time`, `c-giotag`, `c-number`, `c-sysdate`, `c-verified`) 
VALUES (null,$C_LOGID,$C_DATE,$C_TIME,$C_GIOTAG,$C_MOBILE,$SYSDATE,null);
if(mysqli_query($conn,$insert ))
echo "sucess";


?>