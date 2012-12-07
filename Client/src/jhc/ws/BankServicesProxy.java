package jhc.ws;

public class BankServicesProxy implements jhc.ws.BankServices {
  private String _endpoint = null;
  private jhc.ws.BankServices bankServices = null;
  
  public BankServicesProxy() {
    _initBankServicesProxy();
  }
  
  public BankServicesProxy(String endpoint) {
    _endpoint = endpoint;
    _initBankServicesProxy();
  }
  
  private void _initBankServicesProxy() {
    try {
      bankServices = (new jhc.ws.BankServicesServiceLocator()).getBankServices();
      if (bankServices != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)bankServices)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)bankServices)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (bankServices != null)
      ((javax.xml.rpc.Stub)bankServices)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public jhc.ws.BankServices getBankServices() {
    if (bankServices == null)
      _initBankServicesProxy();
    return bankServices;
  }
  
  public java.lang.String validateCreditCard(java.lang.String number, java.lang.String month, java.lang.String year) throws java.rmi.RemoteException{
    if (bankServices == null)
      _initBankServicesProxy();
    return bankServices.validateCreditCard(number, month, year);
  }
  
  
}