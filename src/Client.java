import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import corbaJavaGenerated.CounterCORBA.*;

public class Client {
	public static void main(String[] args){
		try {

			// create and initialize the ORB
			ORB orb = ORB.init(args, null);

			// get the root naming context
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			// Cast to and use NamingContextExt instead of NamingContext. This
			// is
			// part of the Interoperable naming Service.
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

			// resolve the Object Reference in Naming
			String serviceName = "Counter";
			NameComponent path[] = ncRef.to_name(serviceName);
			CounterInterface CounterImpl = CounterInterfaceHelper.narrow(ncRef.resolve(path));

			System.out.println("Obtained a handle on server object: "+ CounterImpl);
			System.out.println(CounterImpl.getCount());
		} catch (Exception e) {
			System.out.println("ERROR : " + e);
			e.printStackTrace();
		}
	}
}
