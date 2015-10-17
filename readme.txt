0. You need to run idlj to create the missing *.java files from CounterInterface.idl 
(that are expected to get created in corbaJavaGenerated.CounterCORBA)

To generate *.java files from IDL file CounterInterface.idl 
either assuming that you are in directory src/corba when you call idlj:

idlj -td ../ -pkgPrefix CounterCORBA corbaJavaGenerated -fall CounterInterface.idl


(If you use an IDE such as Eclipse, it might not be aware of file system changes,
and you need to press F5 after each idlj run to reread the file system.)

After that the *.java files should compile without problems.

To run:

1. Start CORBA middleware (the ORB) on all hosts:
orbd -ORBInitialPort 1050

2. Start server (adjust class path)
java -cp ./bin/ Server -ORBInitialPort 1050

3. Start client (adjust class path)
java -cp ./bin/ Client -ORBInitialPort 1050

