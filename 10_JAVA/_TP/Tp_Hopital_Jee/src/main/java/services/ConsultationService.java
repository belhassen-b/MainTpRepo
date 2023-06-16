package services;

import entities.Consultation;
import interfaces.Repository;

import java.util.List;

public class ConsultationService extends BaseService implements Repository<Consultation> {
    @Override
    public boolean create(Consultation o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Consultation findById(int id) {
        return null;
    }

    @Override
    public List<Consultation> findAll() {
        return null;
    }
}
