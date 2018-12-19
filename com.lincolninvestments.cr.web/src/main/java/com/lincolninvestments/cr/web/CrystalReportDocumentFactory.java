package com.lincolninvestments.cr.web;

import java.io.File;

import org.apache.commons.pool2.BaseKeyedPooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import com.crystaldecisions.sdk.occa.report.application.ReportClientDocument;

public class CrystalReportDocumentFactory extends BaseKeyedPooledObjectFactory<String, ReportClientDocument> {

	@Override
	public ReportClientDocument create(String key) throws Exception {
		return ReportClientDocument.openReport(new File(key));
	}

	@Override
	public PooledObject<ReportClientDocument> wrap(ReportClientDocument value) {
		return new DefaultPooledObject<ReportClientDocument>(value);
	}

}
