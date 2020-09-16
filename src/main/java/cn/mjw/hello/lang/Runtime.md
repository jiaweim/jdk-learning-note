
通过Java执行系统命令，与cmd中或者终端上一样执行shell命令，最典型的用法就是使用Runtime.getRuntime().exec(command)或者new ProcessBuilder(cmdArray).start()。让我们看看Runtime、ProcessBuilder的详细解析和详细用法。

## Runtime

Runtime类是Java程序的运行时环境。不能new出一个Runtime对象，只能通过getRuntime()方法获取当前Runtime运行时对象的引用。然后可以调用Runtime的方法查看和修改Java虚拟机的状态。

Runtime和ProcessBuilder的不同点就是，启动子进程时的命令形式不同，Runtime.getRuntime.exec() 可以把命令和参数写在一个String中，用空格分开，ProcessBuilder则是构造函数的参数中，传递一个由命令和参数组成的list或数组。

Runtime类主要的方法如下：

|方法|功能|
|---|---|
|exec(String command)|接收一个命令然后执行，通过该方法可以执行和 cmd 中用法一样的命令。比如，`Runtime.getRuntime().exec("ls")`，就和 cmd 中执行 ls 效果一样|
|freeMemory()|查看当前 JVm 内存中空闲内存|
|totalMemory()|查看当前 JVM 使用的总内存大小|
|maxMemory()|查看JVM 最终可以使用的最大内存|
|availableProcessors()|查看本机有多少处理器|
|exit(int)|退出当前 Java 程序的运行，System.exit(int) 方法就是调用 Runtime.exit(int) 退出运行的|



