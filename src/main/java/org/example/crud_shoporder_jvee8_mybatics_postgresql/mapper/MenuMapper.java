package org.example.crud_shoporder_jvee8_mybatics_postgresql.mapper;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.apache.ibatis.session.SqlSession;
import org.example.crud_shoporder_jvee8_mybatics_postgresql.models.Menu;

import javax.faces.bean.ApplicationScoped;
import java.util.List;

@Named
@ApplicationScoped
public class MenuMapper {
    private SqlSession sqlSession;

    @Inject
    public MenuMapper(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    // This method is for testing purposes only
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<Menu> getAllMenus() {
        return sqlSession.selectList("getAllMenus");
    }

    public void insertMenu(Menu menu) {
        sqlSession.insert("insertMenu", menu);
        sqlSession.commit();
    }

    public void updateMenu(Menu menu) {
        sqlSession.update("updateMenu", menu);
        sqlSession.commit();
    }

    public void deleteMenu(int id) {
        sqlSession.delete("deleteMenu", id);
        sqlSession.commit();
    }
}