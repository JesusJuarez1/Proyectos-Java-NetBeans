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

public class ProductoDAO {
    
    static Logger logger = Logger.getLogger(ProductoDAO.class.getName());
    
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public ProductoDAO(){
        emf = Persistence.createEntityManagerFactory("UnidadPersistenciaToDos");
        em=emf.createEntityManager();
    }
    
    //Crea un Producto y le asigna los valores recividos, y retorna el objeto.
    public Productos createProducto(String nombreProduc, double precioProduc, int cantidadProduc) {
        Productos unProducto;
        unProducto = new Productos();
        unProducto.setNombreProduc(nombreProduc);
        unProducto.setPrecioProduc(precioProduc);
        unProducto.setCantidadProduc(cantidadProduc);
        return unProducto;
    }
    
    //Consulta la base de datos y regresa todos los objetos en una lista
    //Manda llamar el metodo createProducto
    public List<Productos> findAll(Conector unConect) {
        Connection con = unConect.conectar();
        Productos unProducto;
        List<Productos> listaSalida;
        listaSalida = new ArrayList<>();
        final String qrySelect;
        qrySelect = " SELECT * from PRODUCTO ";
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(qrySelect);
            while (rs.next()) {
                unProducto = createProducto(rs.getString("nombre"), rs.getDouble("precio"), rs.getInt("cantidad"));
                unProducto.setIdProduc(rs.getInt("id"));
                listaSalida.add(unProducto);
            }
        } catch(SQLException e){
            System.err.println("Error en la ejecucion " + e.getMessage());
        }
        unConect.close();
        return listaSalida;
    }
    
    //Actualiza un registro de la base de datos con los nuevos parametros recividos
    //pasandole el id del producto que se desea actualizar
    public void update(int idProduc, Conector conector, String nombre, double precio, int cantidad){
        Connection con = conector.conectar();
        final String qryUpdate;
        qryUpdate = "UPDATE PRODUCTO SET nombre = ? , "
                + "precio = ? , "
                + "cantidad = ? "
                + "WHERE id = ? ";
        try{
            PreparedStatement pstm = con.prepareStatement(qryUpdate);
            pstm.setString(1, nombre);
            pstm.setDouble(2, precio);
            pstm.setInt(3, cantidad);
            pstm.setInt(4, idProduc);
            pstm.executeUpdate();
            System.out.println("Se actualizo el registro correctamente");
        }catch (SQLException e) {
            System.err.println("Error en la ejecucion " + e.getMessage());
        }
        conector.close();
    }
    
    //Elimina un registro de la base de datos, pasandole el id del producto que se desea eliminar
    public void delete(int idProducto, Conector conector){
        Connection con = conector.conectar();
        final String qryDelete;
        qryDelete = " DELETE from PRODUCTO where id == "+idProducto;
        try{
            Statement stmt = con.createStatement();
            boolean rs = stmt.execute(qryDelete);
            if(!rs == true){
                System.out.println("Se ha eliminado el producto");
            }else{
                System.out.println("No se ha eliminado el producto correctamente");
            }
        }catch (SQLException e) {
            System.err.println("Error en la ejecucion " + e.getMessage());
        }
        conector.close();
    }
    
    //Regresa un registro de la base de datos con el id que se le esta pasando
    public Productos findById(Integer idProducto, Conector conector){
        Productos unProducto = null;
        Connection con = conector.conectar();
        final String qrySelect;
        qrySelect = " SELECT * from PRODUCTO where id == "+idProducto;
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(qrySelect);
            unProducto = createProducto(rs.getString("nombre"), rs.getDouble("precio"), rs.getInt("cantidad"));
            unProducto.setIdProduc(rs.getInt("id"));
        }catch (SQLException e) {
            System.err.println("Error en la ejecucion " + e.getMessage());
        }
        conector.close();
        return unProducto;
    }
    
    //Regresa una lista de productos que tengan el msimo nombre, pasandole el nombre del registro que se desea encontrar
    public List<Productos> findAllWhereNameLike(String textoNombre, Conector unConect){
        Connection con = unConect.conectar();
        Productos unProducto;
        List<Productos> listaSalida;
        listaSalida = new ArrayList<>();
        final String qrySelect;
        qrySelect = " SELECT * from PRODUCTO where nombre == "+textoNombre;
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(qrySelect);
            if(rs != null){
                while (rs.next()) {
                unProducto = createProducto(rs.getString("nombre"), rs.getDouble("precio"), rs.getInt("cantidad"));
                unProducto.setIdProduc(rs.getInt("id"));
                listaSalida.add(unProducto);
                }
            }else{
                System.out.println("No se encontraron coinsidencias");
            }
        }catch (SQLException e) {
            System.err.println("Error en la ejecucion " + e.getMessage());
        }
        unConect.close();
        return listaSalida;
    }
    
    //Guarda en la base de datos el producto que se le esta pasando como parametro
    public void saveProducto(Productos unProducto, Connection connect){
        final String qryInsert;
         qryInsert = "INSERT INTO PRODUCTO "
                + "(nombre, precio, cantidad ) values ";
        try(Statement stmt = connect.createStatement()) {
            String datosInsert;
            datosInsert = "('"+unProducto.getNombreProduc()+"', " + unProducto.getPrecioProduc()+", "
                    + unProducto.getCantidadProduc()+")";
            stmt.executeUpdate(qryInsert + datosInsert);
            System.out.println("Producto guardado");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

}
