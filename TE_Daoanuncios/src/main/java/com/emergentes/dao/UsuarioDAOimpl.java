
package com.emergentes.dao;

import com.emergentes.modelo.Usuarios;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDAOimpl extends ConexionBD implements UsuarioDao{

    @Override
    public void insert(Usuarios usuario) throws Exception {
        String sql = "insert into usuarios (nombre,correo,clave) values (?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, usuario.getNombre());
        ps.setString(2, usuario.getCorreo());
        ps.setString(3, usuario.getClave());
        ps.executeUpdate();
        this.desconectar();
       
    }

    @Override
    public void update(Usuarios usuario) throws Exception {
        String sql = "update usuarios set nombre=?, correo=?, clave=? where id=? ";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, usuario.getNombre());
        ps.setString(2, usuario.getCorreo());
        ps.setString(3, usuario.getClave());
        ps.setInt(4,usuario.getId());
        ps.executeUpdate();
        this.desconectar();
       
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from usuarios where id=? ";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconectar();
       
    }

    @Override
    public List<Usuarios> getAll() throws Exception {
         List<Usuarios> lista = null;
        String sql = "select * from usuarios";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        lista = new ArrayList<Usuarios>();
        while (rs.next()) {
            Usuarios usu = new Usuarios();

            usu.setId(rs.getInt("id"));
            usu.setNombre(rs.getString("nombre"));
            usu.setCorreo(rs.getString("correo"));
            usu.setClave(rs.getString("clave"));
            lista.add(usu);
            
        }
        this.desconectar();
        return lista;
       
    }

    @Override
    public Usuarios getById(int id) throws Exception {
         Usuarios usu = new Usuarios();
        try{
        String sql = "select * from usuarios where id=? ";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            usu.setId(rs.getInt("id"));
            usu.setNombre(rs.getString("nombre"));
            usu.setCorreo(rs.getString("correo"));
            usu.setClave(rs.getString("clave"));
            

        }
        }catch(SQLException ex){
            throw ex;
        }finally{
            this.desconectar();
        }
        this.desconectar();
        return usu;
      
    }
    
}
