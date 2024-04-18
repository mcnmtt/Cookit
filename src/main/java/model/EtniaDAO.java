package model;

import java.util.List;

public interface EtniaDAO {

    List<Etnia> doRetrieveAllEtnia();

    void addEtnia(Etnia etnia);

    void deleteEtnia(Etnia etnia);

    Etnia doRetrieveByName(String name);

    void doUpdateEtnia(Etnia etnia, String name);

}