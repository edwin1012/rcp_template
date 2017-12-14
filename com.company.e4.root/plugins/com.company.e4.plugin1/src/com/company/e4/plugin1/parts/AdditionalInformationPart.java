package com.company.e4.plugin1.parts;

import javax.annotation.PostConstruct;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class AdditionalInformationPart {

	@PostConstruct
	public void postContruct(Composite parent) {
		Text text = new Text(parent, SWT.BORDER | SWT.MULTI);
	}
}
