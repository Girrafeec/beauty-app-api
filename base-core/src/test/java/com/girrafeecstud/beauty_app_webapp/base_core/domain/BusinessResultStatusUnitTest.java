package com.girrafeecstud.beauty_app_webapp.base_core.domain;

import com.girrafeecstud.beauty_app_webapp.base_core.domain.base.BusinessResult;
import com.girrafeecstud.beauty_app_webapp.base_core.domain.base.BusinessResultStatus;
import org.junit.Test;
import org.junit.Assert;

public class BusinessResultStatusUnitTest {

    @Test
    public void expectBusinessResultWithSuccessStatus() {

        BusinessResult result = new BusinessResult(
                "Example data",
                "Example message",
                BusinessResultStatus.SUCCESS
        );

        BusinessResultStatus expectedResult = BusinessResultStatus.SUCCESS;

        BusinessResultStatus actualResult = null;

        switch (result.getBusinessResultStatus()) {
            case SUCCESS:
                actualResult = BusinessResultStatus.SUCCESS;
                break;
            case ERROR:
                actualResult = BusinessResultStatus.ERROR;
                break;
        }

        Assert.assertEquals(expectedResult, actualResult);
    }

}
