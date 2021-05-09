# MysqlDbFetch
For fetching MySQL table data to Android -Simple Example 
<br/>
[Project Main Directory](https://github.com/ashokas058/MysqlDbFetch/tree/master/app/src/main/java/com/ashokas/userprofileui)
<br/>
[PHPFile-INSERT](https://github.com/ashokas058/MysqlDbFetch/blob/master/Php/PhpInsert.php)
<br/>
[PHPFile -RCV](https://github.com/ashokas058/MysqlDbFetch/blob/master/Php/phpselect.php)
<hr/>
It having two class AsynSend and AsynRcv.
<br/>
Both class extends By AsyncTask class of Android .So that the task will perform in seperate thread.
UI wont afected.
<br/>
one for sending data to the (youweb.com/insert.php ) MysqlDb.
<br/>
AsynRcv will receive JSON_Response and converted it to **JsonArray>jsonObject>ModelObject(Person-project)> finally ArrayList<Person>.**
 <br/>
**Currently the Ui will receive one object value on textView as configured**
 
  <br/>
  Works over WAN network.
   <br/>
  Protocol- https
  <hr/>
  
   <p align="center">
<img  src="https://github.com/ashokas058/MysqlDbFetch/blob/master/Screenshot/personModel_table.png"
  alt="Home UI">
</p>
  
  <p align="center">
<img width="160" src="https://github.com/ashokas058/MysqlDbFetch/blob/master/Screenshot/Screenshot_2021-05-09-03-33-23-483_com.ashokas.userprofileui.jpg"
  alt="Home UI">
</p>
