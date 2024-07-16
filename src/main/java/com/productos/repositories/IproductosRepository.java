package com.productos.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.productos.models.productos;

//clase para realizar las operaciones de jpa que ocuparemos 
@Repository
public interface IproductosRepository  extends JpaRepository<productos, Long> {

}
