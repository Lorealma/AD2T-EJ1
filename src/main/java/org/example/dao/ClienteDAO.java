package org.example.dao;

import org.example.bbdd.ObjectDBUtil;
import org.example.modelo.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class ClienteDAO {

    public static void mostrarTodosLosClientes(){

        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();

        TypedQuery<Cliente> query = em.createQuery("select c from Cliente c", Cliente.class);

        ArrayList<Cliente> clientes = (ArrayList<Cliente>) query.getResultList();

        for(Cliente cliente: clientes){

            System.out.println(cliente);

        }

    }


    public static void insertarCliente(Cliente cliente){

        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
        }finally{
            em.close();
        }

    }

    public static void getCliente(Long id){

        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();

        Cliente c =null;

        try{
            c = em.find(Cliente.class,id);

        } finally {
            em.close();
        }

        System.out.println(c);


    }

    public static void listarMejoresClientes(Long cantidad){

        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();

        try {
            TypedQuery<Cliente> query = em.createQuery("select c from Cliente c where c.estado= 'activo' and c.totalVentas > :cantidad ", Cliente.class);
            query.setParameter("cantidad", cantidad);
            ArrayList<Cliente> clientes = (ArrayList<Cliente>) query.getResultList();

            for(Cliente cliente: clientes){

                System.out.println(cliente);

            }


        }finally{

            em.close();

        }
    }

    public static void estadisticas(){

        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();

        TypedQuery<Cliente> query = em.createQuery("select c from Cliente c", Cliente.class);

        ArrayList<Cliente> clientes = (ArrayList<Cliente>) query.getResultList();

        Long totalVentas = 0L;

        for(Cliente cliente: clientes) {

            totalVentas += (cliente.getTotalVentas());

        }

        System.out.println("El total de ventas es de: " + totalVentas);

        Long promedio = totalVentas/clientes.size();

        System.out.println("Promedio ventas: " + promedio);

        TypedQuery<Cliente> query2 = em.createQuery("select c from Cliente c where c.estado='inactivo' and c.totalVentas>0L", Cliente.class);

        ArrayList<Cliente> clientesInactivos = (ArrayList<Cliente>) query2.getResultList();

        int contadorInactivos=0;

        for(Cliente cliente:clientesInactivos){

            contadorInactivos++;

        }

        System.out.println("La cantidad de clientes inactivos con un total de ventas mayor a cero es: " + contadorInactivos);

    }

}
