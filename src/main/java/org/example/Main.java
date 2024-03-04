package org.example;

import org.example.dao.ClienteDAO;
import org.example.modelo.Cliente;

public class Main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Paula", 550L, "activo");
        Cliente cliente2 = new Cliente("Alejandro", 870L, "inactivo");
        Cliente cliente3 = new Cliente("Manuel", 620L, "activo");
        Cliente cliente4 = new Cliente("Tamara", 960L, "activo");
        Cliente cliente5 = new Cliente("Carlos", 490L, "inactivo");

        ClienteDAO.insertarCliente(cliente1);
        ClienteDAO.insertarCliente(cliente2);
        ClienteDAO.insertarCliente(cliente3);
        ClienteDAO.insertarCliente(cliente4);
        ClienteDAO.insertarCliente(cliente5);

        System.out.println("TODOS LOS CLIENTES: ");

        ClienteDAO.mostrarTodosLosClientes();

        System.out.println(" ");

        System.out.println("CLIENTES POR ID: ");

        ClienteDAO.getCliente(3L);

        System.out.println(" ");

        System.out.println("MEJORES CLIENTES: ");

        ClienteDAO.listarMejoresClientes(700L);

        System.out.println(" ");

        System.out.println("ESTADISTICAS: ");

        ClienteDAO.estadisticas();


    }
}