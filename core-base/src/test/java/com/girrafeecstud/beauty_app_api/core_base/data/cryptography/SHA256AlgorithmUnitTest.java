package com.girrafeecstud.beauty_app_api.core_base.data.cryptography;

import com.girrafeecstud.beauty_app_api.core_base.data.base.cryptography.SHA256Hash;
import org.junit.Assert;
import org.junit.Test;

public class SHA256AlgorithmUnitTest {

    @Test
    public void getCorrectSHA256Hash() {
        SHA256Hash sha256Hash = new SHA256Hash();

        String expectedResult = "9a900403ac313ba27a1bc81f0932652b8020dac92c234d98fa0b06bf0040ecfd";

        String actualResult = sha256Hash.getSHA256Hash("qwertyuiop");

        Assert.assertEquals(expectedResult, actualResult);
    }

}
