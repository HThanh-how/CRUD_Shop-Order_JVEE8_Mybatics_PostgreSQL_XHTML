package org.example.crud_shoporder_jvee8_mybatics_postgresql.bean;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import org.example.crud_shoporder_jvee8_mybatics_postgresql.mapper.MenuMapper;
import org.example.crud_shoporder_jvee8_mybatics_postgresql.models.Menu;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "menuBean")
@SessionScoped
public class MenuBean {
    @Inject
    private MenuMapper menuMapper;

    private List<Menu> menus;

    @PostConstruct
    public void init() {
        this.menus = menuMapper.getAllMenus();
    }

    public List<Menu> getMenus() {
        return this.menus;
    }

    public void setMenuMapper(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    public void addMenu(Menu menu) {
        menuMapper.insertMenu(menu);
        this.menus = menuMapper.getAllMenus();
    }

    public void updateMenu(Menu menu) {
        menuMapper.updateMenu(menu);
        this.menus = menuMapper.getAllMenus();
    }

    public void deleteMenu(int id) {
        menuMapper.deleteMenu(id);
        this.menus = menuMapper.getAllMenus();
    }
}