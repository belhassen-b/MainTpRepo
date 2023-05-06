package entity;

public class Ticket {
    private int id;
    private int idClient;
    private int idEvenement;
    private int nbTickets;


    public Ticket(int idClient, int idEvenement, int nbTickets) {
        this.idClient = idClient;
        this.idEvenement = idEvenement;
        this.nbTickets = nbTickets;
    }

    public Ticket(int id, int idClient, int idEvenement, int nbTickets) {
        this(idClient, idEvenement, nbTickets);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdEvenement() {
        return idEvenement;
    }

    public void setIdEvenement(int idEvenement) {
        this.idEvenement = idEvenement;
    }

    public int getNbTickets() {
        return nbTickets;
    }

    public void setNbTickets(int nbTickets) {
        this.nbTickets = nbTickets;
    }

    public int getIdEvent() {
        return idEvenement;
    }
}

