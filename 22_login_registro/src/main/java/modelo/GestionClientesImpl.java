package modelo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import beans.Cliente;
import mapeadores.MapeadorCliente;

@Component("gclientes")
public class GestionClientesImpl implements GestionClientes {
    
	@Autowired
	JdbcTemplate jt;
	@Override
	public boolean registrarCliente(Cliente c) {
		jt.update("insert into clientes (usuario,password,email,telefono) values(?,?,?,?)",
				c.getUsuario(),c.getPassword(),c.getEmail(),c.getTelefono());
		
		return true;
	}
	
	/* (non-Javadoc)
	 * @see modelo.GestionClientes#estaRegistrado(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean estaRegistrado(String user, String pwd) {
		
		boolean resultado=false;
		String sql="select * from clientes where usuario=? and password=?";
		List<Cliente> clientes=jt.query(sql, new MapeadorCliente(),user,pwd);
		if(clientes.size()>0){
			resultado=true;
		}
		return resultado;
	}

	
	

}
