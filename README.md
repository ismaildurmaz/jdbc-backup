jdbc-backup
===========

JDBC Database Backup For MySQL, PostgreSQL, Oracle, SQL Server...

It is simple and fast. 

It has not been finished yet!! There can be bugs or improvements.

execute argument can be a file, network or console..

For Maven
<repositories>
  <repository>
    <id>jdbc-backup</id>
	  <url>https://github.com/ismaildurmaz/jdbc-backup</url>
  </repository>
</repositories>

<dependencies>
  <dependency>
	  <groupId>com.intenum</groupId>
	  <artifactId>jdbc-backup</artifactId>
	  <version>0.0.1</version>
  </dependency>
</dependencies>

sample :

Backup backup = new Backup(connection);
print("Backup start time : " + new Date().toString());
backup.execute(System.out); 
print("Backup end time : " + new Date().toString());
