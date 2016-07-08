
URL url = null;

try {

  url = new URL("platform:/plugin/" 
  	+ "your_bundle-symbolicname"
	+ "path_to_file");
	
	} catch (MalformedURLException e1) {
	  e1.printStackTrace();
}