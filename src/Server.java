import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import Objects.Counter;
import corbaJavaGenerated.CounterCORBA.CounterInterface;
import corbaJavaGenerated.CounterCORBA.CounterInterfaceHelper;

public class Server {
	public static void main(String args[]){
		try{
//			ORB orb = ORB.init(args, null);
//			POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
//			rootpoa.the_POAManager().activate();
//			
//			Counter counter = new Counter();
//			org.omg.CORBA.Object ref = rootpoa.servant_to_reference(counter);
			
			ORB orb = ORB.init(args, null); // create and initialize the ORB

			// get reference to rootpoa, cast it to POA type & activate the
			// POAManager
			POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootpoa.the_POAManager().activate();

			// create servant
			Counter counter = new Counter();
			
			// get object reference from the servant and cast it to
			// HelloInterface type
			org.omg.CORBA.Object ref = rootpoa.servant_to_reference(counter);
			CounterInterface href = CounterInterfaceHelper.narrow(ref);

			// get the root naming context
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			// Cast to and use NamingContextExt which is part of the
			// Interoperable
			// Naming Service (INS) specification.
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

			// bind the Object Reference in Naming
			String serviceName = "Counter";
			NameComponent path[] = ncRef.to_name(serviceName);
			ncRef.rebind(path, href);

			System.out.println("CounterServer ready and waiting ...");

			// wait for invocations from clients
			orb.run();
			
			
		}catch(Exception e){
			System.err.println("Error: " + e);
			e.printStackTrace(System.out);
		}
	}
}
