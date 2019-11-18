package net.ug.hibernet5.ug_hibernate5;





/**
 * Hello world!
 *
 */
public class App 
{
public static void imprimir(String message) {
		
		System.out.println(message);
	}

    public static void main( String[] args )
    {
    	crear();
    	read();
    	update();
    	read();
    	delete();
    	
        }
        
        	public static void crear() {
        		ProductoDao daoProducto = new ProductoDao();
        	Producto producto = new Producto(1,"Pasta dental","Triple accion",1);
        	daoProducto.setup();
        	daoProducto.crear(producto);
        	Producto producto2 = new Producto(2,"Detergente","Deja",2);
        	daoProducto.crear(producto2);  
    		Producto producto3 = new Producto(3,"Ajax Clorox","Mas rapido imposible",4);
        	daoProducto.crear(producto3);   
    		Producto producto4 = new Producto(4,"Serviletas","Marca Familia",3);
        	daoProducto.crear(producto4);   
            
        }
        	
        	
        	public static void read() {
        		ProductoDao daoProducto = new ProductoDao();
        		daoProducto.setup();
        		Producto producto = daoProducto.read(22);
        		
        		imprimir(producto.toString());
      	}
            public static void update() {

            	ProductoDao daoProducto = new ProductoDao();
            	daoProducto.setup();
        		Producto producto = daoProducto.read(4);
        		producto.setDescripcion("Colores");
       	}
        		
        	public static void delete() {
        		ProductoDao daoProducto = new ProductoDao();
        		daoProducto.setup();
        		daoProducto.delete(2);
        	
        	}
        
    }