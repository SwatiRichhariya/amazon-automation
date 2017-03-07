package enums;

public enum URL {
	  
	PRODUCT_SECTION("/gp/product"),  
	BASEURL("http://www.amazon.com");  

	String url;  
	URL(String url){  
	   this.url = url;
	  }  
	  public String getURL() {  
	     return url;  
	}      
}
