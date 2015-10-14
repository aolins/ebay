package de.mobile.aol;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.sun.grizzly.http.SelectorThread;
import com.sun.jersey.api.container.grizzly.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.core.spi.component.ioc.IoCComponentProviderFactory;
import com.sun.jersey.guice.spi.container.GuiceComponentProviderFactory;
import de.mobile.aol.data.AutoEntry;
import org.h2.tools.Server;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.net.URI;
import java.util.List;


/**
 * Created by aol on 2015.10.12..
 */
public class Main {

    public static final String BASE_URI = "http://localhost:8089/myapp/";

    public static void main(String[] args) throws Exception {

//        h2Start();
        SelectorThread st = start(new RunModule());

        System.out.println(String.format(st.isRunning() + "Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        System.in.read();
        org.hibernate.ejb.HibernatePersistence c;
        st.stopEndpoint();
//        h2Stop();


    }

    public static SelectorThread start(final AbstractModule am) throws IOException {
        final ResourceConfig rc = new PackagesResourceConfig("de.mobile.aol.services");
        IoCComponentProviderFactory ioc = new GuiceComponentProviderFactory(rc, Guice.createInjector(am));


//        com.sun.
        return GrizzlyServerFactory.create(URI.create(BASE_URI), rc, ioc);
    }
    static Server server;
    static EntityManagerFactory entityManagerFactory;
    public static void h2Start() throws Exception {

        Class.forName("javax.transaction.SystemException");

        // start the TCP Server
        server = Server.createTcpServer("-tcpPort", "9123", "-tcpAllowOthers").start();

        entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");



        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(new AutoEntry("red", "audi", "a2", "kompakt", "", 200));
        entityManager.persist(new AutoEntry("blue", "audi", "a3", "kompakt", "", 200));
        entityManager.getTransaction().commit();
        entityManager.close();


        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<AutoEntry> result = entityManager.createQuery( "from auto" ).getResultList();
        for ( AutoEntry event : result ) {
            System.out.println( "au (" + event.toString() + ") : "  );
        }

        entityManager.getTransaction().commit();
        entityManager.close();

    }
    public static void h2Stop() throws Exception{
// stop the TCP Server
        server.stop();
    }
}
