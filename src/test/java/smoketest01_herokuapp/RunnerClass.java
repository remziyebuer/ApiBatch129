package smoketest01_herokuapp;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)//önce bunu yazar daha sonra asagida suitimizi belirtiriz

@Suite.SuiteClasses(
        {   C01_PostRequest.class,
            C02_GetRequest_PozitifTest.class,
            C03_PutRequest.class,
            C04_PatchRequest.class,
            C05_DeleteRequest.class,
            C06_GetRequest_NegativeTest.class
        }
        )//buraya
// calistiracagimiz classlari sirasi ile yazariz

public class RunnerClass {
}
