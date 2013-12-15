/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;
/**
 *
 * @author kaizeurk
 */
public class JDBCconnection {
   

  /**
  * URL de connection
  */
  private static String url = "jdbc:oracle:thin:@zeta.labunix.uqam.ca:1521:baclab";

  /**
  * Nom du user
  */
  private String user = "";

  /**
  * Mot de passe du user
  */
  private String passwd = "";

  /**
  * Objet Connection
  */
  private Connection connect;

  /**
  * Constructeur
  */
  public JDBCconnection(String _user, String _passwd){
      this.user = _user;
      this.passwd = _passwd;
    
    }
  
  /**
  * Méthode qui va retourner notre instance
  * et la créer si elle n'existe pas...
  * @return
  */
  public Connection getInstance(){
    if( getConnect() == null){
      try {
            this.connect = DriverManager.getConnection(url, getUser(), getPasswd());
      } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.getMessage(), "ERREUR DE CONNEXION ! ", JOptionPane.ERROR_MESSAGE);
      }
    }		
    return this.connect;	
  }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the passwd
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * @param passwd the passwd to set
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    /**
     * @return the connect
     */
    public Connection getConnect() {
        return connect;
    }
    
}