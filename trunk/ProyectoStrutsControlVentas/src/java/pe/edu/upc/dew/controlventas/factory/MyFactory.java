package pe.edu.upc.dew.controlventas.factory;

import java.sql.Connection;
import javax.sql.DataSource;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceUtils;
import pe.edu.upc.dew.controlventas.service.CarroCompraService;
import pe.edu.upc.dew.controlventas.service.ClienteService;
import pe.edu.upc.dew.controlventas.service.LineaCreditoService;
import pe.edu.upc.dew.controlventas.service.UsuarioService;

/**
 * Método general para la conexion a BD mediante Ibatis
 * @author u814296
 */
public class MyFactory {

    private static MyFactory singleton = null;
    private BeanFactory factory = null;

    /**
     * Constructor donde hace el llamdo al xml general de mapeo.
     */
    public MyFactory() {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
        this.factory = (BeanFactory) context;
    }

    /**
     * Metodo general para obtener la instaciona de la clase.
     * @return
     */
    public static MyFactory getInstance() {
        if (singleton == null) {
            singleton = new MyFactory();
        }
        return singleton;
    }

    /**
     * Se obtiene los servicio para la conexion a BD del Cliente
     * @return Servicios de Cliente
     */
    public ClienteService getClienteService() {
        return (ClienteService) factory.getBean("clienteService");
    }

    /**
     * Se obtiene los servicio para la conexion a BD de Transaccion
     * @return Servicios de Carro de Compras
     */
    public CarroCompraService getCarroCompraService() {
        return (CarroCompraService) factory.getBean("carroCompraService");
    }

    /**
     * Se obtiene los servicio para la conexion a BD de Linea de Credito
     * @return Servicios de Linea de Credito
     */
    public LineaCreditoService getLineaCreditoService() {
        return (LineaCreditoService) factory.getBean("lineaCreditoService");
    }

    /**
     * Se obtiene los servicio para la conexion a BD del Usuario
     * @return Servicios de Usuario
     */
    public UsuarioService getUsuarioService() {
        return (UsuarioService) factory.getBean("usuarioService");
    }

    /**
     * Se obtiene la conexion actual
     * @return Conexion a BD
     */
    public Connection getConection() {
        DataSource ds = (DataSource) factory.getBean("dataSource");
        Connection conn = DataSourceUtils.getConnection(ds);
        return conn;
    }

    /**
     * Liberacion de conexion
     * @param conn Se envia la conexion a BD actual
     */
    public void releaseConection(Connection conn) {
        if(conn != null) {
            DataSource ds =  (DataSource)factory.getBean("dataSource");
            DataSourceUtils.releaseConnection(conn,ds);
        }
    }

}
