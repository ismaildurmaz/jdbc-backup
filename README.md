jdbc-backup
===========

JDBC Database Backup For MySQL, PostgreSQL, Oracle, SQL Server...

It is simple and fast. 

It has not been finished yet!! There can be bugs or improvements.

execute argument can be a file, network or console..

sample :

Backup backup = new Backup(connection);
print("Backup start time : " + new Date().toString());
backup.execute(System.out); 
print("Backup end time : " + new Date().toString());
