import java.sql.*;

public class StudentiDao {
    private final String dbUrl = "jdbc:mysql://localhost:3306/gestione_studenti";
    private final String user = "root";
    private final String password = "Ferrinico92";

    public void insertStudente (Studente studente) throws SQLException {
        Connection conn = DriverManager.getConnection(dbUrl,user,password);
        Statement statement = conn.createStatement();

        String studente1 = ""
                + "INSERT INTO gestione_studenti.studenti "
                + "( nome, cognome, eta) "
                + "VALUES('"+studente.getNome()+"', '"+studente.getCognome()+"', '"+studente.getEta()+"');";

        statement.executeUpdate(studente1);
        conn.close();

        System.out.println("Studente inserito!");
    };


    public void letturaStudente() throws SQLException{
        Connection conn = DriverManager.getConnection(dbUrl,user,password);
        Statement statement = conn.createStatement();

        String studente1 = ""
                + "SELECT id, nome, cognome, eta "
                + "FROM gestione_studenti.studenti;";

        ResultSet resultSet = statement.executeQuery(studente1);

        int i=0;

        while (resultSet.next()){
            i++;
            System.out.println("id"+ resultSet.getString("id")+i);
            System.out.println("nome"+resultSet.getString("nome")+i);
            System.out.println("cognome"+resultSet.getString("cognome")+i);
            System.out.println("eta"+resultSet.getString("eta")+i);

        }

        conn.close();
    }


   public void aggiornamentoStudente(Studente newStudentForUpdate, Integer id) throws SQLException {
       Connection conn = DriverManager.getConnection(dbUrl, user, password);
       Statement statement = conn.createStatement();

       String studenteDaCercare = ""
               + "SELECT id, nome, cognome, eta "
               + "FROM gestione_studenti.studenti" +
               "  WHERE id = " + id;

       ResultSet resultSet = statement.executeQuery(studenteDaCercare);
       Integer currentStudentId = null;


       while (resultSet.next()) {
            currentStudentId = resultSet.getInt("id");
       }

       String updateStudente = ""
               + "UPDATE gestione_studenti.studenti "
               + "SET nome='" + newStudentForUpdate.getNome() + "', cognome='" + newStudentForUpdate.getCognome() + "', eta=" + newStudentForUpdate.getEta() + " "
               + "WHERE id=" + currentStudentId;

       statement.executeUpdate(updateStudente);
       System.out.println("studente con " + id + "aggiornato");

       conn.close();
   }

























}




