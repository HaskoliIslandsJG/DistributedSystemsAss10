package corbaJavaGenerated.CounterCORBA;


/**
* corbaJavaGenerated/CounterCORBA/CounterInterfaceHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CounterInterface.idl
* Saturday, October 17, 2015 1:55:24 PM GMT
*/

abstract public class CounterInterfaceHelper
{
  private static String  _id = "IDL:CounterCORBA/CounterInterface:1.0";

  public static void insert (org.omg.CORBA.Any a, corbaJavaGenerated.CounterCORBA.CounterInterface that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static corbaJavaGenerated.CounterCORBA.CounterInterface extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (corbaJavaGenerated.CounterCORBA.CounterInterfaceHelper.id (), "CounterInterface");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static corbaJavaGenerated.CounterCORBA.CounterInterface read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_CounterInterfaceStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, corbaJavaGenerated.CounterCORBA.CounterInterface value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static corbaJavaGenerated.CounterCORBA.CounterInterface narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof corbaJavaGenerated.CounterCORBA.CounterInterface)
      return (corbaJavaGenerated.CounterCORBA.CounterInterface)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      corbaJavaGenerated.CounterCORBA._CounterInterfaceStub stub = new corbaJavaGenerated.CounterCORBA._CounterInterfaceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static corbaJavaGenerated.CounterCORBA.CounterInterface unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof corbaJavaGenerated.CounterCORBA.CounterInterface)
      return (corbaJavaGenerated.CounterCORBA.CounterInterface)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      corbaJavaGenerated.CounterCORBA._CounterInterfaceStub stub = new corbaJavaGenerated.CounterCORBA._CounterInterfaceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
