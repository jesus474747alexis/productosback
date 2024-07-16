package com.productos.services;

import com.productos.models.productos;
import com.productos.repositories.IproductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class productosServices {
	 private IproductosRepository productoRepo;
	    
	    @Autowired
	    public productosServices(IproductosRepository productoRepo) {
	        this.productoRepo = productoRepo;
	    }

	    
	    public productos crearproducto(productos productos){
	        return productoRepo.save(productos);
	    }
	    
	    public List<productos> listarproductos(){
	        return productoRepo.findAll();
	    }
	  
	    
	    public void eliminarproductoPorId(Long id){
	        productoRepo.deleteById(id);
	    }
	    

	    
	    public void actualizarproducto(productos producto){
	        productoRepo.save(producto);
	    }
	    
	  
	    public Optional<productos> buscarPorId(Long id){
	        return productoRepo.findById(id);
	    }

	    
}
