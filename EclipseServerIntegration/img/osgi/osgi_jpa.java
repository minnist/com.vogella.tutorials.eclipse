import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.eclipse.persistence.jpa.PersistenceProvider;

public class JPADataBaseService {

	Map<String,Object> properties = new HashMap<>();
	// pass the bundles classloader as property
	map.put( PersistenceUnitProperties.CLASSLOADER, getClass().getClassLoader() );

	PersistenceProvider persistenceProvider = new PersistenceProvider();
	EntityManagerFactory entityManagerFactory = persistenceProvider.createEntityManagerFactory( "vogella-entitiy-manager", properties );
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	// do database transactions with the entityManager
}