package com.billetera.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.billetera.business.Category;
import com.billetera.rest.CategoryService;
import com.vaadin.data.Binder;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

@SpringComponent
@UIScope
public class CategoryEditor extends Window  {
	
	TextField name = new TextField("Name");
	TextField description = new TextField("Description");
	TextField period = new TextField("Period");
	
	private Button save = new Button("Save");
	private Button delete = new Button("Delete");	
	
	private Category category;
	private Binder<Category> binder;
	
	@Autowired
	private CategoryService categoryService;
		
	public CategoryEditor()	{
		
		center();
		setClosable(true);
		setModal(true);
		this.setCaption("Add/Edit Category");
		save.setStyleName(ValoTheme.BUTTON_PRIMARY);
		save.setClickShortcut(KeyCode.ENTER);
		save.addClickListener(e -> save());
		
	    //setSizeUndefined();
	    HorizontalLayout actions = new HorizontalLayout(save, delete);
	    actions.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
	    VerticalLayout layout = new VerticalLayout();
	    layout.setMargin(true);
	    layout.setSpacing(true);
	    layout.addComponents(name, description, period, actions);
	    setContent(layout);		    
	    
	    binder = new Binder<>(Category.class);	    
	}
	
	public void edit(Category category)	{
		
		this.category = category;
		/*if(category.getId() != null)	{
			
			binder.bindInstanceFields(this);
		}*/
		
		binder.setBean(category);
	}
	
	private void save()	{
				
		categoryService.saveCategory(category);
	}
}
