/**
 * BankServicesService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package jhc.ws;

public interface BankServicesService extends javax.xml.rpc.Service {
    public java.lang.String getBankServicesAddress();

    public jhc.ws.BankServices getBankServices() throws javax.xml.rpc.ServiceException;

    public jhc.ws.BankServices getBankServices(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
