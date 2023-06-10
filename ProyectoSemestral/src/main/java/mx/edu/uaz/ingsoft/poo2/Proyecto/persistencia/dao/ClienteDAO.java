package mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.edu.uaz.ingsoft.poo2.Proyecto.persistencia.entidades.Cliente;

/**
 *
 * @author jesus
 */
public class ClienteDAO {
    
    static Logger logger = Logger.getLogger(ClienteDAO.class.getName());
    
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public ClienteDAO(){
        emf = Persistence.createEntityManagerFactory("UnidadPersistenciaToDos");
        em=emf.createEntityManager();
    }
    
    public Cliente createCliente(String nombreClien){
        Cliente unCliente;
        unCliente = new Cliente();
        unCliente.setNombreCliente(nombreClien);
        return unCliente;
    }
    
    public List<Cliente> findAll(Conector unConector){
        Connection con = unConector.conectar();
        Cliente unCliente;
        List<Cliente> listaSalida;
        listaSalida = new ArrayList<>();
        final String qrySelect;
        qrySelect = " SELECT * from CLIENTE ";
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(qrySelect);
            while (rs.next()) {
                unCliente = createCliente(rs.getString("nombre"));
                unCliente.setIdCliente(rs.getInt("id"));
                listaSalida.add(unCliente);
            }
        } catch(SQLException e){
            System.err.println("Error en la ejecucion " + e.getMessage());
        }
        unConector.close();
        return listaSalida;
    }
    
    
    
    public Cliente findById(Integer idCliente, Conector conector){
        Cliente unCliente = null;
        Connection con = conector.conectar();
        final String qrySelect;
        qrySelect = " SELECT * from CLIENTE where id == "+idCliente;
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(qrySelect);
            unCliente = createCliente(rs.getString("nombre"));
            unCliente.setIdCliente(rs.getInt("id"));
        }catch (SQLException e) {
            System.err.println("Error en la ejecucion " + e.getMessage());
        }
        conector.close();
        return unCliente;
    }
    
    public List<Cliente> findAllWhereNameLike(String textoNombre, Conector conector){
        Connection con = conector.conectar();
        Cliente unCliente;
        List<Cliente> listaSalida;
        listaSalida = new ArrayList<>();
        final String qrySelect;
        qrySelect = " SELECT * from CLIENTE where nombre == "+textoNombre;
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(qrySelect);
            if(rs != null){
                while (rs.next()) {
                unCliente = createCliente(rs.getString("nombre"));
                unCliente.setIdCliente(rs.getInt("id"));
                listaSalida.add(unCliente);
                }
            }else{
                System.out.println("No se encontraron coinsidencias");
            }
        }catch (SQLException e) {
            System.err.println("Error en la ejecucion " + e.getMessage());
        }
        conector.close();
        return listaSalida;
    }
    
    public void saveCliente(Cliente unCLiente, Connection connect){
        final String qryInsert;
         qryInsert = "INSERT INTO CLIENTE "
                + "(nombre ) values ";
        try(Statement stmt = connect.createStatement()) {
            String datosInsert;
            datosInsert = "('"+unCLiente.getNombreCliente()+"')";
            stmt.executeUpdate(qryInsert + datosInsert);
            System.out.println("Cliente guardado");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
}
