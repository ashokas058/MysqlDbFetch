
<?php





$host = 'localhost';
$user = 'id11297169_shome';
$pass_db = 'U6k#~U%Cs+}\szG)';
$conn=mysqli_connect($host, $user, $pass_db,$user);
$sql_tst = "SELECT * FROM person";
$result=mysqli_query($conn,$sql_tst );

        echo json_encode(($result -> fetch_all(MYSQLI_ASSOC))); 
                
            
                
    
   




       
    
  
 
// Close connection
?>