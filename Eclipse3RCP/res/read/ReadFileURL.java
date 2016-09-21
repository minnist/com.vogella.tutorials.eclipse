public static String readTextFile(URL url) throws IOException {
	StringBuilder output = new StringBuilder();
    String lineSeperator = System.lineSeparator();

    try ( InputStream in = url.openConnection().getInputStream();
          BufferedReader br = new BufferedReader(new InputStreamReader(in)) ) {
    	
    	String inputLine;

        while ((inputLine = br.readLine()) != null ) {
        	output.append(inputLine).append(lineSeperator);
        }

      if (output.length()>0) {
        // remove last line separator
        output.setLength(output.length() - lineSeperator.length());
      }
     }

    return output.toString();
}