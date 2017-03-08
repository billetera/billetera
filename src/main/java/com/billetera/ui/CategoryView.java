package com.billetera.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.billetera.business.Category;
import com.billetera.rest.CategoryService;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window.CloseEvent;
import com.vaadin.ui.Window.CloseListener;
import com.vaadin.ui.themes.ValoTheme;

@Theme("valo")
@SpringUI
public class CategoryView extends UI implements ClickListener, CloseListener {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategoryEditor editor;
	
	private List<Category> categories;
	private Grid<Category> grid;

	
	@Override
	protected void init(VaadinRequest request) {
		
		Panel panel = new Panel("Astronomer Panel");
		setContent(panel);				
		
		VerticalLayout root = new VerticalLayout();
		root.setSpacing(true);
		root.setMargin(true);
		HorizontalLayout titleBar = new HorizontalLayout();
		titleBar.setWidth("100%");
		root.addComponent(titleBar);
		
		Label title = new Label("Categories - Overview");
		titleBar.addComponent(title);
		titleBar.setExpandRatio(title, 1.0f); // Expand

		Label titleComment = new Label("");
		titleComment.setSizeUndefined(); // Take minimum space
		Button newCategory = new Button("New Category");
		newCategory.addClickListener(this);
		titleBar.addComponent(newCategory);		
				
		grid = new Grid<>(Category.class);
		grid.setSizeFull();							
		root.addComponent(grid);	
		populateGrid();
				
		Button accounts = new Button("Accounts");
		Button edit = new Button("Edit");
		Button delete = new Button("Delete");
		CssLayout actions = new CssLayout(accounts, edit, delete);
		actions.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		accounts.setStyleName(ValoTheme.BUTTON_PRIMARY);
		root.addComponent(actions);
				
		panel.setContent(root);
		
		editor.addCloseListener(this);
	}
	
	private void populateGrid()	{
		
		categories = categoryService.getCategories();
		grid.setItems(categories);
		grid.setColumns("name", "period", "balance");		
	}

	@Override
	public void buttonClick(ClickEvent event) {
				
		Category c1 = new Category();
		c1.setId(234L);
		c1.setName("food");
		c1.setDescription("food exp");
		c1.setPeriod("2018");
		editor.edit(c1);
	    // Add it to the root component
	    UI.getCurrent().addWindow(editor);		
	}

	@Override
	public void windowClose(CloseEvent e) {
		
		populateGrid();
	}
}
