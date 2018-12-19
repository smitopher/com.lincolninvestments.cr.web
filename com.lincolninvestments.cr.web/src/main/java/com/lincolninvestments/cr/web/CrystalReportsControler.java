package com.lincolninvestments.cr.web;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lincolninvestments.cr.Constants;

import ObRun.ObFunction.ObApplication;
import ObRun.ObFunction.ObUserApp;

@RestController 
public class CrystalReportsControler implements Constants{
	
	private static final ObjectPool<ObUserApp> OB_APP_POOL = 
			new GenericObjectPool<>(new ObAppPoolFactory());
	private static final String PLEX_ENVIRONMENT_DEFAULT = "Default";
	
	@SuppressWarnings("unchecked")
	@RequestMapping(method=RequestMethod.POST, path="plexCall")
	public PlexCall plexCall(@RequestBody(required=true) PlexCall plexCall) {
		plexCall.exception = null;
		if (plexCall.parameters == null) {
			plexCall.parameters = new String[0];
		}
		if (plexCall.environment == null) {
			plexCall.environment = PLEX_ENVIRONMENT_DEFAULT;
		}
		try {
			ObUserApp obApp = OB_APP_POOL.borrowObject();
			plexCall.messages = (List<String>)obApp.getFromUserStorage(WEB_SERVICE_MESSAGES_KEY);
			plexCall.result = ObApplication.obCallFunction(plexCall.parameters, plexCall.function, plexCall.environment, obApp);
			obApp.setToUserStorage(WEB_SERVICE_MESSAGES_KEY, new ArrayList<String>()	);
			OB_APP_POOL.returnObject(obApp);
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			plexCall.exception = sw.toString();
			e.printStackTrace();
		}
		return plexCall;
	}

}
