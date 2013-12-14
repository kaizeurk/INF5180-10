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
  private static String user = "hc791240";

  /**
  * Mot de passe du user
  */
  private static String passwd = "QHBDfdrx";

  /**
  * Objet Connection
  */
  private static Connection connect;

  /**
  * Méthode qui va retourner notre instance
  * et la créer si elle n'existe pas...
  * @return
  */
  public static Connection getInstance(){
    if(connect == null){
      try {
        connect = DriverManager.getConnection(url, user, passwd);
      } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.getMessage(), "ERREUR DE CONNEXION ! ", JOptionPane.ERROR_MESSAGE);
      }
    }		
    return connect;	
  }
}