package net.vetfurious.test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import net.vetfurious.modelo.FacturaCliente;
import net.vetfurious.dao.FacturaDAO;
import net.vetfurious.excepcion.DAOExcepcion;
import net.vetfurious.modelo.FacturaDetalle;
import net.vetfurious.modelo.Factura;
import net.vetfurious.negocio.AdmFactura;
import net.vetfurious.negocio.IFactura;

import org.junit.Test;

public class FacturaTest {

	//@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	
	//@Test
	public void Factura() {
		int codFactura=1;
		int idCliente=2;
		String cliente="";
		int idPaciente=3 ;
		String paciente="";
		String feRegistro="31/07/2012";
		String ruc="";
		String status="A";
		ArrayList<FacturaDetalle> Detalle =new ArrayList<FacturaDetalle>();
		 
		int codFacturaDet=1;
		int codProducto=1;
		String producto="";
		double qtCantidad=10.36;
		double precio=58.36; 
		FacturaDetalle objFacturaDetalle= new FacturaDetalle(codFacturaDet,codProducto,producto,qtCantidad,precio);
			 
		codFacturaDet=1;
		codProducto=2;
		String producto2="";
		qtCantidad=5.63;
		precio=46.28;
		FacturaDetalle objFacturaDetalle2= new FacturaDetalle(codFacturaDet,codProducto,producto2,qtCantidad,precio);
		 
		Detalle.add(objFacturaDetalle);
		Detalle.add(objFacturaDetalle2);
		
		Factura objFactura= new Factura(codFactura,idCliente,cliente,idPaciente,paciente,feRegistro,ruc,status,Detalle);
		 
		assertNotNull(objFactura);
	}
	
	//@Test
	public void FacturaDetalle() {
		 int codFactura=1;
		 int codProducto=1;
		 String producto="";
		 double qtCantidad=10.36;
		 double precio=58.36;
			 
			 FacturaDetalle objFacturaDetalle= new FacturaDetalle(codFactura,codProducto,producto,qtCantidad,precio);
			 
			 codFactura=1;
			 codProducto=2;
			 producto="";
			 qtCantidad=5.63;
			 precio=46.28;
			 
			 FacturaDetalle objFacturaDetalle2= new FacturaDetalle(codFactura,codProducto,producto,qtCantidad,precio);
			 assertNotNull(objFacturaDetalle);
			 assertNotNull(objFacturaDetalle2);
			 
			 System.out.println(objFacturaDetalle.getCodProducto());
			 System.out.println(objFacturaDetalle.getQtCantidad());
			 System.out.println(objFacturaDetalle.getPrecio());
			 
			 System.out.println(objFacturaDetalle2.getCodProducto());
			 System.out.println(objFacturaDetalle2.getQtCantidad());
			 System.out.println(objFacturaDetalle2.getPrecio());
	}
	
	@Test
	public void GrabarFactura() throws DAOExcepcion{
		int codFactura=3;
		int idCliente=2;
		String cliente="";
		int idPaciente=3 ;
		String paciente="";
		String feRegistro="04/08/2012";
		String ruc="";
		String status="A";
		ArrayList<FacturaDetalle> Detalle =new ArrayList<FacturaDetalle>();
		 
		int codFacturaDet=3;
		int codProducto=1;
		String producto="";
		double qtCantidad=10.36;
		double precio=58.36; 
		FacturaDetalle objFacturaDetalle= new FacturaDetalle(codFacturaDet,codProducto,producto,qtCantidad,precio);
			 
		codFacturaDet=3;
		codProducto=2;
		producto="";
		qtCantidad=5.63;
		precio=46.28;
		FacturaDetalle objFacturaDetalle2= new FacturaDetalle(codFacturaDet,codProducto,producto,qtCantidad,precio);
		 
		Detalle.add(objFacturaDetalle);
		Detalle.add(objFacturaDetalle2);
		
		Factura objFactura= new Factura(codFactura,idCliente,cliente,idPaciente,paciente,feRegistro,ruc,status,Detalle);

		IFactura objAdmFactura=new AdmFactura();
		objAdmFactura.GrabarFactura(objFactura);
		
	}
	
	
	//@Test
	public void EliminarFactura() throws DAOExcepcion{
		int codFactura=1;

		 
		IFactura objAdmFactura=new AdmFactura();
		objAdmFactura.ElimnarFactura(codFactura);
		
		FacturaDAO objAdmFacturaDao=new FacturaDAO();
		
		assertEquals(0, objAdmFacturaDao.ActivaFactura(codFactura));
		
	}
	
	//@Test
		public void ListarFacturas() throws DAOExcepcion{
			List<FacturaCliente> listafacturas;
			IFactura objAdmFactura=new AdmFactura();
			listafacturas=objAdmFactura.ListarFacturas();
			
			assertTrue(listafacturas.size()>0);
		}
	
	
	//@Test
	public void GrabarDetalleWork() throws DAOExcepcion{
		FacturaDetalle objFacturaDetalle=new FacturaDetalle();
		objFacturaDetalle.setCodFactura(3);
		objFacturaDetalle.setCodProducto(3);
		objFacturaDetalle.setQtCantidad(10);
		objFacturaDetalle.setPrecio(12.36);
		IFactura objAdmFactura=new AdmFactura();
		objAdmFactura.GrabarFacturaDetalle(objFacturaDetalle);
		
		//assertTrue(listafacturas.size()>0);
	}
	
}
