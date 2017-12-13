package com.company.e4.rcp.internal.views;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

public class LeftView {

	private ListViewer viewer;

	@Inject
	private ESelectionService selectionService;

	@PostConstruct
	public void createControl(Composite parent) {
		Composite compoiste = new Composite(parent, SWT.NONE);
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		compoiste.setLayout(gridLayout);
		compoiste.setLayoutData(new GridData(GridData.FILL_BOTH));

		viewer = new ListViewer(compoiste, SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
		viewer.getList().setLayoutData(new GridData(GridData.FILL_BOTH));
		viewer.setContentProvider(ArrayContentProvider.getInstance());
		viewer.setLabelProvider(new LabelProvider());
		viewer.setInput(createEmployees());
		viewer.addPostSelectionChangedListener(event -> {
			selectionService.setSelection(event.getSelection());
		});
	}

	@Focus
	public void setFocus() {
		if (viewer != null) {
			viewer.getList().setFocus();
		}
	}

	private List<Person> createEmployees() {
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("Kang", "수석"));
		persons.add(new Person("Edwin", "책임"));
		persons.add(new Person("Sun", "선임"));
		persons.add(new Person("Hawing", "전임"));
		persons.add(new Person("Yeo", "전임"));
		persons.add(new Person("One", "전임"));

		return persons;
	}

}
