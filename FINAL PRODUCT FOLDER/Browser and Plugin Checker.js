browser=navigator.userAgent; // Checks if the browser is Firefox or Opera. If it is neither, then the user is redirected to another webpage.
if (browser.indexOf("Firefox")==-1 && browser.indexOf("OPR")==-1 && browser.indexOf("Opera")==-1) {
	window.location.replace("Get Java-Enabled Browser.html");
		}
else {
///////////////////// THIS CODE WAS TAKEN FROM: http://www.javascripter.net/faq/browsern.htm ////////////////////////////////
	var nVer = navigator.appVersion;
	var nAgt = navigator.userAgent;
	var browserName  = navigator.appName;
	var fullVersion  = ''+parseFloat(navigator.appVersion); 
	var majorVersion = parseInt(navigator.appVersion,10);
	var nameOffset,verOffset,ix;
	// In Opera 15+, the true version is after "OPR/" 
	if ((verOffset=nAgt.indexOf("OPR/"))!=-1) {
 		browserName = "Opera";
 		fullVersion = nAgt.substring(verOffset+4);
	}
	// In older Opera, the true version is after "Opera" or after "Version"
	else if ((verOffset=nAgt.indexOf("Opera"))!=-1) {
 		browserName = "Opera";
 		fullVersion = nAgt.substring(verOffset+6);
 			if ((verOffset=nAgt.indexOf("Version"))!=-1) 
   				fullVersion = nAgt.substring(verOffset+8);
	}
	// In Firefox, the true version is after "Firefox" 
	else if ((verOffset=nAgt.indexOf("Firefox"))!=-1) {
 		browserName = "Firefox";
		fullVersion = nAgt.substring(verOffset+8);
	}
	// trim the fullVersion string at semicolon/space if present
	if ((ix=fullVersion.indexOf(";"))!=-1)
   		fullVersion=fullVersion.substring(0,ix);
	if ((ix=fullVersion.indexOf(" "))!=-1)
   		fullVersion=fullVersion.substring(0,ix);
   			
	majorVersion = parseInt(''+fullVersion,10);
		if (isNaN(majorVersion)) {
 			fullVersion  = ''+parseFloat(navigator.appVersion); 
			majorVersion = parseInt(navigator.appVersion,10);
		}
/////////////////////// TAKEN CODE ENDS HERE ///////////////////////////////////
	 	
	 if (browserName=="Firefox" && majorVersion < 43) { //Checks if the Firefox version is up to date, If not up to date, the user is redirected.
	 	alert("YOUR FIREFOX BROWSER IS NOT UP TO DATE. Please update the browser or the applet will not run.");
	 	window.location.replace("https://www.mozilla.org/en-US/firefox/new/");
	 }
	 	
	 if (browserName=="Opera" && majorVersion < 34) { //Checks if the Opera version is up to date. If not up to date, the user is redirected.
	 	alert("YOUR OPERA BROWSER IS NOT UP TO DATE. Please update the browser or the applet will not run.");
	 	window.location.replace("http://www.opera.com");
	 }
	 	
	java_plugin_version = deployJava.getJREs(); // This checks the version of the Java plugin. The Javascript file that accomplishes this is also in our folder.
	if (java_plugin_version != "1.8.0_71") { // If the plugin is not up to date, redirect the user.
		alert("YOUR JAVA PLUGIN IS NOT UP TO DATE. Please update the plugin or the applet will not run.");
	 	window.location.replace("https://www.java.com/en/download/");
	}
		
	if (navigator.javaEnabled()===false) {	// It could be that the browser and plugin are all up to date. However, if the plugin is not enabled, the applet will not run. This checks if the plugin is enabled.
		alert("YOU NEED TO ENABLE THE JAVA PLUGIN FOR YOUR BROWSER. The applet will not run if the plugin is not enabled.");
		document.write("<center><h1><font color=red face=calibri>Enable the Java plugin.</font></h1></center>");
	}
}