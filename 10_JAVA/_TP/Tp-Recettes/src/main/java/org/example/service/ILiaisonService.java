package org.example.service;

import org.example.entity.Liaison;
import java.util.List;

public interface ILiaisonService {

    Liaison createLiaison(Liaison liaison);

    Liaison updateLiaison(Liaison liaison);

    void deleteLiaison(int id);

    Liaison getLiaison(int id);

    List<Liaison> getAllLiaisons();
}
