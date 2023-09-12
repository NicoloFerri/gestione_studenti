import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
      Studente studente = new Studente(null, "Mario","Rossi",35);
      Studente studente1 = new Studente(null,"Luca","Bianchi",28);
      Studente studente2 = new Studente(null,"Alessandro","Neri",25);

      StudentiDao studenteDao = new StudentiDao();


      try{
          //studenteDao.insertStudente(studente);
          studenteDao.aggiornamentoStudente(studente2,3);
      }catch(SQLException e ){
          throw new RuntimeException(e);
      }



    }
}