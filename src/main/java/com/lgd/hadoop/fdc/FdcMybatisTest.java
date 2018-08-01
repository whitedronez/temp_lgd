package com.lgd.hadoop.fdc;
import java.util.List;
import java.util.Properties;

import com.lgd.hadoop.fdc.services.FdcService;
import com.lgd.hadoop.fdc.domain.FdcTest;
import org.apache.log4j.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FdcMybatisTest {
    private static final Logger LOG = LoggerFactory.getLogger(FdcMybatisTest.class);
    private static final Properties properties = System.getProperties();

    private static FdcService fdcService;

    public static void main( String[] args )
    {
        LOG.debug("LGD Phoenix myBatis DevCode");
        fdcService = new FdcService();

        LOG.debug("== select all fdc test ==");
        List<FdcTest> fdcTestList = fdcService.findAllFdcTest();
        for (FdcTest fdcTest : fdcTestList){
            System.out.println("\tRow: " + fdcTest.getMyKey() + " = " + fdcTest.getMyColumn());
        }

        LOG.debug("== select fdc test by id 2==");
        FdcTest fdcTest2 = fdcService.findFdcTestById(2);
        System.out.println("\tRow: " + fdcTest2.getMyKey() + " = " + fdcTest2.getMyColumn());

        FdcTest fdcTest3 = new FdcTest(3,"3th fdc test record");
        LOG.debug("== insert fdc test by id 3==");
        fdcService.createFdcMapper(fdcTest3);

        LOG.debug("== select all fdc test again ==");
        List<FdcTest> fdcTestList2 = fdcService.findAllFdcTest();
        for (FdcTest fdcTest : fdcTestList2){
            System.out.println("\tRow: " + fdcTest.getMyKey() + " = " + fdcTest.getMyColumn());
        }
        //LOG.debug("== update all fdc test again ==");

    }
}
