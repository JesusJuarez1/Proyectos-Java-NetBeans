package mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.entidades.Productos;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.entidades.Ticket;

/**
 *
 * @author jesus
 */
public class TicketDAO {
    
    static Logger logger = Logger.getLogger(TicketDAO.class.getName());
    
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public TicketDAO(){
        emf = Persistence.createEntityManagerFactory("UnidadPersistenciaToDos");
        em=emf.createEntityManager();
    }
    
    public Ticket createTicket(List<Productos> lista){
        Ticket unTicket = new Ticket();
        unTicket.setListaCompra(unTicket.obtenerLista(lista));
        unTicket.setTotal(unTicket.calcularTotal(lista));
        return unTicket;
    }
    
    public Ticket createTicket(String lista, double total){
        Ticket unTicket = new Ticket();
        unTicket.setListaCompra(lista);
        unTicket.setTotal(total);
        return unTicket;
    }
    
    public List<Ticket> findAll(Conector unConector){
        Connection con = unConector.conectar();
        Ticket unTicket;
        List<Ticket> listaSalida;
        listaSalida = new ArrayList<>();
        final String qrySelect;
        qrySelect = " SELECT * from TICKET ";
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(qrySelect);
            while (rs.next()) {
                unTicket = createTicket(rs.getString("lista"), rs.getDouble("total"));
                unTicket.setIdCompra(rs.getInt("id"));
                listaSalida.add(unTicket);
            }
        } catch(SQLException e){
            System.err.println("Error en la ejecucion " + e.getMessage());
        }
        unConector.close();
        return listaSalida;
    }
    
    //El ticket no necesita ser editado.
    /*
    public void update(int idCompra, Conector conector, String lista, double total){
        Connection con = conector.conectar();
        final String qryUpdate;
        qryUpdate = "UPDATE TICKET SET lista = ? , "
                + "total = ? , "
                + "WHERE id = ? ";
        try{
            PreparedStatement pstm = con.prepareStatement(qryUpdate);
            pstm.setString(1, lista);
            pstm.setDouble(2, total);
            pstm.setInt(3, idCompra);
            pstm.executeUpdate();
            System.out.println("Se actualizo el registro correctamente");
        }catch (SQLException e) {
            System.err.println("Error en la ejecucion " + e.getMessage());
        }
        conector.close();
    }
    **/
    
    //Elimina un registro de la base de datos, pasandole el id del producto que se desea eliminar
    public void delete(int idTicket, Conector conector){
        Connection con = conector.conectar();
        final String qryDelete;
        qryDelete = " DELETE from TICKET where id == "+idTicket;
        try{
            Statement stmt = con.createStatement();
            boolean rs = stmt.execute(qryDelete);
            if(!rs == true){
                System.out.println("Se ha eliminado el Ticket");
            }else{
                System.out.println("No se ha eliminado el Ticket correctamente");
            }
        }catch (SQLException e) {
            System.err.println("Error en la ejecucion " + e.getMessage());
        }
        conector.close();
    }
    
    //Regresa un registro de la base de datos con el id que se le esta pasando
    public Ticket findById(Integer idTicket, Conector conector){
        Ticket unTicket = null;
        Connection con = conector.conectar();
        final String qrySelect;
        qrySelect = " SELECT * from PRODUCTO where id == "+idTicket;
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(qrySelect);
            unTicket = createTicket(rs.getString("lista"), rs.getDouble("total"));
            unTicket.setIdCompra(rs.getInt("id"));
        }catch (SQLException e) {
            System.err.println("Error en la ejecucion " + e.getMessage());
        }
        conector.close();
        return unTicket;
    }
    
    //Guarda en la base de datos el producto que se le esta pasando como parametro
    public void saveTicket(Ticket unTicket, Connection connect){
        final String qryInsert;
         qryInsert = "INSERT INTO TICKET "
                + "(lista, total ) values ";
        try(Statement stmt = connect.createStatement()) {
            String datosInsert;
            datosInsert = "('"+unTicket.getListaCompra()+"', " + unTicket.getTotal()+")";
            stmt.executeUpdate(qryInsert + datosInsert);
            System.out.println("Ticket guardado");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

}
