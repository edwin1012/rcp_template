package com.company.e4.rcp.internal.views;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class RightView {

	private Text txtName;
	private Text txtPosition;
	private Person person;
	
	@Inject
	private IEventBroker eventBroker;
	
	@Inject
	@Optional
	public void setSelectionChanged(@Named(IServiceConstants.ACTIVE_SELECTION) IStructuredSelection selection) {
		if (selection != null && !selection.isEmpty()) {
			person = (Person) selection.getFirstElement();
			txtName.setText(person.getName());
			txtPosition.setText(person.getPosition());
		}
		else {
			person = null;
			if (txtName != null) txtName.setText("");
			if (txtPosition != null) txtPosition.setText("");
		}
	}

	@PostConstruct
	public void createControl(Composite parent) {
		Composite compoiste = new Composite(parent, SWT.NONE);
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		compoiste.setLayout(gridLayout);
		compoiste.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Label lbl = new Label(compoiste, SWT.NONE);
		lbl.setText("이름: ");
		
		txtName = new Text(compoiste, SWT.BORDER);
		txtName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		lbl = new Label(compoiste, SWT.NONE);
		lbl.setText("직책: ");
		
		txtPosition = new Text(compoiste, SWT.BORDER);
		txtPosition.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		Button btnSave = new Button(compoiste, SWT.PUSH);
		btnSave.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 2, 1));
		btnSave.setText("저장");
		btnSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (person != null) {
					person.setName(txtName.getText());
					person.setPosition(txtPosition.getText());
					
					eventBroker.post(PersonEventConstants.TOPIC_PERSON_UPDATE, person);
				}
			}
		});
	}
	
	@Focus
	public void setFocus() {
		txtName.setFocus();
	}
	
}
