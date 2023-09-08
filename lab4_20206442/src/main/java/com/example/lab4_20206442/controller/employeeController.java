package com.example.lab4_20206442.controller;

import com.example.lab4_20206442.entity.Employee;
import com.example.lab4_20206442.repository.Employees;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class employeeController {

    final Employees employees;
    public employeeController(Employees employees){
        this.employees=employees;
    }

    @GetMapping(value = {"/list", ""})
    public String listarTransportistas(Model model) {

        List<Employee> lista = employees.findAll();
        model.addAttribute("listaEmpleado",lista);

        return "principalEmployee";
    }

    @PostMapping(value = "buscarPorNombre")
    public String buscarPorNombre(@RequestParam("searchField") String searchField, Model model){

        List<Employee> listaNombre = employees.buscarPorNombreBaseDatos(searchField);
        model.addAttribute("listaNombre",listaNombre);
        model.addAttribute("textoBuscado",searchField);

        return "principalEmployee";
    }

    @GetMapping("/edit")
    public String editar(Model model,
                                      @RequestParam("id") Integer id) {
        Optional<Employee> optionalEmployee = employees.findById(id);

        if (optionalEmployee.isPresent()) {
            Employee employee=optionalEmployee.get();
            model.addAttribute("employee", employee);
            return "editar";
        } else {
            return "redirect:/employee/list";
        }
    }

    @GetMapping("/editPhone")
    public String editarTelefono(Model model,
                                      @RequestParam("id") Integer id) {
        Optional<Employee> optionalEmployee = employees.findById(id);

        if (optionalEmployee.isPresent()) {
            Employee employee=optionalEmployee.get();
            model.addAttribute("employee", employee);
            return "editarTelefono";
        } else {
            return "redirect:/employee/list";
        }
    }

    @PostMapping("/updateOnlyPhone")
    public String actualizar(Employee employees){

        return "redirect:/employee/list";
    }

}
