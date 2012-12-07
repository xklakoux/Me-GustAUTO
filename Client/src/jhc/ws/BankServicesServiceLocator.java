/**
 * BankServicesServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package jhc.ws;

public class BankServicesServiceLocator extends org.apache.axis.client.Service implements jhc.ws.BankServicesService {

    public BankServicesServiceLocator() {
    }


    public BankServicesServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BankServicesServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BankServices
    private java.lang.String BankServices_address = "http://localhost:8080/BankWebService/services/BankServices";

    public java.lang.String getBankServicesAddress() {
        return BankServices_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BankServicesWSDDServiceName = "BankServices";

    public java.lang.String getBankServicesWSDDServiceName() {
        return BankServicesWSDDServiceName;
    }

    public void setBankServicesWSDDServiceName(java.lang.String name) {
        BankServicesWSDDServiceName = name;
    }

    public jhc.ws.BankServices getBankServices() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BankServices_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBankServices(endpoint);
    }

    public jhc.ws.BankServices getBankServices(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            jhc.ws.BankServicesSoapBindingStub _stub = new jhc.ws.BankServicesSoapBindingStub(portAddress, this);
            _stub.setPortName(getBankServicesWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBankServicesEndpointAddress(java.lang.String address) {
        BankServices_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (jhc.ws.BankServices.class.isAssignableFrom(serviceEndpointInterface)) {
                jhc.ws.BankServicesSoapBindingStub _stub = new jhc.ws.BankServicesSoapBindingStub(new java.net.URL(BankServices_address), this);
                _stub.setPortName(getBankServicesWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BankServices".equals(inputPortName)) {
            return getBankServices();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.jhc", "BankServicesService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.jhc", "BankServices"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BankServices".equals(portName)) {
            setBankServicesEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
