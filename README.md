# MysqlDbFetch
For fetching MySQL table data to JSON . It having two class AsynSend and AsynRcv
.one for sending data to the (youweb.com/insert.php ) MysqlDb hosted remotely-WAN.
AsynRcv will receive web response and converted to JsonArray>jsonObject>ModelObject(Person-project)> finally ArrayList<Person>.
currently the Ui will receive one object value on textView as configured.
