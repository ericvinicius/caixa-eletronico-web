package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ConnectionFactoryTest.class, ContaTOTest.class, ContaDAOTest.class, ContaTest.class, MovimentacaoDAOTest.class, MovimentacaoTest.class })
public class AllTests {

}
