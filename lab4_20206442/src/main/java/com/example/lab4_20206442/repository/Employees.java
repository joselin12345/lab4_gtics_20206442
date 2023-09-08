package com.example.lab4_20206442.repository;


import com.example.lab4_20206442.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Employees extends JpaRepository<Employee, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM employees where first_name = ?1 or last_name = ?1")
    List<Employee> buscarPorNombreBaseDatos(String texto);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE employees SET phone_number = ?1 WHERE employee_id = ?2")
    void actualizarTelefono(String numero, Integer employee_id);

}
