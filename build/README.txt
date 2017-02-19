首先需要修改manifest.json中IIH_IEMR的配置，指向本机pkuhit.iih.ui工程所在目录；
修改pom.xml的modules配置，仅保留pkuhit.iih.ui即可。

1）安装git工具
http://172.18.65.157/software/Git-1.9.4-preview20140611.exe

2）启动Git Bash命令行
在开始菜单找到Git/Git Bash，单击打开

3）安装node.js
以下网址选择合适的安装包：
http://www.nodejs.org/download/
当安装完毕node.js后，可以在Git Bash里运行node命令

4）安装npm
4.1）下载脚本http://172.18.65.157/install.sh
4.2）在Git Bash里运行install.sh完成npm安装

或者
node "C:\Program Files\nodejs\node_modules\npm\cli.js" install npm -g

5）下载ExtJS的打包工具，并安装：
http://172.18.65.157/software/SenchaCmd-4.0.4.84-windows.exe.zip

6）安装clean-css
//6.1）npm install clean-css -g
6.2）运行以下命令找到npm的prefix配置
npm config ls -l | grep prefix
结果：
...
prefix = "C:\\Users\\user\\AppData\\Roaming\\npm"
...
6.3）设置环境变量NODE_PATH（目的是可以在代码中引用到安装的clean-css模块）
//export NODE_PATH=/c/Users/dell/AppData/Roaming/npm/node_modules
 //          C:/Users/li_zheng/AppData/Roaming/npm/node_modules
7）安装bower
npm -g install bower

8）利用bower下载代码依赖
8.1）cd进入build目录
//8.2）bower install xap.ej#develop
bower cache clean

9）打包Javascript和css
node run.js package IIH_IEMR --css(说明：在pkuhit-all\pkuhit.iih.ui\test目录下生成iih_iemr.js。打开iih_iemr.js，需要将Xap.ej.element.MessageBox.MessageBox组件的代码移到js文件的最后面。)
mvn package -DskipTests（说明：在pkuhit-all\pkuhit.iih.ui\target目录下生成pkuhit.iih.ui-0.1-SNAPSHOT-bin.zip）


替换补充的 jar 文件


以下无用


iihsrc\pkuhit\pkuhit-all\pkuhit-app目录下执行mvn clean -P reset install -P init
