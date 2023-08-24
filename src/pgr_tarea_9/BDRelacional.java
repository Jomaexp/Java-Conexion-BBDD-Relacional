/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgr_tarea_9;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José María Expósito Reyes
 */
public class BDRelacional {
    private int codigo;
    private String nombre;
    private int id_localizacion;
    private int id_manager;
    
    public int altas(int codigo, String nombre, int id_localizacion, 
            int id_manager){
        int n=0;
        try{
             Class.forName("com.mysql.jdbc.Driver");
             Connection conexion = DriverManager.getConnection
             ("jdbc:mysql://localhost/75160119y","root","");
             Statement sentencia = conexion.createStatement();
             String sql="INSERT into Departamentos VALUES ('"+codigo+"','"
                     +nombre+"','"+id_localizacion+"','"+id_manager+"');";
             n = sentencia.executeUpdate(sql);
             sentencia.close();
             conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDRelacional.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BDRelacional.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
        public int bajas(int codigo){
        int n=0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/75160119y","root","");
            Statement sentencia = conexion.createStatement();
            String sql="DELETE FROM Departamentos WHERE codigo="+codigo;
            n = sentencia.executeUpdate(sql);
            sentencia.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDRelacional.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BDRelacional.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
        
    public int modificar(int codigo, String nombre, int id_localizacion, 
            int id_manager){
        int n=0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/75160119y","root","");
            Statement sentencia = conexion.createStatement();
            String sql="UPDATE Departamentos SET nombre='"+nombre+"',"
                    + " id_localizacion="+id_localizacion+","
                    + "id_manager="+id_manager+" WHERE codigo="+codigo+";";
            n = sentencia.executeUpdate(sql);
            sentencia.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDRelacional.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BDRelacional.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
     public String listado(){
         String lista="";
     
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection
            ("jdbc:mysql://localhost/75160119y","root","");
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery
            ("SELECT * FROM Departamentos ORDER BY codigo;");
             
             while (resultado.next()){
                 lista = lista + "Código: " + resultado.getInt(1) + System.lineSeparator()+
                         "Nombre: "+ resultado.getString(2) +System.lineSeparator()+
                         "Id Localización: " + resultado.getInt(3) +System.lineSeparator()+
                         "Id Manager: " + resultado.getInt(4)+System.lineSeparator()
                         +System.lineSeparator();
             } 
             sentencia.close();
             resultado.close();
             conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDRelacional.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BDRelacional.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
     }
     
     public BDRelacional busqueda(int codigo){

         BDRelacional obj=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection
                ("jdbc:mysql://localhost/75160119y","root","");
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery
                ("SELECT * FROM Departamentos WHERE codigo="+codigo);
            
            if(resultado.next()){
                    obj=new BDRelacional(resultado.getInt(1),resultado.getString(2),
                    resultado.getInt(3),resultado.getInt(4));
            }             
    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDRelacional.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BDRelacional.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
     }

    public BDRelacional() {
    }

    public BDRelacional(int codigo, String nombre, int id_localizacion, int id_manager) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.id_localizacion = id_localizacion;
        this.id_manager = id_manager;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_localizacion() {
        return id_localizacion;
    }

    public void setId_localizacion(int id_localizacion) {
        this.id_localizacion = id_localizacion;
    }

    public int getId_manager() {
        return id_manager;
    }

    public void setId_manager(int id_manager) {
        this.id_manager = id_manager;
    }
    
    
         
}
