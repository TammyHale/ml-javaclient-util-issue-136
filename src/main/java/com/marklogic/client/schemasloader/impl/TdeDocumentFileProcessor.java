package com.marklogic.client.schemasloader.impl;

import com.marklogic.client.file.DocumentFile;
import com.marklogic.client.file.DocumentFileProcessor;
import com.marklogic.client.helper.LoggingObject;
import com.marklogic.client.io.Format;

public class TdeDocumentFileProcessor extends LoggingObject implements DocumentFileProcessor {

	@Override
	public DocumentFile processDocumentFile(DocumentFile documentFile) {
		String uri = documentFile.getUri();
		String extension = documentFile.getFileExtension();

		if (("tdej".equals(extension) || "tdex".equals(extension)) || (uri != null && uri.startsWith("/tde"))) {
			documentFile.getDocumentMetadata().withCollections("http://marklogic.com/xdmp/tde");
		}

		if ("tdej".equals(extension)) {
			documentFile.setFormat(Format.JSON);
		} else if ("tdex".equals(extension)) {
			documentFile.setFormat(Format.XML);
		}

		return documentFile;
	}
}
