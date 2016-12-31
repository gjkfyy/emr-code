1、设置工程版本号，在cmd当前目录下执行下面这行命令，可以修改当前目录下pom中的版本号及所有工程下的pom版本号。
mvn versions:set -DnewVersion=2.1.10
		注意：开发使用版本号为x.x.x-SNAPSHOT，正式版版本号x.x.x
		
2、设置系统版本号，在pkuhit-app目录下执行下面这行命令，可以修改pkuhit-app中settings.properties和pkuhit.iih.ui中的package.json的版本号。
mvn package -P version
		注意：执行该条命令，只会修改build序号，而且是根据当前序号+1.
3、mvn package -P init
		
每次在版本测试完成后，更改版本号，并且提交。