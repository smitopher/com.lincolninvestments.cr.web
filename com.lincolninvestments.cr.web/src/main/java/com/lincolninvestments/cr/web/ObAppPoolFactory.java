package com.lincolninvestments.cr.web;

import java.util.ArrayList;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.KeyedObjectPool;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericKeyedObjectPool;
import org.apache.commons.pool2.impl.GenericKeyedObjectPoolConfig;

import com.crystaldecisions.sdk.occa.report.application.ReportClientDocument;
import com.lincolninvestments.cr.Constants;

import ObRun.ObFunction.ObUserApp;


public class ObAppPoolFactory extends BasePooledObjectFactory<ObUserApp> implements Constants{
	static {
		GenericKeyedObjectPoolConfig<ReportClientDocument> cfg = new GenericKeyedObjectPoolConfig<>();
		cfg.setMaxTotalPerKey(2);
		cfg.setBlockWhenExhausted(true);
		RCD_POOL = new GenericKeyedObjectPool<>(new CrystalReportDocumentFactory(), cfg);;
	}
	private static final KeyedObjectPool<String, ReportClientDocument> RCD_POOL;
	
	@Override
	public ObUserApp create() throws Exception {
		ObUserApp app = new ObUserApp("");
		app.setToUserStorage(REPORT_CLIENT_DOC_POOL_KEY, RCD_POOL);
		app.setToUserStorage(WEB_SERVICE_MESSAGES_KEY, new ArrayList<String>());
		return app;
	}

	@Override
	public void destroyObject(PooledObject<ObUserApp> p) throws Exception {
		// TODO Auto-generated method stub
		p.getObject().clearReferences();
	}

	@Override
	public PooledObject<ObUserApp> wrap(ObUserApp obApp) {
		return new DefaultPooledObject<ObUserApp>(obApp);
	}

}
