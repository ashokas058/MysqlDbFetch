<?php


$C_LOGID=urldecode($_POST['C_LOGID']);
$C_DATE=urldecode($_POST['C_DATE']);
$C_TIME=urldecode($_POST['C_TIME']);
$C_MOBILE=urldecode($_POST['C_MOBILE']);
$C_GIOTAG=urldecode($_POST['C_GIOTAG']);
$SYSDATE=urldecode($_POST['SYSDATE']);


$host = 'localhost';
$user = 'id11297169_shome';
$pass_db = 'U6k#~U%Cs+}\szG)';
$conn=mysqli_connect($host, $user, $pass_db,$user);

$dologin = "select id,pass from user where id = $id and pass = $pass ";
$insert=INSERT INTO `call_record`(`id`, `c-logid`, `c-date`, `c-time`, `c-giotag`, `c-number`, `c-sysdate`, `c-verified`) 
VALUES (null,$C_LOGID,$C_DATE,$C_TIME,$C_GIOTAG,$C_MOBILE,$SYSDATE,null);
if(mysqli_query($conn,$insert ))
echo "sucess";


?>
