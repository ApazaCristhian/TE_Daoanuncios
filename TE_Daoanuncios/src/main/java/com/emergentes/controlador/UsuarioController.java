package com.emergentes.controlador;

import com.emergentes.dao.UsuarioDAOimpl;
import com.emergentes.dao.UsuarioDao;
import com.emergentes.modelo.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         //usuario controller
        UsuarioDao dao = new UsuarioDAOimpl();
        Usuarios usu = new Usuarios();
        int id;
        String action = (request.getParameter("action") != null) ? request.getParameter("action") :"view" ;
        
        switch (action){
            case "add":
                request.setAttribute("usuario", usu);
                request.getRequestDispatcher("frmusuario.jsp").forward(request, response);
                break;
            case "edit":
                // controller?action=edit&id=3
                id=Integer.parseInt(request.getParameter("id")) ;
            
                try {
                    //obtener el objeto que corresponde al registro
                    usu = dao.getById(id);
                } catch (Exception ex) {
                    System.out.println("error" + ex.getMessage());
                }
            
                //colocar como atributo
                request.setAttribute("usuario", usu);
                // transferir el control a frmusuario.jsp
                request.getRequestDispatcher("frmusuario.jsp").forward(request, response);
                break;
                
            case "delete":
                id=Integer.parseInt(request.getParameter("id"));
            
                try {
                    dao.delete(id);
                } catch (Exception ex) {
                    System.out.println("error al eliminar "+ex.getMessage());
                }
            
                response.sendRedirect("UsuarioController");
                break;

            case "view":
            List<Usuarios>lista = new ArrayList<Usuarios>() ;
                try {
                    
                    lista = dao.getAll();
                } catch (Exception ex) {
                    System.out.println("error en la lista"+ex.getMessage());
                }
                request.setAttribute("usuario",lista);
                request.getRequestDispatcher("usuario.jsp").forward(request, response);
            
                break;

            default:
                break;
        } 
    }

    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String clave = request.getParameter("clave");
        
        Usuarios usu = new Usuarios();
        
        usu.setId(id);
        usu.setNombre(nombre);
        usu.setCorreo(correo);
        usu.setClave(clave);
        
         UsuarioDao dao = new UsuarioDAOimpl();
         
         if (id==0) {
            try {
                dao.insert(usu);
            } catch (Exception ex) {
                System.out.println("error al insertar "+ ex.getMessage());;
            }
        }else{
            try {
                dao.update(usu);
            } catch (Exception ex) {
                System.out.println("error al editar"+ex.getMessage());
            }
         }
         response.sendRedirect("UsuarioController");

    }

}
