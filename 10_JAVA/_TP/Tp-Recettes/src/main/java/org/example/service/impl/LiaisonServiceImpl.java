package org.example.service.impl;

import org.example.dao.impl.LiaisonDaoImpl;
import org.example.dao.impl.RecipeDaoImpl;
import org.example.entity.Liaison;
import org.example.service.ILiaisonService;

import java.sql.SQLException;
import java.util.List;

public class LiaisonServiceImpl implements ILiaisonService {

    private final LiaisonDaoImpl liaisonDao;

    public LiaisonServiceImpl() throws SQLException {
        this.liaisonDao = new LiaisonDaoImpl();
    }

    @Override
    public Liaison createLiaison(Liaison liaison) {
        return liaisonDao.save(liaison);
    }

    @Override
    public Liaison updateLiaison(Liaison liaison) {
        return liaisonDao.update(liaison);
    }

    @Override
    public void deleteLiaison(int id) {
liaisonDao.delete(id);
    }

    @Override
    public Liaison getLiaison(int id) {
        return liaisonDao.findById(id);
    }

    @Override
    public List<Liaison> getAllLiaisons() {
        return liaisonDao.findAll();
    }
}
