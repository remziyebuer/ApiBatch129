package smoketest01_herokuapp;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)//önce bunu yazar daha sonra asagida suitimizi belirtiriz

@Suite.SuiteClasses(
        {   C01_PostRequest.class,
            C02_GetRequest.class,
            C03_PutRequest.class
        }
        )//buraya
// calistiracagimiz classlari sirasi ile yazariz



public class RunnerClass {
}
