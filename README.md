## 版本
- MySQL：5.7
- Mycat-server-1.5.1-RELEASE

## mycat  一个数据库配置
### mycat server.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- - - Licensed under the Apache License, Version 2.0 (the "License"); 
	- you may not use this file except in compliance with the License. - You 
	may obtain a copy of the License at - - http://www.apache.org/licenses/LICENSE-2.0 
	- - Unless required by applicable law or agreed to in writing, software - 
	distributed under the License is distributed on an "AS IS" BASIS, - WITHOUT 
	WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. - See the 
	License for the specific language governing permissions and - limitations 
	under the License. -->
<!DOCTYPE mycat:server SYSTEM "server.dtd">
<mycat:server xmlns:mycat="http://org.opencloudb/">
	<system>
	<property name="defaultSqlParser">druidparser</property>
	<user name="root">
		<property name="password">123456</property>
		<property name="schemas">TESTDB</property>
	</user>

	<user name="user">
		<property name="password">user</property>
		<property name="schemas">TESTDB</property>
		<property name="readOnly">true</property>
	</user>
</mycat:server>
```
### mycat schema.xml

```xml
<?xml version="1.0"?>
<!DOCTYPE mycat:schema SYSTEM "schema.dtd">
<mycat:schema xmlns:mycat="http://org.opencloudb/" >

	<schema name="TESTDB" checkSQLschema="false" sqlMaxLimit="100">
		
		<table name="user" dataNode="dn4" rule="auto-sharding-long" />

	</schema>

	<dataNode name="dn4" dataHost="localhost4" database="db4" />
	
	<dataHost name="localhost4" maxCon="1000" minCon="10" balance="0"
		writeType="0" dbType="mysql" dbDriver="native" switchType="1"  slaveThreshold="100">
		<heartbeat>select user()</heartbeat>
			<writeHost host="hostM1" url="35.234.6.85:3306" user="root"
			password="123456">
		
		</writeHost>
		
	</dataHost>
	
</mycat:schema>
```

### mycat rule.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- - - Licensed under the Apache License, Version 2.0 (the "License"); 
	- you may not use this file except in compliance with the License. - You 
	may obtain a copy of the License at - - http://www.apache.org/licenses/LICENSE-2.0 
	- - Unless required by applicable law or agreed to in writing, software - 
	distributed under the License is distributed on an "AS IS" BASIS, - WITHOUT 
	WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. - See the 
	License for the specific language governing permissions and - limitations 
	under the License. -->
<!DOCTYPE mycat:rule SYSTEM "rule.dtd">
<mycat:rule xmlns:mycat="http://org.opencloudb/">
    <tableRule name="auto-sharding-long">
		<rule>
			<columns>user_id</columns>
			<algorithm>rang-long</algorithm>
		</rule>
	</tableRule>
</mycat:rule>

```