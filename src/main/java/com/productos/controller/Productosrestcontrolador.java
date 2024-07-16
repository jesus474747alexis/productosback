package com.productos.controller;
import com.productos.exception.BadRequestException;
import com.productos.exception.ResourceNotFoundException;
import com.productos.models.productos;
import com.productos.models.MensajeResponse;
import com.productos.services.productosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos/")
public class Productosrestcontrolador {
	
	private productosServices productosServices;
	
    @Autowired
    public Productosrestcontrolador(productosServices productosServices) {
        this.productosServices = productosServices;
    }
    
  
    MensajeResponse mensajeresponse= new MensajeResponse();  
	
    productos producto=null;
   
    @PostMapping(value = "crear", headers = "Accept=application/json")
    public ResponseEntity<?> crearproducto(@RequestBody productos productos) {
    	productos producto =new productos();
    	try {
    	producto.setId(productos.getId()); 
    	producto.setNombre(producto.getNombre());
    	producto.setPrecio(productos.getPrecio());
    	this.producto=productosServices.crearproducto(producto);
    	mensajeresponse.setMnesaje("Guardado correctamente");
    	mensajeresponse.setObject(producto);
    	return new ResponseEntity<>(mensajeresponse, HttpStatus.CREATED);
    	 } catch (DataAccessException exDt) {
             throw  new BadRequestException(exDt.getMessage());
         }
    }
    
    @GetMapping(value = "", headers = "Accept=application/json")
    public ResponseEntity<?> listarproductos() {
    	 try{
    	        List<productos> getList = productosServices.listarproductos();
    	        if (getList == null || getList.isEmpty()) {
    	            throw new ResourceNotFoundException("productos");
    	        }
    	        mensajeresponse.setMnesaje("Lista de productos");
    	    	mensajeresponse.setObject(getList);
    	        return new ResponseEntity<>(mensajeresponse, HttpStatus.OK);
    	        } catch (DataAccessException exDt) {
    	            throw  new BadRequestException(exDt.getMessage());
    	        }    
    	
    	
    }

  	
    @PutMapping(value = "actualizar/{id}", headers = "Accept=application/json")
    public ResponseEntity<?> actualizarEmpleado(@RequestBody @Valid productos productos,@PathVariable Long id) {
    	Optional<productos> producto = productosServices.buscarPorId(id);
    	productos productoActualizar =new productos();
    	try {
    		 if (productos == null || productos.getId()!=id ) {
    			 throw new ResourceNotFoundException("empleado", "id", id);
    		 } else {
    			 productoActualizar.setId(productos.getId());
    			 productoActualizar.setNombre(productos.getNombre());
    			 productoActualizar.setPrecio(productos.getPrecio());
    			 this.producto=productosServices.crearproducto(productoActualizar);
             	mensajeresponse.setMnesaje("Guardado correctamente");
             	mensajeresponse.setObject(productos);
             	return new ResponseEntity<>(mensajeresponse, HttpStatus.CREATED);
             }
        	 } catch (DataAccessException exDt) {
                 throw  new BadRequestException(exDt.getMessage());
             }
    }

 



    		
         @DeleteMapping(value = "eliminar/{id}", headers = "Accept=application/json")
         public ResponseEntity<?>  eliminarEmpleado(@PathVariable Long id) {
            Optional<productos> producto = productosServices.buscarPorId(id);
         	productos productoActualizar =new productos();
           try {  
    	   productosServices.eliminarproductoPorId(id);
    	   mensajeresponse.setMnesaje("Empleado con id : "+id+ "eliminado correctamente");
    	   mensajeresponse.setObject(producto);
	    	 return new ResponseEntity<>(mensajeresponse, HttpStatus.OK);
            }catch (DataAccessException exDt) {
            throw  new BadRequestException(exDt.getMessage());
            }    
           }

  
}
