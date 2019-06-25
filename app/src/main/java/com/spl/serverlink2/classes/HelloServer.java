package com.spl.serverlink2.classes;

import java.io.IOException;
import java.util.Map;

import fi.iki.elonen.NanoHTTPD;

public class HelloServer extends NanoHTTPD {

	public HelloServer() throws IOException {
		super(8080 );
		start( NanoHTTPD.SOCKET_READ_TIMEOUT, false );
		System.out.println( "\nRunning! Point your browsers to http://localhost:8080/ \n" );
	}

	public static HelloServer main( String[] args ) {
		HelloServer helloServer = null;
		try {
			helloServer = new HelloServer();
			helloServer.makeSecure( NanoHTTPD.makeSSLSocketFactory("/keystore.jks", "password".toCharArray()), null );
		} catch (IOException ioe) {
			System.err.println( "Couldn't start server:\n" + ioe );
		}
		return helloServer;
	}

	@Override
	public Response serve( IHTTPSession session ){
		String uri = session.getUri();
		if( uri.equals( "/hello" ) ){
			return newFixedLengthResponse("<html><head></head><body><h1>Hello there</h1></body></html>" );
		}
		/*String answer = "";
		try {
			// Open file from SD Card
			File root = Environment.getExternalStorageDirectory();
			FileReader index = new FileReader(root.getAbsolutePath() + "/www/index.html" );
			BufferedReader reader = new BufferedReader(index);
			String line = "";
			while ((line = reader.readLine()) != null) {
				answer += line;
			}
			reader.close();

		} catch(IOException ioe) {
			Log.w("Httpd", ioe.toString());
		}
		return newFixedLengthResponse( answer );*/
		//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		/*String uri = session.getUri();
		if( uri.equals( "/hello" ) ){
			//String response = "HelloWorld";
			//return newFixedLengthResponse(response);
			FileInputStream fis = new FileInputStream(YOUR_FILE);
			return newChunkedResponse( Response.Status.OK, MIME-Type, fis );
		}*/
		//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		String msg = "<html><body><h1>Hello server</h1>\n";
		Map<String, String> parms = session.getParms();
		if (parms.get("username") == null) {
			msg += "<form action='?' method='get'>\n  <p>Your name: <input type='text' name='username'></p>\n" + "</form>\n";
		} else {
			msg += "<p>Hello, " + parms.get("username") + "!</p>";
		}
		return newFixedLengthResponse(msg + "</body></html>\n");
	}
}